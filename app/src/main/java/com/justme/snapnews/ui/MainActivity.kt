package com.justme.snapnews.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.justme.snapnews.R
import com.justme.snapnews.ui.fragments.DashboardFragment
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity() {
    private lateinit var imgHistoryIcon: ImageView
    private lateinit var txtNameOfApp: TextView
    private lateinit var imgBookmarkMainAc: ImageView
    private lateinit var flFrame: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val sharedPreferences = getSharedPreferences("snapnewsCache", Context.MODE_PRIVATE)

        setContentView(R.layout.activity_main)

        onBackPressedDispatcher.addCallback(this@MainActivity, onBackPressedCallback)

        val sfm = supportFragmentManager

        imgHistoryIcon = findViewById(R.id.imgHistoryIcon)
        txtNameOfApp = findViewById(R.id.txtNameOfApp)
        imgBookmarkMainAc = findViewById(R.id.imgBookmarkMainAc)
        flFrame = findViewById(R.id.flFrame)

        sharedPreferences.edit().putString("openedAt", getCurrentTime()).apply()

        fragmentView(sfm, DashboardFragment())

        imgHistoryIcon.setOnClickListener {
            fragmentView(sfm, HistoryFragment())
        }

        txtNameOfApp.setOnClickListener {
            fragmentView(sfm, DashboardFragment())
        }

        imgBookmarkMainAc.setOnClickListener {
            fragmentView(sfm, BookmarkFragment())
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        val sharedPreferences = getSharedPreferences("snapnewsCache", Context.MODE_PRIVATE)

        sharedPreferences.edit().putString("lastOpenedAt", getCurrentTime()).apply()
    }

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            val frag = supportFragmentManager.findFragmentById(R.id.flFrame)

            if (frag !is DashboardFragment) fragmentView(
                supportFragmentManager,
                DashboardFragment()
            )
            else finish()
        }
    }

    private fun fragmentView(sfm: FragmentManager, fragment: Fragment) {
        sfm.beginTransaction().replace(R.id.flFrame, fragment).commit()
    }

    private fun getCurrentTime(): String {
        val currentTime = Date()
        val formatter =
            SimpleDateFormat("HH:mm", Locale.getDefault()) // Customize the format as needed
        return formatter.format(currentTime)
    }
}