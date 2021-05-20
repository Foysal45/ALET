package com.alet.apps.c_activity.ac_details.fragment.fg_property_details.view

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.widget.GridLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.annotation.NonNull
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import com.alet.apps.R
import com.alet.apps.c_activity.ac_details.fragment.fg_property_details.adapter.recycler_adapter.RecyclerAdapterProperty
import com.alet.apps.c_activity.ac_details.fragment.fg_property_details.adapter.recycler_adapter.RecyclerAdapterPropertyFeature
import com.alet.apps.c_activity.ac_details.fragment.fg_property_details.adapter.recycler_adapter.RecyclerAdapterPropertyPhoto
import com.alet.apps.c_activity.ac_details.fragment.fg_property_details.model.PropertyFeature
import com.alet.apps.c_activity.ac_details.fragment.fg_property_details.model.PropertyPhoto
import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.fragment_faq.view.*
import kotlinx.android.synthetic.main.fragment_property_details.*
import kotlinx.android.synthetic.main.fragment_property_details.view.*


private const val PROPERTY_ID = "propertyId"

class PropertyDetailsFragment : Fragment() {
    private var propertyId: Int? = null
    lateinit var mapFragment: SupportMapFragment
    lateinit var propertyPhotoList: MutableList<PropertyPhoto>
    lateinit var recyclerAdapterPropertyPhoto: RecyclerAdapterPropertyPhoto
    lateinit var propertyFacilityList: MutableList<PropertyFeature>
    lateinit var recyclerAdapterPropertyFacility: RecyclerAdapterPropertyFeature
    lateinit var propertyFeatureList: MutableList<PropertyFeature>
    lateinit var recyclerAdapterPropertyFeature: RecyclerAdapterPropertyFeature
    lateinit var propertyList: MutableList<PropertyPhoto>
    lateinit var recyclerAdapterProperty: RecyclerAdapterProperty
    lateinit var linearLayoutManager: LinearLayoutManager

