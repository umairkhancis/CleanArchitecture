package feature1.repository

import feature1.dto.DataDto

interface Feature1Repository {
    suspend fun getData(): DataDto
}