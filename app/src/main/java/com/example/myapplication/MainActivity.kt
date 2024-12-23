package com.example.myapplication

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.Worker
import androidx.work.WorkerParameters
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val uploadRequest = OneTimeWorkRequest.Builder(UploadWorker::class.java)
            .build()
        val workManager = WorkManager.getInstance(applicationContext)
        workManager.enqueue(uploadRequest)
        //ActivityRouter.navigate(R.id.fragment_a, R.id.main, supportFragmentManager)


    }


}


object ActivityRouter {
    fun navigate(id : Int, replace : Int, fragmentManager : FragmentManager)  {
        when(id) {
            R.id.fragment_a -> {
                fragmentManager
                    .beginTransaction()
                    .replace(replace, FragmentA())
                    .addToBackStack(null)
                    .commit()
            }
            R.id.fragment_b -> {
                fragmentManager
                    .beginTransaction()
                    .replace(
                        replace,
                        FragmentB()
                    )
                    .addToBackStack(null)
                    .commit()
            }
            R.id.fragment_c -> {
                fragmentManager
                    .beginTransaction()
                    .replace(
                        replace,
                        FragmentC()
                    )
                    .addToBackStack(null)
                    .commit()
            }
            else -> null
        }
    }
}

class UploadWorker(private val context : Context, params : WorkerParameters) : Worker(context, params) {

    override fun doWork(): Result {
        Handler(Looper.getMainLooper()).post {
        Toast.makeText(context, "Battery is charging", Toast.LENGTH_SHORT).show()
        }
        return Result.success()
    }
}
