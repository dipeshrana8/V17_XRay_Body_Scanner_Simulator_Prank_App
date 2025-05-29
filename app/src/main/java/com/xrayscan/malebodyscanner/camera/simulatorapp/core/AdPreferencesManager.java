package com.xrayscan.malebodyscanner.camera.simulatorapp.core;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

public class AdPreferencesManager {

    public static final String AD_NATIVE_TOGGLE_KEY = "native_show";
    public static final String AD_INTERSTITIAL_FLAG_KEY = "interstial_onoff";
    public static final String WEB_NAV_LINK_KEY = "redirect_link";
    private static final String PREF_KEY_STRING_ARRAY = "string_list_pref";
    private static final String AD_INTERSTITIAL_SLOT_ID = "interstitial";
    private static final String AD_NATIVE_CONTENT_LINK = "native_link";


    private static final String LEGAL_POLICY_URL_KEY = "privacy_policy_link";
    private static final String PUSH_TOKEN_APP_ID_KEY = "onesignal_id";

    private static SharedPreferences preference() {
        return AppLifecycleHandler.get().getSharedPreferences("adController", Context.MODE_PRIVATE);
    }

    public static String getRedirectLink() {
        return preference().getString(WEB_NAV_LINK_KEY, "");
    }

    public static void setRedirectLink(String value) {
        preference().edit().putString(WEB_NAV_LINK_KEY, value).apply();
    }

    public static void setappopen_redirect(String value) {
        preference().edit().putString(AD_INTERSTITIAL_SLOT_ID, value).apply();
    }


    public static boolean getNative_show() {
        return preference().getBoolean(AD_NATIVE_TOGGLE_KEY, false);
    }

    public static void setNative_show(boolean value) {
        preference().edit().putBoolean(AD_NATIVE_TOGGLE_KEY, value).apply();
    }

    public static void setnative_link(String value) {
        preference().edit().putString(AD_NATIVE_CONTENT_LINK, value).apply();
    }

    public static String getnative_redirect_link() {
        return preference().getString(AD_NATIVE_CONTENT_LINK, "");
    }

    public static boolean getIninterstialWeb() {
        return preference().getBoolean(AD_INTERSTITIAL_FLAG_KEY, false);
    }

    public static void setIninterstialWeb(boolean value) {
        preference().edit().putBoolean(AD_INTERSTITIAL_FLAG_KEY, value).apply();
    }

    public static ArrayList<String> getPrefKeyStringArray() {
        String json = preference().getString(PREF_KEY_STRING_ARRAY, null);
        if (json != null) {
            try {
                return new Gson().fromJson(json, new TypeToken<ArrayList<String>>() {
                }.getType());
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
        }
        return new ArrayList<>();
    }

    public static void setPrefKeyStringArray(ArrayList<String> list) {
        String json = new Gson().toJson(list);
        preference().edit().putString(PREF_KEY_STRING_ARRAY, json).apply();
    }

    public static String getPrivacyPolicyUrl() {
        return preference().getString(LEGAL_POLICY_URL_KEY, "");
    }


    public static void setPrivacyPolicyUrl(String url) {
        preference().edit().putString(LEGAL_POLICY_URL_KEY, url).apply();
    }

    public static String getOneSignalAppId() {
        return preference().getString(PUSH_TOKEN_APP_ID_KEY, "");
    }


    public static void setOneSignalAppId(String appId) {
        preference().edit().putString(PUSH_TOKEN_APP_ID_KEY, appId).apply();
    }
}

