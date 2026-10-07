package com.example.myapplicationapp.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ProfileViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileUiState())


    val uiState = _uiState.asStateFlow()


    fun toggleInfo() =
        _uiState.update { it.copy(showInfo = !it.showInfo) }

    fun mulaiEdit() = _uiState.update {
        it.copy(
            isEditing = true,
            editNama = it.profile.nama,
            editBio = it.profile.bio
        )
    }

    fun ubahNama(teks: String) =
        _uiState.update { it.copy(editNama = teks) }

    fun ubahBio(teks: String) =
        _uiState.update { it.copy(editBio = teks.take(100)) }

    // Save: validasi dulu, lalu update profil (email, phone, lokasi tetap)
    fun simpan() {
        if (!_uiState.value.bisaSimpan) return
        _uiState.update {
            it.copy(
                profile = it.profile.copy(
                    nama = it.editNama.trim(),
                    bio = it.editBio.trim()
                ),
                isEditing = false
            )
        }
    }

    fun batal() =
        _uiState.update { it.copy(isEditing = false) }

    fun ubahDarkMode(aktif: Boolean) =
        _uiState.update { it.copy(isDarkMode = aktif) }
}