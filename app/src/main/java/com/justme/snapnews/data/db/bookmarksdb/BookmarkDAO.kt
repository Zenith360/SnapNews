package com.justme.snapnews.data.db.bookmarksdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface BookmarkDAO {

    @Insert
    fun insertInBookmarks(bookmarkEntity: BookmarkEntity)

    @Query("SELECT * FROM bookmarks")
    fun getAllBookmarks() : List<BookmarkEntity>

    @Delete
    fun deleteFromBookmarks(bookmarkEntity: BookmarkEntity)

    @Query("UPDATE bookmarks SET isBookmarked = :isBookmarked WHERE article_id = :artId")
    fun getBookmarkById(isBookmarked : Boolean, artId : String) : BookmarkEntity
}