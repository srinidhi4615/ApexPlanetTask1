package com.apexplanet.task1

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("posts/1")
    suspend fun getPost(): Post

    @POST("posts/add")
    suspend fun createPost(
        @Body post: Post
    ): Post
}