package com.example.ribpush.second_child.analytics

import com.example.ribpush.second_child.SecondChildView
import io.reactivex.functions.Consumer

internal object SecondChildAnalytics : Consumer<SecondChildAnalytics.Event> {

    sealed class Event {
        data class ViewEvent(val event: SecondChildView.Event) : Event()
    }

    override fun accept(event: SecondChildAnalytics.Event) {
        // TODO Implement tracking
    }
}
