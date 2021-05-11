package com.wc.tictactoeapp

import com.wc.tictactoeapp.constants.Constants.Companion.gameDraw
import com.wc.tictactoeapp.constants.Constants.Companion.playerO
import com.wc.tictactoeapp.constants.Constants.Companion.playerOWin
import com.wc.tictactoeapp.constants.Constants.Companion.playerX
import com.wc.tictactoeapp.constants.Constants.Companion.playerXWin
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private val mainActivity = MainActivity()

    @Test
    fun checkFirstMoveInGameInvalidPlayer() {
        val playerName = mainActivity.getPlayer("Z")
        assertNull(playerName)
    }

    @Test
    fun checkFirstMoveInGame() {
        val playerName = mainActivity.getPlayer("")
        assertNotNull(playerName)
        assertEquals(playerName, playerX)
    }

    @Test
    fun checkNextPlayerWithInputO() {
        val playerName = mainActivity.getPlayer(playerO)
        assertNotNull(playerName)
        assertEquals(playerName, playerO)
    }

    @Test
    fun checkNextPlayerWithInputX() {
        val playerName = mainActivity.getPlayer(playerX)
        assertNotNull(playerName)
        assertEquals(playerName, playerX)
    }

    @Test
    fun checkCellIdAddedInXList() {
        mainActivity.addSelectedCellInListforPlayer(1, playerX)
        mainActivity.addSelectedCellInListforPlayer(2, playerX)
        assertNotNull(mainActivity.playerXList)
        assertEquals(mainActivity.playerXList[0], 1)
        assertEquals(mainActivity.playerXList[1], 2)
    }

    @Test
    fun checkCellIdAddedInOList() {
        mainActivity.addSelectedCellInListforPlayer(9,playerO)
        mainActivity.addSelectedCellInListforPlayer(8,playerO)
        assertNotNull(this.mainActivity.playerOList)
        assertEquals(this.mainActivity.playerOList[0], 9)
        assertEquals(this.mainActivity.playerOList[1], 8)
    }


    @Test
    fun checkPlayerXWinsGameInRow() {
        mainActivity.addSelectedCellInListforPlayer(1, playerX)
        mainActivity.addSelectedCellInListforPlayer(2, playerX)
        mainActivity.addSelectedCellInListforPlayer(3, playerX)
        val playerWin = mainActivity.checkGameStatus(mainActivity.currentOrNextPlayer)
        assertNotNull(playerWin)
        assertEquals(playerWin, playerXWin)

    }

    @Test
    fun checkPlayerXWinsGameInColumn() {
        mainActivity.addSelectedCellInListforPlayer(1, playerX)
        mainActivity.addSelectedCellInListforPlayer(4, playerX)
        mainActivity.addSelectedCellInListforPlayer(7, playerX)
        val playerWin = mainActivity.checkGameStatus(mainActivity.currentOrNextPlayer)
        assertNotNull(playerWin)
        assertEquals(playerWin, playerXWin)

    }

    @Test
    fun checkPlayerXWinsGameinDiagonal() {
        mainActivity.addSelectedCellInListforPlayer(3, playerX)
        mainActivity.addSelectedCellInListforPlayer(5, playerX)
        mainActivity.addSelectedCellInListforPlayer(7, playerX)
        val playerWin = mainActivity.checkGameStatus(mainActivity.currentOrNextPlayer)
        assertNotNull(playerWin)
        assertEquals(playerWin, playerXWin)

    }

    @Test
    fun checkplayerOWinsGameinRow() {
        mainActivity.addSelectedCellInListforPlayer(4, playerO)
        mainActivity.addSelectedCellInListforPlayer(5, playerO)
        mainActivity.addSelectedCellInListforPlayer(6, playerO)
        val playerWin = mainActivity.checkGameStatus(mainActivity.currentOrNextPlayer)
        assertNotNull(playerWin)
        assertEquals(playerWin, playerOWin)
    }

    @Test
    fun checkPlayerOWinsGameinColumn() {
        mainActivity.addSelectedCellInListforPlayer(2, playerO)
        mainActivity.addSelectedCellInListforPlayer(5, playerO)
        mainActivity.addSelectedCellInListforPlayer(8, playerO)
        val playerWin = mainActivity.checkGameStatus(mainActivity.currentOrNextPlayer)
        assertNotNull(playerWin)
        assertEquals(playerWin, playerOWin)

    }

    @Test
    fun checkplayerOWinsGameInDiagonal() {
        mainActivity.addSelectedCellInListforPlayer(1, playerO)
        mainActivity.addSelectedCellInListforPlayer(5, playerO)
        mainActivity.addSelectedCellInListforPlayer(9, playerO)
        val playerWin = mainActivity.checkGameStatus(mainActivity.currentOrNextPlayer)
        assertNotNull(playerWin)
        assertEquals(playerWin, playerOWin)
    }



    @Test
    fun checkGameisDraw() {
        mainActivity.addSelectedCellInListforPlayer(1, playerX)
        mainActivity.addSelectedCellInListforPlayer(2, playerO)
        mainActivity.addSelectedCellInListforPlayer(5, playerX)
        mainActivity.addSelectedCellInListforPlayer(3, playerO)
        mainActivity.addSelectedCellInListforPlayer(4, playerO)
        mainActivity.addSelectedCellInListforPlayer(9, playerO)
        mainActivity.addSelectedCellInListforPlayer(6, playerX)
        mainActivity.addSelectedCellInListforPlayer(8, playerX)
        mainActivity.addSelectedCellInListforPlayer(7, playerX)

        val playerWin = mainActivity.checkGameStatus(mainActivity.currentOrNextPlayer)
        assertNotNull(playerWin)
        assertEquals(playerWin, gameDraw)
    }

    @Test
    fun checkGameContinuesForPlayerX() {
        mainActivity.addSelectedCellInListforPlayer(1, playerX)
        mainActivity.addSelectedCellInListforPlayer(5, playerO)
        val nextPlayer= mainActivity.checkGameStatus(mainActivity.currentOrNextPlayer)
        assertNotNull(nextPlayer)
        assertEquals(nextPlayer, playerX)
    }

    @Test
    fun checkGameContinuesForPlayerO() {
        mainActivity.addSelectedCellInListforPlayer(2, playerX)
        mainActivity.addSelectedCellInListforPlayer(4, playerX)
        val nextPlayer= mainActivity.checkGameStatus(mainActivity.currentOrNextPlayer)
        assertNotNull(nextPlayer)
        assertEquals(nextPlayer, playerO)
    }

    @Test
    fun checkGameContinuesForLastTurnForPlayerX() {
        mainActivity.addSelectedCellInListforPlayer(1, playerX)
        mainActivity.addSelectedCellInListforPlayer(2, playerO)
        mainActivity.addSelectedCellInListforPlayer(5, playerX)
        mainActivity.addSelectedCellInListforPlayer(3, playerO)
        mainActivity.addSelectedCellInListforPlayer(6, playerX)
        mainActivity.addSelectedCellInListforPlayer(4, playerO)
        mainActivity.addSelectedCellInListforPlayer(8, playerX)
        mainActivity.addSelectedCellInListforPlayer(7, playerO)
        val nextPlayer= mainActivity.checkGameStatus(mainActivity.currentOrNextPlayer)
        assertNotNull(nextPlayer)
        assertEquals(nextPlayer, playerX)
    }

}