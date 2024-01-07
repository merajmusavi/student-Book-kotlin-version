package com.example.student.book.kotlin.version

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.transaction.annotation.Transactional

interface StudentRepo : JpaRepository<Student, Long> {
    @Query("SELECT s FROM student_kt s where email= ?1")
    fun findUserByEmailAddress(email: String): Student? = null

    @Transactional
    @Modifying
    @Query("DELETE FROM student_kt s WHERE email =?1")
    fun deleteUserBasedOnEmail(email: String)
}