package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity4 : AppCompatActivity() {
    private lateinit var button3: Button
    private lateinit var button4: Button
    private lateinit var button5: Button
    private lateinit var textView4: TextView
    private lateinit var editText2: EditText
    private lateinit var editText3: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        button3 = findViewById<Button>(R.id.button3)
        button4 = findViewById<Button>(R.id.button4)
        button5 = findViewById<Button>(R.id.button5)
        textView4 = findViewById<TextView>(R.id.textView4)
        editText2 = findViewById<EditText>(R.id.editText2)
        editText3 = findViewById<EditText>(R.id.editText3)
        button3.setOnClickListener(mListener)
        button4.setOnClickListener(mListener2)
        button5.setOnClickListener(mListener3)
    }
    var mListener = View.OnClickListener {
        var PA = editText3.text.toString().toInt()
        var H = editText2.text.toString().toInt()
        var avg:Float=H.toFloat()/PA.toFloat()
        val count = getSharedPreferences("personal", 0)
        count.edit()
            .putInt("PA",PA)
            .putInt("H",H)
            .putFloat("avg",avg)
            .commit()
    }
    var mListener2 = View.OnClickListener {
        val count = getSharedPreferences("personal", 0)
        val savedPA = count.getInt("PA", 0)
        val savedH = count.getInt("H", 0)
        val savedAvg = count.getFloat("avg", 0.0f)
        textView4.text = "打數: $savedPA, 安打: $savedH, 打擊率: $savedAvg"
    }
    var mListener3 = View.OnClickListener {
        val count = getSharedPreferences("personal", 0)
        count.edit().clear().commit()
    }
}