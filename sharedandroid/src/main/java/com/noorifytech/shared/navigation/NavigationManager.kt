package com.noorifytech.shared.navigation

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import com.noorifytech.shared.extensions.showToast

object Feature1 : Screen {
    override val actionName = "com.noorifytech.feature1.view.Feature1Activity"
}

object Feature2 : Screen {
    override val actionName = "com.noorifytech.feature2.view.activity.MoviesListActivity"
}

object Feature3 : Screen {
    override val actionName = "com.noorifytech.feature2.view.activity.MoviesListActivity"
}

/**
 * An [android.app.Activity] that can be addressed by an intent with an action.
 */
interface Screen {
    val actionName: String
}

/**
 * Maps screen to an intent with an addressable action.
 */
private fun intent(screen: Screen): Intent {
    return Intent(screen.actionName)
}

/**
 * An extension function of activity to navigate to a particular screen.
 */
fun Activity.navigateTo(screen: Screen, dataIntent: Intent? = intent(screen)) {
    val newScreen = dataIntent?.apply {
        action = screen.actionName
    }

    try {
        startActivity(newScreen)
    } catch (ex: ActivityNotFoundException) {
        showToast("Screen not found!")
    }
}