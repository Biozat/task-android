  package com.biozat.taskandroidhamzat

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.biozat.taskandroidhamzat.adapter.RecyclerViewAdapter
import com.biozat.taskandroidhamzat.network.RetrofitInstance
import com.biozat.taskandroidhamzat.network.RetrofitService
import com.biozat.taskandroidhamzat.repository.MemesRepository
import com.biozat.taskandroidhamzat.viewmodel.MemeViewModelFactory
import com.biozat.taskandroidhamzat.viewmodel.MemesViewModel

  private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [RecyclerListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class RecyclerListFragment : Fragment() {

    private lateinit var recyclerAdapter :  RecyclerViewAdapter
    private lateinit var memesViewModel: MemesViewModel
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_recycler_list, container, false)
        initViewModel(view)
        initViewModel()
        return view
    }

    private fun initViewModel(view: View){
      val recyclerView =  view.findViewById<RecyclerView>(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val decortion = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decortion)
        recyclerAdapter = RecyclerViewAdapter()
        recyclerView.adapter = recyclerAdapter
    }

    private fun initViewModel(){
        val retrofitInstance = RetrofitInstance.getRetrofitInstance().create(RetrofitService::class.java)

        val memesRepository = MemesRepository(retrofitInstance)
        memesViewModel = ViewModelProvider(this, MemeViewModelFactory(memesRepository)).get(MemesViewModel::class.java)

        memesViewModel.memes.observe(viewLifecycleOwner) {
            Log.d("TAG", "onCreate: ${it.toString()}")

                recyclerAdapter.setUpdatedData(it.data.memes)

//            recyclerAdapter.setUpdatedData(it.memes)
        }
        /*
            val viewModel = ViewModelProvider(this).get(MainActivtyViewmodel::class.java)
            viewModel.getRecyclerListObserver().observe(viewLifecycleOwner, Observer<RecyclerList>{
                if(it != null){
                  //    //  recyclerAdapter.setUpdatedData(it.memes)
                }else{
                    Toast.makeText(activity, "Error is getting data", Toast.LENGTH_SHORT).show()
                }
            })
            viewModel.makeApiCall()

            */
    }
    //  recyclerAdapter.setUpdatedData(it.memes)
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment RecyclerListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            RecyclerListFragment()
    }
}