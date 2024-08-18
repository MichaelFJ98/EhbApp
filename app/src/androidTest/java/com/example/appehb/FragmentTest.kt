package com.example.appehb

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isClickable
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.isNotClickable
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class FragmentTest {
    @get: Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test1() {
        onView(withId(R.id.fabAddWorkout)).check(matches(isDisplayed()))
    }

    @Test
    fun test2() {
        onView(withId(R.id.fabAddWorkout)).check(matches(isClickable()))
    }

    @Test
    fun test3() {
        onView(withId(R.id.recyclerView_lvWorkout)).check(matches(isNotClickable()))
    }


}