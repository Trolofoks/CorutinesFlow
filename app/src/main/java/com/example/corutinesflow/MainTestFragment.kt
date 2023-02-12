package com.example.corutinesflow

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.corutinesflow.databinding.FragmentMainTestBinding

class MainTestFragment : BaseFragment<FragmentMainTestBinding>(FragmentMainTestBinding::inflate){

    lateinit var vm: MainTestViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm = MainTestViewModel()

        vm.visibleLive.observe(viewLifecycleOwner, Observer {isVisible ->
            if (isVisible){
                binding.textView.visibility = View.VISIBLE
            } else {
                binding.textView.visibility = View.INVISIBLE
            }
        })

        vm.messageLive.observe(viewLifecycleOwner, Observer {text ->
            binding.textView.text = text
        })

        binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
            Log.d("MyLog", "$isChecked")
            vm.toggleVisibility( isChecked )
        }
    }
}