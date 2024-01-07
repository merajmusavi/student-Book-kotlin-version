package com.example.student.book.domain.aggregate.book.entity.valueobject

import org.springframework.data.annotation.CreatedDate
import java.time.LocalDate
import java.time.LocalDateTime

data class CreationDate private constructor(val value: LocalDateTime) {

    companion object {
        fun makeNew(dateString: String): Result<CreationDate> {
            return try {

                val pareDate = LocalDateTime.parse(dateString)
                isValidDate(pareDate)

                Result.success(CreationDate(pareDate))
            } catch (e: Exception) {
                Result.failure(InvalidDateEnteredException("invalid format"))
            }
        }


        private fun isValidDate(date : LocalDateTime) {
            if (date.isBefore(LocalDateTime.now())){
                throw InvalidDateEnteredException("invalid date exception")
            }
        }
    }
    class InvalidDateEnteredException(message: String) : Exception(message)

}

