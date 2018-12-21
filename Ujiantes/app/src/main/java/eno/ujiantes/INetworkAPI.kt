package eno.ujiantes

import io.reactivex.Observable
import retrofit2.http.GET

interface INetworkAPI {

    @GET("posts/")
    fun getAllPosts(): Observable<List<Post>>
}