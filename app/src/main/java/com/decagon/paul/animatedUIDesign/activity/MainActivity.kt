package com.decagon.paul.animatedUIDesign.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.airbnb.lottie.LottieAnimationView
import com.decagon.paul.animatedUIDesign.R

class MainActivity : AppCompatActivity() {

    lateinit var lottieAnimationView: LottieAnimationView;
    lateinit var lottieAnimationView2: LottieAnimationView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*used a lottie animation to create a splash screen animation */
        lottieAnimationView2 = findViewById(R.id.lottiePro)
        lottieAnimationView = findViewById(R.id.lottieRelax)
        lottieAnimationView2.animate().translationY(-1600F).setDuration(1000).startDelay = 4000
        lottieAnimationView.animate().translationX(-100F).setDuration(1000).startDelay = 4000


        /*handler to delay the switching to the home activity so as to allow the splash screen to display*/
        val handler = Handler(Looper.myLooper()!!)
        handler.postDelayed(
            {
                Intent(this, HomeActivity::class.java).apply {
                    startActivity(this)
                    finish()
                }
            }, 4600
        )

    }
}