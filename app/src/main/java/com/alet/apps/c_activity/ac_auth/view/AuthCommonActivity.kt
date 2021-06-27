package com.alet.apps.c_activity.ac_auth.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alet.apps.R
import com.alet.apps.c_activity.ac_auth.fragment.fg_change_pass.view.ChangePassFragment
import com.alet.apps.c_activity.ac_auth.fragment.fg_recovary.view.RecoveryCodeFragment
import com.alet.apps.enam.AcName
import com.alet.apps.util.Utility

class AuthCommonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth_common)
        Utility.replaceFramgentWithoutBackStack(AcName.AUTH,this,RecoveryCodeFragment())
    }
}