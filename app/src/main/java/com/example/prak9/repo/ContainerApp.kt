package com.example.prak9.repo

import android.app.Application
import android.content.Context
import com.example.prak9.room.DatabaseSiswa

interface ContainerApp {
    val repoSiswa : RepoSiswa
}

class ContainerDataApp(private val context: Context) :
    ContainerApp {
        override val repoSiswa : RepoSiswa by lazy {
        OfflineRepoSiswa(
            DatabaseSiswa.
            getDatabase(context).
            siswaDao())
    }
}

class AplikasiSiswa : Application() {
    /**
     * AppContainer instance digunakan oleh kelas-kelas lainnya untuk mendapatkan dependensi
     */
     lateinit var container: ContainerApp

     override fun onCreate() {
         super.onCreate()
         container = ContainerDataApp(this)
     }
}