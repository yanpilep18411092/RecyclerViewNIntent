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

        // DATA NOKEN
        val imgList = listOf<ImgData>(

            ImgData(
                R.drawable.noken1,getString(R.string.noken_gantung), getString(R.string.noken_gantung_desc)
            ),
            ImgData(
                R.drawable.noken2,getString(R.string.noken_perang), getString(R.string.noken_perang_desc)
            ),
            ImgData(
                R.drawable.noken3,getString(R.string.noken_sekolah), getString(R.string.noken_sekolah_desc)
            ),
            ImgData(
                R.drawable.noken4,getString(R.string.noken_raja), getString(R.string.noken_raja_desc)
            ),
            ImgData(
                R.drawable.noken5,getString(R.string.noken_bayi), getString(R.string.noken_bayi_desc)
            ),
            ImgData(
                R.drawable.noken6,getString(R.string.noken_upacara), getString(R.string.noken_upacara_desc)
            ),
            ImgData(
                R.drawable.noken1,getString(R.string.noken_mini), getString(R.string.noken_mini_desc)
            ),
            ImgData(
                R.drawable.noken2,getString(R.string.noken_modern), getString(R.string.noken_modern_desc)
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