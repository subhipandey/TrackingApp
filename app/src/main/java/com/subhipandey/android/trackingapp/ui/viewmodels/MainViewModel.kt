package com.subhipandey.android.trackingapp.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.subhipandey.android.trackingapp.database.Run
import com.subhipandey.android.trackingapp.repository.MainRepository
import com.subhipandey.android.trackingapp.util.SortType
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject @ViewModelInject constructor(
    val mainRepository: MainRepository
) : ViewModel() {

  private val runsSortedByDate = mainRepository.getAllRunSortedByDate()
    private val runsSortedByDistance = mainRepository.getAllRunsSortedByDistance()
    private val runsSortedByCaloriesBurned = mainRepository.getAllRunSortedByCaloriesBurned()
    private val runsSortedByTimeMillis = mainRepository.getAllRunSortedByTimeInMillis()
    private val runSortedByAvgSpeed = mainRepository.getAllRunSortedByAvgSpeed()

    val runs = MediatorLiveData<List<Run>>()
    var sortType = SortType.DATE
    init{
        runs.addSource(runsSortedByDate){ result ->
            if(sortType == SortType.AVG_SPEED){
                result?.let {runs.value = it}
            }
        }
        runs.addSource(runsSortedByCaloriesBurned){ result ->
            if(sortType == SortType.CALORIES_BURNED){
                result?.let {runs.value = it}
            }
        }
        runs.addSource(runsSortedByDistance){ result ->
            if(sortType == SortType.DISTANCE){
                result?.let {runs.value = it}
            }
        }
        runs.addSource(runsSortedByTimeMillis){ result ->
            if(sortType == SortType.RUNNING_TIME){
                result?.let {runs.value = it}
            }
        }
    }


    fun sortRuns(sortType: SortType) = when(sortType){
        SortType.DATE -> runsSortedByDate.value?.let{runs.value = it}
        SortType.RUNNING_TIME -> runsSortedByTimeMillis.value?.let{runs.value = it}
        SortType.AVG_SPEED -> runSortedByAvgSpeed.value?.let{runs.value = it}
        SortType.DISTANCE -> runsSortedByDistance.value?.let{runs.value = it}
        SortType.CALORIES_BURNED -> runsSortedByCaloriesBurned.value?.let{runs.value = it}
    }.also{
        this.sortType = sortType
    }


    fun insertRun(run: Run) = viewModelScope.launch {
        mainRepository.insertRun(run)
    }
}