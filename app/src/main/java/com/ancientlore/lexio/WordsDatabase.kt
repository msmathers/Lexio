package com.ancientlore.lexio

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

@Database(entities = [(Word::class)], version = 1)
abstract class WordsDatabase : RoomDatabase() {

	abstract fun wordDao(): WordDao

	companion object : SingletonHolder<WordsDatabase, Context>({
		Room.databaseBuilder(it,
				WordsDatabase::class.java, "words.db")
				.build()
	})
}