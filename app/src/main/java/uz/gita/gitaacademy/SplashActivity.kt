package uz.gita.gitaacademy

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        changeStatusBarColor(Color.WHITE.toDarkenColor())
        CoroutineScope(Dispatchers.Default).launch(Dispatchers.Default) {
            delay(2000)
            val i = Intent(baseContext, MainActivity::class.java)
            startActivity(i)
        }
    }
}