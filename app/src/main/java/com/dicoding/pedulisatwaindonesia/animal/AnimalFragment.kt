package com.dicoding.pedulisatwaindonesia.animal

import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.pedulisatwaindonesia.databinding.FragmentAnimalBinding
import com.dicoding.pedulisatwaindonesia.utils.MarginItemDecoration

class AnimalFragment : Fragment() {

    private lateinit var fragmentAnimalBinding: FragmentAnimalBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        fragmentAnimalBinding = FragmentAnimalBinding.inflate(layoutInflater, container, false)
        return fragmentAnimalBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[AnimalViewModel::class.java]
            val movies = viewModel.getAnimal()

            val movieAdapter = AnimalAdapter()
            movieAdapter.setAnimal(movies)

            val marginVertical = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16f, resources.displayMetrics)

            with(fragmentAnimalBinding.rvMovies) {
                addItemDecoration(MarginItemDecoration(marginVertical.toInt()))
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                this.adapter = movieAdapter
            }
        }
    }

}