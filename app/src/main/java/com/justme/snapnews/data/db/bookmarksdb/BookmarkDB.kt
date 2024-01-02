package com.justme.snapnews.data.db.bookmarksdb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [BookmarkEntity::class], version = 1)
abstract class BookmarkDB : RoomDatabase() {
    abstract fun bookmarkDAO(): BookmarkDAO
}