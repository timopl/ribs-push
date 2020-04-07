package com.example.ribpush.second_child

import com.nhaarman.mockitokotlin2.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner


@RunWith(RobolectricTestRunner::class)
class SecondChildRouterTest {

    private var interactor: SecondChildInteractor = mock()
    private var router: SecondChildRouter? = null

    @Before
    fun setup() {
        router = SecondChildRouter(
            savedInstanceState = null
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
