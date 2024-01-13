package com.justme.snapnews.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.justme.snapnews.R
import com.justme.snapnews.data.db.bookmarksdb.BookmarkDB
import com.justme.snapnews.data.db.bookmarksdb.BookmarkEntity
import com.justme.snapnews.util.converterToBookmarkEntity
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BookmarkRecyclerAdapter(
    private val context: Context,
    private val bookmarks: MutableList<BookmarkEntity>
) :
    RecyclerView.Adapter<BookmarkRecyclerAdapter.BookmarkViewHolder>() {
    class BookmarkViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val rlSingleItem: RelativeLayout = view.findViewById(R.id.rlSingleItem)
        val imgNewsImage: ImageView = view.findViewById(R.id.imgNewsImage)
        val txtHeadline: TextView = view.findViewById(R.id.txtHeadline)
        val imgBookmark: ImageView = view.findViewById(R.id.imgBookmark)
        val txtDescription: TextView = view.findViewById(R.id.txtDescription)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.single_item_dashboard, parent, false)
        return BookmarkViewHolder(view)
    }

    override fun getItemCount(): Int = bookmarks.size

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        val data = bookmarks[position]
        if (data.title.isNotEmpty())
            holder.txtHeadline.text = data.title
        else
            holder.txtHeadline.text = context.getString(R.string.placeholder_headline)
        if (!data.description.isNullOrEmpty())
            holder.txtDescription.text = data.content.substringBefore(".") + "."
        else
            holder.txtDescription.text = data.description
        Picasso.get().load(data.image_url).error(R.drawable.garden_test).into(holder.imgNewsImage)
        holder.imgBookmark.setImageResource(R.drawable.ic_bookmark_filled)

        val db = Room.databaseBuilder(context, BookmarkDB::class.java, "bookmarks").build()
        val dao = db.bookmarkDAO()

        holder.imgBookmark.setOnClickListener {
            holder.rlSingleItem.visibility = View.GONE
            CoroutineScope(Dispatchers.IO).launch {
                dao.deleteFromBookmarks(data)
            }
        }
    }
}
