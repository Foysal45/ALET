package com.alet.apps.c_activity.ac_details.fragment.fg_property_details.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.alet.apps.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

private const val PROPERTY_ID = "propertyId"

class PropertyDetailsFragment : Fragment() {
    private var propertyId: Int? = null
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
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }

    private fun action(view: View) {

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