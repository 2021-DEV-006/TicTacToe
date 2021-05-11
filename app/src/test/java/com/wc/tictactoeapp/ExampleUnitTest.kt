package com.wc.tictactoeapp

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

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
        assertEquals(playerName, "X")
    }

    @Test
    fun checkNextPlayerWithInputO() {
        val playerName = mainActivity.getPlayer("O")
        assertNotNull(playerName)
        assertEquals(playerName, "O")
    }

    @Test
    fun checkNextPlayerWithInputX() {
        val playerName = mainActivity.getPlayer("X")
        assertNotNull(playerName)
        assertEquals(playerName, "X")
    }

    @Test
    fun checkCellIdAddedInXList() {
        mainActivity.addSelectedCellInListforXO(1,"X")
        mainActivity.addSelectedCellInListforXO(2,"X")
        assertNotNull(mainActivity.playerXList)
        assertEquals(mainActivity.playerXList[0], 1)
        assertEquals(mainActivity.playerXList[1], 2)
    }

    @Test
    fun checkCellIdAddedInOList() {
        mainActivity.addSelectedCellInListforXO(9,"O")
        mainActivity.addSelectedCellInListforXO(8,"O")
        assertNotNull(this.mainActivity.playerOList)
        assertEquals(this.mainActivity.playerOList[0], 9)
        assertEquals(this.mainActivity.playerOList[1], 8)
    }

    @Test
    fun checkPlayerXWinsGame() {

    }
    @Test
    fun checkPlayerOWinsGame() {

    }

    @Test
    fun checkGameisDraw() {

    }



}