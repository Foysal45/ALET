package com.alet.apps.c_activity.ac_details.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alet.apps.R
import com.alet.apps.c_activity.ac_auth.fragment.fg_change_pass.view.ChangePassFragment
import com.alet.apps.c_activity.ac_details.fragment.fg_history.view.HistoryFragment
import com.alet.apps.c_activity.ac_details.fragment.fg_terms.view.TermsFragment
import com.alet.apps.enam.AcName
import com.alet.apps.util.Utility
import kotlinx.android.synthetic.main.activity_details_common.*

class DetailsCommonActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details_common)
        page_title.text = getString(R.string.title_history)
        Utility.replaceFramgentWithoutBackStack(AcName.DETAILS,this, HistoryFragment())
    }
}