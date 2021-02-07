package com.leotosin.thedicegame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = MainViewModel()
    }

    fun rollDices(view : View)
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