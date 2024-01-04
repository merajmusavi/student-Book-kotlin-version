package com.example.student.Book.kotlin.version

import org.springframework.data.jpa.repository.JpaRepository

interface StudentRepo:JpaRepository<Student,Long> {
}