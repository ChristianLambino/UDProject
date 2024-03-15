package com.castres.breand.block6.p1.androidproject.MVVM

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.castres.breand.block6.p1.androidproject.Components.ComponentRepository
import com.castres.breand.block6.p1.androidproject.Components.ComponentsItems
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ComponentsViewModel(private val componentRepository: ComponentRepository) : ViewModel() {

    val errorMessage = MutableLiveData<String>()
    val componentsList = MutableLiveData<List<ComponentsItems>>()
    var job: Job? = null

    val loading = MutableLiveData<Boolean>()
    val exceptionHandler = CoroutineExceptionHandler { _, throwable ->
        onError("Exception handled: ${throwable.localizedMessage}")
    }



    fun getComponent() {
        job = viewModelScope.launch {
            loading.value = true
            try {
                val response = componentRepository.getComponent()
                if (response.isSuccessful) {
                    val items = response.body()
                    if (items != null) {
                        componentsList.postValue(listOf(items))
                    } else {
                        onError("Empty response")
                    }
                } else {
                    onError("Error: ${response.message()}")
                }
            } catch (e: Exception) {
                onError("Exception handled: ${e.localizedMessage}")
            } finally {
                loading.value = false
            }
        }
    }

    fun onError(message: String) {
        viewModelScope.launch {
            errorMessage.value = message
            loading.value = false
        }
    }



    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }


}