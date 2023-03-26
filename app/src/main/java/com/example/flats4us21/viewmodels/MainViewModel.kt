package com.example.flats4us21.viewmodels

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.ViewModel
import com.example.flats4us21.R

import com.example.flats4us21.data.Offer
import com.example.flats4us21.data.Property

private val offer1 =
    Offer(
        dateIssue = "20-03-2023",
        status = "aktywny",
        price = 2500.50F,
        description = "Lorem ipsum",
        rentalPeriod = "3 lata",
        interestedPeople = 48,
        Property(
            city = "Warszawa",
            street = "Kościuszki 10A",
            maxResidents = 2,
            equipment = "Brak",
            image = R.drawable.property
        )
    )
private val offer2 =
    Offer(
        dateIssue = "21-03-2023",
        status = "aktywny",
        price = 3500.50F,
        description = "Lorem ipsum",
        rentalPeriod = "2 lata",
        interestedPeople = 18,
        Property(
            city = "Warszawa",
            street = "Pruszkowska 10A",
            maxResidents = 4,
            equipment = "Sofa",
            image = R.drawable.property
        )
    )
private val offer3 =
    Offer(
        dateIssue = "21-03-2023",
        status = "aktywny",
        price = 3500.50F,
        description = "Lorem ipsum",
        rentalPeriod = "2 lata",
        interestedPeople = 18,
        Property(
            city = "Warszawa",
            street = "Pruszkowska 10A",
            maxResidents = 4,
            equipment = "Sofa",
            image = R.drawable.property
        )
    )
private val data = listOf<Offer>(offer1, offer2, offer3)

interface Server {
    fun loadDataFromDb() : List<Offer>
}

class MainViewModel() : ViewModel(), Server, Parcelable {
    private var offer: Offer? = null

    constructor(parcel: Parcel) : this() {

    }

    override fun loadDataFromDb(): List<Offer> {
        return data
    }

    fun setOffer(offer: Offer){
        this.offer = offer
    }
    fun getOffer() = offer
    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(p0: Parcel, p1: Int) {
        TODO("Not yet implemented")
    }

    companion object CREATOR : Parcelable.Creator<MainViewModel> {
        override fun createFromParcel(parcel: Parcel): MainViewModel {
            return MainViewModel(parcel)
        }

        override fun newArray(size: Int): Array<MainViewModel?> {
            return arrayOfNulls(size)
        }
    }
}