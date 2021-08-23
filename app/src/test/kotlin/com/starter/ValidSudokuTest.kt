package com.starter

import org.amshove.kluent.`should equal`
import org.junit.jupiter.api.Test

class ValidSudokuTest {

    /*
    Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

    Each row must contain the digits 1-9 without repetition.
    Each column must contain the digits 1-9 without repetition.
    Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

     */
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val seen = mutableSetOf<String>()
        for (rowIndex in 0..8) {
            for (columnIndex in 0..8) {
                if (board[rowIndex][columnIndex] != '.') {
                    if(
                        !seen.add("found ${board[rowIndex][columnIndex]} at row $rowIndex") ||
                        !seen.add("found ${board[rowIndex][columnIndex]} at column $columnIndex") ||
                        !seen.add("found ${board[rowIndex][columnIndex]} at cube ${rowIndex / 3} - ${columnIndex/3}")
                    ) {
                        return false
                    }
                }
            }
        }
        return true
    }

    @Test
    internal fun name() {
        val board = arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )

        isValidSudoku(board) `should equal` true
    }
}