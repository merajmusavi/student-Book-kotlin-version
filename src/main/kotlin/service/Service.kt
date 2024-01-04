package service

import com.example.student.Book.kotlin.version.Student
import com.example.student.Book.kotlin.version.StudentRepo
import org.springframework.stereotype.Service

@Service
class Service(val repo : StudentRepo) {
    fun insertUser(stu: Student) {
        repo.save(stu)
    }
}