package com.example.projetoandroidbsico.Views

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.projetoandroidbsico.Connection.RetrofitRepositories
import com.example.projetoandroidbsico.Models.Academia
import com.example.projetoandroidbsico.Models.Results
import com.example.projetoandroidbsico.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_map.*
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ActivityMaps : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var result: ArrayList<Academia>
    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_map)
        init()


    }

    private fun init() {
        val mapFragment = map as SupportMapFragment
        mapFragment.getMapAsync(this@ActivityMaps)


    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap
        if (mMap.isBuildingsEnabled) {
            toast("as")
        }

        //Add a marker in Cesar School and move the camera
        //val cesarSchool = LatLng(-8.059616, -34.8730747)
        //mMap.addMarker(MarkerOptions().position(cesarSchool).title("Cesar School"))
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(cesarSchool))
        callMap()
    }

    private fun callMap() {
        if (checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
            == PackageManager.PERMISSION_GRANTED
            || checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
            == PackageManager.PERMISSION_GRANTED
        ) {
            mMap.isMyLocationEnabled = true


            val cesarSchool = LatLng(-8.059616, -34.8730747)
            mMap.addMarker(MarkerOptions().position(cesarSchool).title("Cesar School"))
            var requestAcademias = RetrofitRepositories().AcademiasRequest()
            requestAcademias.getGyms().enqueue(object : Callback<Results> {
                override fun onFailure(call: Call<Results>, t: Throwable) {
                    toast("Erro: ${t.message}")

                }

                override fun onResponse(call: Call<Results>, response: Response<Results>) {
                    if (response.code() == 200) {
                        if (response.body() != null) {
                            if (response.isSuccessful) {
                                result = response.body()!!.result.records
                                result.forEach { academia ->
                                    val academiaPosition = LatLng(academia.latitude, academia.longitude)
                                    mMap.addMarker(MarkerOptions().position(academiaPosition).title(academia.polo))

                                }
                            }
                        }
                    }
                }

            })







            try {
                val locationManager =
                    getSystemService(Context.LOCATION_SERVICE) as LocationManager

                val locationListener = object : LocationListener {
                    override fun onLocationChanged(location: Location?) {
                        val latitude = location?.latitude ?: -8.059616
                        val longitude = location?.longitude ?: -34.8730747

                        val latlng = LatLng(latitude, longitude)

                        val marker =
                            mMap.addMarker(MarkerOptions().position(latlng).title("Esta é minha localização"))

                        marker.position = latlng

                    }

                    override fun onStatusChanged(
                        provider: String?,
                        status: Int,
                        extras: Bundle?
                    ) {

                    }

                    override fun onProviderEnabled(provider: String?) {

                    }

                    override fun onProviderDisabled(provider: String?) {

                    }

                }
                locationManager.requestLocationUpdates(
                    LocationManager.GPS_PROVIDER,
                    0,
                    0f,
                    locationListener
                )
            } catch (ex: SecurityException) {
                Toast.makeText(this, ex.message, Toast.LENGTH_LONG).show()
            }
        } else {
            requestPermissions(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ), 1010
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            1010 -> {
                if (grantResults.isNotEmpty() && checkAllPermissionAreGranted(grantResults)) {
                    callMap()
                }
            }
        }
    }

    private fun checkAllPermissionAreGranted(grantResults: IntArray): Boolean {
        var result = true
        grantResults.forEach { grant ->
            if (grant != PackageManager.PERMISSION_GRANTED) {
                result = false
            }
        }
        return result
    }

}
