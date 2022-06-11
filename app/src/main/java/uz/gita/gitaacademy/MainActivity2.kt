package uz.gita.gitaacademy

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.view.WindowManager

import android.view.View
import android.view.Window
import androidx.core.widget.NestedScrollView
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.appbar.MaterialToolbar


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        changeNavigationBarColor(Color.BLACK.toDarkenColor())
        window.navigationBarColor = Color.WHITE
        setContentView(R.layout.item_layout1)
        setSupportActionBar(findViewById(R.id.toolbar))

        val appbar = findViewById<AppBarLayout>(R.id.appbar)
        val toolbarLayout = findViewById<CollapsingToolbarLayout>(R.id.toolbar_layout)
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        toolbarLayout.title = ""
        findViewById<NestedScrollView>(R.id.plant_detail_scrollview).setOnScrollChangeListener(
            NestedScrollView.OnScrollChangeListener { _, _, scrollY, _, _ ->


                val shouldShowToolbar = scrollY > toolbar.height
                var isToolbarShown = false
                toolbarLayout.title = ""

                if (isToolbarShown != shouldShowToolbar) {
                    isToolbarShown = shouldShowToolbar

                    appbar.isActivated = shouldShowToolbar

                    toolbarLayout.title = "GITA academy "
                    toolbar.visibility = View.VISIBLE
                    toolbarLayout.isTitleEnabled = shouldShowToolbar
                } else {
                    toolbarLayout.title = ""
                    toolbar.visibility = View.INVISIBLE
                }
            }
        )
        toolbar.setNavigationOnClickListener {
            finish()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val w: Window = window
        w.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        val title = findViewById<TextView>(R.id.text_title)
        val description = findViewById<TextView>(R.id.description)
        val image: ImageView = findViewById(R.id.detail_image)
        val text = findViewById<TextView>(R.id.text)

        val bundle: Bundle? = intent?.extras
        val option: Int? = bundle?.getInt("option")
        when (option) {
            1 -> {
                title.setText(R.string.title_qudrataka)
                description.setText(R.string.job_qudrat_aka)
                image.setImageResource(R.drawable.photoqudrataka)
                text.setText(R.string.text_qudrataka)
            }
            2 -> {
                title.setText(R.string.title_sherzodaka)
                description.setText(R.string.job_sherzodbek_aka)
                image.setImageResource(R.drawable.rasm_sherzzoaka)
                text.setText(R.string.text_sherzodaka)
            }
            3 -> {
                title.setText(R.string.title_abdumajidaka)
                description.setText(R.string.job_abdumajid_aka)
                image.setImageResource(R.drawable.abdmaka2)
                text.setText(R.string.text_abdumajidaka)
            }
            4 -> {
                title.setText(R.string.title_temurusmon)
                description.setText(R.string.job_temur_aka)
                image.setImageResource(R.drawable.attr_temur_usmon)
                text.setText(R.string.text_temurusmon_two)
            }
            5 -> {
                description.setText(R.string.job_sherali_aka)
                image.setImageResource(R.drawable.sh2)
                text.setText(R.string.sherali_aka)
            }
            6 -> {
                title.setText(R.string.title_jahongir)
                description.setText(R.string.job_jahongir_aka)
                image.setImageResource(R.drawable.j3)
                text.setText(R.string.text_jahongir)
            }
        }
        findViewById<TextView>(R.id.telegram).setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW,
                Uri.parse("https://t.me/DasturchilarAkademiyasi")))
        }
        findViewById<TextView>(R.id.facebook).setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.facebook.com/gitauzofficial")))
        }
        findViewById<TextView>(R.id.youtube).setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.youtube.com/c/GITADasturchilarAkademiyasi")))
        }
        findViewById<TextView>(R.id.instagram).setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW,
                Uri.parse("https://www.instagram.com/gita.uzofficial")))
        }

    }
}