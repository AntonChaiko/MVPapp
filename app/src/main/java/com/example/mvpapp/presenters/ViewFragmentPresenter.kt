package com.example.mvpapp.presenters

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.mvpapp.R
import com.example.mvpapp.model.ColorsModel
import com.example.mvpapp.views.BaseView


@InjectViewState
class ViewFragmentPresenter : MvpPresenter<BaseView>() {
    lateinit var colorsList: MutableList<ColorsModel>

    init {
        resetList()
        viewState.setAdapter(colorsList)
    }

    fun resetList() {
        colorsList = mutableListOf(
            ColorsModel("Red", "#FE0B0B", R.color.red),
            ColorsModel("Blue", "#2C98FC", R.color.blue),
            ColorsModel("Black", "#FF000000", R.color.black),
            ColorsModel("White", "#FFFFFFFF", R.color.white),
            ColorsModel("Light Green", "#1EBF01", R.color.light_green),
            ColorsModel("Pink", "#FFC0CB", R.color.pink),
            ColorsModel("Chocolate", "#D2691E", R.color.chocolate),
            ColorsModel("Linen", "#FAF0E6", R.color.linen)
        )
        colorsList.shuffle()
    }

}