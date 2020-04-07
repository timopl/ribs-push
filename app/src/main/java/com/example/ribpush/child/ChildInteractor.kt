package com.example.ribpush.child

import android.os.Bundle
import androidx.lifecycle.Lifecycle
import com.badoo.mvicore.android.lifecycle.createDestroy
import com.badoo.mvicore.android.lifecycle.startStop
import com.badoo.mvicore.binder.using
import com.badoo.ribs.core.Interactor
import com.example.ribpush.child.analytics.ChildAnalytics
import com.example.ribpush.child.feature.ChildFeature
import com.example.ribpush.child.mapper.InputToWish
import com.example.ribpush.child.mapper.NewsToOutput
import com.example.ribpush.child.mapper.StateToViewModel
import com.example.ribpush.child.mapper.ViewEventToAnalyticsEvent
import com.example.ribpush.child.mapper.ViewEventToWish
import io.reactivex.ObservableSource
import io.reactivex.functions.Consumer

internal class ChildInteractor(
    savedInstanceState: Bundle?,
    private val router: ChildRouter,
    private val input: ObservableSource<Child.Input>,
    private val output: Consumer<Child.Output>,
    private val feature: ChildFeature
) : Interactor<ChildView>(
    savedInstanceState = savedInstanceState,
    disposables = feature
) {

    private val newsListener: Consumer<ChildFeature.News> = Consumer {
        when (it) {
            is ChildFeature.News.Navigate -> router.push(ChildRouter.Configuration.Content.SecondChild)
        }
    }

    override fun onAttach(ribLifecycle: Lifecycle, savedInstanceState: Bundle?) {
        ribLifecycle.createDestroy {
            bind(feature.news to output using NewsToOutput)
            bind(input to feature using InputToWish)
        }
    }

    override fun onViewCreated(view: ChildView, viewLifecycle: Lifecycle) {
        viewLifecycle.startStop {
            bind(feature to view using StateToViewModel)
            bind(view to feature using ViewEventToWish)
            bind(view to ChildAnalytics using ViewEventToAnalyticsEvent)
            bind(feature.news to newsListener)
        }
    }
}
