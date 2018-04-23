package com.test

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TestName
import org.slf4j.LoggerFactory
import java.io.File
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*

abstract class BaseTest {

    protected val logger = LoggerFactory.getLogger(javaClass)

    @Rule @JvmField
    var name = TestName()

    private var testStartDate: Long = 0

    protected val tempDirectory: String
        get() {
            File(TEMP_DIR).mkdirs()
            return TEMP_DIR
        }

    @Before
    fun setUpBeforeTest() {
        testStartDate = System.currentTimeMillis()
        logger.info("===================================================================")
        logger.info("BEGIN TEST " + name.methodName)
        logger.info("===================================================================")

    }

    @After
    fun tearDownAfterTest() {
        val executionTime = System.currentTimeMillis() - testStartDate
        logger.info("===================================================================")
        logger.info("END TEST " + name.methodName)
        logger.info("execution time: " + TIME_FORMAT.format(executionTime) + " ms")
        logger.info("===================================================================")
    }

    companion object {

        protected val TIME_FORMAT = DecimalFormat("####,###.###",
                DecimalFormatSymbols(Locale.US))

        private val TEMP_DIR = "./target/junit-temp/" + System.currentTimeMillis()
    }

}