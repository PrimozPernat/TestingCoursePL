package com.plcoding.testingcourse.part4.presentation

import com.plcoding.testingcourse.R
import com.plcoding.testingcourse.part1.domain.AnalyticsLogger
import com.plcoding.testingcourse.part1.domain.LogParam
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.BeforeEach

class GoodProfileViewModelTest {

	private lateinit var SUT: GoodProfileViewModel
	private val fakeAnalyticsLogger = FakeAnalyticsLogger()


	@BeforeEach
	fun setUp() {
		SUT = GoodProfileViewModel(fakeAnalyticsLogger)
	}

	@Test
	fun `test saving profile`() {
		SUT.saveProfile()
		assert(SUT.state.infoMessage == UiText.StringResource(R.string.successfully_saved_profile))
	}
}

class FakeAnalyticsLogger: AnalyticsLogger {

	override fun logEvent(key: String, vararg params: LogParam<Any>) {

	}

}