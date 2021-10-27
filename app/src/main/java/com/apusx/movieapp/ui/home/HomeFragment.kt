package com.apusx.movieapp.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.apusx.movieapp.Adapters.CustomAdapter
import com.apusx.movieapp.Models.FilmsModel
import com.apusx.movieapp.Models.Item
import com.apusx.movieapp.databinding.FragmentHomeBinding
import com.apusx.movieapp.Services.Common
import com.apusx.movieapp.Services.RetrofitServices
import dmax.dialog.SpotsDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!



    lateinit var mService: RetrofitServices
    lateinit var dialog: AlertDialog

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        val recycler: RecyclerView = binding.recyclerHome
        recycler.layoutManager = LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        dialog = SpotsDialog.Builder().setCancelable(true).setContext(context).build()

        mService = Common.retrofitService

        dialog.show()
        mService.get250topmovies().enqueue(object : Callback<FilmsModel> {

            override fun onResponse(
                call: Call<FilmsModel>,
                response: Response<FilmsModel>
            ) {

                Log.d("Retrofit",response.code().toString())

                if( response.isSuccessful){
                    dialog.dismiss()
                    Log.d("Retrofit",response.body()?.items?.size.toString())

                    var response_data = response.body()?.items
                    if (response_data != null) {
                        recycler.adapter =
                            context?.let { CustomAdapter(response_data.toMutableList(), it) }
                    }

                }
            }


            override fun onFailure(call: Call<FilmsModel>, t: Throwable) {
                Log.d("RETROFIT",t.localizedMessage)

            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

