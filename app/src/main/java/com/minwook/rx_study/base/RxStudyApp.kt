package com.minwook.rx_study.base

import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.annotation.ArrayRes
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.multidex.MultiDexApplication

class RxStudyApp : MultiDexApplication() {
    companion object {
        lateinit var appContext: RxStudyApp
        var runningActivitys: Int = 0

        fun string(@StringRes resId: Int): String {
            return appContext.getString(resId)
        }

        fun color(@ColorRes resId: Int): Int {
            return ContextCompat.getColor(appContext, resId)
        }

        fun arrays(@ArrayRes resId: Int): Array<String> {
            return resources().getStringArray(resId)
        }

        fun resources(): Resources {
            return appContext.resources
        }

        fun drawable(@DrawableRes resId: Int): Drawable? {
            return ContextCompat.getDrawable(appContext, resId)
        }

        fun packageName(): String {
            return appContext.packageName
        }
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this
    }
}