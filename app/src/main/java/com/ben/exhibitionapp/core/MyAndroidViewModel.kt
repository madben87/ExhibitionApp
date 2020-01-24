package com.ben.exhibitionapp.core

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlin.coroutines.CoroutineContext

open class MyAndroidViewModel(application: Application) : AndroidViewModel(application), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob()

    override fun onCleared() {
        super.onCleared()
        cancel()
    }
}