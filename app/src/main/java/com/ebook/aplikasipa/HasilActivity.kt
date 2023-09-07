package com.ebook.aplikasipa

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast



class HasilActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hasil)

        val byteArray = intent.getByteArrayExtra("image")
        val bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray!!.size)
        val nama = intent.getStringExtra("nama")

        val penyakit: TextView = findViewById(R.id.penyakit)
        val gambar: ImageView = findViewById(R.id.foto)
        val gejala: TextView = findViewById(R.id.txtGejala)
        val obat: TextView = findViewById(R.id.txtObat)
        val btnKembali: Button = findViewById(R.id.btkembali)


        penyakit.text = "Nama Penyakit: " + intent.getStringExtra("penyakit")

        gambar.setImageBitmap(bitmap)

        btnKembali.setOnClickListener {
            onBackPressed()
        }

//        if (nama == "Abses"){
//            gejala.text = "1. Pembengkakan: Abses biasanya ditandai dengan adanya pembengkakan yang terlihat pada kulit atau jaringan di sekitar area yang terinfeksi. Pembengkakan ini bisa terlihat sebagai benjolan merah, berukuran kecil hingga besar.\n" +
//                    "\n" +
//                    "2. Rasa sakit: Kucing yang mengalami abses cenderung merasa nyeri atau tidak nyaman pada area yang terinfeksi. Mereka mungkin menunjukkan tanda-tanda ketidaknyamanan seperti menghindari sentuhan di area tersebut atau mengeong dengan nada tinggi.\n" +
//                    "\n" +
//                    "3. Perubahan perilaku: Kucing yang menderita abses sering kali menjadi lebih lemas, kurang aktif, atau kehilangan nafsu makan. Mereka mungkin juga terlihat kurang berminat bermain atau berinteraksi dengan lingkungan sekitar.\n" +
//                    "\n" +
//                    "4. Perubahan pada kulit: Kulit di sekitar abses bisa terlihat merah, panas, dan terasa gatal. Pada beberapa kasus, abses dapat pecah, menghasilkan luka terbuka atau borok yang dapat berisi nanah atau cairan.\n" +
//                    "\n" +
//                    "5. Gangguan pada sistem kekebalan tubuh: Kucing dengan abses seringkali juga mengalami demam, kehilangan berat badan, atau penurunan energi secara keseluruhan. Abses merupakan indikasi adanya infeksi, dan tubuh kucing perlu melawan infeksi tersebut."
//
//            obat.text = "Cara Mengobati Abses: "+ "\n" +
//                        "Pemberian antbiotik pada area abses dan obat penghilang rasa sakit. Jika abses sudah begitu parah, harap untuk membawa ke dokter hewan" +
//                        "untuk mendapatkan penanganan lebih lanjut seperti operasi abses."
//        }
        if (nama == "Jamur") {
            gejala.text = "1. Perubahan pada kulit: Infeksi jamur pada kucing umumnya mempengaruhi kulit, dan gejalanya dapat berupa daerah kulit yang mengalami kebotakan, kering, bersisik, atau mengelupas. Anda mungkin melihat adanya perubahan warna pada kulit, seperti bercak merah atau kecoklatan.\n" +
                    "\n" +
                    "2. Gatal-gatal: Infeksi jamur dapat menyebabkan rasa gatal yang parah pada kucing. Kucing mungkin akan terus menggaruk atau menjilati area yang terinfeksi untuk mencoba meredakan rasa gatalnya. Hal ini dapat menyebabkan iritasi lebih lanjut pada kulit dan memperburuk kondisi.\n" +
                    "\n" +
                    "3. Lesi atau luka: Dalam beberapa kasus, infeksi jamur pada kucing dapat menyebabkan munculnya lesi atau luka di area yang terinfeksi. Lesi tersebut bisa berupa borok, kulit pecah-pecah, atau lecet.\n" +
                    "\n" +
                    "4. Kelembapan berlebih: Infeksi jamur seringkali menyebabkan daerah yang terkena menjadi lembap atau berminyak. Kulit kucing mungkin terasa lembab atau berminyak saat disentuh.\n" +
                    "\n" +
                    "5. Kehilangan bulu: Infeksi jamur dapat menyebabkan kebotakan pada area yang terinfeksi. Kucing dapat mengalami kehilangan bulu yang meluas di sekitar daerah yang terkena, dan kulit di bawahnya dapat terlihat kemerahan atau teriritasi."

            obat.text = "Cara Mengobati Jamur:" + "\n"+
                        "Ada beberpa produk yang dapat digunakan untuk menghilangkan jamur pada kucing, antara lain: " +"\n" +
                        "1. Krim Antijamur contohnya miconazole." + "\n" +
                        "2. Shampo Antijamur yang mengandung miconazole dan chlorhexidine." +"\n" +
                        "3. Cairan Antijamur contohnya lime sulfur atau enilconazole."

        }
        else if (nama == "Jerawat Kucing"){
            gejala.text = "1. Munculnya komedo atau \"jerawat\": Jerawat pada kucing biasanya terlihat sebagai komedo hitam atau putih yang muncul pada dagu, bibir bawah, atau area sekitar dagu. Komedo dapat berupa bintik-bintik kecil atau benjolan yang terlihat seperti jerawat manusia.\n" +
                        "\n" +
                        "2. Peradangan dan kemerahan: Area yang terinfeksi jerawat pada kucing bisa menjadi merah, teriritasi, dan terlihat membengkak. Kemerahan dan peradangan ini terjadi karena folikel rambut tersumbat dan infeksi bakteri sekunder.\n" +
                        "\n" +
                        "3. Gatal-gatal: Kucing dengan jerawat dapat merasa gatal atau tidak nyaman pada area yang terkena. Mereka mungkin menggaruk atau menggosok-gosokkan bagian dagu mereka pada benda-benda untuk mencoba meredakan gatalnya.\n" +
                        "\n" +
                        "4. Luka dan keropeng: Jerawat yang parah atau terinfeksi dapat menyebabkan luka atau keropeng pada kulit kucing. Kucing mungkin juga mengalami perubahan pada kondisi bulu di sekitar area yang terkena, seperti kehilangan bulu atau kebotakan.\n" +
                        "\n" +
                        "5. Infeksi sekunder: Kadang-kadang, jerawat pada kucing dapat menyebabkan infeksi bakteri sekunder. Gejalanya termasuk adanya nanah, bau yang tidak sedap, dan peningkatan kemerahan dan peradangan pada area yang terkena."

            obat.text = "Cara Mengobati Jerawat Kucing: "+"\n"+
                        "1. Dengan membersihkan area sekitarnya dengan chlorhexidine antibacterial. Bersihkan bagian jerawat kucing beberapa kali sehari hingga breakout-nya memudar." +"\n"+
                        "2. Selain dibersihkan, cara menghilangkan jerawat kucing selanjutnya yang bisa dilakukan adalah dengan memberikan kompres air hangat untuk mengurangi pembengkakan.\n" +
                        "3. Pemberian makanan mengandung asam lemak seperti omega-3 juga bisa membantu menjaga kesehatan kulit.\n" +
                        "4. Menggunakan shampoo antibakterial atau anti fungal.\n" +
                        "5. Memberikan gel pereda jerawat kucing.\n" +
                        "6. Untuk beberapa kasus, dokter hewan juga merekomendasikan untuk memberikan antibiotik atau antiradang untuk mengurangi pembengkakan."

        }
        else if (nama == "Scabies"){
            gejala.text = "1. Kucing sering menjilat, menggigit, atau menggaruk area tubuh yang terkena tungau.\n" +
                    "\n" +
                    "2. Area tubuh yang sering digaruk karena adanya tungau, dapat menyebabkan kerontokan bulu kucing.\n" +
                    "\n" +
                    "3. Terlihat bercak bersisik pada kulit, luka, atau koreng.\n" +
                    "\n" +
                    "4. Tungau telinga biasanya membuat kucing sering menggelengkan kepala atau meletakkan telinga pada lantai.\n" +
                    "\n" +
                    "5. Tungau telinga juga sering menyebabkan kotoran dan residu tungau menumpuk di bagian telinga.\n" +
                    "\n" +
                    "6. Bulu kucing menjadi rontok atau pitak.\n" +
                    "\n" +
                    "7. Kulit kucing menjadi kemerahan dan mengalami iritasi dan kemerahan.\n" +
                    "\n" +
                    "8. Kulit kucing berkerak atau berkerut, terutama pada area telinga."

            obat.text = "Cara Mengobati Scabies Kucing: "+"\n"+
                        "Pengobatan scabies pada kucing yang sudah terbukti aman dan efektif adalah dengan memberikan obat tetes kutu yang mengandung Selamectin, Fluralaner, Sarolaner, atau Moxadectin ke kucing yang terinfeksi."

        }else {
            gejala.text =
                        "1. Gatal-gatal yang parah: Kucing yang terinfeksi tungau telinga dapat mengalami gatal-gatal yang parah di daerah telinga. Mereka mungkin menggaruk, menggeleng-gelengkan kepala, atau menggosokkan telinga mereka pada benda-benda untuk mencoba meredakan gatal.\n" +
                        "\n" +
                        "2. Sekresi berwarna hitam atau coklat: Tungau telinga kucing dapat menyebabkan produksi cairan berwarna hitam atau coklat di dalam telinga kucing. Cairan ini dapat terlihat seperti bubuk kecil dan biasanya berbau tidak sedap.\n" +
                        "\n" +
                        "3. Kerak pada telinga: Kucing dengan infeksi tungau telinga dapat mengalami pembentukan kerak atau keropeng pada telinga mereka.\n" +
                        "\n" +
                        "4. Kehilangan pendengaran: Jika infeksi tidak diobati, kucing dapat mengalami kehilangan pendengaran. Kucing dapat menunjukkan gejala seperti ketidakmampuan untuk merespons suara atau mengubah perilaku ketika dipanggil.\n" +
                        "\n" +
                        "5. Perubahan perilaku: Kucing dengan tungau telinga dapat menunjukkan perubahan perilaku seperti gelisah, tidak nyaman, atau menghindari sentuhan pada daerah telinga."

            obat.text = "Cara Mengobati Tungau Telinga Kucing: "+"\n"+
                        "langkah pertama yang harus dilakukan adalah membersihkan telinga. Hapus penumpukan kotoran dengan membilas telinga dengan sangat lembut. Gunakan kapas yang ditetesi dengan baby oil untuk membersihkan telinga dan sisa-sisa kotoran." +
                        "Lebih baik lagi menggunakan obat pembersih telinga khusus kucing, yang kemudian diteteskan ke dalam lubang telinga kucing. "

        }

    }

}


