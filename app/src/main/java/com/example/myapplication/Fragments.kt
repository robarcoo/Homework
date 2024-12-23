package com.example.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentABinding
import com.example.myapplication.databinding.FragmentBBinding
import com.example.myapplication.databinding.FragmentCBinding

class FragmentA : Fragment() {

    private var _binding: FragmentABinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        container?.clearDisappearingChildren()
        _binding = FragmentABinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonA.setOnClickListener {
            ActivityRouter.navigate(R.id.fragment_b, R.id.fragment_a, parentFragmentManager)
        }

        binding.button2A.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}

class FragmentB : Fragment() {

    private var _binding: FragmentBBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        container?.clearDisappearingChildren()
        _binding = FragmentBBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonB.setOnClickListener {
            ActivityRouter.navigate(R.id.fragment_c, R.id.fragment_b, parentFragmentManager)
        }

        binding.button2B.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }
}

class FragmentC : Fragment() {

    private var _binding: FragmentCBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        container?.clearDisappearingChildren()
        _binding = FragmentCBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonC.setOnClickListener {
            ActivityRouter.navigate(R.id.fragment_a, R.id.fragment_c, parentFragmentManager)
        }

        binding.button2C.setOnClickListener {
            parentFragmentManager.popBackStack()
        }
    }


}