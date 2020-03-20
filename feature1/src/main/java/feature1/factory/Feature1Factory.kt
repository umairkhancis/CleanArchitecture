package feature1.factory

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.noorifytech.datasource.backend.impl.mock.MockBackendDataSource
import com.noorifytech.shared.base.BaseViewModelFactory
import feature1.mapper.Mapper
import feature1.repository.impl.Feature1RepositoryImpl
import feature1.usecase.impl.FetchDataUseCaseImpl
import feature1.viewmodel.Feature1ViewModel
import feature1.viewmodel.impl.Feature1ViewModelImpl

object Feature1Factory {
    fun createFeature1ViewModel(activity: FragmentActivity): Feature1ViewModel {
        val factory = BaseViewModelFactory(::getFeature1ViewModel)
        return ViewModelProviders.of(activity, factory)[Feature1ViewModelImpl::class.java]
    }

    private fun getFeature1ViewModel(): Feature1ViewModel {
        val dataSource = MockBackendDataSource()
        val repo = Feature1RepositoryImpl(dataSource, Mapper)
        val fetchDataUseCase = FetchDataUseCaseImpl(repo, Mapper)

        return Feature1ViewModelImpl(fetchDataUseCase)
    }
}