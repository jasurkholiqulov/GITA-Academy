package uz.gita.gitaacademy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView



class Example : AppCompatActivity() {

    private val data =  ArrayList<Data>()
    private val adapter = DataAdapter(data,this)
    private lateinit var list : RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_example)
/*
        val imageView = findViewById<ImageView>(R.id.imageView1212)
        val displayMetrics = resources.displayMetrics

        val width = displayMetrics.widthPixels.toInt()
        val height = displayMetrics.heightPixels.toInt()
        Picasso.with(this)
            .load("https://telegra.ph/file/94c6426bbbfbb20480483.jpg")
            .resize( height,width)
            .into(imageView)*/
        list = findViewById(R.id.recyclerView)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)

//        adapter.itemOnClick = {
//            when(it.id){
//                1-> setArgs(11)
//                2-> setArgs(12)
//            }
//        }
        adapter.itemClickListener {
            Log.d("TTT","$it")
            setArgs(it.url)
        }
        data.add(Data(1,"https://telegra.ph/Dastur-interfeysini-yigishda-yol-qoyiladigan-oddiy-xatoliklar-12-06","https://telegra.ph/file/dc006765bc07937258969.jpg","Dastur interfeysini yigʻishda yoʻl qoʻyiladigan oddiy xatoliklar"))
        data.add(Data(2,"https://telegra.ph/Dasturlashni-kitobdan-organish-kerakmi-12-04","https://telegra.ph/file/f69aa543aabc7266647d4.jpg","Dasturlashni kitobdan o'rganish kerakmi?"))
        data.add(Data(3,"https://telegra.ph/Dasturlashni-organishda-duch-kelinadigan-qiyinchiliklar-12-05","https://telegra.ph/file/624828aca5358802a77de.jpg","Dasturlashni oʻrganishda duch kelinadigan qiyinchiliklar"))
        data.add(Data(4,"https://telegra.ph/Compiler-Interpretator-va-Jit-compiler-lar-haqida-qisqacha-12-16","https://telegra.ph/file/421c3c89640dd47c077d4.jpg","Compiler, Interpretator va Jit compiler lar haqida qisqacha"))
        data.add(Data(5,"https://telegra.ph/Android-app-development-uchun-kotlin-javadan-yaxshiroqmi-12-07","https://telegra.ph/file/74df805210b1ee894ac01.jpg","Android ilovalar ishlab chiqish uchun Kotlin Javadan yaxshiroqmi?"))
        data.add(Data(6,"https://telegra.ph/Android-SharedPreferences-05-14","https://telegra.ph/file/274a105cd09dae27b1a56.png","Android SharedPreferences"))

    }

    private fun setArgs(c : String){
        val intent = Intent(this, WebView::class.java)
        intent.putExtra("option",c)
        Log.d("TTT","ketdi $c")
        startActivity(intent)
    }
}