package com.example.ribpush.second_child

import com.badoo.ribs.customisation.RibCustomisationDirectory
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.ObservableSource
import io.reactivex.functions.Consumer
import org.junit.After
import org.junit.Before
import org.junit.Test

class SecondChildWorkflowTest {

    private lateinit var workflow: SecondChild.Workflow

    @Before
    fun setup() {
        workflow = SecondChildBuilder(object : SecondChild.Dependency {
            override fun secondChildInput(): ObservableSource<SecondChild.Input> = mock()
            override fun secondChildOutput(): Consumer<SecondChild.Output> = mock()
            override fun ribCustomisation(): RibCustomisationDirectory = mock()
        }).build(null).also {
            it.onAttach()
        }
    }

    @After
    fun tearDown() {
    }

    /**
     * TODO: Add tests for every workflow action that operates on the node
     */
    @Test
    fun `business logic operation test`() {
        workflow.businessLogicOperation()
        // verify(feature).accept(Wish)

        throw RuntimeException("Add real tests.")
    }

    /**
     * TODO: Add tests for every workflow action that attaches a child to ensure workflow step can be fulfilled
     */
    @Test
    fun `attach child workflow step is fulfillable`() {
        // val testObserver = TestObserver<Child.Workflow>()

        // workflow.attachChild1().subscribe(testObserver)

        // testObserver.assertValueCount(1)
        // testObserver.assertComplete()

        throw RuntimeException("Add real tests.")
    }
}
