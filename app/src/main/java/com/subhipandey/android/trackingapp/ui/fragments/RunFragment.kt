package com.subhipandey.android.trackingapp.ui.fragments

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.subhipandey.android.trackingapp.R
import com.subhipandey.android.trackingapp.ui.viewmodels.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RunFragment : Fragment(R.layout.fragment_run) {


    private val viewModel: MainViewModel by viewModels()
}