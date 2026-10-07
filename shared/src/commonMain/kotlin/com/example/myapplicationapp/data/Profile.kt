package com.example.myapplicationapp.data
data class Profile(
    val nama: String,
    val bio: String,
    val email: String,
    val phone: String,
    val lokasi: String
)

object ProfileRepository {
    val defaultProfile = Profile(
        nama = "Divania Munthe",
        bio = "Mahasiswa Teknik Informatika ITERA yang lagi belajar bikin aplikasi mobile ecek ecek.",
        email = "divania.124140027@student.itera.ac.id",
        phone = "+62 821-6295-9034",
        lokasi = "Bandar Lampung, Indonesia"
    )
}