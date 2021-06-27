package com.alet.apps.c_activity.ac_auth.fragment.fg_recovary.view

import android.os.Bundle
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.alet.apps.R
import kotlinx.android.synthetic.main.fragment_recovery_code.view.*

class RecoveryCodeFragment : Fragment() {
    var v: View? = null
    var e1=""
    var e2=e1
    var e3=e1
    var e4=e1
    var e5=e1
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_recovery_code, container, false)
        init(view)
        action(view)
        return view
    }

    private fun init(view: View) {
        v = view

    }

    private fun action(view: View) {
        view.et_1.requestFocus()
        view.et_1.addTextChangedListener {
            if (view.et_1.text.isNotBlank()) {
                e1=view.et_1.text.toString()
                view.et_2.requestFocus()
            }
        }
        view.et_2.addTextChangedListener {
            if (view.et_2.text.isNotBlank()) {
                view.et_3.requestFocus()
            }
        }
        view.et_3.addTextChangedListener {
            if (view.et_3.text.isNotBlank()) {
                view.et_4.requestFocus()
            }
        }
        view.et_4.addTextChangedListener {
            if (view.et_4.text.isNotBlank()) {
                view.et_5.requestFocus()
            }
        }

    }
}