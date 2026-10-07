package com.example.myapplicationapp.viewmodel

import com.example.myapplicationapp.data.Profile
import com.example.myapplicationapp.data.ProfileRepository

data class ProfileUiState(
    val profile: Profile = ProfileRepository.defaultProfile,
    val isEditing: Boolean = false,
    val editNama: String = "",
    val editBio: String = "",
    val showInfo: Boolean = true,
    val isDarkMode: Boolean = false
) {

    val bisaSimpan: Boolean
        get() = editNama.isNotBlank()
}