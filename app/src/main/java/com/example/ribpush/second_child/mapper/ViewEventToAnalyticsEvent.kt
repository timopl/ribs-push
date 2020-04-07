package com.example.ribpush.second_child.mapper

import com.example.ribpush.second_child.SecondChildView.Event
import com.example.ribpush.second_child.analytics.SecondChildAnalytics
import com.example.ribpush.second_child.analytics.SecondChildAnalytics.Event.ViewEvent

internal object ViewEventToAnalyticsEvent : (Event) -> SecondChildAnalytics.Event? {

    override fun invoke(event: Event): SecondChildAnalytics.Event? =
        ViewEvent(event)
}
