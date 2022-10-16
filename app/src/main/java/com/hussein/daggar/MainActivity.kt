package com.hussein.daggar

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.hussein.daggar.databinding.ActivityMainBinding
import com.hussein.daggar.viewmodels.ProductViewModel
import com.hussein.daggar.viewmodels.ProductViewModelFactory
import javax.inject.Inject


/**Tutorial from here https://www.youtube.com/watch?v=sfjK21cPUds */
class MainActivity : AppCompatActivity() {
    lateinit var productViewModel: ProductViewModel
    lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var productViewModelFactory: ProductViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        (application as App).component.injtect(this)
        //productViewModel=ViewModelProvider(this,productViewModelFactory).get(ProductViewModel::class.java)  // This same in next line
        productViewModel= ViewModelProvider(this,productViewModelFactory)[ProductViewModel::class.java]
        //Make text scrolling
        binding.tvProduct.movementMethod = ScrollingMovementMethod()

        productViewModel.productsLiveData.observe(this) {
            //binding.tvProduct.text=it.products[0].title+"\n"+it.products[0].description+"\n"+"Price: "+it.products[0].price
            val items=it.products
            binding.tvProduct.text=items.joinToString { x->x.title+"\n"+x.description+"\n"+"Price: "+x.price }

        }
    }
}