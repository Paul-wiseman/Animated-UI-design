package com.decagon.paul.animatedUIDesign.activity

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.widget.ImageButton
import android.widget.RemoteViews
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.decagon.paul.animatedUIDesign.R
import com.decagon.paul.animatedUIDesign.adapters.DebitCardViewAdapter
import com.decagon.paul.animatedUIDesign.adapters.PartnersAdapter
import com.decagon.paul.animatedUIDesign.naviagationFragments.HistoryFragment
import com.decagon.paul.animatedUIDesign.naviagationFragments.PaymentFragment
import com.decagon.paul.animatedUIDesign.naviagationFragments.ProductFragment
import com.decagon.paul.animatedUIDesign.naviagationFragments.SupportFragment
import com.decagon.paul.animatedUIDesign.utils.DummyDataGenerator
import com.google.android.material.bottomnavigation.BottomNavigationView
import me.relex.circleindicator.CircleIndicator3

class HomeActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        /*codes for notification */
        lateinit var notificationManager: NotificationManager
        lateinit var notificationChannel: NotificationChannel
        lateinit var Builder: Notification.Builder
        var channelID = "Paul"
        var desc = "Notifications"
        notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        /*OnclickListner to send notification */
        var btnnotification: ImageButton = findViewById(R.id.btnnotification)

        btnnotification.setOnClickListener {
            val pendingIntent = PendingIntent.getActivity(
                this, 0, intent,
                PendingIntent.FLAG_CANCEL_CURRENT
            )
            val view = RemoteViews(packageName, R.layout.activity_home)
            notificationChannel = NotificationChannel(
                channelID, desc,
                NotificationManager.IMPORTANCE_HIGH
            )

            /*A configurations for what the notification is going to do using the phones resource*/
            notificationChannel.enableLights(true) // turn the phone light on
            notificationChannel.lightColor = Color.GRAY // the lightcolor of the notification
            notificationChannel.enableVibration(true) // the notification is able to make the make the phone vibrate
            notificationManager.createNotificationChannel(notificationChannel) // the configuration of the notification channel
            Builder = Notification.Builder(this, channelID)
                .setContentTitle("Good Day, Click me") // Title of the notification
                .setContentText("How Far Darot") // the notification display text
                .setChannelId(channelID) // Notification id
                .setSmallIcon(R.drawable.ic_baseline_access_alarm_24) //
                .setLargeIcon(
                    BitmapFactory.decodeResource(
                        this.resources,
                        R.drawable.ic_launcher_background
                    )
                )
                .setContentIntent(pendingIntent)
            notificationManager.notify(1234, Builder.build())
        }

        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager2)
        val indicator3 = findViewById<CircleIndicator3>(R.id.indicator)
        viewPager2.adapter = DebitCardViewAdapter(DummyDataGenerator.accounts())
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        viewPager2.setPadding(30, 0, 30, 0)
        viewPager2.apply {
            clipToPadding = false
            clipToPadding = false
            offscreenPageLimit = 2
        }
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        /*recyclerview adapter*/

        recyclerView.adapter = PartnersAdapter(DummyDataGenerator.allData())
        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        /*viewpager adapter*/

        /*bottom circle indicator*/
        indicator3.setViewPager(viewPager2)

        /*Codes for bottom navigation view*/
        val bottomViewNav = findViewById<BottomNavigationView>(R.id.bottom_navigationView)
        val productFragment = ProductFragment()
        val paymentFragment = PaymentFragment()
        val historyFragment = HistoryFragment()
        val supportFragment = SupportFragment()
        getCurrentFragment(productFragment)
        bottomViewNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.bn_product -> getCurrentFragment(productFragment)
                R.id.payment -> getCurrentFragment(paymentFragment)
                R.id.bn_history -> getCurrentFragment(historyFragment)
                R.id.bnsupport -> getCurrentFragment(supportFragment)
            }
            true
        }
    }

    private fun getCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_fragment, fragment)
            commit()
        }
}
