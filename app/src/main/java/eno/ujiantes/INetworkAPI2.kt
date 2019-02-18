package eno.ujiantes

import io.reactivex.Observable
import retrofit2.http.GET

interface INetworkAPI2 {
    @GET("comments/")
    fun getAllPosts(): Observable<List<Comment>>
}