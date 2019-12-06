package com.example.projetoandroidbsico

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter : MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val buttonLogin = findViewById<Button>(R.id.button_login)

        buttonLogin.setOnClickListener {
            val intent = Intent(baseContext, ActivityLogin::class.java)

            startActivity(intent)
        }

        val buttonRegister = findViewById<Button>(R.id.button_register)

        buttonRegister.setOnClickListener {

            val intent = Intent(baseContext, ActivityRegister::class.java)

            startActivity(intent)


        }


        val componentName = ComponentName(this, MyJobService::class.java)
        val jobInfo = JobInfo.Builder(12, componentName)
            .setRequiresCharging(true)
            .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
            .setPeriodic(1000L)
            .build()


        val jobScheduler = getSystemService(Context.JOB_SCHEDULER_SERVICE) as JobScheduler?
        val resultCode = jobScheduler?.schedule(jobInfo)
        if(resultCode == JobScheduler.RESULT_SUCCESS){
            Log.d("Olá", "Job scheduled!")
        }else{
            Log.d("Hello,", "Job not scheduled")
        }

    }


}