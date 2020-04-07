package com.example.ribpush.child.mapper

import com.example.ribpush.child.Child.Output
import com.example.ribpush.child.feature.ChildFeature.News

internal object NewsToOutput : (News) -> Output? {

    override fun invoke(news: News): Output? = null
}
