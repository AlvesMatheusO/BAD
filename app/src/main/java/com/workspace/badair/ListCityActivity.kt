package com.workspace.badairdetector

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.workspace.badair.CityInfoActivity
import com.workspace.badair.GameActivity
import com.workspace.badair.R
import kotlinx.android.synthetic.main.activity_list_city.*

class ListCityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_city)

        cidade_example.setOnClickListener {
            startActivity(Intent(this, CityInfoActivity::class.java))
        }

        icon_game.setOnClickListener {
            startActivity(Intent(this, GameActivity::class.java))
        }


    }
}
