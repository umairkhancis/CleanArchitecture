package feature1.exception

import com.noorifytech.shared.exception.AppException

class FetchDataException(code: Int, msg: String) : AppException(code, msg)