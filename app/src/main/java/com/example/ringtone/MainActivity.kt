package com.example.ringtone

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import com.example.ringtone.R

class MainActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null
    private var lastButton: ImageButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val logoSplash = findViewById<ImageView>(R.id.logoSplash)
        val songList = findViewById<ScrollView>(R.id.songList)

        val animAbajo = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo)
        val animArriba = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba)

        animAbajo.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {}
            override fun onAnimationRepeat(animation: Animation?) {}
            override fun onAnimationEnd(animation: Animation?) {
                songList.visibility = View.VISIBLE
                songList.startAnimation(animArriba)
            }
        })

        logoSplash.startAnimation(animAbajo)

        setupButton(R.id.btn_1, R.raw.iphone_notificacion)
        setupButton(R.id.btn_2, R.raw.mario_bros_vida)
        setupButton(R.id.btn_3, R.raw.messenger_tono_mensaje_)
        setupButton(R.id.btn_4, R.raw.pacman_dies)
        setupButton(R.id.btn_5, R.raw.ringtones_original_iphone)
        setupButton(R.id.btn_6, R.raw.ringtones_pato_donald)
        setupButton(R.id.btn_7, R.raw.ringtones_super_mario_bros)
        setupButton(R.id.btn_8, R.raw.tono_mensaje_3_)
        setupButton(R.id.btn_9, R.raw.vehicle031)
        setupButton(R.id.btn_10, R.raw.whistle_campana_whatsapp)
    }

    private fun setupButton(buttonId: Int, audioRes: Int) {
        val button = findViewById<ImageButton>(buttonId)

        button.setOnClickListener {
            if (lastButton == button && mediaPlayer?.isPlaying == true) {
                mediaPlayer?.pause()
                button.setImageResource(R.drawable.play)
            } else {
                lastButton?.setImageResource(R.drawable.play)
                mediaPlayer?.stop()
                mediaPlayer?.release()

                mediaPlayer = MediaPlayer.create(this, audioRes)
                mediaPlayer?.start()
                button.setImageResource(R.drawable.pause)
                lastButton = button

                mediaPlayer?.setOnCompletionListener {
                    button.setImageResource(R.drawable.play)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}