package pt.ipt.dam2022.openstreetmaps

import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.infowindow.InfoWindow

class MarkerWindow : InfoWindow {

    private var parent: MainActivity
    private var text: String

    constructor(
            mapView: MapView, parent: MainActivity, text: String
    ) : super(R.layout.info_window, mapView) {
        this.parent = parent
        this.text = text
    }

    override fun onOpen(item: Any?) {
        // close all windows at beginning
        closeAllInfoWindowsOn(mapView)

        // access to button and textView
        val myHelloButton = mView.findViewById<Button>(R.id.HelloBT)
        val myTextView = mView.findViewById<TextView>(R.id.textView)

        // define value to TextView
        myTextView.text = text

        // define what appends when we click on button
        myHelloButton.setOnClickListener {
            Toast.makeText(parent, "Hello $text", Toast.LENGTH_SHORT).show()
        }

        // when one click on the area of the window, it close
        mView.setOnClickListener{
            close()
        }
    }

    override fun onClose() {
        // TODO("Not yet implemented")
    }


}