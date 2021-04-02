package br.com.nettracker.ui.notification.manager

import br.com.nettracker.ui.notification.models.NotificationChannelEnum

interface NotificationManager {
    fun notify(
        channel: NotificationChannelEnum,
        title: String,
        message: String
    )
}