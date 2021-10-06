package com.fahmi.dicoding.submission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView

@Suppress("DEPRECATION")
class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_BIRTH_DATE = "extra_birth_date"
        const val EXTRA_BIRTH_PLACE = "extra_birth_place"
        const val EXTRA_NATIONALITY = "extra_nationality"
        const val EXTRA_HEIGHT = "extra_height"
        const val EXTRA_WEIGHT = "extra_weight"
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_BIO = "extra_bio"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        supportActionBar?.title = "Detail"

        val actionBar = getSupportActionBar()
        if(actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true)
        }

        val tvDetailName : TextView = findViewById(R.id.tv_detail_name)
        val tvDetailBirthDate : TextView = findViewById(R.id.tv_detail_birth_date)
        val tvDetailBirthPlace : TextView = findViewById(R.id.tv_detail_birth_place)
        val tvDetailNationality : TextView = findViewById(R.id.tv_detail_nationality)
        val tvDetailHeight : TextView = findViewById(R.id.tv_detail_height)
        val tvDetailWeight : TextView = findViewById(R.id.tv_detail_weight)
        val ivDetailPhoto : ImageView = findViewById(R.id.iv_detail_photo)
        val tvDetailBio : TextView = findViewById(R.id.tv_detail_bio)

        val name = intent.getStringExtra(EXTRA_NAME)
        val birth_date = intent.getStringExtra(EXTRA_BIRTH_DATE)
        val birth_place = intent.getStringExtra(EXTRA_BIRTH_PLACE)
        val nationality = intent.getStringExtra(EXTRA_NATIONALITY)
        val height = intent.getStringExtra(EXTRA_HEIGHT)
        val weight = intent.getStringExtra(EXTRA_WEIGHT)
        val photo = intent.getIntExtra(EXTRA_PHOTO, 0)
        val bio = intent.getStringExtra(EXTRA_BIO)

        tvDetailName.text = name
        tvDetailBirthDate.text = "Birth Date: $birth_date"
        tvDetailBirthPlace.text = "Birth Place: $birth_place"
        tvDetailNationality.text = "Nationality: $nationality"
        tvDetailHeight.text = "Height: $height"
        tvDetailWeight.text = "Weight: $weight"
        ivDetailPhoto.setImageDrawable(resources.getDrawable(photo))
        tvDetailBio.text = bio
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onContextItemSelected(item)
    }
}