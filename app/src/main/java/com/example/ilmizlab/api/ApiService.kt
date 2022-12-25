package com.example.ilmizlab.api

import com.example.ilmizlab.models.*
import com.example.ilmizlab.models.request.GetCenterRequest
import io.reactivex.Observable
import retrofit2.http.*

interface ApiService {
    @Headers(
        "Key: oNDC06WChdNiLZtat9a6mAUC9k2zc0"
    )
    @GET("offers")
    fun getOffers(): Observable<BaseResponseModel<List<OfferModel>>>
    @Headers(
        "Key: oNDC06WChdNiLZtat9a6mAUC9k2zc0"
    )
    @GET("categories")
    fun getCategories(): Observable<BaseResponseModel<List<CategoryModel>>>

    @Headers(
        "Key: oNDC06WChdNiLZtat9a6mAUC9k2zc0"
    )
    @POST("training_centers")
    fun getTrainingCenterSearch(@Body request: GetCenterRequest): Observable<BaseResponseModel<List<TrainingCenterModel>>>
    @Headers(
        "Key: oNDC06WChdNiLZtat9a6mAUC9k2zc0"
    )
    @POST("training_centers")
    fun getTrainingCenter(@Body request: GetCenterRequest): Observable<BaseResponseModel<List<TrainingCenterModel>>>

    @POST("training_centers")
    fun getCourses(@Body request: GetCenterRequest): Observable<BaseResponseModel<List<CoursesModel>>>

    @GET("get_news")
    fun getNewsCenter(): Observable<BaseResponseModel<List<NewsModel>>>

    @GET("get_ratings")
    fun getRatings(): Observable<BaseResponseModel<List<RatingModel>>>
}