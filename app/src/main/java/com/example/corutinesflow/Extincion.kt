package com.example.corutinesflow

import androidx.lifecycle.LifecycleCoroutineScope
import java.util.concurrent.Flow

//fun <T> Flow<T>.launchWhenStarted(lifecycleScope: LifecycleCoroutineScope){
//    lifecycleScope.launchWhenCreated {
//        this@launchWhenStarted.collect()
//    }
//}