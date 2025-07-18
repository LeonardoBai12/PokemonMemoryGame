package io.lb.domain.usecases

import io.lb.common.data.model.Score
import io.lb.common.shared.flow.Resource
import io.lb.domain.repository.MemoryGameRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Use case to get a list of scores.
 *
 * @property repository The repository to fetch data from.
 */
class GetScoresByAmountUseCase @Inject constructor(
    private val repository: MemoryGameRepository
) {
    /**
     * Fetches a list of scores.
     *
     * @param amount The amount of cards in the game.
     *
     * @return A [Flow] of [Resource] of a list of [Score] objects.
     */
    operator fun invoke(amount: Int): Flow<Resource<List<Score>>> = flow {
        emit(Resource.Loading())
        runCatching {
            val scores = repository.getScoresByAmount(amount)
            emit(Resource.Success(scores))
        }.getOrElse {
            emit(Resource.Error(it.message.toString()))
        }
    }
}
