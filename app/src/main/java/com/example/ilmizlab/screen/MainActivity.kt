package com.example.ilmizlab.screen

import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.ilmizlab.R
import com.example.ilmizlab.databinding.ActivityMainBinding
import com.example.ilmizlab.screen.home.HomeFragment
import com.example.ilmizlab.screen.news.NewsFragment
import com.example.ilmizlab.screen.search.SearchFragment
import com.example.ilmizlab.screen.subscriber.SubscriberFragment

import com.example.ilmizlab.models.AddressModel
import com.example.ilmizlab.screen.map.MapFragment
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import org.greenrobot.eventbus.EventBus


class MainActivity : AppCompatActivity() {
    val homeFragment = HomeFragment.newInstance()
    val searchFragment = SearchFragment.newInstance()
    val mapFragment = MapFragment.newInstance()
    val newsFragment = NewsFragment.newInstance()
    val subscriberFragment = SubscriberFragment.newInstance()

    var activeFragment: Fragment = homeFragment

    lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var fusedLocationProviderClient: FusedLocationProviderClient


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(this)


        binding.btnPinLocation.setOnClickListener {
            Toast.makeText(this, "Joylashuv aniqlandi!", Toast.LENGTH_SHORT).show()
            checkLocationPermission()
        }

        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        binding.logIn.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))

        }
        binding.navAbout.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))

        }
        binding.tvLogOutText.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            binding.tvLogOutContainer.visibility = View.INVISIBLE
            binding.logIn.visibility = View.VISIBLE
            binding.tvProfileContainer.visibility = View.GONE
            binding.myProfileContainer.visibility = View.GONE
            binding.tvCenterContainer.visibility = View.GONE

        }






// button bosilganda draweeLayoutni open qilish
            binding.btnMenu.setOnClickListener{
                binding.drawerLayout.openDrawer(binding.navView)  // this crashes (also crashes with Gravity.LEFT or similar)
            }
        binding.navProfileEdit.setOnClickListener {
            startActivity(Intent(this, ProfileEditActivity::class.java))
        }

        binding.navView.bringToFront()
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
//        binding.navView.getHeaderView(0).findViewById<TextView>(R.id.log_in).setOnClickListener {
//            Toast.makeText(this, "BUm!", Toast.LENGTH_LONG).show()
//        }

//ishlamadi
        supportFragmentManager.beginTransaction()
            .add(R.id.flContainer, homeFragment, homeFragment.tag).hide(homeFragment).commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.flContainer, searchFragment, searchFragment.tag).hide(searchFragment).commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.flContainer, mapFragment, mapFragment.tag).hide(mapFragment).commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.flContainer, newsFragment, newsFragment.tag).hide(newsFragment).commit()
        supportFragmentManager.beginTransaction()
            .add(R.id.flContainer, subscriberFragment, subscriberFragment.tag)
            .hide(subscriberFragment).commit()

        supportFragmentManager.beginTransaction().show(activeFragment).commit()

        binding.bottomNavigationView.setOnItemSelectedListener {
            if (it.itemId == R.id.actionHome) {
                supportFragmentManager.beginTransaction().hide(activeFragment).show(homeFragment)
                    .commit()
                activeFragment = homeFragment
            } else if (it.itemId == R.id.actionSearch) {
                supportFragmentManager.beginTransaction().hide(activeFragment).show(searchFragment)
                    .commit()
                activeFragment = searchFragment
            } else if (it.itemId == R.id.actionMap) {
                supportFragmentManager.beginTransaction().hide(activeFragment).show(mapFragment)
                    .commit()
                activeFragment = mapFragment
            } else if (it.itemId == R.id.actionNew) {
                supportFragmentManager.beginTransaction().hide(activeFragment).show(newsFragment)
                    .commit()
                activeFragment = newsFragment
            } else if (it.itemId == R.id.actionSubscribe) {
                supportFragmentManager.beginTransaction().hide(activeFragment)
                    .show(subscriberFragment).commit()
                activeFragment = subscriberFragment
            }
            return@setOnItemSelectedListener true
        }
    }
    private fun checkLocationPermission() {
        val task = fusedLocationProviderClient.lastLocation

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)

            != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        ){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 101)
            return

        }

        task.addOnSuccessListener {
            if (it != null){
                Toast.makeText(applicationContext, "${it.latitude} ${it.longitude}", Toast.LENGTH_SHORT).show()
                val addressModel = AddressModel("", it.latitude, it.longitude)
                EventBus.getDefault().post(addressModel)

            }
        }
    }
}