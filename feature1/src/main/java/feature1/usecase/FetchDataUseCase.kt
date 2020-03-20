package feature1.usecase

import feature1.dto.DataVO

interface FetchDataUseCase {
    suspend fun fetchData(): DataVO
}