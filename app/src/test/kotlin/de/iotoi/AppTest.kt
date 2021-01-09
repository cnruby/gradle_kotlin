/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package de.iotoi

import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertNotNull
import kotlin.test.assertEquals

class AppTest {
    @Test fun testAppHasAGreeting() {
        val classUnderTest = HelloLib()
        assertNotNull(classUnderTest.greeting, "app should have a greeting")
    }

    @Test fun testType(){
        val greeting = HelloLib().greeting
        assertEquals(greeting.javaClass.name, "java.lang.String");
        assertEquals(greeting.javaClass.kotlin.qualifiedName, "kotlin.String");

        assertEquals(greeting::class.simpleName, "String");
        assertEquals(greeting::class.qualifiedName, "kotlin.String");
    }
}
