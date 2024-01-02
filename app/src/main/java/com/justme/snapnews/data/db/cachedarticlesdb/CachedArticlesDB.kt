package com.justme.snapnews.data.db.cachedarticlesdb

import androidx.room.Database

@Database(
    entities = [TopCategory::class, BusinessCategory::class, TechnologyCategory::class, ScienceCategory::class, CrimeCategory::class, DomesticCategory::class,
        EducationCategory::class, EntertainmentCategory::class, EnvironmentCategory::class, FoodCategory::class, HealthCategory::class, OtherCategory::class,
        PoliticsCategory::class, SportsCategory::class, TourismCategory::class, WorldCategory::class],
    version = 1
)
abstract class CachedArticlesDB {
    abstract fun TopCategoryDao(): TopDao
    abstract fun BusinessCategoryDao(): BusinessDao
    abstract fun TechnologyCategoryDao(): TechnologyDao
    abstract fun ScienceCategoryDao(): ScienceDao
    abstract fun CrimeCategoryDao(): CrimeDao
    abstract fun DomesticCategoryDao(): DomesticDao
    abstract fun EducationCategoryDao(): EducationDao
    abstract fun EntertainmentCategoryDao(): EntertainmentDao
    abstract fun EnvironmentCategoryDao(): EnvironmentDao
    abstract fun FoodCategoryDao(): FoodDao
    abstract fun HealthCategoryDao(): HealthDao
    abstract fun OtherCategoryDao(): OtherDao
    abstract fun PoliticsCategoryDao(): PoliticsDao
    abstract fun SportsCategoryDao(): SportsDao
    abstract fun TourismCategoryDao(): TourismDao
    abstract fun WorldCategoryDao(): WorldDao
}