package com.justme.snapnews.ui.fragments

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.HorizontalScrollView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.justme.snapnews.R
import com.justme.snapnews.data.models.NewsItem
import com.justme.snapnews.ui.adapters.DashboardRecyclerAdapter
import com.justme.snapnews.util.isConnectedToInternet
import org.json.JSONObject
import java.time.LocalTime
import java.time.temporal.ChronoUnit
import java.util.Locale
import java.util.Queue

class DashboardFragment : Fragment() {
    private lateinit var flDashboard: FrameLayout
    private lateinit var rlDashboard: RelativeLayout
    private lateinit var rvDashboard: RecyclerView
    private lateinit var pbDashboard: ProgressBar
    private lateinit var hsvFilterButtons: HorizontalScrollView
    private lateinit var btnFilterTop: Button
    private lateinit var btnFilterTechnology: Button
    private lateinit var btnFilterBusiness: Button
    private lateinit var btnFilterScience: Button
    private lateinit var btnFilterCrime: Button
    private lateinit var btnFilterDomestic: Button
    private lateinit var btnFilterEducation: Button
    private lateinit var btnFilterEntertainment: Button
    private lateinit var btnFilterEnvironment: Button
    private lateinit var btnFilterFood: Button
    private lateinit var btnFilterHealth: Button
    private lateinit var btnFilterOther: Button
    private lateinit var btnFilterPolitics: Button
    private lateinit var btnFilterSports: Button
    private lateinit var btnFilterTourism: Button
    private lateinit var btnFilterWorld: Button

    private lateinit var layoutManagerDashboard: LinearLayoutManager
    private lateinit var dashboardRecyclerAdapter: DashboardRecyclerAdapter

    private var url = "https://newsdata.io/api/1/news?apikey="

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        val sharedPreferences =
            requireContext().getSharedPreferences("snapnewsCache", Context.MODE_PRIVATE)

        flDashboard = view.findViewById(R.id.flDashboard)
        rlDashboard = view.findViewById(R.id.rlDashboard)
        rvDashboard = view.findViewById(R.id.rvDashboard)
        pbDashboard = view.findViewById(R.id.pbDashboard)
        hsvFilterButtons = view.findViewById(R.id.hsvFilterButtons)
        btnFilterTop = view.findViewById(R.id.btnFilterTop)
        btnFilterTechnology = view.findViewById(R.id.btnFilterTechnology)
        btnFilterBusiness = view.findViewById(R.id.btnFilterBusiness)
        btnFilterScience = view.findViewById(R.id.btnFilterScience)
        btnFilterCrime = view.findViewById(R.id.btnFilterCrime)
        btnFilterDomestic = view.findViewById(R.id.btnFilterDomestic)
        btnFilterEducation = view.findViewById(R.id.btnFilterEducation)
        btnFilterEntertainment = view.findViewById(R.id.btnFilterEntertainment)
        btnFilterEnvironment = view.findViewById(R.id.btnFilterEnvironment)
        btnFilterFood = view.findViewById(R.id.btnFilterFood)
        btnFilterHealth = view.findViewById(R.id.btnFilterHealth)
        btnFilterOther = view.findViewById(R.id.btnFilterOther)
        btnFilterPolitics = view.findViewById(R.id.btnFilterPolitics)
        btnFilterSports = view.findViewById(R.id.btnFilterSports)
        btnFilterTourism = view.findViewById(R.id.btnFilterTourism)
        btnFilterWorld = view.findViewById(R.id.btnFilterWorld)

        layoutManagerDashboard = LinearLayoutManager(activity as Context)

        rvDashboard.layoutManager = layoutManagerDashboard

        hsvFilterButtons.isHorizontalScrollBarEnabled = false

        val lastOpenedAt = sharedPreferences.getString("lastOpenedAt", "00:00") ?: "00:00"
        val curTime = sharedPreferences.getString("openedAt", "00:00") ?: "00:00"

        val timeCheck = isTimeDifferenceOneHourOrMore(lastOpenedAt, curTime)

        val queue = Volley.newRequestQueue(activity as Context)

        val selectedBtn = btnFilterTop

        btnFilterBusiness.setOnClickListener {
            buttonHandler(btnFilterBusiness, selectedBtn, queue)
        }

        //check which button has been clicked

        //check if article list already exists; if one hour has passed fetch new and delete from db
        //if exists pass that list onto adapter
        //subsequently request article
        //pass to adapter

        return view
    }

    private fun isTimeDifferenceOneHourOrMore(time1: String, time2: String): Boolean {
        val formatter = java.time.format.DateTimeFormatter.ofPattern("HH:mm")
        val parsedTime1 = LocalTime.parse(time1, formatter)
        val parsedTime2 = LocalTime.parse(time2, formatter)

        val minutesBetween = ChronoUnit.MINUTES.between(parsedTime1, parsedTime2)

        return minutesBetween >= 60
    }

    private fun buttonHandler(btn: Button, selectedFilterBtn: Button, queue: RequestQueue) {
        if (selectedFilterBtn != btn) {
            TODO("Change color (background and text)")
        }

        TODO("Change color (background and text) selected")

        val category = btn.text.toString().lowercase(Locale.getDefault())

        addToQueue(category, queue)
    }

    private fun addToQueue(category: String, queue: RequestQueue) {

        url += "&category=$category"
        val newsArticles: MutableList<NewsItem> = mutableListOf()

        if (isConnectedToInternet(activity as Context)) {
            try {
                val jsonObj = JSONObject()
                jsonObj.put("category", category)

                val jsonObjectRequest = object :
                    JsonObjectRequest(Method.GET, url, jsonObj, Response.Listener { jsonObj ->
                        if (jsonObj.getString("status") == "success") {
                            val articles = jsonObj.getJSONArray("results")
                            for (i in 0 until articles.length()) {
                                val article = articles.getJSONObject(i)
                                val newsItem = NewsItem(
                                    article_id = article.getString("article_id"),
                                    content = article.getString("content"),
                                    link = article.getString("link"),
                                    title = article.getString("title"),
                                    category = category,
                                    country = article.getJSONArray("country").getString(0),
                                    description = article.getString("description"),
                                    image_url = article.getString("image_url"),
                                    source_id = article.getString("source_id"),
                                    isBookmarked = false
                                )
                                newsArticles.add(newsItem)
                            }
                        } else {
                            TODO("make a toast for try again")
                        }
                    }, Response.ErrorListener {
                        TODO("make a toast also log")
                    }) {}
                rvDashboard.adapter = DashboardRecyclerAdapter(activity as Context, newsArticles)
                queue.add(jsonObjectRequest)
            } catch (e: Exception) {
                TODO("Make a toast also log")
            }
        } else {
            val dialog = AlertDialog.Builder(activity as Context)
            dialog.setTitle("Error!")
            dialog.setMessage("Internet Connection not Found!")
            dialog.setPositiveButton("Open Settings") { _, _ ->
                val settingsIntent = Intent(Settings.ACTION_WIRELESS_SETTINGS)
                startActivity(settingsIntent)
                if (isAdded){
                    requireActivity().finish()
                }
            }
            dialog.setNegativeButton("Exit") { _, _ ->
                ActivityCompat.finishAffinity(requireActivity())
            }
            dialog.create()
            dialog.show()
        }
    }
}