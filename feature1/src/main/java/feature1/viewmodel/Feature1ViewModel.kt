package feature1.viewmodel

import androidx.lifecycle.LiveData
import com.noorifytech.shared.exception.AppException

interface Feature1ViewModel {
    val error: LiveData<AppException>

    suspend fun fetchData(): LiveData<String>
}