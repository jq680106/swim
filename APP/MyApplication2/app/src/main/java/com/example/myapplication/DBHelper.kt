import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) :
    SQLiteOpenHelper(context, name, factory, version) {
    //定義資料表格
    companion object {
        private const val DATABASE_NAME = "player_list"
        private const val DATABASE_VERSION = 1
        const val TABLE_PLAYER_LIST = "player_list"
        const val COLUMN_PLAYER_ID = "_id"
        const val COLUMN_PLAYER_NAME = "name"
        const val TABLE_PLAYER_DETAIL = "player_detail"
        const val COLUMN_PLAYER_NICKNAME = "nickname"
        const val COLUMN_PLAYER_COUNTRY = "country"
        const val COLUMN_PLAYER_POSITION = "position"
        const val COLUMN_PLAYER_HABITS = "habits"
        const val COLUMN_PLAYER_H_W = "h_w"
        const val COLUMN_PLAYER_OLD = "old"
        const val COLUMN_PLAYER_DETAIL_ID = "player_detail_id"
        const val COLUMN_PLAYER_AVG = "avg"
        const val COLUMN_PLAYER_HR = "hr"
        const val COLUMN_PLAYER_R = "r"
        const val COLUMN_PLAYER_H = "h"
        const val COLUMN_PLAYER_K = "k"
        const val COLUMN_PLAYER_G = "g"
        const val COLUMN_PLAYER_STAT_ID = "player_stat_id"
        const val TABLE_PLAYER_STATS = "table_player_stat"
    }
    override fun onCreate(db: SQLiteDatabase) {
        //創建球員詳細資料表
        val createPlayerDetailTable = "CREATE TABLE $TABLE_PLAYER_DETAIL (" +
                "$COLUMN_PLAYER_DETAIL_ID INTEGER PRIMARY KEY , " +
                "$COLUMN_PLAYER_NICKNAME TEXT, " +
                "$COLUMN_PLAYER_COUNTRY TEXT, " +
                "$COLUMN_PLAYER_POSITION TEXT, " +
                "$COLUMN_PLAYER_HABITS TEXT, " +
                "$COLUMN_PLAYER_H_W TEXT, " +
                "$COLUMN_PLAYER_OLD TEXT)"
        db.execSQL(createPlayerDetailTable)
        //創建球員名單資料表
        val createPlayerListTable = "CREATE TABLE $TABLE_PLAYER_LIST (" +
                "$COLUMN_PLAYER_NAME TEXT, " +
                "$COLUMN_PLAYER_ID INTEGER PRIMARY KEY, " +
                "FOREIGN KEY ($COLUMN_PLAYER_ID) REFERENCES $TABLE_PLAYER_DETAIL($COLUMN_PLAYER_DETAIL_ID))"
        db.execSQL(createPlayerListTable)
        //創建球員數據資料表
        val createPlayerStatsTable = "CREATE TABLE $TABLE_PLAYER_STATS (" +
                "$COLUMN_PLAYER_STAT_ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "$COLUMN_PLAYER_AVG REAL, " +
                "$COLUMN_PLAYER_HR INTEGER, " +
                "$COLUMN_PLAYER_R INTEGER, " +
                "$COLUMN_PLAYER_H INTEGER, " +
                "$COLUMN_PLAYER_K INTEGER, " +
                "$COLUMN_PLAYER_G INTEGER)"
        db.execSQL(createPlayerStatsTable)
    }
    override fun onUpgrade(db: SQLiteDatabase, oldVer : Int, newVer: Int) {
    }
}