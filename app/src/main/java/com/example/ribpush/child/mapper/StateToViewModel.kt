package com.example.ribpush.child.mapper

import com.example.ribpush.child.ChildView.ViewModel
import com.example.ribpush.child.feature.ChildFeature.State

internal object StateToViewModel : (State) -> ViewModel {

    override fun invoke(state: State): ViewModel = ViewModel()
}
