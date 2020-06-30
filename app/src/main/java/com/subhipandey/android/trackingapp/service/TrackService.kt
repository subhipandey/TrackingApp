package com.subhipandey.android.trackingapp.service

import android.content.Intent
import androidx.lifecycle.LifecycleService
import com.subhipandey.android.trackingapp.util.Constants.ACTION_PAUSE_SERVICE
import com.subhipandey.android.trackingapp.util.Constants.ACTION_START_OR_RESUME_SERVICE
import com.subhipandey.android.trackingapp.util.Constants.ACTION_STOP_SERVICE
import timber.log.Timber

class TrackService : LifecycleService() {

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent?.let {
            when(it.action){
                ACTION_START_OR_RESUME_SERVICE -> {
                    Timber.d("started or resume service")
                }
                ACTION_PAUSE_SERVICE -> {
                    Timber.d("Pause service")
                }
                ACTION_STOP_SERVICE -> {
                    Timber.d("Stop Service")
                }

            }
        }
        return super.onStartCommand(intent, flags, startId)
    }
}