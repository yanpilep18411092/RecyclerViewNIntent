package com.example.projectserwin

import android.content.ClipData.Item
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.projectserwin.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private lateinit var binding: ActivityRecyclerViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val imgList = listOf<ImgData>(

            ImgData(
                R.drawable.udang_selingkuh,getString(R.string.udang_selingkuh), getString(R.string.udang_selingkuh_desc)
            ),
            ImgData(
                R.drawable.ulat_sagu,getString(R.string.ulat_sagu), getString(R.string.ulat_sagu_desc)
            ),
            ImgData(
                R.drawable.sarang_semut,getString(R.string.sarang_semut), getString(R.string.sarang_semut_desc)
            ),
        )

        val myRecyclerView = findViewById<RecyclerView>(R.id.myRV)

        myRecyclerView.layoutManager = LinearLayoutManager(this)
        myRecyclerView.setHasFixedSize(true)
        myRecyclerView.adapter = ImgAdapter(this, imgList) { selectedItem ->
            val intent = Intent(this, DetailActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, selectedItem)  // kirim data ImgData
            startActivity(intent)
        }

    }

}