package com.example.bankasiaapp.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bankasiaapp.model.ApiResponse
import com.example.bankasiaapp.model.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class HomeViewModel : ViewModel() {

    private val userService = ApiService()
    private val disposable = CompositeDisposable()

    val user = MutableLiveData<List<ApiResponse>>()

    fun refresh() {
        fetchFromRemote()
    }

    private fun fetchFromRemote() {
        disposable.add(
            userService.getUser()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<ApiResponse>>() {

                    override fun onSuccess(userList: List<ApiResponse>) {
                        user.value = userList
                    }

                    override fun onError(e: Throwable) {
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