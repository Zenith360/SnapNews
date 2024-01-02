package com.justme.snapnews.util

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest


fun isConnectedToInternet(context: Context): Boolean {
    val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkRequest = NetworkRequest.Builder().addTransportType(NetworkCapabilities.TRANSPORT_WIFI).build()

    var result = false
    val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            result = true
        }
    }

    try {
        connectivityManager.registerNetworkCallback(networkRequest, networkCallback)
    } finally {
        connectivityManager.unregisterNetworkCallback(networkCallback)
    }

    return result
}