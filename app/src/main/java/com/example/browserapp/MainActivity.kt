package com.example.browserapp

import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.example.browserapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.webView.settings.javaScriptEnabled = true
        binding.webView.webViewClient = WebViewClient()

        binding.webView.webChromeClient = object : WebChromeClient() {
            override fun onReceivedTitle(view: WebView?, title: String?) {
                super.onReceivedTitle(view, title)
                if (!title.isNullOrEmpty()){
                    binding.toolbar.title = title
                }else {
                    binding.toolbar.title = getString(R.string.app_name)
                }
            }
        }

        binding.search.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH || actionId  == EditorInfo.IME_ACTION_DONE) {
                val url = binding.search.text.toString()
                binding.webView.loadUrl("https://"+url)
                true
            } else {
                false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
            menuInflater.inflate(R.menu.horizontal_menu, menu)
        }else{
            menuInflater.inflate(R.menu.vertical_menu, menu)
        }

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.green -> {
                binding.search.setBackgroundColor(getColor(R.color.green))
                true
            }
            R.id.blue -> {
                binding.search.setBackgroundColor(getColor(R.color.blue))
                true
            }
            R.id.violet -> {
                binding.search.setBackgroundColor((getColor(R.color.violet)))
                true
            }
            R.id.brown -> {
                binding.search.setBackgroundColor((getColor(R.color.brown)))
                true
            }
            R.id.yellow -> {
                binding.search.setBackgroundColor((getColor(R.color.yellow)))
                true
            }
            R.id.orange -> {
                binding.search.setBackgroundColor((getColor(R.color.orange)))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
