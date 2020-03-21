package com.noorifytech.shared.base.mvp

interface BaseLoadableContentView : BaseView {
    fun showLoading()

    fun hideLoading()

    fun showNoContent()

    fun showNoConnection()

    fun showError()
}
