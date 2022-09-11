package com.example.ilmizlab.screen

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ilmizlab.api.repository.TrainingRepository
import com.example.ilmizlab.models.*
import com.example.ilmizlab.models.request.GetCenterRequest

class MainViewModel : ViewModel() {

    val repository = TrainingRepository()

    val progress = MutableLiveData<Boolean>()

    val error = MutableLiveData<String>()
    val offersData = MutableLiveData<List<OfferModel>>()
    val categoriesData = MutableLiveData<List<CategoryModel>>()
    val centerTopData = MutableLiveData<List<TrainingCenterModel>>()
    val centerData = MutableLiveData<List<TrainingCenterModel>>()
    val coursesData = MutableLiveData<List<CoursesModel>>()
    val newsData = MutableLiveData<List<NewsModel>>()
    val ratingData = MutableLiveData<List<RatingModel>>()

    fun getOffers() {
        repository.getOffers(error, progress, offersData)
    }

    fun getCategories() {
        repository.getCategories(error, categoriesData)
    }

    fun getTrainingTopCenter() {
        repository.getTopCenter(GetCenterRequest( 0, 0, 0, 0,"", "rating", 0, 40.3680081, 71.7810391), error, centerTopData)
    }
    fun getTrainingCenter() {
        repository.getCenter(GetCenterRequest(0, 0, 0, 0, "","", 0, 0.0, 0.0),
           error, centerData)
    }
    fun getCenterSearch() {
        repository.getCenter(GetCenterRequest(0, 0, 0, 0, "","", 0, 0.0, 0.0),
           error, centerData)
    }
    fun getCourses() {
        repository.getCourses(GetCenterRequest(0, 0, 0, 0, "", "rating", 0, 0.0, 0.0), error, coursesData)
    }
    fun getNews(){
        repository.getNews(error, newsData)
    }
    fun getRating(){
        repository.getRating(error, ratingData)
    }


}