package com.alet.apps.c_activity.ac_auth.fragment.fg_sign_in.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alet.apps.R


class SignInFragment : Fragment() {
    var v: View? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_sign_in, container, false)
        init(view)
        action(view)
        return view
    }
    private fun init(view: View) {
        v = view
    }
    private fun action(view: View) {

    }




}