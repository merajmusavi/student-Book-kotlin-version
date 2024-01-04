package com.example.student.Book.kotlin.version

import jakarta.persistence.*


@Entity(name = "student_kt")
@Table(name = "student_kt"
, uniqueConstraints = [UniqueConstraint(name = "un_email", columnNames = ["email"])])
data class Student(



    @SequenceGenerator(name = "seq", sequenceName = "seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(
        name = "id",
        nullable = false
    )
    @Id
    val id: Long? = null,


    @Column(name = "first_name", nullable = false,)

    val firstName: String? = null,



    @Column(name = "email")
    var email: String? = null,


    @Column(name = "age")
    val age : Int

)

