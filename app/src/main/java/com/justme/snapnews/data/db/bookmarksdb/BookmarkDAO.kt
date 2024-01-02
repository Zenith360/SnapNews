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

    @Query("SELECT * FROM bookmarks WHERE article_id = :artId")
    fun getBookmarkById(artId : String) : BookmarkEntity
}