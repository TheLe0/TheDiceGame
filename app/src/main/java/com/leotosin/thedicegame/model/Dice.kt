package com.leotosin.thedicegame.model

import com.leotosin.thedicegame.util.NumberUtil

data class Dice (val value: Int = NumberUtil.rollDice())
