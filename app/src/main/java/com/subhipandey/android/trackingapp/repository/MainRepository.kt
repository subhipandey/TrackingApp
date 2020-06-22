package com.subhipandey.android.trackingapp.repository

import com.subhipandey.android.trackingapp.database.Run
import com.subhipandey.android.trackingapp.database.RunDao
import javax.inject.Inject

class MainRepository @Inject constructor(
    val runDao:RunDao
){
    suspend fun insertRun(run: Run) = runDao.insert(run)
    suspend fun deleteRun(run: Run) = runDao.deleteRun(run)

    fun getAllRunSortedByDate() = runDao.getAllRunsSortedByDate()
    fun getAllRunsSortedByDistance() = runDao.getAllRunsSortedByDistance()
    fun getAllRunSortedByTimeInMillis() = runDao.getAllRunsSortedByTimeMillis()
    fun getAllRunSortedByAvgSpeed() = runDao.getAllRunsSortedByAvgSpeed()
    fun getAllRunSortedByCaloriesBurned() = runDao.getAllRunsSortedByCaloriesBurned()

    fun getTotalAvgSpeed() = runDao.getTotalAvgSpeed()
    fun getTotalDistance() = runDao.getTotalDistance()
    fun getTotalCaloriesBurned() = runDao.getTotalCaloriesBurned()
    fun getTotalTimeInMillis() = runDao.getTotalTimeInMillis()


}