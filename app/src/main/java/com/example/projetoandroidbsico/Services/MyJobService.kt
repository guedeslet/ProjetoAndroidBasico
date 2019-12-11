package com.example.projetoandroidbsico.Services

import android.app.job.JobParameters
import android.app.job.JobService
import android.util.Log
import java.lang.Exception


public class MyJobService: JobService(){


    private val TAG = MyJobService::class.java.simpleName
    var isWorking = false

    override fun onStopJob(p0: JobParameters?): Boolean {

        return false

    }

    override fun onStartJob(p0: JobParameters?): Boolean {
        Log.d("aspk", "Job Started!")
        isWorking = true



        // We need 'jobParameters' so we can call ''obFinished'

        startWorkOnNewThread(p0)
        return isWorking


    }

    fun startWorkOnNewThread(p0: JobParameters?){

        Thread(Runnable{
            doWork(p0)
        }).start()

    }

    fun doWork(p0: JobParameters?){


        for (x in 0..1000){

            Log.d("aspk", "Job finished!")
            try{
                Thread.sleep(10)
            }catch (e: Exception){}
        }
        Log.d("aspk", "Job finished!")
        isWorking = false
        val needsReschedule = false
        jobFinished(p0, needsReschedule)


    }


}