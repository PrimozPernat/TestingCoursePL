package com.plcoding.testingcourse.part1.data

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.logEvent
import com.plcoding.testingcourse.part1.domain.AnalyticsLogger
import com.plcoding.testingcourse.part1.domain.LogParam

class FirebaseAnalyticsLogger(private val analytics: FirebaseAnalytics): AnalyticsLogger {
	override fun logEvent(key: String, vararg params: LogParam<Any>) {
		analytics.logEvent("save_profile") {
			params.forEach {
				param(it.key, it.value.toString())
			}
		}
	}
}