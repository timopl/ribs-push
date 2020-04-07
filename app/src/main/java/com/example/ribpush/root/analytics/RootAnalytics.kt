package com.example.ribpush.root.analytics

import com.example.ribpush.root.RootView
import io.reactivex.functions.Consumer

internal object RootAnalytics : Consumer<RootAnalytics.Event> {

    sealed class Event {
        data class ViewEvent(val event: RootView.Event) : Event()
    }

    override fun accept(event: RootAnalytics.Event) {
        // TODO Implement tracking
    }
}
