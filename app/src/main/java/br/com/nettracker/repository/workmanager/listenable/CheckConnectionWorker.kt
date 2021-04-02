package br.com.nettracker.repository.workmanager.listenable

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import br.com.nettracker.extensions.format
import br.com.nettracker.ui.notification.manager.NotificationManager
import br.com.nettracker.ui.notification.models.NotificationChannelEnum.TRACKER
import java.util.Calendar
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

@Suppress("EXPERIMENTAL_API_USAGE")
class CheckConnectionWorker(
    context: Context,
    private val workerParams: WorkerParameters
) : Worker(context, workerParams), KoinComponent {
    private val notificationManager: NotificationManager by inject()

    override fun doWork(): Result {
        val time = Calendar.getInstance().time
        val title = TITLE + workerParams.runAttemptCount
        val message = MESSAGE_FORMAT + time.format()

        notificationManager.notify(channel = TRACKER, title = title, message = message)
        return Result.success()
    }

    companion object {
        const val MESSAGE_FORMAT = "4G foi iniciado em : "
        const val TITLE = "Monitoramento"
        const val WORKER_NAME = "CheckConnectionWorker"
    }
}