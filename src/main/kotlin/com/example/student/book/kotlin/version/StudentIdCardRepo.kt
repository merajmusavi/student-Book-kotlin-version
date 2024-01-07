package com.example.student.book.kotlin.version

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface StudentIdCardRepo : JpaRepository<StudentIdCard,Long>{


    @Query("SELECT s FROM student_id_card_kt s JOIN s.student WHERE s.cardNumber = ?1")
    fun findByIdCard(idcard:String) : StudentIdCard
}