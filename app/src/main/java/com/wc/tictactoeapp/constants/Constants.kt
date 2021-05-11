package com.wc.tictactoeapp.constants

class Constants {

    companion object {

        const val playerX = "X"
        const val playerO = "O"

        const val playerXWin = "XWin"
        const val playerOWin = "OWin"
        const val gameDraw = "gameDraw"

        val combinationsToWin: List<List<Int>> = listOf(
            listOf(1, 2, 3),
            listOf(4, 5, 6),
            listOf(7, 8, 9),
            listOf(1, 4, 7),
            listOf(2, 5, 8),
            listOf(3, 6, 9),
            listOf(1, 5, 9),
            listOf(3, 5, 7)
        )

    }
}