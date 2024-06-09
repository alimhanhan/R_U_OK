package com.example.ruok_workers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.ruok_workers.databinding.FragmentCountingAddBinding
import com.example.ruok_workers.databinding.FragmentDashboardBinding
import com.example.ruok_workers.databinding.FragmentLocationAddBinding


class CountingAddFragment : Fragment() {
    lateinit var binding: FragmentCountingAddBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCountingAddBinding.inflate(inflater, container, false)

        //btnCompleteCountingAdd 클릭시 CountingAddFragment에서 CountingTableFragment로 이동
        binding.btnCountingAdd.setOnClickListener {
            val parentActivity = activity as DashboardActivity
            parentActivity.setFragment(CountingTableFragment())
        }
        
        return binding.root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CountingAddFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}