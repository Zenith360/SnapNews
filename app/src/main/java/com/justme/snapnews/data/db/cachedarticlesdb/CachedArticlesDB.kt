package com.justme.snapnews.data.db.cachedarticlesdb

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [CachedArticlesEntity::class],
    version = 1
)
abstract class CachedArticlesDB : RoomDatabase(){
    abstract fun cachedArticlesDao(): CachedArticlesDao
}