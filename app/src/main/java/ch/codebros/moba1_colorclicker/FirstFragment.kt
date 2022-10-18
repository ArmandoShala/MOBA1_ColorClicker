package ch.codebros.moba1_colorclicker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import ch.codebros.moba1_colorclicker.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
    private var buttons : MutableList<Button> = mutableListOf()
    private lateinit var amountOfButtons: MainActivity.Difficulty

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initTable()

        binding.buttonStart.setOnClickListener {
            // start game
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun initTable() {
        binding.tableLayout.removeAllViews()
        generateButtons()
        addButtonsToTable()
    }


    fun generateButtons() {
        // generate buttons
        for(i in 0..10) {
            val button = Button(context)
            button.text = "$i"
            button.id = i
            buttons.add(button)
        }
    }

    // add buttons to table
    fun addButtonsToTable() {
        buttons.forEach { btn -> binding.tableLayout.addView(btn) }
    }

    public fun setAmountOfButtons(amount: MainActivity.Difficulty) {
        amountOfButtons = amount
    }
    public fun getAmountOfButtons(): MainActivity.Difficulty {
        return amountOfButtons
    }


}