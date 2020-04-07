package com.example.ribpush.second_child

import com.example.ribpush.second_child.feature.SecondChildFeature
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.ObservableSource
import io.reactivex.functions.Consumer
import org.junit.After
import org.junit.Before
import org.junit.Test

class SecondChildInteractorTest {

    private val input: ObservableSource<SecondChild.Input> = mock()
    private val output: Consumer<SecondChild.Output> = mock()
    private val feature: SecondChildFeature = mock()
    private val router: SecondChildRouter = mock()
    private lateinit var interactor: SecondChildInteractor

    @Before
    fun setup() {
        interactor = SecondChildInteractor(
            savedInstanceState = null,
            input = input,
            output = output,
            feature = feature,
            router = router
        )
    }

    @After
    fun tearDown() {
    }

    /**
     * TODO: Add real tests.
     */
    @Test
    fun `an example test with some conditions should pass`() {
        throw RuntimeException("Add real tests.")
    }
}
