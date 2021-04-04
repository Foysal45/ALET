package com.alet.apps.c_activity.ac_auth.fragment.fg_sign_up.view

import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alet.apps.R
import kotlinx.android.synthetic.main.fragment_sign_up.view.*


class SignUpFragment : Fragment() {
    var v: View? = null
    var mIsShowPass = false;
    var mIsShowConPass = false;
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_sign_up, container, false)
        init(view)
        action(view)
        return view
    }

    private fun init(view: View) {
        v = view
        showPassword(mIsShowPass)
        showConPassword(mIsShowConPass)
    }

    private fun action(view: View) {
        view.password_show_hide.setOnClickListener {
            mIsShowPass = !mIsShowPass
            showPassword(mIsShowPass)
        }
        view.con_password_show_hide.setOnClickListener {
            mIsShowConPass = !mIsShowConPass
            showConPassword(mIsShowConPass)
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

    private fun showConPassword(isShow: Boolean) {
        if (isShow) {
            v!!.con_password.setTransformationMethod(HideReturnsTransformationMethod.getInstance())
            v!!.con_password_show_hide.setImageResource(R.drawable.ic_baseline_visibility_off_24)
        } else {
            v!!.con_password.setTransformationMethod(PasswordTransformationMethod.getInstance())
            v!!.con_password_show_hide.setImageResource(R.drawable.ic_baseline_visibility_24)
        }
        v!!.con_password.setSelection(v!!.password.getText().toString().length)
    }
}