package com.plcoding.testingcourse.part4.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import com.plcoding.testingcourse.R
import com.plcoding.testingcourse.part1.domain.AnalyticsLogger
import com.plcoding.testingcourse.part1.domain.LogParam

class GoodProfileViewModel(private val analyticsLogger: AnalyticsLogger) : ViewModel() {

	var state by mutableStateOf(GoodProfileState())
		private set

	fun saveProfile() {
		analyticsLogger.logEvent(
			key = "save_profile",
			LogParam("profile_id", state.profileId),
			LogParam("username", state.username)

		)

		state = state.copy(
			infoMessage = UiText.StringResource(R.string.successfully_saved_profile)
		)
	}
}