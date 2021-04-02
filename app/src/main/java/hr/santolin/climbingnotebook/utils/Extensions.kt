package hr.santolin.climbingnotebook.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.preference.PreferenceManager
import hr.santolin.climbingnotebook.R

fun View.applyAnimation(animId:Int) {
        this.startAnimation(AnimationUtils.loadAnimation(context, animId))
}
inline fun <reified T: Activity> Context.startActivity()=  startActivity(Intent(this, T::class.java).apply {
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)//what does this meeean
})

fun Context.getBooleanPreference(key:String)= PreferenceManager.getDefaultSharedPreferences(this).getBoolean(key,false)
fun Context.setBooleanPreference(key:String, value: Boolean) = PreferenceManager.getDefaultSharedPreferences(this)
        .edit()
        .putBoolean(key,value)
        .commit()
fun Context.showToast(text: String,toastLength: Int)= Toast.makeText(this, text, toastLength).show()


fun Context.isOnline ():Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager   //zašto baš 'as'
        connectivityManager.activeNetwork?.let{
                network->connectivityManager.getNetworkCapabilities(network)?.let {
                        capabilities->
                return capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) || capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
        }
        }
        return false
}

