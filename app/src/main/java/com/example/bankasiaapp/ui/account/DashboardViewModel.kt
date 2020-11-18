package com.example.bankasiaapp.ui.account

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bankasiaapp.model.ApiResponse
import com.example.bankasiaapp.model.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class DashboardViewModel : ViewModel() {

    private val userService = ApiService()
    private val disposable = CompositeDisposable()

    val user = MutableLiveData<List<ApiResponse>>()
    val userLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        fetchFromRemote()
    }

    private fun fetchFromRemote() {
        loading.value = true
        disposable.add(
            userService.getUser()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<ApiResponse>>() {

                    override fun onSuccess(userList: List<ApiResponse>) {
                        user.value = userList
                        userLoadError.value = false
                        loading.value = false
                    }

                    override fun onError(e: Throwable) {
                        userLoadError.value = true
                        loading.value = false
                        e.printStackTrace()
                    }

                })
        )

    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}