package com.example.myapplication

import MyDBHelper
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var textView1: TextView
    private lateinit var listView: ListView
    private lateinit var playerList: List<String> // 假設球員名單以字串列表的形式存在
    data class Player(val id: Int, val name: String)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listView)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        textView1 = findViewById(R.id.textView1)
        button1.setOnClickListener(mListener1)
        button2.setOnClickListener(mListener2)
        //取得球員列表資料庫
        val dbHelper = MyDBHelper(this, "player_list", null, 1)
        val database = dbHelper.readableDatabase
        // 定義查詢的列
        val projection = arrayOf("_id", "name")
        val cursor = database.query("player_list", projection
            , null, null, null, null, null)
        // 創建暫存的球員列表
        val tempPlayerList = mutableListOf<Player>()
        // 遍歷查詢結果並將每個球員的資料加入暫存列表
        while (cursor.moveToNext()) {
            val id = cursor.getInt(cursor.getColumnIndexOrThrow("_id"))
            val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
            val player = Player(id, name)
            tempPlayerList.add(player)
        }
        cursor.close()
        // 提取球員名稱列表
        playerList = tempPlayerList.map { it.name }
        // 創建adapter設置給ListView
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, playerList)
        listView.adapter = adapter
        // 點擊view事件
        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedPlayer = tempPlayerList[position] // 獲取選定的球員對象
            // 創建Intent，傳遞資料至詳細球員資料畫面
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("playerName", selectedPlayer.name)
            intent.putExtra("playerId", selectedPlayer.id)
            startActivity(intent)
        }

    }
    var mListener1 = View.OnClickListener {
        val intent = Intent(this, MainActivity3::class.java)
        startActivity(intent)
    }
    var mListener2 = View.OnClickListener {
        val intent = Intent(this, MainActivity4::class.java)
        startActivity(intent)
    }
}
