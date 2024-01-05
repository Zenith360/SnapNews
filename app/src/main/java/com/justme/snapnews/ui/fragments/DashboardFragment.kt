package com.justme.snapnews.ui.fragments

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.HorizontalScrollView
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.ScrollView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.justme.snapnews.R
import com.justme.snapnews.data.db.cachedarticlesdb.CachedArticlesDB
import com.justme.snapnews.data.db.cachedarticlesdb.CachedArticlesDao
import com.justme.snapnews.data.db.cachedarticlesdb.CachedArticlesEntity
import com.justme.snapnews.data.models.NewsItem
import com.justme.snapnews.ui.adapters.DashboardRecyclerAdapter
import com.justme.snapnews.util.converterToCachedArticlesEntity
import com.justme.snapnews.util.converterToNewsItem
import com.justme.snapnews.util.isConnectedToInternet
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.json.JSONObject
import java.time.LocalTime
import java.time.temporal.ChronoUnit
import java.util.Locale

class DashboardFragment : Fragment() {
    private lateinit var svDashboard: ScrollView
    private lateinit var rlDashboard: RelativeLayout
    private lateinit var rvDashboard: RecyclerView
    private lateinit var pbDashboard: ProgressBar
    private lateinit var hsvFilterButtons: HorizontalScrollView
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
    private lateinit var rvTopNews: RecyclerView

    private lateinit var layoutManager: LinearLayoutManager
    private lateinit var dashboardRecyclerAdapter: DashboardRecyclerAdapter
    private lateinit var futureArticles: MutableList<NewsItem>

    private var url = "https://newsdata.io/api/1/news?apikey="
    private val tag = "DashboardFragment"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        val sharedPreferences =
            requireContext().getSharedPreferences("snapnewsCache", Context.MODE_PRIVATE)

        svDashboard = view.findViewById(R.id.svDashboard)
        rlDashboard = view.findViewById(R.id.rlDashboard)
        rvDashboard = view.findViewById(R.id.rvDashboard)
        pbDashboard = view.findViewById(R.id.pbDashboard)
        hsvFilterButtons = view.findViewById(R.id.hsvFilterButtons)
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
        rvTopNews = view.findViewById(R.id.rvTopNews)

        layoutManager = LinearLayoutManager(activity as Context)

        rvDashboard.layoutManager = layoutManager
        rvTopNews.layoutManager = layoutManager

        hsvFilterButtons.isHorizontalScrollBarEnabled = false

        val lastOpenedAt = sharedPreferences.getString("lastOpenedAt", "00:00") ?: "00:00"
        val curTime = sharedPreferences.getString("openedAt", "00:00") ?: "00:00"

        val timeCheck = isTimeDifferenceOneHourOrMore(lastOpenedAt, curTime)

        val queue = Volley.newRequestQueue(activity as Context)

        var selectedBtn = btnFilterTechnology
        val db = Room.databaseBuilder(
            activity as Context,
            CachedArticlesDB::class.java,
            "cached-article"
        ).build()
        val dao = db.cachedArticlesDao()

        addToQueue("top", queue, rvTopNews)

        btnFilterTechnology.setOnClickListener {
            selectedBtn = btnClick(btnFilterTechnology, selectedBtn, dao, queue, timeCheck)
        }

        btnFilterBusiness.setOnClickListener {
            selectedBtn = btnClick(btnFilterBusiness, selectedBtn, dao, queue, timeCheck)
        }

        btnFilterCrime.setOnClickListener {
            selectedBtn = btnClick(btnFilterCrime, selectedBtn, dao, queue, timeCheck)
        }

        btnFilterDomestic.setOnClickListener {
            selectedBtn = btnClick(btnFilterDomestic, selectedBtn, dao, queue, timeCheck)
        }

        btnFilterEntertainment.setOnClickListener {
            selectedBtn = btnClick(btnFilterEntertainment, selectedBtn, dao, queue, timeCheck)
        }

        btnFilterEducation.setOnClickListener {
            selectedBtn = btnClick(btnFilterEducation, selectedBtn, dao, queue, timeCheck)
        }

        btnFilterEnvironment.setOnClickListener {
            selectedBtn = btnClick(btnFilterEnvironment, selectedBtn, dao, queue, timeCheck)
        }

        btnFilterFood.setOnClickListener {
            selectedBtn = btnClick(btnFilterFood, selectedBtn, dao, queue, timeCheck)
        }

        btnFilterHealth.setOnClickListener {
            selectedBtn = btnClick(btnFilterHealth, selectedBtn, dao, queue, timeCheck)
        }

        btnFilterOther.setOnClickListener {
            selectedBtn = btnClick(btnFilterOther, selectedBtn, dao, queue, timeCheck)
        }

        btnFilterPolitics.setOnClickListener {
            selectedBtn = btnClick(btnFilterPolitics, selectedBtn, dao, queue, timeCheck)
        }

