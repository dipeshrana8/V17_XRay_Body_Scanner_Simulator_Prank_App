package com.xrayscan.malebodyscanner.camera.simulatorapp

import android.content.SharedPreferences
import android.util.Log
import androidx.appcompat.app.AppCompatDelegate

import com.google.firebase.FirebaseApp
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.xrayscan.malebodyscanner.camera.simulatorapp.core.AdPreferencesManager
import com.xrayscan.malebodyscanner.camera.simulatorapp.core.AppLifecycleHandler
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject


class AppStartupManager : AppLifecycleHandler() {

    private var editor: SharedPreferences.Editor? = null

    companion object {
        lateinit var sharedPreferences: SharedPreferences
    }

    private val databaseName = "ad_demo"

    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        sharedPreferences = getSharedPreferences(databaseName, MODE_PRIVATE)
        editor = sharedPreferences.edit()

        setupFirebaseRemoteConfig()
    }

    private fun setupFirebaseRemoteConfig() {
        val remoteConfig = FirebaseRemoteConfig.getInstance()
        val configSettings = FirebaseRemoteConfigSettings.Builder()
            .setMinimumFetchIntervalInSeconds(100)
            .build()

        remoteConfig.setConfigSettingsAsync(configSettings)
        remoteConfig.setDefaultsAsync(R.xml.backup_rules)

        remoteConfig.fetchAndActivate().addOnCompleteListener { task ->
            if (task.isSuccessful) {
                try {
                    val jsonString = remoteConfig.getString("comgetfreediamonds")
                    Log.d("RemoteConfig", "setupFirebaseRemoteConfig: " + jsonString)
                    val jsonObject = JSONObject(jsonString)


                    AdPreferencesManager.setNative_show(
                        jsonObject.optBoolean(
                            AdPreferencesManager.AD_NATIVE_TOGGLE_KEY, false
                        )
                    )
                    AdPreferencesManager.setIninterstialWeb(
                        jsonObject.optBoolean(
                            "interstial_onoff",
                            false
                        )
                    )

                    val bannerImageArray = extractStringList(jsonObject, "daily_BannerImage")
                    AdPreferencesManager.setPrefKeyStringArray(bannerImageArray)

                    val multipleLinkArray = extractStringList(jsonObject, "multiple_link")
                    if (multipleLinkArray.isNotEmpty()) {
                        val selectedLink = multipleLinkArray.random()
                        AdPreferencesManager.setRedirectLink(selectedLink)
                        AdPreferencesManager.setnative_link(selectedLink)
                        AdPreferencesManager.setappopen_redirect(selectedLink)
                    }

                    val privacyPolicyUrl = jsonObject.optString("privacy_policy_link", "")
                    AdPreferencesManager.setPrivacyPolicyUrl(privacyPolicyUrl)

                    val oneSignalAppId = jsonObject.optString("onesignal_id", "")
                    AdPreferencesManager.setOneSignalAppId(oneSignalAppId)


                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }
    }

    private fun extractStringList(jsonObject: JSONObject, key: String): ArrayList<String> {
        val result = ArrayList<String>()
        try {
            val jsonArray = JSONArray(jsonObject.getString(key))
            for (i in 0 until jsonArray.length()) {
                result.add(jsonArray.getString(i))
            }
        } catch (e: JSONException) {
            e.printStackTrace()
        }
        return result
    }
}
