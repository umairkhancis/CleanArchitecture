package feature3.factory

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.noorifytech.shared.base.mvvm.BaseViewModelFactory
import feature3.viewmodel.ProductListingsViewModel
import feature3.viewmodel.impl.ProductListingsViewModelImpl

object ProductListingFeatureFactory {
    fun createProductListingFeatureViewModel(activity: FragmentActivity): ProductListingsViewModel {
        val factory =
            BaseViewModelFactory(::getProductListingsViewModel)
        return ViewModelProviders.of(activity, factory)[ProductListingsViewModelImpl::class.java]
    }

    private fun getProductListingsViewModel(): ProductListingsViewModel {
//        val dataSource = MockFirebaseDataSource()
//        val repo = ProductRepositoryImpl(dataSource, Mapper)
//        val fetchProductsUseCase = FetchProductsUseCaseImpl(repo, Mapper)

        return ProductListingsViewModelImpl()
    }
}