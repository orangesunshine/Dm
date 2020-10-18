package com.orange.junit

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.google.common.truth.Truth.assertThat
import org.junit.Test

private const val FAKE_STRING = "app"
class EmailValidatorTest {
    val context = ApplicationProvider.getApplicationContext<Context>()

    @Test
    fun validate_email() {
        val string = context.getString(R.string.app_name)
        assertThat(string).isEqualTo(FAKE_STRING)
    }

}