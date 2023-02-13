package com.example.corutinesflow

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.corutinesflow.databinding.FragmentMainTestBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainTestFragment : BaseFragment<FragmentMainTestBinding>(FragmentMainTestBinding::inflate){

    lateinit var vm: MainTestViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        vm = ViewModelProvider(this).get(MainTestViewModel::class.java)

        lifecycleScope.launchWhenCreated {
            vm.messageFlow
                .onEach {message->
                    binding.textView.text = message
                    Log.d("MyLogMessage", "$message")

                }
                .collect()
        }
        binding.checkBox.setOnCheckedChangeListener { _, isChecked ->
            Log.d("MyLogCheck", "$isChecked")
            vm.toggleVisibility( isChecked )
        }

        lifecycleScope.launchWhenCreated {
            vm.visibleFlow.collect() {isVisible->
                Log.d("MyLogVisible", "$isVisible")
                binding.textView.isVisible = isVisible
                binding.checkBox.isChecked = isVisible
            }
        }




    }
}