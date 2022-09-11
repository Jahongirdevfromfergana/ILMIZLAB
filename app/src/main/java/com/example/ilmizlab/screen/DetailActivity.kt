package com.example.ilmizlab.screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract
import android.widget.TableLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.bumptech.glide.Glide
import com.example.ilmizlab.R
import com.example.ilmizlab.databinding.ActivityDetailBinding
import com.example.ilmizlab.models.AddressModel
import com.example.ilmizlab.models.TrainingCenterModel
import com.example.ilmizlab.utils.Constants
import com.example.ilmizlab.view.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    lateinit var item: TrainingCenterModel
    lateinit var address: AddressModel

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityDetailBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        item = intent.getSerializableExtra(Constants.EXTRA_DATA) as TrainingCenterModel

        binding.centerName.text = item.name
        binding.centerDetailName.text = item.name
        binding.centerStar.text = item.rating_count.toString()
        binding.centerStartUnlinet.text = item.rating.toString().substring(0,3)
        binding.subscribeCount.text = item.subsribers_count.toString()
        binding.averageMonhlyPaymentMax.text = item.monthly_payment_max.toString()
        binding.averageMonhlyPaymentMin.text = item.monthly_payment_min.toString()
        binding.centerLocation.text = item.address
        binding.region.text = item.district.district_name

        binding.contactUs.text = item.phone

        binding.carouselView.setImageResource(item.main_image.length)
        Glide.with(this).load(Constants.IMAGE_HOST + item.main_image).into(binding.carouselView)

//        binding.carouselView.setImageListener { position, imageView ->
//            Glide.with(imageView).load("http://demo-ilm-izlab.devapp.uz/{item.images[position]}").into(imageView)
//        }
//        binding.carouselView.pageCount = item.images.count()

        val tabLayout: Any = try {
            findViewById<TabLayout>(R.id.tab_layout)
        } catch (e: Exception) {
        }

        binding.btnBack.setOnClickListener {
            finish()
        }
        val viewPager2 = findViewById<ViewPager2>(R.id.viewPager2)
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        viewPager2.adapter = adapter

        TabLayoutMediator(tabLayout as TabLayout, viewPager2){ tab, position ->
            when(position){

                0 -> {
                    tab.text = "Kurslar"
                }
                1 -> {
                    tab.text = "Yangiliklar"
                }
                2 -> {
                    tab.text = "Baholar"
                }
            }
        }.attach()

    }
    override fun onDestroy() {
        super.onDestroy()
        if (EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().unregister(this)
        }
    }
    @Subscribe
    fun onEvent(address: AddressModel){
        this.address = address
      //  binding.edAddress.setText("${address.latitude},   ${address.longitude}")

    }


  }
