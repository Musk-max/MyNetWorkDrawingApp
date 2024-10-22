package com.example.reseaufranck

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.reseaufranck.fragments.connectFragment
import com.example.reseaufranck.fragments.editFragment
import com.example.reseaufranck.fragments.moveFragment
import com.example.reseaufranck.fragments.plusFragment
import com.example.reseaufranck.fragments.refreshFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Instanciation des fragments
        val plusFragment=plusFragment()
        val editFragment= editFragment()
        val moveFragment= moveFragment()
        val refreshFragment=refreshFragment()
        val connectFragment= connectFragment()
        // Par défaut on est sur le plusFragment
        makeCurrentFragment(plusFragment)
        val bottom_navigation:BottomNavigationView= findViewById(R.id.bottom_navigation)
        bottom_navigation.setOnNavigationItemSelectedListener{
            when (it.itemId) {
                //rediriger l'app sur le fragment adequat selon l'item sur lequel on click
                R.id.add-> makeCurrentFragment(plusFragment)
                R.id.connect-> makeCurrentFragment(connectFragment)
                R.id.edit-> makeCurrentFragment(editFragment)
                R.id.move-> makeCurrentFragment(moveFragment)
                R.id.refresh-> makeCurrentFragment(refreshFragment)
            }
            true
        }

    }
    private fun  makeCurrentFragment(fragment: Fragment)=supportFragmentManager.beginTransaction().apply{
        replace(R.id.fl_wrapper, fragment)
        commit()

    }


}
