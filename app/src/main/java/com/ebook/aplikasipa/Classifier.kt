package com.ebook.aplikasipa

import android.content.res.AssetManager
import android.graphics.Bitmap
import android.util.Log
import org.tensorflow.lite.Interpreter
import java.io.FileInputStream
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.MappedByteBuffer
import java.nio.channels.FileChannel
import java.util.*

class Classifier(assetManager: AssetManager, modelPath: String, labelPath: String, inputSize: Int) {
    private var INTERPRETER: Interpreter
    private var LABEL_LIST: List<String>
    private val INPUT_SIZE: Int = inputSize
    private val PIXEL_SIZE: Int = 3
    private val IMAGE_MEAN = 0
    private val IMAGE_STD = 256.0f
    private val MAX_RESULTS = 3
    private val THRESHOLD = 0.4f

    data class Recognition(
        var id: String = "",
        var title: String = "",
        var confidence: Float = 0F
    )  {
        override fun toString(): String {
            return "Title = $title, Akurasi = $confidence"
        }
    }

    init {
        INTERPRETER = Interpreter(loadModelFile(assetManager, modelPath))
        LABEL_LIST = loadLabelList(assetManager, labelPath)
    }
    //tujuan untuk memuat file model dari aset aplikasi Android menjadi MappedByteBuffer.
    //menggunakan machhine learning yang sudah dilatih sebelumnya
    private fun loadModelFile(assetManager: AssetManager, modelPath: String): MappedByteBuffer {
        val fileDescriptor = assetManager.openFd(modelPath)
        val inputStream = FileInputStream(fileDescriptor.fileDescriptor)
        val fileChannel = inputStream.channel
        val startOffset = fileDescriptor.startOffset
        val declaredLength = fileDescriptor.declaredLength
        return fileChannel.map(FileChannel.MapMode.READ_ONLY, startOffset, declaredLength)
    }
    //memuat daftar label atau kelas dari suatu model machine learning dari file teks.
    private fun loadLabelList(assetManager: AssetManager, labelPath: String): List<String> {
        return assetManager.open(labelPath).bufferedReader().useLines { it.toList() }

    }

    //mengenali atau mengklasifikasikan gambar menggunakan model machine learning yang telah dilatih sebelumnya.
    //Fungsi ini menerima sebuah Bitmap sebagai input dan mengembalikan daftar hasil pengenalan (Classifier.Recognition).
    fun recognizeImage(bitmap: Bitmap): List<Classifier.Recognition> {
        val scaledBitmap = Bitmap.createScaledBitmap(bitmap, INPUT_SIZE, INPUT_SIZE, false)
        val byteBuffer = convertBitmapToByteBuffer(scaledBitmap)
        val result = Array(1) { FloatArray(LABEL_LIST.size) }
        INTERPRETER.run(byteBuffer, result)
        return getSortedResult(result)
    }


    //mengkonversi sebuah Bitmap menjadi ByteBuffer
    private fun convertBitmapToByteBuffer(bitmap: Bitmap): ByteBuffer { // mengkonversi sebuah bitmap menjadi byteBuffer.
        val byteBuffer = ByteBuffer.allocateDirect(4 * INPUT_SIZE * INPUT_SIZE * PIXEL_SIZE)
        byteBuffer.order(ByteOrder.nativeOrder())
        val intValues = IntArray(INPUT_SIZE * INPUT_SIZE)

        bitmap.getPixels(intValues, 0, bitmap.width, 0, 0, bitmap.width, bitmap.height)
        var pixel = 0
        for (i in 0 until INPUT_SIZE) {
            for (j in 0 until INPUT_SIZE) {
                val `val` = intValues[pixel++]

    //Kodingan ini mengambil nilai piksel gambar yang telah dinormalisasi dan menyimpannya dalam bentuk ByteBuffer,
    //yang nantinya dapat diberikan langsung sebagai input ke model
                byteBuffer.putFloat((((`val`.shr(16)  and 0xFF) - IMAGE_MEAN) / IMAGE_STD))
                byteBuffer.putFloat((((`val`.shr(8) and 0xFF) - IMAGE_MEAN) / IMAGE_STD))
                byteBuffer.putFloat((((`val` and 0xFF) - IMAGE_MEAN) / IMAGE_STD))
            }
        }
        return byteBuffer
    }

    //memproses dan mengurutkan hasil prediksi dari model machine learning menjadi daftar hasil pengenalan (Classifier.Recognition)
    //Fungsi ini mengambil array hasil prediksi (labelProbArray) sebagai input dan mengembalikan daftar hasil pengenalan yang diurutkan berdasarkan tingkat kepercayaan (confidence)
    private fun getSortedResult(labelProbArray: Array<FloatArray>): List<Classifier.Recognition> {
        Log.d("Classifier", "List Size:(%d, %d, %d)".format(labelProbArray.size,labelProbArray[0].size,LABEL_LIST.size))

        val pq = PriorityQueue(
            MAX_RESULTS,
            Comparator<Classifier.Recognition> {
                    (_, _, confidence1), (_, _, confidence2)
                -> java.lang.Float.compare(confidence1, confidence2) * -1
            })

        for (i in LABEL_LIST.indices) {
            val confidence = labelProbArray[0][i]
            if (confidence >= THRESHOLD) {
                pq.add(Classifier.Recognition("" + i,
                    if (LABEL_LIST.size > i) LABEL_LIST[i] else "Unknown", confidence*100)
                )
            }
        }
        Log.d("Classifier", "pqsize:(%d)".format(pq.size))

        val recognitions = ArrayList<Classifier.Recognition>()
        val recognitionsSize = Math.min(pq.size, MAX_RESULTS)
        for (i in 0 until recognitionsSize) {
            recognitions.add(pq.poll())
        }
        return recognitions
    }

}