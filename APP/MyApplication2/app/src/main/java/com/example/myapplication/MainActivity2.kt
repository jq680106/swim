package com.example.myapplication

import MyDBHelper
import MyDBHelper.Companion.COLUMN_PLAYER_AVG
import MyDBHelper.Companion.COLUMN_PLAYER_G
import MyDBHelper.Companion.COLUMN_PLAYER_H
import MyDBHelper.Companion.COLUMN_PLAYER_HR
import MyDBHelper.Companion.COLUMN_PLAYER_ID
import MyDBHelper.Companion.COLUMN_PLAYER_K
import MyDBHelper.Companion.COLUMN_PLAYER_R
import MyDBHelper.Companion.TABLE_PLAYER_STATS
import android.annotation.SuppressLint
import android.database.sqlite.SQLiteDatabase
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    private lateinit var textView2: TextView
    private lateinit var textView21: TextView
    //設置table裡面的textview
    private fun createTextView(text: String): TextView {
        val textView = TextView(this)
        textView.text = text
        textView.setPadding(16, 16, 16, 16)
        return textView
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        textView2 = findViewById(R.id.textView2)
        textView21 = findViewById(R.id.textView21)
            //接受上一頁的ID及NAME並顯示
        intent?.extras?.let {
            val playerName = intent.getStringExtra("playerName")
            val playerId = intent.getIntExtra("playerId", 0)
            textView2.text = "No.$playerId Name: $playerName"
        }
        val dbHelper = MyDBHelper(this, "player_list", null, 1)
        val database = dbHelper.readableDatabase
        // 查詢球員詳細資料
        queryPlayerDetails(database)
        // 查詢球員數據
        queryPlayerStats(database)

        // 关闭数据库连接
        database.close()
    }

    private fun queryPlayerDetails(database: SQLiteDatabase) {
        // 從Intent拿取ID
        val playerId = intent.getIntExtra("playerId", 0)
        // 要查詢的列
        val projection = arrayOf(
            MyDBHelper.COLUMN_PLAYER_NICKNAME,
            MyDBHelper.COLUMN_PLAYER_COUNTRY,
            MyDBHelper.COLUMN_PLAYER_POSITION,
            MyDBHelper.COLUMN_PLAYER_HABITS,
            MyDBHelper.COLUMN_PLAYER_H_W,
            MyDBHelper.COLUMN_PLAYER_OLD
        )
        //指定選擇的球員
        val selection = "${MyDBHelper.COLUMN_PLAYER_DETAIL_ID} = ?"
        val selectionArgs = arrayOf(playerId.toString())

        // 進行查詢
        val cursor = database.query(
            MyDBHelper.TABLE_PLAYER_DETAIL,
            projection,
            selection,
            selectionArgs,
            null,
            null,
            null
        )
        // 查询结果是否存在
        if (cursor.moveToFirst()) {
            val country =
                cursor.getString(cursor.getColumnIndexOrThrow(MyDBHelper.COLUMN_PLAYER_COUNTRY))
            val nickname =
                cursor.getString(cursor.getColumnIndexOrThrow(MyDBHelper.COLUMN_PLAYER_NICKNAME))
            val position =
                cursor.getString(cursor.getColumnIndexOrThrow(MyDBHelper.COLUMN_PLAYER_POSITION))
            val habits =
                cursor.getString(cursor.getColumnIndexOrThrow(MyDBHelper.COLUMN_PLAYER_HABITS))
            val hw = cursor.getString(cursor.getColumnIndexOrThrow(MyDBHelper.COLUMN_PLAYER_H_W))
            val old = cursor.getString(cursor.getColumnIndexOrThrow(MyDBHelper.COLUMN_PLAYER_OLD))
            val text = "Country: $country\nNickname: $nickname\n" +
                    "Position: $position\n" +
                    "Habits: $habits\n" +
                    "H/W: $hw\n" +
                    "Old: $old"
            textView21.text = text
        }

        cursor.close()
    }
    private fun queryPlayerStats(database: SQLiteDatabase) {
        val tableLayout = findViewById<TableLayout>(R.id.tableLayout)
        val headerRow = TableRow(this)
        headerRow.setBackgroundColor(Color.LTGRAY)
        headerRow.addView(createTextView("AVG"))
        headerRow.addView(createTextView("HR"))
        headerRow.addView(createTextView("R"))
        headerRow.addView(createTextView("H"))
        headerRow.addView(createTextView("K"))
        headerRow.addView(createTextView("G"))
        // 将標題加到 TableLayout
        tableLayout.addView(headerRow)
        // 从 Intent取得球员 ID
        val playerId = intent.getIntExtra("playerId", 0)
        // 查詢條件
        val projection = arrayOf(
            MyDBHelper.COLUMN_PLAYER_AVG,
            MyDBHelper.COLUMN_PLAYER_HR,
            MyDBHelper.COLUMN_PLAYER_R,
            MyDBHelper.COLUMN_PLAYER_H,
            MyDBHelper.COLUMN_PLAYER_K,
            MyDBHelper.COLUMN_PLAYER_G
        )
        val selection = "${MyDBHelper.COLUMN_PLAYER_STAT_ID} = ?"
        val selectionArgs = arrayOf(playerId.toString())

        // 查询
        val cursor = database.query(
            MyDBHelper.TABLE_PLAYER_STATS,
            projection,
            selection,
            selectionArgs,
            null,
            null,
            null
        )
        //取得資料
        if (cursor.moveToFirst()) {
            do {
                val avg =cursor.getDouble(cursor.getColumnIndexOrThrow(MyDBHelper.COLUMN_PLAYER_AVG))
                val hr = cursor.getInt(cursor.getColumnIndexOrThrow(MyDBHelper.COLUMN_PLAYER_HR))
                val r = cursor.getInt(cursor.getColumnIndexOrThrow(MyDBHelper.COLUMN_PLAYER_R))
                val h = cursor.getInt(cursor.getColumnIndexOrThrow(MyDBHelper.COLUMN_PLAYER_H))
                val k = cursor.getInt(cursor.getColumnIndexOrThrow(MyDBHelper.COLUMN_PLAYER_K))
                val g = cursor.getInt(cursor.getColumnIndexOrThrow(MyDBHelper.COLUMN_PLAYER_G))

                // 创建新的 TableRow 並添加 TextView
                val dataRow = TableRow(this)
                dataRow.addView(createTextView(avg.toString()))
                dataRow.addView(createTextView(hr.toString()))
                dataRow.addView(createTextView(r.toString()))
                dataRow.addView(createTextView(h.toString()))
                dataRow.addView(createTextView(k.toString()))
                dataRow.addView(createTextView(g.toString()))
                // 數據插入tableView
                tableLayout.addView(dataRow)
            } while (cursor.moveToNext())
        }

        cursor.close()
    }
}