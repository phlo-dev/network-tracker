package br.com.nettracker.ui.notification.manager

import android.app.NotificationChannel
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import br.com.nettracker.R
import br.com.nettracker.ui.MainActivity
import br.com.nettracker.ui.notification.models.NotificationChannelEnum
import java.util.UUID

class NotificationManagerImpl(
    private val context: Context
) : NotificationManager {
    private val newNotificationId get() = UUID.randomUUID().hashCode()
    private val intent = Intent(context, MainActivity::class.java).apply {
        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
    }
    private val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

    override fun notify(channel: NotificationChannelEnum, title: String, message: String) {
        createBuilder(channel).run {
            setContentTitle(title)
            setStyle(NotificationCompat.BigTextStyle().bigText(message))
            NotificationManagerCompat.from(context)
                .notify(newNotificationId, build())
        }
    }

    private fun createBuilder(
        channel: NotificationChannelEnum
    ): NotificationCompat.Builder {
        createNotificationChannel(channel)
        return NotificationCompat.Builder(context, channel.name)
            .setSmallIcon(R.drawable.ic_policy_24)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
    }

    private fun createNotificationChannel(channelEnum: NotificationChannelEnum) {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        val importance = ANDROID_NOTIFICATION_MANAGER.IMPORTANCE_DEFAULT
        val channel = NotificationChannel(channelEnum.name, channelEnum.channelName, importance)
        // Register the channel with the system
        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE)
            as ANDROID_NOTIFICATION_MANAGER
        notificationManager.createNotificationChannel(channel)
    }
}

private typealias ANDROID_NOTIFICATION_MANAGER = android.app.NotificationManager