package com.ivanli.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    companion object{

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = PagerAdapter(supportFragmentManager,2)
        viewpage.adapter = adapter
        tab_Layout.setupWithViewPager(viewpage)
    }
}
class PagerAdapter(f: FragmentManager,bh: Int): FragmentPagerAdapter(f,bh){
    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> FragmentOne()
            1 -> FragmentTwo()
            else -> return FragmentOne()
        }
    }
    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return return when (position) {
            0 -> "TAB1"
            1 -> "TAB2"
            else -> ""
        }
    }
}