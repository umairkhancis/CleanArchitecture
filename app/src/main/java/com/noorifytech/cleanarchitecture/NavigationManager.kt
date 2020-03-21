package com.noorifytech.cleanarchitecture

import android.app.Activity
import android.content.Intent

/**
 * An [android.app.Activity] that can be addressed by an intent with an action.
 */
interface Screen {
    val actionName: String
}

/**
 * Create an Intent with [Intent.ACTION_VIEW] to an [Screen].
 */
private fun intent(screen: Screen): Intent {
    return Intent(screen.actionName)
}

/**
 * An extension function of activity to navigate to a particular screen.
 */
fun Activity.navigateTo(screen: Screen) {
    startActivity(intent(screen))
}

object Screens {
    object GetDataScreen : Screen {
        override val actionName = "com.noorifytech.feature1.view.Feature1Activity"
    }

    object MoviesListingsScreen : Screen {
        override val actionName = "com.noorifytech.feature2.view.activity.MoviesListActivity"
    }

    object MovieDetailsScreen : Screen {
        override val actionName = "com.noorifytech.feature2.view.activity.MovieDetailsActivity"
    }
}