package com.example.tiptime

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.assertion.ViewAssertions.matches
import org.hamcrest.Matchers.containsString

// テストを実行するためのインストルメントテストランナーの指定。デバイスまたはエミュレータを動かすのに必要
@RunWith(AndroidJUnit4::class)
class CalculatorTests {
    // クラス内のテスト実行の前にこの後のルール（ここではアクティビティの起動）を実行できる
    @get:Rule()
    // 指定したアクティビティを起動するように指示
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_20_percent_tip( ) {
        onView(withId(R.id.cost_of_service_edit_text)).perform(typeText("50.00")).perform(ViewActions.closeSoftKeyboard())

        onView(withId(com.example.tiptime.R.id.calculate_button)).perform(click())

        // matches, containsStringは手動でのimport必須
        onView(withId(R.id.tip_result)).check(matches(withText(containsString("￥10"))))
    }

}