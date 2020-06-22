package com.subhipandey.android.trackingapp.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.subhipandey.android.trackingapp.R
import com.subhipandey.android.trackingapp.ui.viewmodels.MainViewModel
import com.subhipandey.android.trackingapp.ui.viewmodels.StatisticsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StatisticsFragment : Fragment(R.layout.fragment_statistics) {
    private val viewModel: StatisticsViewModel by viewModels()
}