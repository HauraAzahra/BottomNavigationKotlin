package com.haura.idn.bottomnavigationkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.haura.idn.bottomnavigationkotlin.fragment.FavoriteFragment
import com.haura.idn.bottomnavigationkotlin.fragment.HomeFragment
import com.haura.idn.bottomnavigationkotlin.fragment.ProfileFragment

class MainActivity : AppCompatActivity() {

    //create three object for fragment as create in java

    lateinit var homeFragment: HomeFragment
    lateinit var favoriteFragment: FavoriteFragment
    lateinit var profileFragment: ProfileFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigation : BottomNavigationView = findViewById(R.id.btn_nav)

        //for make fragment default
        favoriteFragment = FavoriteFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout,favoriteFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        bottomNavigation.setOnNavigationItemSelectedListener { item ->
            //conditional
            when (item.itemId){
                //now create three fragment
                R.id.home ->{
                    homeFragment = HomeFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout,homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

                R.id.favorite ->{
                    favoriteFragment = FavoriteFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout,favoriteFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }


                R.id.profile ->{
                    profileFragment = ProfileFragment()
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.frame_layout,profileFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }

            }
            true
        }
    }
}
