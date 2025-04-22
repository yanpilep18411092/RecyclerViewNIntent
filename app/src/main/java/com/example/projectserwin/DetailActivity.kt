package com.example.projectserwin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.projectserwin.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val img = intent.getParcelableExtra<ImgData>(RecyclerViewActivity.INTENT_PARCELABLE)
        val imgSrc = binding.imgDetail
        val imgTitle = binding.titleDetail
        val imgDesc = binding.descDetail

        imgSrc.setImageResource(img!!.imgSrc)
        imgTitle.text = img.imgTitle
        imgDesc.text = img.imgDesc
    }
}