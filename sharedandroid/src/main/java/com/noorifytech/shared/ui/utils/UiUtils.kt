package com.noorifytech.shared.ui.utils

import android.view.View
import com.google.android.material.snackbar.Snackbar

fun showSnackBar(rootView: View, message: String) =
    Snackbar.make(rootView, message, Snackbar.LENGTH_LONG).show()