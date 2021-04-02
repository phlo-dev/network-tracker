package br.com.nettracker.ui

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Operation
import br.com.nettracker.R
import br.com.nettracker.extensions.showToast
import br.com.nettracker.repository.workmanager.WorkerProvider
import br.com.nettracker.ui.notification.manager.NotificationManager
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val workerProvider: WorkerProvider by inject()
    private val notificationManager: NotificationManager by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<TextView>(R.id.mainTextView).setOnClickListener {
            val enqueueWorker = workerProvider.enqueueWorker()

            enqueueWorker.state.observe(this) {
                if (it.toString() == "SUCCESS") {
                    showToast(
                        enqueueWorker.result.isDone.toString()
                    )
                }
            }
        }
    }
}