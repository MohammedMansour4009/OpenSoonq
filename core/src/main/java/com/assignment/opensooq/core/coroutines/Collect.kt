package com.assignment.opensooq.core.coroutines

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

fun <T> StateFlow<T>.collect(
    lifecycleOwner: LifecycleOwner,
    action: suspend (value: T) -> Unit
) {
    lifecycleOwner.lifecycleScope.launch {
        flowWithLifecycle(lifecycleOwner.lifecycle).distinctUntilChanged().collectLatest(action)
    }
}

fun <T> SharedFlow<T>.collect(
    lifecycleOwner: LifecycleOwner,
    action: suspend (value: T) -> Unit
) {
    lifecycleOwner.lifecycleScope.launch { flowWithLifecycle(lifecycleOwner.lifecycle).collectLatest(action) }
}
