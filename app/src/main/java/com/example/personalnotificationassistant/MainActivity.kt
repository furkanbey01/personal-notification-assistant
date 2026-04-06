package com.example.personalnotificationassistant

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import com.example.personalnotificationassistant.databinding.ActivityMainBinding

/**
 * The main activity shows a button to grant notification access. When clicked it
 * launches the Notification Listener settings page so the user can enable
 * access for this app.
 */
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGrantAccess.setOnClickListener {
            // Launch system settings for notification listener access
            val intent = Intent(Settings.ACTION_NOTIFICATION_LISTENER_SETTINGS)
            startActivity(intent)
        }
    }
}
