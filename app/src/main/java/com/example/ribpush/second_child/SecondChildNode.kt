package com.example.ribpush.second_child

import android.os.Bundle
import android.view.ViewGroup
import com.badoo.ribs.core.Node

class SecondChildNode internal constructor(
    savedInstanceState: Bundle?,
    viewFactory: ((ViewGroup) -> SecondChildView?)?,
    private val router: SecondChildRouter,
    private val interactor: SecondChildInteractor
) : Node<SecondChildView>(
    savedInstanceState = savedInstanceState,
    identifier = object : SecondChild {},
    viewFactory = viewFactory,
    router = router,
    interactor = interactor
)
