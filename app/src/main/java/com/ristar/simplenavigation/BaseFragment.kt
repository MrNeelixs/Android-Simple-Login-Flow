package com.ristar.simplenavigation

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController

open class BaseFragment : Fragment() {

    fun setupNavigation(viewModel: BaseViewModel) {
        viewModel.navigationLD.observe(viewLifecycleOwner, Observer {
            Log.d(javaClass.simpleName, "navigationLD()")
            navigate(it)
        })
    }

    fun navigate(navDirections: NavDirections) =
        findNavController().navigate(navDirections)
}