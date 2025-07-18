package io.lb.domain.repository

import io.lb.common.data.model.AstorCard
import io.lb.common.data.model.Score
import io.lb.common.shared.error.MemoryGameException

/**
 * Repository for the Memory Game.
 */
interface MemoryGameRepository {
    /**
     * Get a list of Astor pairs.
     *
     * @param amount the amount of Astor pairs to get.
     *
     * @return a list of Astor pairs.
     */
    suspend fun getAstorPairs(amount: Int): List<AstorCard>

    /**
     * Get a list of scores.
     *
     * @return a list of scores.
     */
    suspend fun getScores(): List<Score>

    /**
     * Get a list of scores by amount of cards.
     *
     * @param amount the amount of cards in the game.
     */
    suspend fun getScoresByAmount(amount: Int): List<Score>

    /**
     * Insert a score into the database.
     *
     * @param score the score to insert.
     */
    @Throws(MemoryGameException::class)
    suspend fun insertScore(score: Int, amount: Int)
}
