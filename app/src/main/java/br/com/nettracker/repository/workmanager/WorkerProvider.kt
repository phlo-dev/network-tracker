package br.com.nettracker.repository.workmanager

import androidx.work.Operation

interface WorkerProvider {
    fun enqueueWorker(): Operation
}