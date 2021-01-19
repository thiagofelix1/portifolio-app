package br.com.thiagofelix.portifolioapp.sidemenu

import android.view.Menu
import br.com.thiagofelix.portifolioapp.R

class MenuUtil {
    //

    companion object{
        val HOME_FRAGMENT_CODE = 0
        val CV_FRAGMENT_CODE = 1
        val PORTIFOLIO_FRAGMENT_CODE = 2

        fun getMenuList():List<MenuItem>{
           val list = arrayListOf<MenuItem>()
            list.add(MenuItem(R.drawable.ic_baseline_home_24 , HOME_FRAGMENT_CODE, true))
            list.add(MenuItem(R.drawable.ic_baseline_school_24 , CV_FRAGMENT_CODE, false))
            list.add(MenuItem(R.drawable.ic_baseline_dashboard_24 , PORTIFOLIO_FRAGMENT_CODE, false))

            return list

        }
    }

}