package com.justme.snapnews.data.db.cachedarticlesdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.justme.snapnews.data.models.NewsItem

@Entity(tableName = "cached_articles")
data class CachedArticlesEntity(
    @PrimaryKey val timeStamp : String,
    @ColumnInfo(name = "top") val top: MutableList<NewsItem>? = null,
    @ColumnInfo(name = "technology") val technology: MutableList<NewsItem>? = null,
    @ColumnInfo(name = "business") val business: MutableList<NewsItem>? = null,
    @ColumnInfo(name = "crime") val crime: MutableList<NewsItem>? = null,
    @ColumnInfo(name = "domestic") val domestic: MutableList<NewsItem>? = null,
    @ColumnInfo(name = "education") val education: MutableList<NewsItem>? = null,
    @ColumnInfo(name = "entertainment") val entertainment: MutableList<NewsItem>? = null,
    @ColumnInfo(name = "environment") val environment: MutableList<NewsItem>? = null,
    @ColumnInfo(name = "food") val food: MutableList<NewsItem>? = null,
    @ColumnInfo(name = "health") val health: MutableList<NewsItem>? = null,
    @ColumnInfo(name = "other") val other: MutableList<NewsItem>? = null,
    @ColumnInfo(name = "politics") val politics: MutableList<NewsItem>? = null,
    @ColumnInfo(name = "science") val science: MutableList<NewsItem>? = null,
    @ColumnInfo(name = "sports") val sports: MutableList<NewsItem>? = null,
    @ColumnInfo(name = "tourism") val tourism: MutableList<NewsItem>? = null,
    @ColumnInfo(name = "world") val world: MutableList<NewsItem>? = null,
)
