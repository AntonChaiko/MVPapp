package com.example.mvpapp.bases

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.arellomobile.mvp.MvpAppCompatFragment

abstract class BaseFragment<T: ViewDataBinding> : MvpAppCompatFragment() {

    lateinit var binding: T

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,getFragmentView(),container, false)
        return binding.root
    }
    abstract fun getFragmentView(): Int

}