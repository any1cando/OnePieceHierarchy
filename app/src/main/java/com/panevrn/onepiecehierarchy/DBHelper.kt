package com.panevrn.onepiecehierarchy

import android.R.attr.name
import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.panevrn.onepiecehierarchy.pirates.Pirate


const val DATABASE_NAME = "OnePieceDB"
const val DATABASE_VERSION = 1

class DBHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    private val CREATE_PIRATES_TABLE = """
        CREATE TABLE pirates (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            name TEXT,
            age TEXT,
            bounty LONG,
            hasDevilFruit INTEGER,
            description TEXT,
            destiny TEXT
        );
    """.trimIndent()

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_PIRATES_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        if (oldVersion < 2) { // Предполагается, что версия 2 добавляет 'hasDevilFruit'
            db.execSQL("ALTER TABLE pirates ADD COLUMN hasDevilFruit INTEGER DEFAULT 0")
        }
    }

    fun addPirate(pirate: Pirate) {
        val db = this.writableDatabase // Получаем доступ для записи в базу данных

        val values = ContentValues().apply {
            put("name", pirate.name)
            put("age", pirate.age)
            put("bounty", pirate.bounty)
            put("hasDevilFruit", if (pirate.devilFruit) 1 else 0) // Преобразуем boolean в integer
            put("description", pirate.crimeHistory)
            put("destiny", pirate.destiny)
        }

        db.insert("pirates", null, values) // Вставляем значения в таблицу
        db.close() // Закрываем базу данных после выполнения операции
    }

    fun deletePirateById(pirateId: Int): Boolean {
        val db = this.writableDatabase

        // Условие удаления
        val whereClause = "id = ?"

        // Аргументы условия
        val whereArgs = arrayOf(pirateId.toString())

        // Выполнение удаления
        val deletedRows = db.delete("pirates", whereClause, whereArgs)

        // Закрытие базы данных
        db.close()

        // Возвращаем true, если удалена хотя бы одна строка
        return deletedRows > 0
    }
    fun getPirateById(id: Int): Pirate? {
        val db = this.readableDatabase
        val cursor = db.query("pirates", null, "id=?", arrayOf(id.toString()), null, null, null)

        if (cursor.moveToFirst()) {
            val checkDF = cursor.getInt(cursor.getColumnIndexOrThrow("hasDevilFruit"))
            val devilFruit = if (checkDF == 1) { true } else { false }

            val pirate = Pirate(
                id = cursor.getInt(cursor.getColumnIndexOrThrow("id")),
                name = cursor.getString(cursor.getColumnIndexOrThrow("name")),
                age = cursor.getString(cursor.getColumnIndexOrThrow("age")).toInt(),
                bounty = cursor.getLong(cursor.getColumnIndexOrThrow("bounty")),
                devilFruit = devilFruit,
                crimeHistory = cursor.getString(cursor.getColumnIndexOrThrow("description")),
                destiny = cursor.getString(cursor.getColumnIndexOrThrow("destiny"))
            )
            return pirate
        } else {
            return null
        }
    }

    fun getAllPirates(): List<Pirate> {
        val db = this.writableDatabase
        val cursor = db.query("pirates", null, null, null, null, null, null)
        val pirates = mutableListOf<Pirate>()

        with(cursor) {
            while (moveToNext()) {
                val checkDF = getInt(getColumnIndexOrThrow("hasDevilFruit"))
                val devilFruitCheck = if (checkDF == 1) { true } else { false }
                pirates.add(Pirate(
                    id = getInt(getColumnIndexOrThrow("id")),
                    name = getString(getColumnIndexOrThrow("name")),
                    age = getString(getColumnIndexOrThrow("age")).toInt(),
                    bounty = getLong(getColumnIndexOrThrow("bounty")),
                    devilFruit = devilFruitCheck,
                    crimeHistory = getString(getColumnIndexOrThrow("description")),
                    destiny = getString(getColumnIndexOrThrow("destiny"))

                ))
            }
        }
        cursor.close()
        db.close()
        return pirates
    }
}