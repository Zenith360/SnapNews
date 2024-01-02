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
import com.justme.snapnews.R
import com.justme.snapnews.data.models.NewsItem

class DashboardRecyclerAdapter(
    private val context: Context,
    private val newsItems : MutableList<NewsItem>
) :
    RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardViewHolder>() {
    class DashboardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val llCardLayout: LinearLayout = view.findViewById(R.id.llCardLayout)
        val cvImage: CardView = view.findViewById(R.id.cvImage)
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
        TODO("Not yet implemented")
    }
}