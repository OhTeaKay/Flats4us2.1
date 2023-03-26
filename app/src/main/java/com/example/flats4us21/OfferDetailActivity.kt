package com.example.flats4us21

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.flats4us21.data.Offer
import com.example.flats4us21.databinding.ActivityOfferDetailBinding
import com.example.flats4us21.viewmodels.MainViewModel

class OfferDetailActivity : AppCompatActivity() {
    private lateinit var viewModel : MainViewModel
    private lateinit var binding : ActivityOfferDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOfferDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        val offer = intent.extras?.let { viewModel.loadDataFromDb().get(it.getInt("index")) }
        bindOfferData(offer)
    }

    private fun bindOfferData(offer: Offer?) {
        offer ?: return

        binding.image.setImageResource(offer.property.image)
        binding.dateIssue.text = offer.dateIssue
        binding.price.text = offer.price.toString()
        binding.address.text = "${offer.property.city} ${offer.property.street}"
        binding.period.text = offer.rentalPeriod
        binding.maxResidents.text = offer.property.maxResidents.toString()
        binding.equipment.text = offer.property.equipment
        binding.interestedPeople.text = offer.interestedPeople.toString()
    }
}