package com.example.ribpush.root.mapper

import com.example.ribpush.root.RootView.Event
import com.example.ribpush.root.analytics.RootAnalytics
import com.example.ribpush.root.analytics.RootAnalytics.Event.ViewEvent

internal object ViewEventToAnalyticsEvent : (Event) -> RootAnalytics.Event? {

    override fun invoke(event: Event): RootAnalytics.Event? =
        ViewEvent(event)
}
