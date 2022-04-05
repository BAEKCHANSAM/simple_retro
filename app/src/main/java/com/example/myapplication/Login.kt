package com.example.myapplication

// 아웃풋을 만든다
data class Login(
  //json에 있는 Key값이랑 똑같아야지만 값이 넘어 온다.
  var code : String,
  var msg : String
)