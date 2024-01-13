package com.justme.snapnews.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.justme.snapnews.R
import com.justme.snapnews.data.db.bookmarksdb.BookmarkDAO
import com.justme.snapnews.data.db.bookmarksdb.BookmarkDB
import com.justme.snapnews.data.db.bookmarksdb.BookmarkEntity
import com.justme.snapnews.ui.adapters.BookmarkRecyclerAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class BookmarksFragment : Fragment() {
    private lateinit var rlBookmarks : RelativeLayout
    private lateinit var txtBookmark : TextView
    private lateinit var rvBookmarks : RecyclerView
    private lateinit var pbBookmarks : ProgressBar

    private lateinit var layoutManager: LinearLayoutManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_bookmarks, container, false)

        rlBookmarks = view.findViewById(R.id.rlBookmarks)
        txtBookmark = view.findViewById(R.id.txtBookmark)
        rvBookmarks = view.findViewById(R.id.rvBookmarks)
        pbBookmarks = view.findViewById(R.id.pbBookmarks)


        val db = Room.databaseBuilder(activity as Context, BookmarkDB::class.java, "bookmarks").build()
        val dao = db.bookmarkDAO()
        val articles : MutableList<BookmarkEntity>

        runBlocking { articles = retrieveBookmarks(dao) }

        if (articles.isNotEmpty()){
            pbBookmarks.visibility = View.GONE
            rlBookmarks.visibility = View.VISIBLE
            layoutManager = LinearLayoutManager(activity as Context)
            rvBookmarks.layoutManager = layoutManager
            rvBookmarks.adapter = BookmarkRecyclerAdapter(activity as Context, articles)
        }

        return view
    }

    private suspend fun retrieveBookmarks(dao : BookmarkDAO) : MutableList<BookmarkEntity>{
        return withContext(Dispatchers.IO) {
            return@withContext dao.getAllBookmarks()
        }
    }
}