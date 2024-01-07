package com.example.student.book.kotlin.version
import com.example.student.book.domain.aggregate.student.entity.StudentEn
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.time.Instant

@SpringBootApplication
class StudentBookKotlinVersionApplication

fun main(args: Array<String>) {
	runApplication<StudentBookKotlinVersionApplication>(*args)


}
