package com.chatbotdialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings.LOAD_CACHE_ELSE_NETWORK
import android.webkit.WebView
import androidx.fragment.app.DialogFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ChatDialog : DialogFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Holo_Light);
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // apply web view setting and load the url
        view.findViewById<WebView>(R.id.chatWebView).apply {
            // enable java setting for web view
            settings.javaScriptEnabled = true

            // enable the wide view mode
            settings.useWideViewPort = true
            settings.loadWithOverviewMode = true

            // enable load images automatically
            settings.loadsImagesAutomatically = true

            // dom storage and enable the cache mode
            settings.domStorageEnabled = true
            settings.cacheMode = LOAD_CACHE_ELSE_NETWORK
            settings.setAppCacheEnabled(true)

            // load the url
            loadUrl("https://chats.landbot.io/v2/H-698159-96JWRD7RPM27F86R/index.html")
        }

        // close dialog
        view.findViewById<FloatingActionButton>(R.id.closeChatDialog).setOnClickListener {
            dismiss()
        }
    }
}