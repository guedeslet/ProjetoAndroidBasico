package com.example.projetoandroidbsico.Views

import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.core.app.NotificationCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.projetoandroidbsico.Adapters.MyAdapterBooks
import com.example.projetoandroidbsico.Notifications.ChannelID
import com.example.projetoandroidbsico.Notifications.NOTIFICATION_CHANNELS
import com.example.projetoandroidbsico.Notifications.NotificationsProvider
import com.example.projetoandroidbsico.Services.MyJobService
import com.example.projetoandroidbsico.R

class MainActivity : AppCompatActivity() {

    companion object {
        const val NOTIFICATION_ID = 1
        val notificationsProvider = NotificationsProvider()
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter : MyAdapterBooks

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initNotifications()

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
            Log.d("aspk", "Job scheduled!")
        }else{
            Log.d("aspk", "Job not scheduled")
        }

    }

    private fun initNotifications() {

        notificationsProvider.buildNotification(
            this,
            NOTIFICATION_CHANNELS[ChannelID.TEST]!!,
            NOTIFICATION_ID,
            "Notification Check",
            5,
            "Check Notifications Working As Expected"
        ) { channelId ->
            NotificationCompat.Builder(this, channelId)
                .setContentTitle("The future is in your hands")
                .setContentText("Você já deu uma olhada nas notícias sobre Bitcoins hoje?")
                .setSmallIcon(R.drawable.ic_event_note_black_24dp)
        }
    }


}