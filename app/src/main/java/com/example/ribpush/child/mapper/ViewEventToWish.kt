package com.example.ribpush.child.mapper

import com.example.ribpush.child.ChildView.Event
import com.example.ribpush.child.feature.ChildFeature.Wish

internal object ViewEventToWish : (Event) -> Wish? {

    override fun invoke(event: Event): Wish? =
        when (event) {
            is Event.Navigate -> Wish.Navigate
        }
}
