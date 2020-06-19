package com.subhipandey.android.trackingapp.di

import android.content.Context
import androidx.room.Room
import com.subhipandey.android.trackingapp.database.RunningDatabase
import com.subhipandey.android.trackingapp.util.Constants.RUNNING_DATABASE_NAME
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ApplicationComponent::class)
object ApplicationModule {

    fun provideRunningDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        RunningDatabase::class.java,
        RUNNING_DATABASE_NAME
    )
}