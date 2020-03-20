package feature1.usecase.impl

import com.noorifytech.core.domain.Data
import com.noorifytech.shared.exception.AppException
import feature1.dto.DataDto
import feature1.dto.DataVO
import feature1.exception.FetchDataException
import feature1.mapper.Mapper
import feature1.repository.Feature1Repository
import feature1.usecase.FetchDataUseCase

class FetchDataUseCaseImpl(
    private val repository: Feature1Repository,
    private val mapper: Mapper = Mapper
) : FetchDataUseCase {

    override suspend fun fetchData(): DataVO {
        try {
            val rawData = repository.getData()

            // Perform business logic.
            val transformedData = transformData(rawData)

            // Convert data in the form conformable to the caller.
            return mapper.map(transformedData)
        } catch (e: FetchDataException) {
            throw AppException(e.code, e.msg)
        }
    }

    private fun transformData(rawData: DataDto) = DataDto(Data(rawData.value).reversed())
}