# My Profile App

Tugas Praktikum Minggu 3 - Pengembangan Aplikasi Mobile (IF25-22017)
Program Studi Teknik Informatika, Institut Teknologi Sumatera (ITERA)

**Nama:** Divania Munthe
**NIM:** 124140027

## Deskripsi

Aplikasi profil sederhana yang dibuat menggunakan **Compose Multiplatform**. Aplikasi menampilkan foto profil bulat, nama, bio singkat, dan daftar informasi kontak (email, nomor HP, lokasi). Informasi kontak bisa disembunyikan dan ditampilkan lewat tombol dengan animasi.

## Fitur

- Header dengan foto profil (circular) dan nama
- Bio / deskripsi singkat
- Daftar informasi: Email, Phone, Location
- Tombol untuk menampilkan / menyembunyikan info (dengan `AnimatedVisibility`)
- Tema warna baby pink

## Composable Functions

| Composable | Fungsi |
|---|---|
| `ProfileHeader` | Menampilkan foto profil bulat dan nama |
| `ProfileCard` | Card berisi bio dan konten tambahan (slot `content`) |
| `InfoItem` | Satu baris info: icon, label, dan value |

## Komponen yang Digunakan

- **Layout:** `Column`, `Row`, `Box`
- **UI Components:** `Text`, `Button`, `Image`, `Icon`, `Card`
- **Modifier:** `fillMaxSize`, `fillMaxWidth`, `padding`, `size`, `clip`, `background`
- **Bonus:** `AnimatedVisibility`

## Screenshot

### Android

![Screenshot Android](screenshots/android.png)

### Desktop

![Screenshot Desktop](screenshots/desktop.png)

## Cara Menjalankan

1. Clone repository ini
   ```bash
   git clone <url-repository-kamu>
   ```
2. Buka project di Android Studio dan tunggu Gradle sync selesai
3. Jalankan aplikasi:
   - **Android:** pilih konfigurasi `androidApp`, lalu klik Run
   - **Desktop:** jalankan `./gradlew :desktopApp:run` (Windows: `gradlew.bat :desktopApp:run`)

## Struktur Utama

```
shared/src/commonMain/
├── kotlin/com/example/myapplicationapp/App.kt   # UI utama dan composable
└── composeResources/drawable/                   # foto profil
```

## Tech Stack

- Kotlin Multiplatform
- Compose Multiplatform (Material 3)
- Material Icons Extended
