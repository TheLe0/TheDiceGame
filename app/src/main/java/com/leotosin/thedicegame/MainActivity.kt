package com.leotosin.thedicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.leotosin.thedicegame.util.NumberUtil

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = MainViewModel()

        this.populateSpinner()

        val numberOfDices : Spinner = findViewById(R.id.spin_num_of_dices)
        numberOfDices.onItemSelectedListener = object : AdapterView.OnItemSelectedListener
        {
            val button : FloatingActionButton = findViewById(R.id.btn_roll)

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long)
            {
                val item :String = numberOfDices.selectedItem.toString()
                val dice :ImageView = findViewById(R.id.ic_dice_two)

                when (item.toInt())
                {
                    NumberUtil.ONE_DICE ->
                    {
                        dice.visibility = View.GONE
                    }
                    NumberUtil.TWO_DICE ->
                    {
                        dice.visibility = View.VISIBLE
                    }
                }

                button.requestFocus()
            }

            override fun onNothingSelected(parent: AdapterView<*>?)
            {
                button.requestFocus()
            }

        }

    }

    fun rollDices(view : View)
    {
        if (view.id == R.id.btn_roll)
        {
            val diceOne :ImageView = findViewById(R.id.ic_dice_one)
            val diceTwo : ImageView = findViewById(R.id.ic_dice_two)

            when (viewModel.getDiceValue())
            {
                1 -> diceOne.setImageResource(R.drawable.dice_1)
                2 -> diceOne.setImageResource(R.drawable.dice_2)
                3 -> diceOne.setImageResource(R.drawable.dice_3)
                4 -> diceOne.setImageResource(R.drawable.dice_4)
                5 -> diceOne.setImageResource(R.drawable.dice_5)
                6 -> diceOne.setImageResource(R.drawable.dice_6)
            }

            when (viewModel.getDiceValue())
            {
                1 -> diceTwo.setImageResource(R.drawable.dice_1)
                2 -> diceTwo.setImageResource(R.drawable.dice_2)
                3 -> diceTwo.setImageResource(R.drawable.dice_3)
                4 -> diceTwo.setImageResource(R.drawable.dice_4)
                5 -> diceTwo.setImageResource(R.drawable.dice_5)
                6 -> diceTwo.setImageResource(R.drawable.dice_6)
            }
        }
    }

    private fun populateSpinner()
    {
        val adapter : ArrayAdapter<String> = ArrayAdapter(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                viewModel.numberOfDices()
        )

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item)

        val numberOfDices : Spinner = findViewById(R.id.spin_num_of_dices)
        numberOfDices.adapter = adapter
    }
}