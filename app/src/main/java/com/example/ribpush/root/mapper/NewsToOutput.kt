package com.example.ribpush.root.mapper

import com.example.ribpush.root.Root.Output
import com.example.ribpush.root.feature.RootFeature.News

internal object NewsToOutput : (News) -> Output? {

    override fun invoke(news: News): Output? = null
}
