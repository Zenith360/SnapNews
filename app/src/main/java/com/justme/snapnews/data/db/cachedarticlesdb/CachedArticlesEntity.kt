package com.justme.snapnews.data.db.cachedarticlesdb

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.justme.snapnews.data.models.NewsItem

@Entity(tableName = "top")
data class TopCategory(
    @PrimaryKey val article_id: String?,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "link") val link: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "category") val category: List<String>,
    @ColumnInfo(name = "country") val country: List<String>,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "image_url") val image_url: String,
    @ColumnInfo(name = "source_id") val source_id: String,
    @ColumnInfo(name = "isBookmarked") val isBookmarked: Boolean
)

@Entity(tableName = "business")
data class BusinessCategory(
    @PrimaryKey val article_id: String?,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "link") val link: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "category") val category: List<String>,
    @ColumnInfo(name = "country") val country: List<String>,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "image_url") val image_url: String,
    @ColumnInfo(name = "source_id") val source_id: String,
    @ColumnInfo(name = "isBookmarked") val isBookmarked: Boolean
)

@Entity(tableName = "technology")
data class TechnologyCategory(
    @PrimaryKey val article_id: String?,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "link") val link: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "category") val category: List<String>,
    @ColumnInfo(name = "country") val country: List<String>,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "image_url") val image_url: String,
    @ColumnInfo(name = "source_id") val source_id: String,
    @ColumnInfo(name = "isBookmarked") val isBookmarked: Boolean
)

@Entity(tableName = "science")
data class ScienceCategory(
    @PrimaryKey val article_id: String?,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "link") val link: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "category") val category: List<String>,
    @ColumnInfo(name = "country") val country: List<String>,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "image_url") val image_url: String,
    @ColumnInfo(name = "source_id") val source_id: String,
    @ColumnInfo(name = "isBookmarked") val isBookmarked: Boolean
)

@Entity(tableName = "crime")
data class CrimeCategory(
    @PrimaryKey val article_id: String?,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "link") val link: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "category") val category: List<String>,
    @ColumnInfo(name = "country") val country: List<String>,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "image_url") val image_url: String,
    @ColumnInfo(name = "source_id") val source_id: String,
    @ColumnInfo(name = "isBookmarked") val isBookmarked: Boolean
)

@Entity(tableName = "domestic")
data class DomesticCategory(
    @PrimaryKey val article_id: String?,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "link") val link: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "category") val category: List<String>,
    @ColumnInfo(name = "country") val country: List<String>,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "image_url") val image_url: String,
    @ColumnInfo(name = "source_id") val source_id: String,
    @ColumnInfo(name = "isBookmarked") val isBookmarked: Boolean
)

@Entity(tableName = "education")
data class EducationCategory(
    @PrimaryKey val article_id: String?,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "link") val link: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "category") val category: List<String>,
    @ColumnInfo(name = "country") val country: List<String>,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "image_url") val image_url: String,
    @ColumnInfo(name = "source_id") val source_id: String,
    @ColumnInfo(name = "isBookmarked") val isBookmarked: Boolean
)

@Entity(tableName = "entertainment")
data class EntertainmentCategory(
    @PrimaryKey val article_id: String?,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "link") val link: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "category") val category: List<String>,
    @ColumnInfo(name = "country") val country: List<String>,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "image_url") val image_url: String,
    @ColumnInfo(name = "source_id") val source_id: String,
    @ColumnInfo(name = "isBookmarked") val isBookmarked: Boolean
)

@Entity(tableName = "environment")
data class EnvironmentCategory(
    @PrimaryKey val article_id: String?,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "link") val link: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "category") val category: List<String>,
    @ColumnInfo(name = "country") val country: List<String>,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "image_url") val image_url: String,
    @ColumnInfo(name = "source_id") val source_id: String,
    @ColumnInfo(name = "isBookmarked") val isBookmarked: Boolean
)

@Entity(tableName = "food")
data class FoodCategory(
    @PrimaryKey val article_id: String?,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "link") val link: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "category") val category: List<String>,
    @ColumnInfo(name = "country") val country: List<String>,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "image_url") val image_url: String,
    @ColumnInfo(name = "source_id") val source_id: String,
    @ColumnInfo(name = "isBookmarked") val isBookmarked: Boolean
)

@Entity(tableName = "health")
data class HealthCategory(
    @PrimaryKey val article_id: String?,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "link") val link: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "category") val category: List<String>,
    @ColumnInfo(name = "country") val country: List<String>,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "image_url") val image_url: String,
    @ColumnInfo(name = "source_id") val source_id: String,
    @ColumnInfo(name = "isBookmarked") val isBookmarked: Boolean
)

@Entity(tableName = "other")
data class OtherCategory(
    @PrimaryKey val article_id: String?,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "link") val link: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "category") val category: List<String>,
    @ColumnInfo(name = "country") val country: List<String>,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "image_url") val image_url: String,
    @ColumnInfo(name = "source_id") val source_id: String,
    @ColumnInfo(name = "isBookmarked") val isBookmarked: Boolean
)

@Entity(tableName = "politics")
data class PoliticsCategory(
    @PrimaryKey val article_id: String?,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "link") val link: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "category") val category: List<String>,
    @ColumnInfo(name = "country") val country: List<String>,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "image_url") val image_url: String,
    @ColumnInfo(name = "source_id") val source_id: String,
    @ColumnInfo(name = "isBookmarked") val isBookmarked: Boolean
)

@Entity(tableName = "sports")
data class SportsCategory(
    @PrimaryKey val article_id: String?,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "link") val link: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "category") val category: List<String>,
    @ColumnInfo(name = "country") val country: List<String>,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "image_url") val image_url: String,
    @ColumnInfo(name = "source_id") val source_id: String,
    @ColumnInfo(name = "isBookmarked") val isBookmarked: Boolean
)

@Entity(tableName = "tourism")
data class TourismCategory(
    @PrimaryKey val article_id: String?,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "link") val link: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "category") val category: List<String>,
    @ColumnInfo(name = "country") val country: List<String>,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "image_url") val image_url: String,
    @ColumnInfo(name = "source_id") val source_id: String,
    @ColumnInfo(name = "isBookmarked") val isBookmarked: Boolean
)

@Entity(tableName = "world")
data class WorldCategory(
    @PrimaryKey val article_id: String?,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "link") val link: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "category") val category: List<String>,
    @ColumnInfo(name = "country") val country: List<String>,
    @ColumnInfo(name = "description") val description: String?,
    @ColumnInfo(name = "image_url") val image_url: String,
    @ColumnInfo(name = "source_id") val source_id: String,
    @ColumnInfo(name = "isBookmarked") val isBookmarked: Boolean
)