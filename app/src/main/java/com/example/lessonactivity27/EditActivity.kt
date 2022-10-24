package com.example.lessonactivity27

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.lessonactivity27.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    private var indexImage = 0
    private var imageId = R.drawable.image_part_039
    private val imageIdList = listOf(
        R.drawable.image_part_001,
        R.drawable.image_part_040,
        R.drawable.image_part_054,
        R.drawable.image_part_011,
        R.drawable.image_part_024,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }

    private fun initButtons() = with(binding){
        bNext.setOnClickListener {
            indexImage++
            if(indexImage > imageIdList.size - 1) indexImage = 0
            Log.d("HappyTAG", "Index: $indexImage")
            imageId = imageIdList[indexImage]
            imageView.setImageResource(imageId)
        }
        bDone.setOnClickListener {
            val card = Card(imageId, edTitle.text.toString(), edDesc.text.toString())
            val editIntent = Intent().apply {
                putExtra("card", card)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}