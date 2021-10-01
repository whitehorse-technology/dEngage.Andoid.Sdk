package com.dengage.sdk.cache

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.dengage.sdk.inappmessage.model.*
import com.dengage.sdk.models.SdkParameters
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

/**
 * Created by Batuhan Coskun on 27 December 2020
 */
class PrefsTest {

    private lateinit var context: Context
    private lateinit var prefs: Prefs

    @Before
    fun setup() {
        context = InstrumentationRegistry.getInstrumentation().context
        prefs = Prefs(context)
    }

    @After
    fun tearDown() {
        prefs.clear()
    }

    @Test
    fun saveSdkParametersToPrefsTest() {
        val accountId = 1
        val accountName = "accountName"
        val eventsEnabled = true
        val inboxEnabled = true
        val inAppEnabled = true
        val subscriptionEnabled = true
        val inAppFetchIntervalInMin = 10
        val inAppMinSecBetweenMessages = 10
        val lastFetchTimeInMillis = 10L
        val appTrackingEnabled = true

        val sdkParameters = SdkParameters(
            accountId = accountId,
            accountName = accountName,
            eventsEnabled = eventsEnabled,
            inboxEnabled = inboxEnabled,
            inAppEnabled = inAppEnabled,
            subscriptionEnabled = subscriptionEnabled,
            inAppFetchIntervalInMin = inAppFetchIntervalInMin,
            inAppMinSecBetweenMessages = inAppMinSecBetweenMessages,
            lastFetchTimeInMillis = lastFetchTimeInMillis,
            appTrackingEnabled = appTrackingEnabled,
            appTrackingList = listOf()
        )
        prefs.sdkParameters = sdkParameters

        Assert.assertEquals(prefs.sdkParameters?.accountId, accountId)
        Assert.assertEquals(prefs.sdkParameters?.accountName, accountName)
        Assert.assertEquals(prefs.sdkParameters?.eventsEnabled, eventsEnabled)
        Assert.assertEquals(prefs.sdkParameters?.inboxEnabled, inboxEnabled)
        Assert.assertEquals(prefs.sdkParameters?.inAppEnabled, inAppEnabled)
        Assert.assertEquals(prefs.sdkParameters?.subscriptionEnabled, subscriptionEnabled)
        Assert.assertEquals(prefs.sdkParameters?.inAppFetchIntervalInMin, inAppFetchIntervalInMin)
        Assert.assertEquals(prefs.sdkParameters?.inAppMinSecBetweenMessages, inAppMinSecBetweenMessages)
        Assert.assertEquals(prefs.sdkParameters?.lastFetchTimeInMillis, lastFetchTimeInMillis)
        Assert.assertEquals(prefs.sdkParameters?.appTrackingEnabled, appTrackingEnabled)
    }

    @Test
    fun saveInAppMessageFetchTimeToPrefsTest() {
        val time = 20L
        prefs.inAppMessageFetchTime = time
        Assert.assertEquals(prefs.inAppMessageFetchTime, time)
    }

    @Test
    fun saveInAppMessageShowTimeToPrefsTest() {
        val time = 20L
        prefs.inAppMessageShowTime = time
        Assert.assertEquals(prefs.inAppMessageShowTime, time)
    }

    @Test
    fun saveInAppMessagesToPrefsTest() {
        val id = Math.random().toString()
        val contentParams = ContentParams(
            position = ContentPosition.BOTTOM.position,
            shouldAnimate = true,
            html = null,
            maxWidth = null,
            radius = null,
            marginTop = null,
            marginBottom = null,
            marginLeft = null,
            marginRight = null,
            dismissOnTouchOutside = false
        )
        val content = Content(
            type = ContentType.SMALL.type,
            targetUrl = null,
            params = contentParams
        )

        val displayCondition = DisplayCondition(
            screenNameFilters = null,
            screenDataFilters = null
        )
        val displayTiming = DisplayTiming(
            triggerBy = TriggerBy.NAVIGATION.triggerBy,
            delay = 10,
            showEveryXMinutes = 5
        )
        val inAppMessageData = InAppMessageData(
            messageId = Math.random().toString(),
            messageDetails = "messageDetails",
            expireDate = "expireDate",
            priority = Priority.LOW.priority,
            dengageSendId = Math.random().toInt(),
            dengageCampId = Math.random().toInt(),
            content = content,
            displayCondition = displayCondition,
            displayTiming = displayTiming
        )

        val inAppMessage = InAppMessage(
            id = id,
            data = inAppMessageData
        )

        prefs.inAppMessages = mutableListOf(inAppMessage)
        Assert.assertEquals(prefs.inAppMessages?.size, 1)
    }

    @Test
    fun clearPrefsTest() {
        prefs.inAppMessageFetchTime = 1
        prefs.clear()
        Assert.assertEquals(prefs.inAppMessageFetchTime, 0)
    }

}