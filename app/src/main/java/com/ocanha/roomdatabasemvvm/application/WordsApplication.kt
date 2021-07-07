package com.ocanha.roomdatabasemvvm.application

import android.app.Application
import com.ocanha.roomdatabasemvvm.database.WordRoomDatabase
import com.ocanha.roomdatabasemvvm.repository.WordRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class WordsApplication : Application() {

    private val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { WordRoomDatabase.getDatabase(applicationScope,this) }
    val repository by lazy { WordRepository(database.wordDao()) }

}