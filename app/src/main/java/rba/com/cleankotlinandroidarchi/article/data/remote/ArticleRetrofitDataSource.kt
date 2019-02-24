package rba.com.cleankotlinandroidarchi.article.data.remote

import io.reactivex.Flowable
import rba.com.cleankotlinandroidarchi.interfaceadapter.article.model.ArticleRemote
import rba.com.cleankotlinandroidarchi.util.GsonBuilder.gson
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface ArticleRetrofitDataSource {

    @GET("/repos/vmg/redcarpet/issues/{number}")
    fun getArticle(@Path("number") number: Int): Flowable<ArticleRemote>

    object Creator {

        fun newArticleRetrofitDataSource(): ArticleRetrofitDataSource {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
            return retrofit.create(ArticleRetrofitDataSource::class.java)
        }
    }
}
