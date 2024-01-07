package com.example.student.book.domain.aggregate.book.entity.valueobject

import org.springframework.data.annotation.CreatedDate
import java.lang.IllegalArgumentException
import java.time.LocalDateTime

class BookEn private constructor() {
    lateinit var bookName: Name;
    lateinit var creationDate: CreationDate

    constructor(bookName: Name, creationDate: CreationDate) : this() {
        this.bookName = bookName
        this.creationDate = creationDate
    }


    companion object {
        fun makeNew(name: String, localDateTime: String): Result<BookEn> {
            val nameResult = Name.makeNew(name)
            val dateResult = CreationDate.makeNew(localDateTime)

            return if (nameResult.isSuccess && dateResult.isSuccess) {
                Result.success(BookEn(nameResult.getOrNull()!!, dateResult.getOrNull()!!))
            } else if (nameResult.isFailure) {
                Result.failure(Name.InvalidBookException("invalid data"))
            } else if (dateResult.isFailure) {
                Result.failure(CreationDate.InvalidDateEnteredException("invalid data"))
            } else {
                Result.failure(IllegalArgumentException("un recognizable error"))
            }
        }
    }
}
