package uz.gita.gitaacademy

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity


class WebView : AppCompatActivity() {
    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        window.navigationBarColor = Color.parseColor("#1A1E4E").toDarkenColor()
        setContentView(R.layout.activity_web_view)
        val myWebView: WebView = findViewById(R.id.webView)

        val bundle: Bundle? = intent?.extras
        val option: String? = bundle?.getString("option")
        Log.d("TTT", "keldi $option")
        myWebView.loadUrl(option!!)
    }
}