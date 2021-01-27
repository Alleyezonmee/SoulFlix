package com.soulinc.soulflix.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import retrofit2.Response

/**
 * paras's creation on 10-01-2021
 */
abstract class BaseRepository {

  suspend fun <T> callApi(optionalLiveData: MutableLiveData<Response<T>>? = null, api: suspend () -> Response<T>) : LiveData<Response<T>> = optionalLiveData?.also { incomingData ->
    val result = liveData(Dispatchers.IO) { emit(api()) }
    val observer :(Response<T>) -> Unit = { incomingData.value = it }
    result.observeForever(observer)
  } ?: run { liveData(Dispatchers.IO) { emit(api()) } }
}