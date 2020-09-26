package com.ristar.simplenavigation

import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.ristar.simplenavigation.utils.LiveEvent

open class BaseViewModel : ViewModel() {
    val navigationLD = LiveEvent<NavDirections>()
}