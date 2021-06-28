package com.example.mvpapp.ui.screens.viewfragment

import com.arellomobile.mvp.MvpView
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType
import com.example.mvpapp.domain.models.ColorsModel

@StateStrategyType(AddToEndSingleStrategy::class)
interface BaseView : MvpView {
    fun setAdapter(list: MutableList<ColorsModel>)
    fun refreshData()
    fun clipboardData(hex:String)
}