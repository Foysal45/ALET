package com.alet.apps.c_activity.ac_auth.fragment.fg_sign_in.view

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.alet.apps.R
import kotlinx.android.synthetic.main.fragment_sign_in.view.*


class SignInFragment : Fragment() {
    var v: View? = null
    var mIsShowPass = false;
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
        showPassword(mIsShowPass)
    }

    private fun action(view: View) {
        view.password_show_hide.setOnClickListener {
            mIsShowPass = !mIsShowPass
            showPassword(mIsShowPass)
        }
    }

    private fun showPassword(isShow: Boolean) {
        if (isShow) {
            v!!.password.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
            v!!.password_show_hide.setImageResource(R.drawable.ic_baseline_visibility_off_24)
        } else {
            v!!.password.setTransformationMethod(PasswordTransformationMethod.getInstance())
            v!!.password_show_hide.setImageResource(R.drawable.ic_baseline_visibility_24)
        }
        v!!.password.setSelection(v!!.password.getText().toString().length)
    }
}