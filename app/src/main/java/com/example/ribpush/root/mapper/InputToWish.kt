package com.example.ribpush.root.mapper

import com.example.ribpush.root.Root.Input
import com.example.ribpush.root.feature.RootFeature.Wish

internal object InputToWish : (Input) -> Wish? {

    override fun invoke(event: Input): Wish? = null
}
