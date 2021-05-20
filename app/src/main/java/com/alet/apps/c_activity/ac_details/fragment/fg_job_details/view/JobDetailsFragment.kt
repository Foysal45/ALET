package com.alet.apps.c_activity.ac_details.fragment.fg_job_details.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.alet.apps.R
import com.alet.apps.c_activity.ac_details.fragment.fg_job_details.adapter.recycler_adapter.RecyclerAdapterBulletHeader
import com.alet.apps.c_activity.ac_details.fragment.fg_job_details.adapter.recycler_adapter.RecyclerAdapterJobKey
import com.alet.apps.c_activity.ac_details.fragment.fg_job_details.model.BulletHeader
import com.alet.apps.c_activity.ac_details.fragment.fg_job_details.model.BulletPoint
import com.alet.apps.c_activity.ac_details.fragment.fg_job_details.model.JobKey
import com.alet.apps.c_activity.ac_details.fragment.fg_property_details.adapter.recycler_adapter.RecyclerAdapterProperty
import com.alet.apps.c_activity.ac_details.fragment.fg_property_details.model.PropertyPhoto
import kotlinx.android.synthetic.main.fragment_job_details.view.*


private const val JOB_ID = "jobId"

class JobDetailsFragment : Fragment() {

    private var jobId: Int? = null
    var v: View? = null

    lateinit var jobKeyList: MutableList<JobKey>
    lateinit var recyclerAdapterJobKey: RecyclerAdapterJobKey

    lateinit var bulletHeaderList: MutableList<BulletHeader>
    lateinit var recyclerAdapterBulletHeader: RecyclerAdapterBulletHeader

    lateinit var propertyList: MutableList<PropertyPhoto>
    lateinit var recyclerAdapterProperty: RecyclerAdapterProperty

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            jobId = it.getInt(JOB_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_job_details, container, false)
        init(view)
        action(view)
        return view
    }

    private fun init(view: View) {
        v = view
        jobKeyList = mutableListOf<JobKey>()
        recyclerAdapterJobKey =
            RecyclerAdapterJobKey(view.context, jobKeyList)

        bulletHeaderList = mutableListOf<BulletHeader>()
        recyclerAdapterBulletHeader =
            RecyclerAdapterBulletHeader(view.context, bulletHeaderList)

        propertyList = mutableListOf<PropertyPhoto>()
        recyclerAdapterProperty =
            RecyclerAdapterProperty(view.context, propertyList)

    }

    private fun action(view: View) {

        view.rec_job_key.layoutManager = GridLayoutManager(view.context, 2)
        view.rec_job_key.adapter = recyclerAdapterJobKey

        view.rec_parent.layoutManager = LinearLayoutManager(view.context)
        view.rec_parent.adapter = recyclerAdapterBulletHeader

        view.rec_jobs.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        view.rec_jobs.adapter = recyclerAdapterProperty

        demoJobKeyLoad()
        demoContextLoad()
        demoPropertyLoad()
    }

    private fun demoContextLoad() {
        var bulletPointList = mutableListOf<BulletPoint>()
        bulletPointList.add(BulletPoint("Nakshikatha is specialized in Branding, Airport service and 360 degree promotional activities. Also operating several world-class Lounges at the Airports of Bangladesh and a five-star category kitchen at HSIA."))
        bulletPointList.add(BulletPoint("We are currently in search of a potential candidate with the needed creative expertise to build our team."))
        bulletHeaderList.add(BulletHeader("Job Context", bulletPointList))
        bulletHeaderList.add(BulletHeader("Job Responsibilites", bulletPointList))

        var bulletPointList1 = mutableListOf<BulletPoint>()
        bulletPointList1.add(BulletPoint("Full-time", R.drawable.shape_rec_transparent))
        bulletHeaderList.add(BulletHeader("Job Status", bulletPointList1))

        bulletHeaderList.add(BulletHeader("Educational Requirements", bulletPointList))
        bulletHeaderList.add(BulletHeader("Additional Requirements", bulletPointList))

        var bulletPointList2 = mutableListOf<BulletPoint>()
        bulletPointList2.add(
            BulletPoint(
                "20,000 - 35,000 BDT/month",
                R.drawable.shape_rec_transparent
            )
        )
        bulletHeaderList.add(BulletHeader("Salary", bulletPointList2))

        bulletHeaderList.add(BulletHeader("Compensation & Other", bulletPointList))

        var bulletPointList3 = mutableListOf<BulletPoint>()
        bulletPointList3.add(BulletPoint("+880123456789", R.drawable.ic_call, true))
        bulletPointList3.add(BulletPoint("companymail@address.domain", R.drawable.ic_mail, true))
        bulletHeaderList.add(BulletHeader("Contacts", bulletPointList3))

        recyclerAdapterBulletHeader.notifyDataSetChanged()
    }

    private fun demoJobKeyLoad() {
        jobKeyList.add(JobKey(R.drawable.ic_vacancies, "Vacancies", "2"))
        jobKeyList.add(JobKey(R.drawable.shape_rec_transparent, " ", " "))
        jobKeyList.add(JobKey(R.drawable.ic_salary, "Salary", "20,000 - 35,000 BDT/month"))
        jobKeyList.add(JobKey(R.drawable.ic_date_job, "Job Posted", "Feb 07,2021"))
        jobKeyList.add(JobKey(R.drawable.ic_location_3, "Job Location", "Doodle X, Mohakhali"))
        jobKeyList.add(JobKey(R.drawable.ic_date_job, "Deadline", "Feb 27,2021"))

        recyclerAdapterJobKey.notifyDataSetChanged()
    }


    private fun demoPropertyLoad() {
        propertyList.add(PropertyPhoto("https://field.buzz/wp-content/uploads/2015/12/fb_logo_square.png"))
        propertyList.add(PropertyPhoto("https://pbs.twimg.com/profile_images/909637476519518208/ZBxCO_OE_400x400.jpg"))
        propertyList.add(PropertyPhoto("https://field.buzz/wp-content/uploads/2015/12/fb_logo_square.png"))
        propertyList.add(PropertyPhoto("https://pbs.twimg.com/profile_images/909637476519518208/ZBxCO_OE_400x400.jpg"))
        propertyList.add(PropertyPhoto("https://field.buzz/wp-content/uploads/2015/12/fb_logo_square.png"))
        propertyList.add(PropertyPhoto("https://pbs.twimg.com/profile_images/909637476519518208/ZBxCO_OE_400x400.jpg"))
        propertyList.add(PropertyPhoto("https://field.buzz/wp-content/uploads/2015/12/fb_logo_square.png"))
        propertyList.add(PropertyPhoto("https://pbs.twimg.com/profile_images/909637476519518208/ZBxCO_OE_400x400.jpg"))
        propertyList.add(PropertyPhoto("https://field.buzz/wp-content/uploads/2015/12/fb_logo_square.png"))
        propertyList.add(PropertyPhoto("https://pbs.twimg.com/profile_images/909637476519518208/ZBxCO_OE_400x400.jpg"))
        propertyList.add(PropertyPhoto("https://field.buzz/wp-content/uploads/2015/12/fb_logo_square.png"))
        propertyList.add(PropertyPhoto("https://pbs.twimg.com/profile_images/909637476519518208/ZBxCO_OE_400x400.jpg"))

        recyclerAdapterProperty.notifyDataSetChanged()
    }

    companion object {

        @JvmStatic
        fun newInstance(jobId: Int) =
            JobDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(JOB_ID, jobId)
                }
            }
    }
}