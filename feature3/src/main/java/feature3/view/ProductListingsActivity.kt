package feature3.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.noorifytech.feature3.databinding.ActivityProductListBinding
import feature3.factory.ProductListingFeatureFactory
import feature3.viewmodel.ProductListingsViewModel

class ProductListingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProductListBinding
    private val viewModel: ProductListingsViewModel by lazy { ProductListingFeatureFactory.createProductListingFeatureViewModel(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    private fun init() {
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.moviesListRv.layoutManager = LinearLayoutManager(this)
        binding.moviesListRv.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )

//        moviesListAdapter = MoviesPagedListAdapter(this, this)
//        binding.moviesListRv.adapter = moviesListAdapter
    }
}
