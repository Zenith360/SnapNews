package com.justme.snapnews.data.db.cachedarticlesdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CachedArticlesDao {
    @Query("SELECT * FROM `cached-articles` WHERE category = :category")
    fun getAllCachedArticles(category: String): MutableList<CachedArticlesEntity>?

    @Insert
    fun insertArticle(article: CachedArticlesEntity)

    @Query("DELETE FROM `cached-articles` WHERE category = :category")
    fun deleteAll(category: String)
}