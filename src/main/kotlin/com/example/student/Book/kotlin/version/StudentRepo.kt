package com.example.student.Book.kotlin.version

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface StudentRepo:JpaRepository<Student,Long> {
    @Query("SELECT s FROM student_kt s where email= ?1")
    fun findUserByEmailAddress(email:String): Student
}