package br.com.thiagofelix.portifolioapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.thiagofelix.portifolioapp.cv.CVFragment
import br.com.thiagofelix.portifolioapp.databinding.ActivityMainBinding
import br.com.thiagofelix.portifolioapp.home.HomeFragment
import br.com.thiagofelix.portifolioapp.portifolio.PortifolioFragment
import br.com.thiagofelix.portifolioapp.sidemenu.Callback
import br.com.thiagofelix.portifolioapp.sidemenu.MenuAdapter
import br.com.thiagofelix.portifolioapp.sidemenu.MenuItem
import br.com.thiagofelix.portifolioapp.sidemenu.MenuUtil

class MainActivity : AppCompatActivity(), Callback {

    private lateinit var binding:ActivityMainBinding
    private lateinit var menuItems:List<MenuItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //setup side menu

        setupSideMenu()

        //setHomeFragment()
        //setCVFragment()
        //setPortifolioFragment()
    }

    fun setupSideMenu(){
        //get menu list item will get data from static data class

        menuItems = MenuUtil.getMenuList()
        val adapter = MenuAdapter(this)
        adapter.mData = menuItems
        binding.rvSideMenu.layoutManager = LinearLayoutManager(this)
        binding.rvSideMenu.adapter = adapter
    }

    fun setPortifolioFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.container, PortifolioFragment()).commit()
    }

    fun setCVFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.container, CVFragment()).commit()
    }

    fun setHomeFragment(){
        supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment()).commit()
    }

    override fun onSideMenuItem(i: Int) {
        when(menuItems[i].code){
            MenuUtil.HOME_FRAGMENT_CODE -> setHomeFragment()
            MenuUtil.CV_FRAGMENT_CODE -> setCVFragment()
            MenuUtil.PORTIFOLIO_FRAGMENT_CODE -> setPortifolioFragment()
            else -> setHomeFragment()
        }
    }

}