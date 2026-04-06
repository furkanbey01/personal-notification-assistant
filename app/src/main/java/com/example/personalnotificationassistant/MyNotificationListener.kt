package com.example.personalnotificationassistant

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.util.Log

/**
 * A simple NotificationListenerService that logs posted notifications. In a
 * production app you would persist this data to a database (e.g. SQLite or
 * Room) for later analysis.
 */
class MyNotificationListener : NotificationListenerService() {

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        sbn?.let {
            val packageName = it.packageName
            val notification = it.notification
            val ticker = notification.tickerText?.toString() ?: ""
            val postTime = it.postTime
            Log.d("MyNotificationListener", "Notification from $packageName: $ticker at $postTime")
            // TODO: persist notification details into a database
        }
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        // Handle notification removal if needed
    }
}
