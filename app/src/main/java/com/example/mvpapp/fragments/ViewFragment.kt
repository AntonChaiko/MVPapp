package com.example.mvpapp.fragments

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.mvpapp.R
import com.example.mvpapp.adapters.RecyclerViewAdapter
import com.example.mvpapp.bases.BaseFragment
import com.example.mvpapp.databinding.FragmentViewBinding
import com.example.mvpapp.model.ColorsModel
import com.example.mvpapp.presenters.ViewFragmentPresenter
import com.example.mvpapp.views.BaseView


class ViewFragment : BaseFragment<FragmentViewBinding>(), BaseView {


    @InjectPresenter
    lateinit var presenter: ViewFragmentPresenter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter = ViewFragmentPresenter()

        binding.swipeToRefreshLayout.setOnRefreshListener { refreshData() }
    }

    override fun getFragmentView(): Int = R.layout.fragment_view

    override fun setAdapter(list: MutableList<ColorsModel>) {
        val adapter = RecyclerViewAdapter{hex -> clipboardData(hex) }
        adapter.submitList(list)
        binding.fragmentRecyclerView.adapter = adapter
    }

    override fun refreshData() {
        presenter.resetList()
        setAdapter(presenter.colorsList)
        binding.swipeToRefreshLayout.isRefreshing = false
    }

    override fun clipboardData(hex:String) {
        val clipboard = activity?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Hex", hex)
        clipboard.setPrimaryClip(clip)
        Toast.makeText(requireContext(),"copied",Toast.LENGTH_SHORT).show()
    }

}