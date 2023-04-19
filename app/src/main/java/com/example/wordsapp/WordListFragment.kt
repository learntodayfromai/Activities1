package com.example.wordsapp
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.wordsapp.databinding.FragmentWordListBinding

class WordListFragment : Fragment() {
    private var _binding : FragmentWordListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView : RecyclerView

    companion object{
        const val LETTER = "letter"
        const val SEARCH_PREFIX = "https://www.google.com/search?q="
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWordListBinding.inflate(inflater,container,false)
        return(binding.root)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val letter = activity?.intent?.extras?.getString(LETTER) ?: "A"
        recyclerView = binding.recyclerView
        recyclerView.layoutManager=LinearLayoutManager(this.requireContext())
        recyclerView.adapter=WordAdapter(letter,this.requireContext())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}