package com.chatbot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.chatbotdialog.ChatDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chatButton.setOnClickListener {
            // The device is using a large layout, so show the fragment as a dialog
            ChatDialog().show(supportFragmentManager, "dialog")
        }
    }
}
