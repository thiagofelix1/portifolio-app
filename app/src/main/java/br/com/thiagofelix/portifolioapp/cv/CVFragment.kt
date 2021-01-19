package br.com.thiagofelix.portifolioapp.cv

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.thiagofelix.portifolioapp.R
import br.com.thiagofelix.portifolioapp.databinding.FragmentCvBinding

class CVFragment:Fragment() {
    private var _binding:FragmentCvBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentCvBinding.inflate(inflater, container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.recyclerviewCv

        //create list of cv items
        val items = arrayListOf<CVItem>(
            CVItem("08 de novembro de 2019" , getString(R.string.job_cigas)),
            CVItem("03 de novembro de 2020 - Atual", getString(R.string.job_cigas))
        )
        val adapter = CVAdapter()
        adapter.mData = items

        binding.recyclerviewCv.layoutManager = LinearLayoutManager(this.context)
        binding.recyclerviewCv.adapter = adapter

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}