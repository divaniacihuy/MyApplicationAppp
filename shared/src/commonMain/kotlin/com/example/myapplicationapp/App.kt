package com.example.myapplicationapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AlternateEmail
import androidx.compose.material.icons.rounded.Map
import androidx.compose.material.icons.rounded.PhoneIphone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource

import myapplicationapp.shared.generated.resources.Res
import myapplicationapp.shared.generated.resources.profile


private const val NAMA = "Divania Munthe"
private const val BIO = "Mahasiswa Teknik Informatika ITERA yang lagi belajar bikin aplikasi mobile ecek ecek."
private const val EMAIL = "divania.124140027@student.itera.ac.id"
private const val PHONE = "+62 821-6295-9034"
private const val LOKASI = "Bandar Lampung, Indonesia"


private val BabyPink = Color(0xFFFFE4EC)
private val DarkPink = Color(0xFFF06292)

@Composable
@Preview
fun App() {
    MaterialTheme {
        var showInfo by remember { mutableStateOf(true) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BabyPink)
                .safeContentPadding()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ProfileHeader(name = NAMA)

            ProfileCard(bio = BIO) {
                AnimatedVisibility(visible = showInfo) {
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        InfoItem(Icons.Rounded.AlternateEmail, "Email", EMAIL)
                        InfoItem(Icons.Rounded.PhoneIphone, "Phone", PHONE)
                        InfoItem(Icons.Rounded.Map, "Location", LOKASI)
                    }
                }
            }

            Button(
                onClick = { showInfo = !showInfo },
                colors = ButtonDefaults.buttonColors(containerColor = DarkPink)
            ) {
                Text(if (showInfo) "Sembunyikan Info" else "Tampilkan Info")
            }
        }
    }
}


@Composable
fun ProfileHeader(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(Color.White),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(Res.drawable.profile),
                contentDescription = "Foto profil",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(Modifier.height(12.dp))
        Text(text = name, fontSize = 26.sp, fontWeight = FontWeight.Bold)
    }
}


@Composable
fun ProfileCard(
    bio: String,
    modifier: Modifier = Modifier,
    content: @Composable ColumnScope.() -> Unit
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(
                text = bio,
                color = Color.Gray,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            content()
        }
    }
}


@Composable
fun InfoItem(icon: ImageVector, label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(44.dp)
                .clip(CircleShape)
                .background(BabyPink),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = DarkPink
            )
        }
        Column(modifier = Modifier.padding(start = 12.dp)) {
            Text(text = label, fontSize = 12.sp, color = Color.Gray)
            Text(text = value, fontWeight = FontWeight.Medium)
        }
    }
}