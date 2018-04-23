package com.test

import org.junit.jupiter.api.Test

class MainIT : BaseTest() {

    @Test
    fun shouldRunMain() {
        Main.main(arrayOf())
    }

}