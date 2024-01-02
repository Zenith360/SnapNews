package com.justme.snapnews.data.db.cachedarticlesdb

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TopDao {
    @Query("SELECT * FROM top")
    fun getAllCachedArticles(): MutableList<TopCategory>

    @Insert
    fun insertArticle(article: TopCategory)

    @Query("DELETE FROM top")
    fun deleteAll()
}

@Dao
interface BusinessDao {
    @Query("SELECT * FROM business")
    fun getAllCachedArticles(): MutableList<BusinessCategory>

    @Insert
    fun insertArticle(article: BusinessCategory)

    @Query("DELETE FROM business")
    fun deleteAll()
}

@Dao
interface TechnologyDao {
    @Query("SELECT * FROM technology")
    fun getAllCachedArticles(): MutableList<TechnologyCategory>

    @Insert
    fun insertArticle(article: TechnologyCategory)

    @Query("DELETE FROM technology")
    fun deleteAll()
}

@Dao
interface ScienceDao {
    @Query("SELECT * FROM science")
    fun getAllCachedArticles(): MutableList<ScienceCategory>

    @Insert
    fun insertArticle(article: ScienceCategory)

    @Query("DELETE FROM science")
    fun deleteAll()
}

@Dao
interface CrimeDao {
    @Query("SELECT * FROM crime")
    fun getAllCachedArticles(): MutableList<CrimeCategory>

    @Insert
    fun insertArticle(article: CrimeCategory)

    @Query("DELETE FROM crime")
    fun deleteAll()
}

@Dao
interface DomesticDao {
    @Query("SELECT * FROM domestic")
    fun getAllCachedArticles(): MutableList<DomesticCategory>

    @Insert
    fun insertArticle(article: DomesticCategory)

    @Query("DELETE FROM domestic")
    fun deleteAll()
}

@Dao
interface EducationDao {
    @Query("SELECT * FROM education")
    fun getAllCachedArticles(): MutableList<EducationCategory>

    @Insert
    fun insertArticle(article: EducationCategory)

    @Query("DELETE FROM education")
    fun deleteAll()
}

@Dao
interface EntertainmentDao {
    @Query("SELECT * FROM entertainment")
    fun getAllCachedArticles(): MutableList<EntertainmentCategory>

    @Insert
    fun insertArticle(article: EntertainmentCategory)

    @Query("DELETE FROM entertainment")
    fun deleteAll()
}

@Dao
interface EnvironmentDao {
    @Query("SELECT * FROM environment")
    fun getAllCachedArticles(): MutableList<EnvironmentCategory>

    @Insert
    fun insertArticle(article: EnvironmentCategory)

    @Query("DELETE FROM environment")
    fun deleteAll()
}

@Dao
interface FoodDao {
    @Query("SELECT * FROM food")
    fun getAllCachedArticles(): MutableList<FoodCategory>

    @Insert
    fun insertArticle(article: FoodCategory)

    @Query("DELETE FROM food")
    fun deleteAll()
}

@Dao
interface HealthDao {
    @Query("SELECT * FROM health")
    fun getAllCachedArticles(): MutableList<HealthCategory>

    @Insert
    fun insertArticle(article: HealthCategory)

    @Query("DELETE FROM health")
    fun deleteAll()
}

@Dao
interface OtherDao {
    @Query("SELECT * FROM other")
    fun getAllCachedArticles(): MutableList<OtherCategory>

    @Insert
    fun insertArticle(article: OtherCategory)

    @Query("DELETE FROM other")
    fun deleteAll()
}

@Dao
interface PoliticsDao {
    @Query("SELECT * FROM politics")
    fun getAllCachedArticles(): MutableList<PoliticsCategory>

    @Insert
    fun insertArticle(article: PoliticsCategory)

    @Query("DELETE FROM politics")
    fun deleteAll()
}

@Dao
interface SportsDao {
    @Query("SELECT * FROM sports")
    fun getAllCachedArticles(): MutableList<SportsCategory>

    @Insert
    fun insertArticle(article: SportsCategory)

    @Query("DELETE FROM sports")
    fun deleteAll()
}

@Dao
interface TourismDao {
    @Query("SELECT * FROM tourism")
    fun getAllCachedArticles(): MutableList<TourismCategory>

    @Insert
    fun insertArticle(article: TourismCategory)

    @Query("DELETE FROM tourism")
    fun deleteAll()
}

@Dao
interface WorldDao {
    @Query("SELECT * FROM world")
    fun getAllCachedArticles(): MutableList<WorldCategory>

    @Insert
    fun insertArticle(article: WorldCategory)

    @Query("DELETE FROM world")
    fun deleteAll()
}