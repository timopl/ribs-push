package com.example.ribpush.second_child.mapper

import com.example.ribpush.second_child.SecondChildView.ViewModel
import com.example.ribpush.second_child.feature.SecondChildFeature.State

internal object StateToViewModel : (State) -> ViewModel {

    override fun invoke(state: State): ViewModel = ViewModel()
}
