package br.com.thiagofelix.portifolioapp.portifolio

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import br.com.thiagofelix.portifolioapp.databinding.FragmentCvBinding
import br.com.thiagofelix.portifolioapp.databinding.FragmentPortifolioBinding

class PortifolioFragment:Fragment() {

    private var _binding: FragmentPortifolioBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        _binding= FragmentPortifolioBinding.inflate(inflater, container , false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mData = arrayListOf<PortifolioItem>()
        mData.add(PortifolioItem())
        mData.add(PortifolioItem())
        mData.add(PortifolioItem())
        mData.add(PortifolioItem())
        mData.add(PortifolioItem())
        mData.add(PortifolioItem())
        mData.add(PortifolioItem())
        mData.add(PortifolioItem())
        mData.add(PortifolioItem())

        val adapter = PortifolioAdapter()
        adapter.mData = mData

        binding.rvPortifolio.layoutManager = GridLayoutManager(activity , 3)
        binding.rvPortifolio.adapter = adapter

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}