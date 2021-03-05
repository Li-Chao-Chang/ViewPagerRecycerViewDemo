package com.ivanli.demo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_one.*

class  FragmentOne : Fragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_one,container,false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setControl(view)
    }
    private fun setControl(view: View){
        btn.setOnClickListener {
            var viewPager=view.parent as ViewPager
            viewPager.setCurrentItem(1,true)
        }
    }
}
