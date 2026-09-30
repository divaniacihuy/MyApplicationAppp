package com.example.myapplicationapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform