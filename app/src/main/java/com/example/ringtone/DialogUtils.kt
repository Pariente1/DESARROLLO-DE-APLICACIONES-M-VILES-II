package com.example.ringtone

import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AlertDialog

object DialogUtils {
    fun showPointsDialog(context: Context) {
        val dialog = AlertDialog.Builder(context).create()
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.dialog_points, null)
        dialog.setView(view)

        view.findViewById<Button>(R.id.btnAccept).setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()

        val window = dialog.window
        val params = window?.attributes
        params?.gravity = Gravity.CENTER
        params?.y = -150
        window?.attributes = params
    }
}
