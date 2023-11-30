package com.example.lifecycleapp.presentation.counter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.lifecycleapp.databinding.FragmentSecondBinding
import com.example.lifecycleapp.presentation.ViewModelFactory

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    //delegate de viewmodel para reutlizar
    private val viewModel by activityViewModels<MainViewModel> {
        ViewModelFactory()
    }

    //private lateinit var viewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //compartilhar entre fragments:
        //ele espera um owner como parâmetro - que nesse caso é o fragment
        //activity tb implementa o lifecycle owner (fazer o cast):
        //viewModel = ViewModelProvider(activity as AppCompatActivity).get()

        //observar mudanças de valores
        viewModel.counter.observe(viewLifecycleOwner) { counter ->
            binding.tvCounter.text = counter.toString()

        }

        binding.buttonSecond.setOnClickListener {
            // findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            viewModel.increment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}