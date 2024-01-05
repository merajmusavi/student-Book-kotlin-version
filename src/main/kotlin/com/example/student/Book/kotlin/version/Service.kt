package com.example.student.Book.kotlin.version

import com.example.student.Book.kotlin.version.Student
import com.example.student.Book.kotlin.version.StudentRepo
import org.springframework.stereotype.Service

@Service
class Service(val repo: StudentRepo,val idCardRepo : StudentIdCardRepo) {
    fun insertUser(stu: Student) {
        repo.save(stu)
    }

    fun findByEmail(email: String): Student {
        return repo.findUserByEmailAddress(email)
    }

    fun findAllStudents(): List<Student> {
        return repo.findAll();
    }

    fun deleteUser(email: String) {
        repo.deleteUserBasedOnEmail(email)
    }
    fun SaveIdCardAndStudent(idCard: StudentIdCard){
        idCardRepo.save(idCard)
    }
}