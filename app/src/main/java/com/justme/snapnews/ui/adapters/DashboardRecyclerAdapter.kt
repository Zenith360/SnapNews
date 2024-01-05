package com.justme.snapnews.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.justme.snapnews.R
import com.justme.snapnews.data.db.bookmarksdb.BookmarkDB
import com.justme.snapnews.data.models.NewsItem
import com.justme.snapnews.util.converterToBookmarkEntity
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardRecyclerAdapter(
    private val context: Context,
    private val newsItems: MutableList<NewsItem>
) :
    RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>() {
    class DashboardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val imgNewsImage: ImageView = view.findViewById(R.id.imgNewsImage)
        val txtHeadline: TextView = view.findViewById(R.id.txtHeadline)
        val imgBookmark: ImageView = view.findViewById(R.id.imgBookmark)
        val txtDescription: TextView = view.findViewById(R.id.txtDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DashboardViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_item_dashboard, parent, false)

        return DashboardViewHolder(view)
    }

    override fun getItemCount(): Int = newsItems.size

    override fun onBindViewHolder(holder: DashboardViewHolder, position: Int) {
        val data = newsItems[position]
        if (data.title.isEmpty())
            holder.txtHeadline.text = data.title
        else
            holder.txtHeadline.text = context.getString(R.string.placeholder_headline)
        if (data.description.isNullOrEmpty())
            holder.txtDescription.text = data.content.substringBefore(".")
        else
            holder.txtDescription.text = data.description
        Picasso.get().load(data.image_url).error(R.drawable.garden_test).into(holder.imgNewsImage)
        if (data.isBookmarked)
            holder.imgBookmark.setImageResource(R.drawable.ic_bookmark_filled)
        else
            holder.imgBookmark.setImageResource(R.drawable.ic_bookmark_outline)

        val db = Room.databaseBuilder(context, BookmarkDB::class.java, "bookmarks").build()
        val dao = db.bookmarkDAO()

        holder.imgBookmark.setOnClickListener {
            CoroutineScope(Dispatchers.Main).launch {
                val bookmark = converterToBookmarkEntity(data)
                if (data.isBookmarked) {
                    data.isBookmarked = false
                    holder.imgBookmark.setImageResource(R.drawable.ic_bookmark_outline)
                    dao.deleteFromBookmarks(bookmark)
                } else {
                    data.isBookmarked = true
                    holder.imgBookmark.setImageResource(R.drawable.ic_bookmark_filled)
                    dao.insertInBookmarks(bookmark)
                }
            }
        }
    }
}