package uz.ramazon.taqvim2021.ramazontaqvim2021.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import uz.ramazon.taqvim2021.ramazontaqvim2021.R
import uz.ramazon.taqvim2021.ramazontaqvim2021.databinding.ActivityMainBinding
import uz.ramazon.taqvim2021.ramazontaqvim2021.ui.activity.fragment.CityFragment
import uz.ramazon.taqvim2021.ramazontaqvim2021.ui.activity.fragment.DuolarFragment
import uz.ramazon.taqvim2021.ramazontaqvim2021.ui.activity.fragment.MainFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val duolarFragment = DuolarFragment()
        val taqvimFragment = MainFragment()
        val shaharlar = CityFragment()

        makeCurrentFragment(taqvimFragment)

        binding.bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_duolar -> makeCurrentFragment(duolarFragment)
                R.id.nav_taqvim -> makeCurrentFragment(taqvimFragment)
                R.id.nav_shaharlar -> makeCurrentFragment(shaharlar)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayout, fragment)
            commit()
        }
    }
}