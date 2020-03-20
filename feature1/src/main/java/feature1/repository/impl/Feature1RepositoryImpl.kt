package feature1.repository.impl

import com.noorifytech.core.datasource.backend.BackendDataSource
import feature1.dto.DataDto
import feature1.mapper.Mapper
import feature1.repository.Feature1Repository

class Feature1RepositoryImpl(
    private val backendDataSource: BackendDataSource,
    private val mapper: Mapper = Mapper
) : Feature1Repository {

    override suspend fun getData(): DataDto {
        val response = backendDataSource.getData()
        return mapper.map(response)
    }
}