package com.example.myapplicationapp.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AlternateEmail
import androidx.compose.material.icons.rounded.Map
import androidx.compose.material.icons.rounded.PhoneIphone
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplicationapp.viewmodel.ProfileViewModel

@Composable
fun ProfileScreen(
    vm: ProfileViewModel = viewModel { ProfileViewModel() }
) {
    val state by vm.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .safeContentPadding()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Toggle dark mode (state disimpan di ViewModel)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(if (state.isDarkMode) "Dark mode" else "Light mode")
            Switch(
                checked = state.isDarkMode,
                onCheckedChange = vm::ubahDarkMode
            )
        }

        ProfileHeader(name = state.profile.nama)

        if (state.isEditing) {
            EditProfileForm(
                nama = state.editNama,
                bio = state.editBio,
                bisaSimpan = state.bisaSimpan,
                onNamaChange = vm::ubahNama,
                onBioChange = vm::ubahBio,
                onSimpan = vm::simpan,
                onBatal = vm::batal
            )
        } else {
            ProfileCard(bio = state.profile.bio) {
                AnimatedVisibility(visible = state.showInfo) {
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        InfoItem(Icons.Rounded.AlternateEmail, "Email", state.profile.email)
                        InfoItem(Icons.Rounded.PhoneIphone, "Phone", state.profile.phone)
                        InfoItem(Icons.Rounded.Map, "Location", state.profile.lokasi)
                    }
                }
            }

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = vm::toggleInfo) {
                    Text(if (state.showInfo) "Sembunyikan Info" else "Tampilkan Info")
                }
                OutlinedButton(onClick = vm::mulaiEdit) {
                    Text("Edit Profil")
                }
            }
        }
    }
}

@Composable
private fun EditProfileForm(
    nama: String,
    bio: String,
    bisaSimpan: Boolean,
    onNamaChange: (String) -> Unit,
    onBioChange: (String) -> Unit,
    onSimpan: () -> Unit,
    onBatal: () -> Unit
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text("Edit Profil", style = MaterialTheme.typography.titleLarge)

            LabeledTextField("Nama", nama, onNamaChange)
            LabeledTextField("Bio", bio, onBioChange, singleLine = false)
            Text(
                text = "${bio.length} dari 100 karakter",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Button(onClick = onSimpan, enabled = bisaSimpan) { Text("Simpan") }
                OutlinedButton(onClick = onBatal) { Text("Batal") }
            }
        }
    }
}

