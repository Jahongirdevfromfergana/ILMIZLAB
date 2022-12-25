package com.example.ilmizlab.api.repository

import androidx.lifecycle.MutableLiveData
import com.example.ilmizlab.api.NetworkManager
import com.example.ilmizlab.models.*
import com.example.ilmizlab.models.request.GetCenterRequest
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class TrainingRepository {
    val compositeDisposable = CompositeDisposable()
    fun getOffers(
        error: MutableLiveData<String>,
        progress: MutableLiveData<Boolean>,
        offersData: MutableLiveData<List<OfferModel>>
    ) {
        progress.value = true
        compositeDisposable.add(
            NetworkManager.getApiService().getOffers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<BaseResponseModel<List<OfferModel>>>() {
                    override fun onNext(t: BaseResponseModel<List<OfferModel>>) {
                        progress.value = false
                        if (t.success) {
                            offersData.value = t.data
                        } else {
                            error.value = t.message
                        }
                    }
                    override fun onError(e: Throwable) {
                        progress.value = false
                        error.value = e.localizedMessage
                    }
                    override fun onComplete() {
                    }
                })
        )

    }

    fun getCategories(
        error: MutableLiveData<String>,
        categoriesData: MutableLiveData<List<CategoryModel>>
    ) {
        compositeDisposable.add(
            NetworkManager.getApiService().getCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :
                    DisposableObserver<BaseResponseModel<List<CategoryModel>>>() {
                    override fun onNext(t: BaseResponseModel<List<CategoryModel>>) {
                        if (t.success) {
                            categoriesData.value = t.data
                        } else {
                            error.value = t.message
                        }
                    }
                    override fun onError(e: Throwable) {
                        error.value = e.localizedMessage
                    }
                    override fun onComplete() {
                    }
                })
        )
    }
    fun getTopCenter(
        request: GetCenterRequest, error: MutableLiveData<String>,
        centerData: MutableLiveData<List<TrainingCenterModel>>
    ) {
        compositeDisposable.add(
            NetworkManager.getApiService().getTrainingCenter(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :
                    DisposableObserver<BaseResponseModel<List<TrainingCenterModel>>>() {
                    override fun onNext(t: BaseResponseModel<List<TrainingCenterModel>>) {
                        if (t.success) {
                            centerData.value = t.data
                        } else {
                            error.value = t.message
                        }
                    }
                    override fun onError(e: Throwable) {
                        error.value = e.localizedMessage

                    }
                    override fun onComplete() {

                    }
                })
        )
    }
    fun getCenter(
        request: GetCenterRequest, error: MutableLiveData<String>,
        centerData: MutableLiveData<List<TrainingCenterModel>>
    ) {
        compositeDisposable.add(
            NetworkManager.getApiService().getTrainingCenter(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :
                    DisposableObserver<BaseResponseModel<List<TrainingCenterModel>>>() {
                    override fun onNext(t: BaseResponseModel<List<TrainingCenterModel>>) {
                        if (t.success) {
                            centerData.value = t.data
                        } else {
                            error.value = t.message
                        }
                    }
                    override fun onError(e: Throwable) {
                        error.value = e.localizedMessage

                    }
                    override fun onComplete() {

                    }
                })
        )
    } fun getCenterSearch(
        request: GetCenterRequest, error: MutableLiveData<String>,
        centerData: MutableLiveData<List<TrainingCenterModel>>
    ) {
        compositeDisposable.add(
            NetworkManager.getApiService().getTrainingCenterSearch(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :
                    DisposableObserver<BaseResponseModel<List<TrainingCenterModel>>>() {
                    override fun onNext(t: BaseResponseModel<List<TrainingCenterModel>>) {
                        if (t.success) {
                            centerData.value = t.data
                        } else {
                            error.value = t.message
                        }
                    }
                    override fun onError(e: Throwable) {
                        error.value = e.localizedMessage

                    }
                    override fun onComplete() {

                    }
                })
        )
    }
    fun getCourses(
        request: GetCenterRequest,
        error: MutableLiveData<String>,
        coursesData: MutableLiveData<List<CoursesModel>>
    ) {
        compositeDisposable.add(
            NetworkManager.getApiService().getCourses(request)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :
                    DisposableObserver<BaseResponseModel<List<CoursesModel>>>() {
                    override fun onNext(t: BaseResponseModel<List<CoursesModel>>) {
                        if (t.success) {
                            coursesData.value = t.data
                        } else {
                            error.value = t.message
                        }
                    }
                    override fun onError(e: Throwable) {
                        error.value = e.localizedMessage
                    }
                    override fun onComplete() {
                    }
                })
        )
    }
    fun getNews(
        error: MutableLiveData<String>,
        teachersData: MutableLiveData<List<NewsModel>>
    ) {
        compositeDisposable.add(
            NetworkManager.getApiService().getNewsCenter()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :
                    DisposableObserver<BaseResponseModel<List<NewsModel>>>() {
                    override fun onNext(t: BaseResponseModel<List<NewsModel>>) {
                        if (t.success) {
                            teachersData.value = t.data
                        } else {
                            error.value = t.message
                        }
                    }

                    override fun onError(e: Throwable) {
                        error.value = e.localizedMessage
                    }
                    override fun onComplete() {
                    }
                })
        )
    }
    fun getRating(
        error: MutableLiveData<String>,
        teachersData: MutableLiveData<List<RatingModel>>
    ) {
        compositeDisposable.add(
            NetworkManager.getApiService().getRatings()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object :
                    DisposableObserver<BaseResponseModel<List<RatingModel>>>() {
                    override fun onNext(t: BaseResponseModel<List<RatingModel>>) {
                        if (t.success) {
                            teachersData.value = t.data
                        } else {
                            error.value = t.message
                        }
                    }
                    override fun onError(e: Throwable) {
                        error.value = e.localizedMessage
                    }
                    override fun onComplete() {

                    }
                })
        )
    }
}