package com.example.ribpush.child.mapper

import com.example.ribpush.child.ChildView.Event
import com.example.ribpush.child.analytics.ChildAnalytics
import com.example.ribpush.child.analytics.ChildAnalytics.Event.ViewEvent

internal object ViewEventToAnalyticsEvent : (Event) -> ChildAnalytics.Event? {

    override fun invoke(event: Event): ChildAnalytics.Event? =
        ViewEvent(event)
}
