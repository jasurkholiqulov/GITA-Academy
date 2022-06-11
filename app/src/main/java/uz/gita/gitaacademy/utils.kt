package uz.gita.gitaacademy

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity

fun Int.toDarkenColor(): Int {
    val hsv = FloatArray(3)
    Color.colorToHSV(this, hsv)
    hsv[2] *= 0.8f
    return Color.HSVToColor(hsv)
}
fun AppCompatActivity.changeStatusBarColor(color: Int){
    window.statusBarColor = color
}

fun AppCompatActivity.changeNavigationBarColor(color: Int){
    window.navigationBarColor = color
}