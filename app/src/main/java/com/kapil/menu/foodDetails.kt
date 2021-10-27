package com.kapil.menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_food_details.*
import kotlinx.android.synthetic.main.food_ticket.*

class foodDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_details)
        val bundle=intent.extras
        fd_ivFoodImage.setImageResource(bundle!!.getInt("image"))
        fd_tvName.text= bundle.getString("name")
        fd_tvDetails.text= bundle.getString("des")

    }
}