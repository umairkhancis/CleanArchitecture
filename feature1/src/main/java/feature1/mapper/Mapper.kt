package feature1.mapper

import com.noorifytech.core.dto.backend.Response
import feature1.dto.DataDto
import feature1.dto.DataVO

object Mapper {
    fun map(response: Response<String>) = DataDto(response.data)

    fun map(dataDto: DataDto) = DataVO(dataDto.value)
}