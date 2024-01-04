package com.justme.snapnews.data.db.cachedarticlesdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cached-articles")
data class CachedArticlesEntity(
    @PrimaryKey val article_id: String? = "000",
    @ColumnInfo(name = "content") val content: String? = "",
    @ColumnInfo(name = "link") val link: String? = "",
    @ColumnInfo(name = "title") val title: String? = "",
    @ColumnInfo(name = "country") val country: String? = "",
    @ColumnInfo(name = "description") val description: String? = "",
    @ColumnInfo(name = "image_url") val image_url: String? = "",
    @ColumnInfo(name = "source_id") val source_id: String? = "",
    @ColumnInfo(name = "isBookmarked") val isBookmarked: Boolean? = false,
    @ColumnInfo(name = "category") val category: String? = ""
)