        btnFilterSports.setOnClickListener {
            selectedBtn = btnClick(btnFilterSports, selectedBtn, dao, queue, timeCheck)
        }

        btnFilterTourism.setOnClickListener {
            selectedBtn = btnClick(btnFilterTourism, selectedBtn, dao, queue, timeCheck)
        }

        btnFilterWorld.setOnClickListener {
            selectedBtn = btnClick(btnFilterWorld, selectedBtn, dao, queue, timeCheck)
        }

        btnFilterScience.setOnClickListener {
            selectedBtn = btnClick(btnFilterScience, selectedBtn, dao, queue, timeCheck)
        }
        return view
    }

    private fun isTimeDifferenceOneHourOrMore(time1: String, time2: String): Boolean {
        val formatter = java.time.format.DateTimeFormatter.ofPattern("HH:mm")
        val parsedTime1 = LocalTime.parse(time1, formatter)
        val parsedTime2 = LocalTime.parse(time2, formatter)

        val minutesBetween = ChronoUnit.MINUTES.between(parsedTime1, parsedTime2)

        return minutesBetween >= 60
    }

    private fun buttonHandler(
        btn: Button,
        selectedFilterBtn: Button,
        queue: RequestQueue,
        category: String
    ) {
        if (selectedFilterBtn != btn) changeColorOfBtn(selectedFilterBtn, true)
        changeColorOfBtn(btn, false)
        addToQueue(category, queue, rvDashboard)
    }

    private fun addToQueue(
        category: String,
        queue: RequestQueue,
        recycler: RecyclerView
    ) { // TODO : rewrite this function so that the adapter initialization can happen in the
        // click listener
        url += "&category=$category"
        val newsArticles: MutableList<NewsItem> = mutableListOf()

        if (isConnectedToInternet(activity as Context)) {
            try {
                val jsonObj = JSONObject()
                jsonObj.put("category", category)

                val jsonObjectRequest = object :
                    JsonObjectRequest(Method.POST, url, jsonObj, Response.Listener { jsonObj ->
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
                            futureArticles = newsArticles
                        } else {
                            Toast.makeText(
                                activity as Context,
                                "News can't be fetched. Try again later",
                                Toast.LENGTH_SHORT
                            ).show()
                            Log.e(tag, "success status code not received.")
                        }
                    }, Response.ErrorListener {
                        Toast.makeText(
                            activity as Context,
                            "News can't be fetched. Try again later",
                            Toast.LENGTH_SHORT
                        ).show()
                        Log.e(tag, "response error listener", it.cause)
                    }) {}
                recycler.adapter = DashboardRecyclerAdapter(activity as Context, newsArticles)
                queue.add(jsonObjectRequest)
            } catch (e: Exception) {
                Toast.makeText(
                    activity as Context,
                    "Parse Error",
                    Toast.LENGTH_SHORT
                ).show()
                Log.e(tag, "Json parse error probs", e.cause)
            }
        } else {
            val dialog = AlertDialog.Builder(activity as Context)
            dialog.setTitle("Error!")
            dialog.setMessage("Internet Connection not Found!")
            dialog.setPositiveButton("Open Settings") { _, _ ->
                val settingsIntent = Intent(Settings.ACTION_WIRELESS_SETTINGS)
                startActivity(settingsIntent)
                if (isAdded) {
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

    private fun changeColorOfBtn(btn: Button, isSelectedBtn: Boolean) {
        if (!isSelectedBtn) {
            btn.setBackgroundColor(resources.getColor(R.color.white, null))
            btn.setTextColor(resources.getColor(R.color.black, null))
        } else {
            btn.setBackgroundColor(resources.getColor(R.color.gradient_red, null))
            btn.setTextColor(resources.getColor(R.color.white, null))
        }
    }

    private fun backgroundDBOperations(category: String, dao: CachedArticlesDao) {
        CoroutineScope(Dispatchers.IO).launch {
            dao.deleteAll(category)
            val cachedArticles = converterToCachedArticlesEntity(futureArticles)
            for (article in cachedArticles) dao.insertArticle(article)
        }
    }

    private fun btnClick(
        btn: Button,
        selectedFilterBtn: Button,
        dao: CachedArticlesDao,
        queue: RequestQueue,
        timeCheck: Boolean
    ): Button {
        val category = btn.text.toString().lowercase(Locale.getDefault())
        if (timeCheck) {
            buttonHandler(btn, selectedFilterBtn, queue, category)
            backgroundDBOperations(category, dao)
        } else {
            val articles: MutableList<CachedArticlesEntity>
            runBlocking {
                articles = dao.getAllCachedArticles(category) ?: mutableListOf()
            }
            if (articles.isNotEmpty()) {
                val newsItems = converterToNewsItem(articles)
                dashboardRecyclerAdapter =
                    DashboardRecyclerAdapter(activity as Context, newsItems)
                rvDashboard.adapter = dashboardRecyclerAdapter
            } else {
                buttonHandler(btn, selectedFilterBtn, queue, category)
            }
        }
        return btn
    }
}