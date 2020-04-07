package com.example.ribpush.root

import android.os.Bundle
import androidx.lifecycle.Lifecycle
import com.badoo.mvicore.android.lifecycle.createDestroy
import com.badoo.mvicore.android.lifecycle.startStop
import com.badoo.mvicore.binder.using
import com.badoo.ribs.core.Interactor
import com.example.ribpush.root.analytics.RootAnalytics
import com.example.ribpush.root.feature.RootFeature
import com.example.ribpush.root.mapper.InputToWish
import com.example.ribpush.root.mapper.NewsToOutput
import com.example.ribpush.root.mapper.StateToViewModel
import com.example.ribpush.root.mapper.ViewEventToAnalyticsEvent
import com.example.ribpush.root.mapper.ViewEventToWish
import io.reactivex.ObservableSource
import io.reactivex.functions.Consumer

internal class RootInteractor(
    savedInstanceState: Bundle?,
    private val router: RootRouter,
    private val input: ObservableSource<Root.Input>,
    private val output: Consumer<Root.Output>,
    private val feature: RootFeature
) : Interactor<RootView>(
    savedInstanceState = savedInstanceState,
    disposables = feature
) {

    private val newsListener: Consumer<RootFeature.News> = Consumer {
        when (it) {
            is RootFeature.News.Navigate -> router.push(RootRouter.Configuration.Content.Child)
        }
    }

    override fun onAttach(ribLifecycle: Lifecycle, savedInstanceState: Bundle?) {
        ribLifecycle.createDestroy {
            bind(feature.news to output using NewsToOutput)
            bind(input to feature using InputToWish)
        }
    }

    override fun onViewCreated(view: RootView, viewLifecycle: Lifecycle) {
        viewLifecycle.startStop {
            bind(feature to view using StateToViewModel)
            bind(view to feature using ViewEventToWish)
            bind(view to RootAnalytics using ViewEventToAnalyticsEvent)
            bind(feature.news to newsListener)
        }
    }
}
