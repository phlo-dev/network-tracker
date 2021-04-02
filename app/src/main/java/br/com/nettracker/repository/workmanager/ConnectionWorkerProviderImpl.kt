package br.com.nettracker.repository.workmanager

import android.content.Context
import androidx.work.Constraints
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.Operation
import androidx.work.WorkManager
import br.com.nettracker.repository.workmanager.listenable.CheckConnectionWorker

class ConnectionWorkerProviderImpl(private val context: Context) : WorkerProvider {

    override fun enqueueWorker(): Operation {
        val workerName: String = CheckConnectionWorker.WORKER_NAME
        val workRequest = getWorkRequest()
        val policy = ExistingWorkPolicy.REPLACE
        return WorkManager.getInstance(context)
            .beginUniqueWork(workerName, policy, workRequest)
            .enqueue()
    }

    private val constraints = Constraints.Builder()
        .setRequiredNetworkType(NetworkType.CONNECTED)
        .build()

    private fun getWorkRequest() =
        OneTimeWorkRequestBuilder<CheckConnectionWorker>()
            .setConstraints(constraints)
            .build()
}