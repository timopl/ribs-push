package com.example.ribpush.second_child

import android.os.Bundle
import com.badoo.ribs.core.Builder
import com.badoo.ribs.customisation.customisationsBranchFor
import com.badoo.ribs.customisation.getOrDefault
import com.example.ribpush.second_child.feature.SecondChildFeature

class SecondChildBuilder(
    override val dependency: SecondChild.Dependency
) : Builder<SecondChild.Dependency>() {

    fun build(savedInstanceState: Bundle?): SecondChildNode {
        val customisation = SecondChild.Customisation()
        val feature = SecondChildFeature()
        val router = SecondChildRouter(savedInstanceState, customisation.transitionHandler)
        val interactor = createInteractor(savedInstanceState, router, dependency, feature)

        return SecondChildNode(
            savedInstanceState,
            customisation.viewFactory(null),
            router,
            interactor
        )
    }

    private fun createInteractor(
        savedInstanceState: Bundle?,
        router: SecondChildRouter,
        dependency: SecondChild.Dependency,
        feature: SecondChildFeature
    ) =
        SecondChildInteractor(
            savedInstanceState,
            router,
            dependency.secondChildInput(),
            dependency.secondChildOutput(),
            feature
        )
}
