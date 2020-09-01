package com.minwook.rx_study.network

import com.minwook.rx_study.network.response.SearchRepositoriesResponse
import io.reactivex.Flowable
import retrofit2.http.*

class GithubRouter : RetrofitCreator() {

    companion object {
        fun api(): GithubAPI {
            return create(GithubAPI::class.java)
        }
    }

    //또는 반환값을 Response<StartupResponse>
    interface GithubAPI {
        @GET("/search/repositories")
        fun getSearchRepositories(@Query("q") query: String, @Query("sort") sort: String = "stars", @Query("order") order: String = "desc"): Flowable<SearchRepositoriesResponse>
    }
}