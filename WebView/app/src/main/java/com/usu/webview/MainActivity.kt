package com.usu.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val webView = WebView(this)
        webView.loadUrl("https://usu.edu")
        webView.webViewClient = WebViewClient()
        val mainLayout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
        }

        val button = Button(this).apply {
            text = "Go to a new site"
            setOnClickListener {
                webView.loadUrl("https://google.com")
            }
        }
        mainLayout.addView(button)
        mainLayout.addView(webView)
        setContentView(mainLayout)
    }
}