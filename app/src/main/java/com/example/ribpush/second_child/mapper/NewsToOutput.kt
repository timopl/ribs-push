package com.example.ribpush.second_child.mapper

import com.example.ribpush.second_child.SecondChild.Output
import com.example.ribpush.second_child.feature.SecondChildFeature.News

internal object NewsToOutput : (News) -> Output? {

    override fun invoke(news: News): Output? = null
}
