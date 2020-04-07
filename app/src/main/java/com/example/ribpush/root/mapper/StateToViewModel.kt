package com.example.ribpush.root.mapper

import com.example.ribpush.root.RootView.ViewModel
import com.example.ribpush.root.feature.RootFeature.State

internal object StateToViewModel : (State) -> ViewModel {

    override fun invoke(state: State): ViewModel = ViewModel()
}
