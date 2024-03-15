package com.castres.breand.block6.p1.androidproject.MVVM

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.castres.breand.block6.p1.androidproject.Components.ComponentRepository

class ComponentViewModelFactory(private val repository: ComponentRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(ComponentsViewModel::class.java)) {
            ComponentsViewModel(repository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}