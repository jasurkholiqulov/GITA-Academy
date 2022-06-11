package uz.gita.gitaacademy

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.FrameLayout


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       /* val crashButton = Button(this)
        crashButton.text = "Test Crash"
        crashButton.setOnClickListener {
            throw RuntimeException("Test Crash") // Force a crash
        }*/

       /* addContentView(crashButton, ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT))
*/
        window.statusBarColor = Color.parseColor("#1A1E4E").toDarkenColor()
     //   window.navigationBarColor = Color.parseColor("#1A1E4E").toDarkenColor()
        findViewById<FrameLayout>(R.id.extrainfo).setOnClickListener { startActivity(Intent(this,
            Example::class.java)) }

        findViewById<FrameLayout>(R.id.qudrataka).setOnClickListener{ setArgs(1) }
        findViewById<FrameLayout>(R.id.sherzodaka).setOnClickListener{ setArgs(2) }
        findViewById<FrameLayout>(R.id.abdumajidaka).setOnClickListener{ setArgs(3) }
        findViewById<FrameLayout>(R.id.sheraliaka).setOnClickListener{ setArgs(5) }
        findViewById<FrameLayout>(R.id.jahongiraka).setOnClickListener{ setArgs(6) }
        findViewById<FrameLayout>(R.id.temur).setOnClickListener{setArgs(4) }
    }
    private fun setArgs(c : Int){
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra("option",c)
        startActivity(intent)
    }
    override fun onBackPressed() {
        super.onBackPressed()
        finishAffinity()
    }
}