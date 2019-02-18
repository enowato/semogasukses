package eno.ujiantes

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager

import com.google.gson.GsonBuilder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.schedulers.IoScheduler
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.comment.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class commactivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.comment)
        recyclerViewcomm.layoutManager = LinearLayoutManager(this)
        val id=intent.getIntExtra("id",1)
        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://jsonplaceholder.typicode.com/posts/$id/").build()

        val postsApi = retrofit.create(INetworkAPI2::class.java)

        var response = postsApi.getAllPosts()

        response.observeOn(AndroidSchedulers.mainThread()).subscribeOn(IoScheduler()).subscribe {
            recyclerViewcomm.adapter = adapter2(it, this)
        }
    }
}
