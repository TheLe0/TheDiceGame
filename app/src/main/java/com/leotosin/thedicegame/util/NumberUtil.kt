package com.leotosin.thedicegame.util

object NumberUtil
{
    const val ONE_DICE = 1
    const val TWO_DICE = 2

    fun rollDice() :Int
    {
        return  (1..6).random()
    }
}