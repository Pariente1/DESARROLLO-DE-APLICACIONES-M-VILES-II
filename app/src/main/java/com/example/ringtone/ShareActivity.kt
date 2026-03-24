package com.example.ringtone

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ShareActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share)

        val imageIds = listOf(R.id.img_fcb, R.id.img_insta, R.id.img_twit, R.id.img_wsp)

        for (id in imageIds) {
            findViewById<ImageView>(id)?.setOnClickListener {
                DialogUtils.showPointsDialog(this)
            }
        }

        findViewById<android.widget.ImageButton>(R.id.btn_back)?.setOnClickListener {
            finish()
        }
    }
}
