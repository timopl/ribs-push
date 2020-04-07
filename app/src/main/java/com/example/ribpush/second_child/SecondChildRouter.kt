package com.example.ribpush.second_child

import android.os.Bundle
import android.os.Parcelable
import com.badoo.ribs.core.Router
import com.badoo.ribs.core.routing.action.RoutingAction
import com.badoo.ribs.core.routing.transition.handler.TransitionHandler
import com.example.ribpush.second_child.SecondChildRouter.Configuration
import com.example.ribpush.second_child.SecondChildRouter.Configuration.Content
import com.example.ribpush.second_child.SecondChildRouter.Configuration.Overlay
import com.example.ribpush.second_child.SecondChildRouter.Configuration.Permanent
import kotlinx.android.parcel.Parcelize

class SecondChildRouter(
    savedInstanceState: Bundle?,
    transitionHandler: TransitionHandler<Configuration>? = null
): Router<Configuration, Permanent, Content, Overlay, SecondChildView>(
    savedInstanceState = savedInstanceState,
    transitionHandler = transitionHandler,
    initialConfiguration = Content.Default,
    permanentParts = emptyList()
) {
    sealed class Configuration : Parcelable {
        sealed class Permanent : Configuration()
        sealed class Content : Configuration() {
            @Parcelize object Default : Content()
        }
        sealed class Overlay : Configuration()
    }

    override fun resolveConfiguration(configuration: Configuration): RoutingAction<SecondChildView> =
        RoutingAction.noop()
}
