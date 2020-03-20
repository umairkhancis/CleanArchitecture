package feature1.viewmodel.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.noorifytech.shared.base.BaseViewModel
import com.noorifytech.shared.exception.AppException
import feature1.usecase.FetchDataUseCase
import feature1.viewmodel.Feature1ViewModel

class Feature1ViewModelImpl(private val useCase: FetchDataUseCase)
    : BaseViewModel(), Feature1ViewModel {

    private var data: MutableLiveData<String> = MutableLiveData()

    private var _error: MutableLiveData<AppException> = MutableLiveData()

    override suspend fun fetchData(): LiveData<String> {
        try {
            val data = useCase.fetchData()
            updateView(data.value)
        } catch (appException: AppException) {
            updateView(appException)
        }

        return data
    }

    override val error: LiveData<AppException> get() {
        this._error.value = AppException(code = 404, msg = "No Internet Connection ${errorCount++}")
        return this._error
    }

    private fun updateView(data: String) {
        this.data.value = data
    }

    private fun updateView(appException: AppException) {
        when(appException.code) {
            0 -> this._error.value = appException
            1 -> this._error.value = appException
            2 -> this._error.value = appException
            3 -> this._error.value = appException
            else -> this._error.value = appException
        }
    }

    companion object {
        var errorCount = 1
    }
}