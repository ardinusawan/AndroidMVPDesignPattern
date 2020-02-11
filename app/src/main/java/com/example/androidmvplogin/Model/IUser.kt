package com.example.androidmvplogin.Model

interface IUser {
    fun getEmail(): String
    fun getPassword(): String
    fun isValidData(): Int
}