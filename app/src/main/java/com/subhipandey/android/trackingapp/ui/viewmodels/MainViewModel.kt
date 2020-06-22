package com.subhipandey.android.trackingapp.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.subhipandey.android.trackingapp.repository.MainRepository
import javax.inject.Inject

class MainViewModel @Inject @ViewModelInject constructor(
    val mainRepository: MainRepository
): ViewModel() {
}