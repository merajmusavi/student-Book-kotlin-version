package com.example.student.book.kotlin.version

import org.springframework.stereotype.Service

@Service
class Service(val repo: StudentRepo, val idCardRepo: StudentIdCardRepo) {
    fun insertUser(stu: Student) {
        repo.save(stu)
    }

    fun findByEmail(email: String): Student? {
        return repo.findUserByEmailAddress(email)
    }

    fun findAllStudents(): List<Student> {
        return repo.findAll();
    }

    fun deleteUser(email: String) {

        val student = repo.findUserByEmailAddress(email)
        if (student == null)
            repo.deleteUserBasedOnEmail(email)
    }

    fun SaveIdCardAndStudent(idCard: StudentIdCard) {
        idCardRepo.save(idCard)
    }

    fun findBasedOnUserIdCard(get: String?): StudentIdCard {
        return idCardRepo.findByIdCard(get.toString())
    }
}