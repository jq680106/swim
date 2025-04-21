package com.example.myapplication

import MyDBHelper
import MyDBHelper.Companion.COLUMN_PLAYER_AVG
import MyDBHelper.Companion.COLUMN_PLAYER_COUNTRY
import MyDBHelper.Companion.COLUMN_PLAYER_DETAIL_ID
import MyDBHelper.Companion.COLUMN_PLAYER_G
import MyDBHelper.Companion.COLUMN_PLAYER_H
import MyDBHelper.Companion.COLUMN_PLAYER_HABITS
import MyDBHelper.Companion.COLUMN_PLAYER_HR
import MyDBHelper.Companion.COLUMN_PLAYER_H_W
import MyDBHelper.Companion.COLUMN_PLAYER_ID
import MyDBHelper.Companion.COLUMN_PLAYER_K
import MyDBHelper.Companion.COLUMN_PLAYER_NAME
import MyDBHelper.Companion.COLUMN_PLAYER_NICKNAME
import MyDBHelper.Companion.COLUMN_PLAYER_OLD
import MyDBHelper.Companion.COLUMN_PLAYER_POSITION
import MyDBHelper.Companion.COLUMN_PLAYER_R
import MyDBHelper.Companion.COLUMN_PLAYER_STAT_ID
import MyDBHelper.Companion.TABLE_PLAYER_DETAIL
import MyDBHelper.Companion.TABLE_PLAYER_LIST
import MyDBHelper.Companion.TABLE_PLAYER_STATS
import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Intent
import android.database.DatabaseUtils
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
class enter : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var textView: TextView
    private lateinit var dbHelper: MyDBHelper
    private lateinit var db: SQLiteDatabase
    //進入畫面
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enter)
        button = findViewById<Button>(R.id.button)
        textView = findViewById<TextView>(R.id.textView)
        button.setOnClickListener(mListener3)
        //開始前先清除資料表
        clearPlayerDetailTable()
        dbHelper = MyDBHelper(this, "player_list", null, 1)
        db = dbHelper.writableDatabase
        //插入球員名單
        insertPlayer(1, "Ken")
        insertPlayer(2, "Ben")
        insertPlayer(3, "May")
        insertPlayer(4, "Adam")
        insertPlayer(5, "Mouse")
        insertPlayer(6, "King")
        insertPlayer(7, "Ryan")
        insertPlayer(8, "Ares")
        insertPlayer(9, "Morris")
        insertPlayer(10, "Nick")
        //插入球員詳細資料
        insertPlayerDetails( 1, "Big Bro", "USA","3B","L","184_80","30Y")
        insertPlayerDetails( 2, "SuperHero", "JAPAN","2B","R","190_100","32Y")
        insertPlayerDetails( 3, "Big Man", "TAIWAN","1B","R","184_60","40Y")
        insertPlayerDetails( 4, "Key Man", "JAPAN","C","R","195_80","30Y")
        insertPlayerDetails( 5, "Kris", "TAIWAN","C","R","170_90","20Y")
        insertPlayerDetails( 6, "Amigo", "JAPAN","SS","R","199_75","23Y")
        insertPlayerDetails( 7, "San", "TAIWAN","RF","R","170_80","31Y")
        insertPlayerDetails( 8, "Plus", "JAPAN","CF","R","185_90","32Y")
        insertPlayerDetails( 9, "CJ", "TAIWAN","LF","R","200_75","41Y")
        insertPlayerDetails( 10, "AJ", "TAIWAN","C","R","192_90","44Y")
        //插入球員數據
        insertPlayerStats(  1,0.325, 13, 80, 150, 10,120)
        insertPlayerStats(  2,0.302, 23, 70, 120, 80,110)
        insertPlayerStats(  3,0.286, 15, 60, 100, 78,100)
        insertPlayerStats(  4,0.135, 36, 81, 150, 13,120)
        insertPlayerStats(  5,0.363, 23, 70, 120, 30,110)
        insertPlayerStats(  6,0.246, 15, 60, 100, 70,100)
        insertPlayerStats(  7,0.375, 30, 82, 150, 16,120)
        insertPlayerStats(  8,0.102, 25, 74, 120, 80,110)
        insertPlayerStats(  9,0.186, 15, 40, 100, 70,100)
        insertPlayerStats(  10,0.286, 15, 30, 100, 70,100)
    }
    //切至球員面
    private var mListener3 = View.OnClickListener {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    //球員數據函式
    private fun insertPlayerStats(
        playerId:Int,
        avg: Double,
        hr: Int,
        r: Int,
        h: Int,
        k: Int,
        g: Int
    ) {
        val values = ContentValues()
        values.put(COLUMN_PLAYER_STAT_ID, playerId)
        values.put(COLUMN_PLAYER_AVG, avg)
        values.put(COLUMN_PLAYER_HR, hr)
        values.put(COLUMN_PLAYER_R, r)
        values.put(COLUMN_PLAYER_H, h)
        values.put(COLUMN_PLAYER_K, k)
        values.put(COLUMN_PLAYER_G, g)
        db.insert(TABLE_PLAYER_STATS, null, values)
    }
    //球員名單函式
    private fun insertPlayer(playerId: Int, playerName: String) {
        val values = ContentValues()
        values.put(COLUMN_PLAYER_ID, playerId)
        values.put(COLUMN_PLAYER_NAME, playerName)
        db.insert(TABLE_PLAYER_LIST, null, values)
    }
    //詳細資料函式
    private fun insertPlayerDetails(
        playerId: Int,
        nickname: String,
        country: String,
        position: String,
        habits: String,
        h_w: String,
        old: String
    ) {
        val values = ContentValues()
        values.put(COLUMN_PLAYER_DETAIL_ID, playerId)
        values.put(COLUMN_PLAYER_NICKNAME, nickname)
        values.put(COLUMN_PLAYER_COUNTRY, country)
        values.put(COLUMN_PLAYER_POSITION, position)
        values.put(COLUMN_PLAYER_HABITS, habits)
        values.put(COLUMN_PLAYER_H_W, h_w)
        values.put(COLUMN_PLAYER_OLD, old)
        db.insert(TABLE_PLAYER_DETAIL, null, values)
    }
    private fun clearPlayerDetailTable() {
        val dbHelper = MyDBHelper(this, "player_list", null, 1)
        val db = dbHelper.writableDatabase
        val playerListCount = DatabaseUtils.queryNumEntries(db, MyDBHelper.TABLE_PLAYER_LIST)
        val playerDetailCount = DatabaseUtils.queryNumEntries(db, MyDBHelper.TABLE_PLAYER_DETAIL)
        val playerStatsCount = DatabaseUtils.queryNumEntries(db, MyDBHelper.TABLE_PLAYER_STATS)
        if (playerListCount > 0 && playerDetailCount > 0 && playerStatsCount > 0) {
            db.delete(MyDBHelper.TABLE_PLAYER_LIST, null, null)
            db.delete(MyDBHelper.TABLE_PLAYER_DETAIL, null, null)
            db.delete(MyDBHelper.TABLE_PLAYER_STATS, null, null)
        }

        db.close()
    }

}
