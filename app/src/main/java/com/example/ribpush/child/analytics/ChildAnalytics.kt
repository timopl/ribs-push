package com.example.ribpush.child.analytics

import com.example.ribpush.child.ChildView
import io.reactivex.functions.Consumer

internal object ChildAnalytics : Consumer<ChildAnalytics.Event> {

    sealed class Event {
        data class ViewEvent(val event: ChildView.Event) : Event()
    }

    override fun accept(event: ChildAnalytics.Event) {
        // TODO Implement tracking
    }
}
