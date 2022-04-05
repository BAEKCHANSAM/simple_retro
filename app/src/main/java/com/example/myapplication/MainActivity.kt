package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    //레트로핏 객체 생성
    var retrofit = Retrofit.Builder()
      .baseUrl("https://www.google.com/")
      .addConverterFactory(GsonConverterFactory.create())
      .build()

    var loginService = retrofit.create(LoginService::class.java)


    button.setOnClickListener {
      var textId = editText.text.toString()
      var textPw = editText2.text.toString()

      loginService.requestLogin(textId, textPw).enqueue(object : Callback<Login> {

        override fun onFailure(call: Call<Login>, t: Throwable) {

          Log.d("Debug", t.message.toString())

          var dialog = AlertDialog.Builder(this@MainActivity)
          dialog.setTitle("실패!")
          dialog.setMessage("통신에 실패 했습니다.")
          dialog.show()
        }

        override fun onResponse(call: Call<Login>, response: Response<Login>) {

          Log.d("Debug", response.message())

          var login = response.body()  //

          var dialog = AlertDialog.Builder(this@MainActivity)
          dialog.setTitle("성공!")
          dialog.setMessage("code = " + login?.code + ", msg = " + login?.msg)
          dialog.show()
        }

      })
    }
  }
}
