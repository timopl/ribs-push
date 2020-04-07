package com.example.ribpush.root.feature

import com.badoo.mvicore.element.Actor
import com.badoo.mvicore.element.Bootstrapper
import com.badoo.mvicore.element.NewsPublisher
import com.badoo.mvicore.element.Reducer
import com.badoo.mvicore.feature.ActorReducerFeature
import com.example.ribpush.root.feature.RootFeature.Effect
import com.example.ribpush.root.feature.RootFeature.News
import com.example.ribpush.root.feature.RootFeature.State
import com.example.ribpush.root.feature.RootFeature.Wish
import io.reactivex.Observable
import io.reactivex.Observable.empty
import io.reactivex.Observable.just

internal class RootFeature : ActorReducerFeature<Wish, Effect, State, News>(
    initialState = State(),
    bootstrapper = BootStrapperImpl(),
    actor = ActorImpl(),
    reducer = ReducerImpl(),
    newsPublisher = NewsPublisherImpl()
) {

    data class State(
        val yourData: Any? = null
    )

    sealed class Wish {
        object Navigate: Wish()
    }

    sealed class Effect {
        object DidNavigate: Effect()
    }

    sealed class News {
        object Navigate: News()
    }

    class BootStrapperImpl : Bootstrapper<Wish> {
        override fun invoke(): Observable<Wish> =
            empty()
    }

    class ActorImpl : Actor<State, Wish, Effect> {
        override fun invoke(state: State, wish: Wish): Observable<Effect> =
            when (wish) {
                is Wish.Navigate -> just(Effect.DidNavigate)
            }
    }

    class ReducerImpl : Reducer<State, Effect> {
        override fun invoke(state: State, effect: Effect): State =
            state
    }

    class NewsPublisherImpl : NewsPublisher<Wish, Effect, State, News> {
        override fun invoke(wish: Wish, effect: Effect, state: State): News? =
            when (effect) {
                is Effect.DidNavigate -> News.Navigate
                else -> null
            }
    }
}
