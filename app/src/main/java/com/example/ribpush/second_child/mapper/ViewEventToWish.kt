package com.example.ribpush.second_child.mapper

import com.example.ribpush.second_child.SecondChildView.Event
import com.example.ribpush.second_child.feature.SecondChildFeature.Wish

internal object ViewEventToWish : (Event) -> Wish? {

    override fun invoke(event: Event): Wish? = null
}
