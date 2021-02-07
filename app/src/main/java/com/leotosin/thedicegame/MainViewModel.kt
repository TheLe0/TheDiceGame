package com.leotosin.thedicegame

import androidx.lifecycle.ViewModel
import com.leotosin.thedicegame.model.Dice

class MainViewModel : ViewModel()
{
    fun getDiceValue() :Int
    {
        val dice = Dice()

        return dice.value
    }

}