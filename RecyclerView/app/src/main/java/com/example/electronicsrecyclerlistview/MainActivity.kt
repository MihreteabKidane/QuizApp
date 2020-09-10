package com.example.electronicsrecyclerlistview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var r1: RecyclerView? = null
    var layoutManager: RecyclerView.LayoutManager? = null
    var productList = ArrayList<Product>(arrayListOf(
        Product("Camera",480.10,"Black",R.drawable.cameras.toString(),"101","A camera is an optical instrument used to capture still images or to record moving images, which are stored in a physical medium such as in a digital system or on photographic film. A camera consists of a lens which focuses light from the scene, and a camera body which holds the image capture mechanism."),
        Product("Mobile",343.10,"Black",R.drawable.mobile.toString(),"102","A mobile device is a computing device small enough to hold and operate in the hand. Typically, any handheld computer device will have an LCD or OLED flatscreen interface, providing a touchscreen interface with digital buttons and keyboard or physical buttons along with a physical keyboard."),
        Product("DVD Player",55.25,"Black",R.drawable.dvdplayer.toString(),"103","A DVD player is a device that plays DVDs produced under both the DVD-Video and DVD-Audio technical standards, two different and incompatible standards. Some DVD players will also play audio CDs. ... Some manufacturers originally announced that DVD players would be available as early as the middle of 1996."),
        Product("Laptop",450.10,"Silver",R.drawable.laptop.toString(),"104","A laptop, often called a notebook, is a small, portable personal computer with a \"clamshell\" form factor, typically having a thin LCD or LED computer screen mounted on the inside of the upper lid of the clamshell and an alphanumeric keyboard on the inside of the lower lid."),
        Product("TeleVision",600.75,"Silver",R.drawable.television.toString(),"105","A television (also known as a TV) is a machine with a screen. Televisions receive broadcasting signals and turn them into pictures and sound. The word \"television\" comes from the words tele (Greek for far away) and vision (sight). Sometimes a television can look like a box.")
    ))
    var madr : MyAdapter?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        r1 = findViewById<RecyclerView>(R.id.rv)

        madr = MyAdapter(this,productList)
        layoutManager = LinearLayoutManager(this)
        r1?.layoutManager = layoutManager
        r1?.adapter = madr

    }
}
