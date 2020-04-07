package com.example.ribpush.child.mapper

import com.example.ribpush.child.Child.Input
import com.example.ribpush.child.feature.ChildFeature.Wish

internal object InputToWish : (Input) -> Wish? {

    override fun invoke(event: Input): Wish? = null
}
