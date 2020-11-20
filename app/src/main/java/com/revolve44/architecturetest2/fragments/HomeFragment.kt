package com.revolve44.architecturetest2.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.revolve44.architecturetest2.MainActivity

import com.revolve44.architecturetest2.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * HomeFragment
 *  2 Buttons
 *  Nav graph start fragment
 */

class HomeFragment : Fragment(R.layout.fragment_home), View.OnClickListener { //OnClickListener

    private lateinit var navController: NavController


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = findNavController() //Initialising navController

        //Initialising button click event listener
        home_next_frag_btn.setOnClickListener(this)
        home_close_app_btn.setOnClickListener(this)
    }

    override fun onClick(v: View?) { //When click occurs this function is triggered
        when(v!!.id) { //Check for the id of the view i which click event happened
            R.id.home_next_frag_btn -> goToNextFragment()
            R.id.home_close_app_btn -> closeApp()
        }
    }

    private fun goToNextFragment() {
        val action = HomeFragmentDirections.actionHomeFragmentToProfileFragment() //if needed pass values to frag here NB: add that arguments to nav_graph also
        navController.navigate(action) //navigation
    }

    private fun closeApp() {
        (activity as MainActivity).exitApp()
    }

}
