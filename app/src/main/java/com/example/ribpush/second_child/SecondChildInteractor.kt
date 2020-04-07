package com.example.ribpush.second_child

import android.os.Bundle
import androidx.lifecycle.Lifecycle
import com.badoo.mvicore.android.lifecycle.createDestroy
import com.badoo.mvicore.android.lifecycle.startStop
import com.badoo.mvicore.binder.using
import com.badoo.ribs.core.Interactor
import com.example.ribpush.second_child.analytics.SecondChildAnalytics
import com.example.ribpush.second_child.feature.SecondChildFeature
import com.example.ribpush.second_child.mapper.InputToWish
import com.example.ribpush.second_child.mapper.NewsToOutput
import com.example.ribpush.second_child.mapper.StateToViewModel
import com.example.ribpush.second_child.mapper.ViewEventToAnalyticsEvent
import com.example.ribpush.second_child.mapper.ViewEventToWish
import io.reactivex.ObservableSource
import io.reactivex.functions.Consumer

internal class SecondChildInteractor(
    savedInstanceState: Bundle?,
    private val router: SecondChildRouter,
    private val input: ObservableSource<SecondChild.Input>,
    private val output: Consumer<SecondChild.Output>,
    private val feature: SecondChildFeature
) : Interactor<SecondChildView>(
    savedInstanceState = savedInstanceState,
    disposables = feature
) {

    override fun onAttach(ribLifecycle: Lifecycle, savedInstanceState: Bundle?) {
        ribLifecycle.createDestroy {
            bind(feature.news to output using NewsToOutput)
            bind(input to feature using InputToWish)
        }
    }

    override fun onViewCreated(view: SecondChildView, viewLifecycle: Lifecycle) {
        viewLifecycle.startStop {
            bind(feature to view using StateToViewModel)
            bind(view to feature using ViewEventToWish)
            bind(view to SecondChildAnalytics using ViewEventToAnalyticsEvent)
        }
    }
}