    var v: View? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            propertyId = it.getInt(PROPERTY_ID)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view = inflater.inflate(R.layout.fragment_property_details, container, false)
        init(view)
        action(view)
        return view
    }

    private fun init(view: View) {
        v = view
        propertyPhotoList = mutableListOf<PropertyPhoto>()
        recyclerAdapterPropertyPhoto = RecyclerAdapterPropertyPhoto(view.context, propertyPhotoList)

        propertyFacilityList = mutableListOf<PropertyFeature>()
        recyclerAdapterPropertyFacility =
            RecyclerAdapterPropertyFeature(view.context, propertyFacilityList)

        propertyFeatureList = mutableListOf<PropertyFeature>()
        recyclerAdapterPropertyFeature =
            RecyclerAdapterPropertyFeature(view.context, propertyFeatureList)

        propertyList = mutableListOf<PropertyPhoto>()
        recyclerAdapterProperty =
            RecyclerAdapterProperty(view.context, propertyList)

        linearLayoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(callback)
    }

    private fun action(view: View) {
        view.rec_photo.layoutManager = linearLayoutManager
        view.rec_photo.adapter = recyclerAdapterPropertyPhoto

        view.rec_facility.layoutManager = GridLayoutManager(view.context, 3)
        view.rec_facility.adapter = recyclerAdapterPropertyFacility

        view.rec_feature.layoutManager = GridLayoutManager(view.context, 3)
        view.rec_feature.adapter = recyclerAdapterPropertyFeature

        view.rec_property.layoutManager =
            LinearLayoutManager(view.context, LinearLayoutManager.HORIZONTAL, false)
        view.rec_property.adapter = recyclerAdapterProperty

        view.tv_photo.setOnClickListener {
            view.tv_photo.setTextColor(ContextCompat.getColor(view.context, R.color.colorBlack))
            view.tv_photo_underline.setBackgroundColor(
                ContextCompat.getColor(
                    view.context,
                    R.color.colorOrange
                )
            )
            view.tv_video.setTextColor(ContextCompat.getColor(view.context, R.color.colorDarkGray))
            view.tv_video_underline.setBackgroundColor(
                ContextCompat.getColor(
                    view.context,
                    R.color.colorWhite
                )
            )
            view.tv_map.setTextColor(ContextCompat.getColor(view.context, R.color.colorDarkGray))
            view.tv_map_underline.setBackgroundColor(
                ContextCompat.getColor(
                    view.context,
                    R.color.colorWhite
                )
            )
            view.rec_photo.visibility = View.VISIBLE
            view.youtube_player_view.visibility = View.GONE
            view.map_lay.visibility = View.GONE
        }
        view.tv_video.setOnClickListener {
            view.tv_photo.setTextColor(ContextCompat.getColor(view.context, R.color.colorDarkGray))
            view.tv_photo_underline.setBackgroundColor(
                ContextCompat.getColor(
                    view.context,
                    R.color.colorWhite
                )
            )

            view.tv_video.setTextColor(ContextCompat.getColor(view.context, R.color.colorBlack))
            view.tv_video_underline.setBackgroundColor(
                ContextCompat.getColor(
                    view.context,
                    R.color.colorOrange
                )
            )

            view.tv_map.setTextColor(ContextCompat.getColor(view.context, R.color.colorDarkGray))
            view.tv_map_underline.setBackgroundColor(
                ContextCompat.getColor(
                    view.context,
                    R.color.colorWhite
                )
            )

            view.rec_photo.visibility = View.GONE
            view.youtube_player_view.visibility = View.VISIBLE
            view.map_lay.visibility = View.GONE
        }
        view.tv_map.setOnClickListener {
            view.tv_photo.setTextColor(ContextCompat.getColor(view.context, R.color.colorDarkGray))
            view.tv_photo_underline.setBackgroundColor(
                ContextCompat.getColor(
                    view.context,
                    R.color.colorWhite
                )
            )

            view.tv_video.setTextColor(ContextCompat.getColor(view.context, R.color.colorDarkGray))
            view.tv_video_underline.setBackgroundColor(
                ContextCompat.getColor(
                    view.context,
                    R.color.colorWhite
                )
            )

            view.tv_map.setTextColor(ContextCompat.getColor(view.context, R.color.colorBlack))
            view.tv_map_underline.setBackgroundColor(
                ContextCompat.getColor(
                    view.context,
                    R.color.colorOrange
                )
            )

            view.rec_photo.visibility = View.GONE
            view.youtube_player_view.visibility = View.GONE
            view.map_lay.visibility = View.VISIBLE
        }
        demoPhotoLoad()
        propertyPhotoAnimation(view)
        demoFacilityLoad()
        demoFeatureLoad()
        demoPropertyLoad()
    }

    private fun demoPropertyLoad() {
        propertyList.add(PropertyPhoto("https://3.imimg.com/data3/NK/OT/MY-14932693/flat-interiors-500x500.png"))
        propertyList.add(PropertyPhoto("https://st2.depositphotos.com/23625566/44787/i/450/depositphotos_447877590-stock-photo-modern-television-room-blue-background.jpg"))
        propertyList.add(PropertyPhoto("https://3.imimg.com/data3/NK/OT/MY-14932693/flat-interiors-500x500.png"))
        propertyList.add(PropertyPhoto("https://st2.depositphotos.com/23625566/44787/i/450/depositphotos_447877590-stock-photo-modern-television-room-blue-background.jpg"))
        propertyList.add(PropertyPhoto("https://3.imimg.com/data3/NK/OT/MY-14932693/flat-interiors-500x500.png"))
        propertyList.add(PropertyPhoto("https://st2.depositphotos.com/23625566/44787/i/450/depositphotos_447877590-stock-photo-modern-television-room-blue-background.jpg"))
        propertyList.add(PropertyPhoto("https://3.imimg.com/data3/NK/OT/MY-14932693/flat-interiors-500x500.png"))
        propertyList.add(PropertyPhoto("https://st2.depositphotos.com/23625566/44787/i/450/depositphotos_447877590-stock-photo-modern-television-room-blue-background.jpg"))
        recyclerAdapterProperty.notifyDataSetChanged()
    }

    private fun demoFeatureLoad() {
        propertyFeatureList.add(PropertyFeature(R.drawable.ic_view, "View"))
        propertyFeatureList.add(PropertyFeature(R.drawable.ic_flooring, "Flooring"))
        propertyFeatureList.add(PropertyFeature(R.drawable.ic_balcony_2, "Balcony"))
        propertyFeatureList.add(PropertyFeature(R.drawable.ic_power, "Power Backup"))
        propertyFeatureList.add(PropertyFeature(R.drawable.ic_security_service, "Security Service"))
        propertyFeatureList.add(PropertyFeature(R.drawable.ic_cctv, "CCTV Service"))
        propertyFeatureList.add(PropertyFeature(R.drawable.ic_lift, "Lift"))
        propertyFeatureList.add(PropertyFeature(R.drawable.ic_concierge, "Concierge"))
        propertyFeatureList.add(PropertyFeature(R.drawable.ic_cleaning_service, "Cleaning Service"))
    }

    private fun propertyPhotoAnimation(view: View) {
        val snapHelper: SnapHelper = GravitySnapHelper(Gravity.START)
        snapHelper.attachToRecyclerView(view.rec_photo)
        Handler().postDelayed({ // Do something after 1s = 1000ms
            /*try { */
            val viewHolderDefault: RecyclerView.ViewHolder =
                view.rec_photo.findViewHolderForAdapterPosition(0)!!
            val property_img: ConstraintLayout =
                viewHolderDefault.itemView.findViewById(R.id.photo_lay)
            val photo_margin: ImageView = viewHolderDefault.itemView.findViewById(R.id.photo_margin)

            property_img.animate().setDuration(350).scaleX(1f).scaleY(1f)
                .setInterpolator(AccelerateInterpolator()).start()

            photo_margin.animate().setDuration(350).scaleX(1f).scaleY(1f)
                .setInterpolator(AccelerateInterpolator()).start()
            /* } catch (e: Exception) {
                 Log.d("ok", "Exception: $e")
             }*/
            Log.d("ok", "onScrollStateChanged: 3")
        }, 1000)
        view.rec_photo.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(@NonNull recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    val v = snapHelper.findSnapView(linearLayoutManager)
                    try {
                        val pos: Int = linearLayoutManager.getPosition(v!!)
                        val viewHolder: RecyclerView.ViewHolder =
                            view.rec_photo.findViewHolderForAdapterPosition(pos)!!
                        val property_img: ConstraintLayout =
                            viewHolder.itemView.findViewById(R.id.photo_lay)
                        val photo_margin: ImageView =
                            viewHolder.itemView.findViewById(R.id.photo_margin)

                        property_img.animate().setDuration(350).scaleX(1f).scaleY(1f)
                            .setInterpolator(AccelerateInterpolator()).start();

                        photo_margin.animate().setDuration(350).scaleX(1f).scaleY(1f)
                            .setInterpolator(AccelerateInterpolator()).start()

                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                } else {
                    val v = snapHelper.findSnapView(linearLayoutManager)
                    try {
                        val pos: Int = linearLayoutManager.getPosition(v!!)
                        val viewHolder: RecyclerView.ViewHolder =
                            view.rec_photo.findViewHolderForAdapterPosition(pos)!!
                        val property_img: ConstraintLayout =
                            viewHolder.itemView.findViewById(R.id.photo_lay)
                        val photo_margin: ImageView =
                            viewHolder.itemView.findViewById(R.id.photo_margin)

                        property_img.animate().setDuration(350).scaleX(0.9f).scaleY(0.9f)
                            .setInterpolator(AccelerateInterpolator()).start();

                        photo_margin.animate().setDuration(350).scaleX(0f).scaleY(1f)
                            .setInterpolator(AccelerateInterpolator()).start()

                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
            }
        })

    }

    private fun demoFacilityLoad() {
        propertyFacilityList.add(PropertyFeature(R.drawable.ic_squarefeet, "2240 sq ft"))
        propertyFacilityList.add(PropertyFeature(R.drawable.ic_rooms, "5 Rooms"))
        propertyFacilityList.add(PropertyFeature(R.drawable.ic_bedroom, "4 Bedrooms"))
        propertyFacilityList.add(PropertyFeature(R.drawable.ic_bathroom, "4 Bathrooms"))
        propertyFacilityList.add(PropertyFeature(R.drawable.ic_balcony, "3 Balcony"))
        propertyFacilityList.add(PropertyFeature(R.drawable.ic_kitchen, "1 Kitchen"))
        propertyFacilityList.add(PropertyFeature(R.drawable.ic_maid_room, "1 Maid Room"))
        recyclerAdapterPropertyFacility.notifyDataSetChanged()
    }

    private fun demoPhotoLoad() {
        propertyPhotoList.add(PropertyPhoto("https://3.imimg.com/data3/NK/OT/MY-14932693/flat-interiors-500x500.png"))
        propertyPhotoList.add(PropertyPhoto("https://st2.depositphotos.com/23625566/44787/i/450/depositphotos_447877590-stock-photo-modern-television-room-blue-background.jpg"))
        propertyPhotoList.add(PropertyPhoto("https://3.imimg.com/data3/NK/OT/MY-14932693/flat-interiors-500x500.png"))
        propertyPhotoList.add(PropertyPhoto("https://st2.depositphotos.com/23625566/44787/i/450/depositphotos_447877590-stock-photo-modern-television-room-blue-background.jpg"))
        propertyPhotoList.add(PropertyPhoto("https://3.imimg.com/data3/NK/OT/MY-14932693/flat-interiors-500x500.png"))
        propertyPhotoList.add(PropertyPhoto("https://st2.depositphotos.com/23625566/44787/i/450/depositphotos_447877590-stock-photo-modern-television-room-blue-background.jpg"))
        recyclerAdapterPropertyPhoto.notifyDataSetChanged()
    }

    private val callback = OnMapReadyCallback { googleMap ->
        val place = LatLng(23.745439534397654, 90.4125914133939)
        googleMap.addMarker(MarkerOptions().position(place).title("Flat Location"))
        googleMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(
                place, 12.0f
            )
        )
    }

    companion object {
        @JvmStatic
        fun newInstance(propertyId: Int) =
            PropertyDetailsFragment().apply {
                arguments = Bundle().apply {
                    putInt(PROPERTY_ID, propertyId)
                }
            }
    }
}