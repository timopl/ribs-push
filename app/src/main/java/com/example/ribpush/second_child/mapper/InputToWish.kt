package com.example.ribpush.second_child.mapper

import com.example.ribpush.second_child.SecondChild.Input
import com.example.ribpush.second_child.feature.SecondChildFeature.Wish

internal object InputToWish : (Input) -> Wish? {

    override fun invoke(event: Input): Wish? = null
}
