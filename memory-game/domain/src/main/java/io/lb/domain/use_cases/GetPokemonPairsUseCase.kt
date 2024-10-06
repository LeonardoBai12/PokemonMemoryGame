package io.lb.domain.use_cases

import io.lb.common.data.model.Pokemon
import io.lb.common.shared.flow.Resource
import io.lb.domain.repository.MemoryGameRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

/**
 * Use case to get a list of Pokemon pairs.
 *
 * @property repository The repository to fetch data from.
 */
class GetPokemonPairsUseCase @Inject constructor(
    private val repository: MemoryGameRepository
) {
    /**
     * Fetches a list of Pokemon pairs.
     *
     * @param amount The amount of Pokemon pairs to fetch.
     * @return A [Flow] of [Resource] of a list of [Pokemon] objects.
     */
    suspend operator fun invoke(amount: Int): Flow<Resource<List<Pokemon>>> = flow {
        emit(Resource.Loading())
        runCatching {
            val response = repository.getPokemonPairs(amount)
            emit(Resource.Success(response))
        }.getOrElse {
            emit(Resource.Error(it.message.toString()))
        }
    }
}
