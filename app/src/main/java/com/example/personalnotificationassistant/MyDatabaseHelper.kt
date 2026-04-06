package com.example.personalnotificationassistant

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

/**
 * Simple helper class for creating and upgrading a local SQLite database. The
 * database stores notifications for later analysis. Columns can be extended
 * according to your needs.
 */
class MyDatabaseHelper(context: Context) : SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            """
            CREATE TABLE notifications (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                package_name TEXT,
                title TEXT,
                timestamp INTEGER
            )
            """.trimIndent()
        )
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS notifications")
        onCreate(db)
    }

    companion object {
        const val DB_NAME = "notifications.db"
        const val DB_VERSION = 1
    }
}
