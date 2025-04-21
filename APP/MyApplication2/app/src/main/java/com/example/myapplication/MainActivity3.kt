package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity3 : AppCompatActivity() {
    private lateinit var button30: Button
    private lateinit var button31: Button
    private lateinit var button6: Button
    private lateinit var button7: Button
    private lateinit var button8: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        button30 = findViewById<Button>(R.id.button30)
        button31 = findViewById<Button>(R.id.button31)
        button6 = findViewById<Button>(R.id.button6)
        button7 = findViewById<Button>(R.id.button7)
        button8 = findViewById<Button>(R.id.button8)
        button30.setOnClickListener(mListener3)
        button31.setOnClickListener(mListener1)
        button6.setOnClickListener(mListener6)
        button7.setOnClickListener(mListener7)
        button8.setOnClickListener(mListener8)

    }
    var mListener3 = View.OnClickListener {
        val uri: Uri = Uri.parse("https://www.cpbl.com.tw/")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
    var mListener1 = View.OnClickListener {
        val uri: Uri = Uri.parse("https://www.mlb.com/")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
    var mListener6 = View.OnClickListener {
        val uri: Uri = Uri.parse("https://npb.jp/")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
    var mListener7 = View.OnClickListener {
        val uri: Uri = Uri.parse("https://sports.ltn.com.tw/baseball")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
    var mListener8 = View.OnClickListener {
        val uri: Uri = Uri.parse("https://www.ptt.cc/bbs/Baseball/index.html")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        startActivity(intent)
    }
}