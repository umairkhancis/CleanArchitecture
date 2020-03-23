package feature1.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.noorifytech.feature1.databinding.ActivityFeature1ActivityBinding
import com.noorifytech.shared.extensions.hide
import com.noorifytech.shared.extensions.show
import feature1.factory.Feature1Factory
import feature1.viewmodel.Feature1ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext


class Feature1Activity : AppCompatActivity(), CoroutineScope {

    private lateinit var binding: ActivityFeature1ActivityBinding
    private val viewModel: Feature1ViewModel by lazy { Feature1Factory.createFeature1ViewModel(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeature1ActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.getDataBtn.setOnClickListener {
            showData()
        }

        binding.errorBtn.setOnClickListener {
            showError()
        }

        showData()
    }

    override fun onDestroy() {
        super.onDestroy()

        job.cancel()
    }

    private fun showData() {
        launch {
            binding.progressBar.show()
            viewModel.getData().observe(this@Feature1Activity, Observer { data ->
                binding.progressBar.hide()
                binding.dataTv.text = data
            })
        }
    }

    private fun showError() {
        viewModel.error.observe(this@Feature1Activity, Observer { data ->
            showSnackBar(data.msg)
        })
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(binding.root, message, Snackbar.LENGTH_LONG)
            .apply { show() }
    }

    private val job = Job()

    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main
}
