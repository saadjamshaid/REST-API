package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"

    private var URL = "https://jsonplaceholder.typicode.com/"

    private val retrofit = Retrofit.Builder().baseUrl(URL).addConverterFactory(GsonConverterFactory.create()).build()

    private val retrofitApi = retrofit.create(ApiService::class.java)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        onGet()
        //getUserData()
        onPost()
        onPut()
        onDelete()


    }

    private fun getUserData() {

        retrofitApi.getSpecifiedUser().enqueue(object : Callback<UserData> {
            override fun onResponse(call: Call<UserData>, response: Response<UserData>) {

                Log.i(TAG, "This would be it " + response.body().toString())
            }

            override fun onFailure(call: Call<UserData>, t: Throwable) {
                TODO("Not yet implemented")
            }
        })
    }

    private fun onGet() {

        retrofitApi.getAllUserPosts().enqueue(object : Callback<List<User>> {
            override fun onResponse(call: Call<List<User>>, response: Response<List<User>>) {

                showData(response.body()!!)
            }

            override fun onFailure(call: Call<List<User>>, t: Throwable) {

                Log.i(TAG, "API GET Failure")
            }
        })
    }

    private fun onPost() {


        retrofitApi.saveUserPost(1,"foodoo","doughfoo",1).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                if (response.isSuccessful) {

                    Log.i("Saad", "Post Successful " + response.body().toString() + " Post Code " + response.code().toString())
                }
            }

            override fun onFailure(call: Call<User>, t: Throwable) {

                Log.e("Saad", "API Submission Failure - POST")
            }
        })
    }

    private fun onPut() {

        retrofitApi.saveUserPut(1,"foodoo", "doughfoo",1).enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {

                Log.i("Saad", "PUT successful " + response.body().toString() + " PUT Code " + response.code().toString())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {

                Log.i("Saad", "API Submission Failure - PUT")
            }
        })
    }

    private fun onDelete() {

        retrofitApi.deletePost().enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {

                Log.i("Saad", "Delete Successful " + response.body().toString() + " Delete Code " + response.code().toString())
            }

            override fun onFailure(call: Call<User>, t: Throwable) {

                Log.i("Saad", "API Delete Failure")
            }
        })

    }

    private fun showData(users: List<User>) {

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = (UserAdapter(users))
        }
    }



}