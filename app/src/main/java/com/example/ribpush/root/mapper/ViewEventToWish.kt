package com.example.ribpush.root.mapper

import com.example.ribpush.root.RootView.Event
import com.example.ribpush.root.feature.RootFeature.Wish

internal object ViewEventToWish : (Event) -> Wish? {

    override fun invoke(event: Event): Wish? =
        when (event) {
            is Event.Navigate -> Wish.Navigate
        }
}
