package com.example.student.book.kotlin.version

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.ForeignKey
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import java.time.LocalDateTime

@Entity(name = "book")
@Table(name = "book")
data class Book(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = null,

    @Column(name = "created_at", nullable = true, columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    val creationDate: LocalDateTime? = null,
    @Column(name = "bookName", nullable = false)
    val bookName:String? = null,

    @ManyToOne
    @JoinColumn(
        name = "student_id",
        nullable = false,
        referencedColumnName = "id",
        foreignKey = ForeignKey(name = "fk_stu_book" )
    )
    var student: Student? = null
)