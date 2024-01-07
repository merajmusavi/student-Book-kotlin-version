package com.example.student.book.kotlin.version

import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*


@Entity(name = "student_kt")
@Table(name = "student_kt"
, uniqueConstraints = [UniqueConstraint(name = "un_email", columnNames = ["email"])])
data class Student(



    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
        name = "id",
        nullable = false
    )
    @Id
    val id: Long? = null,


    @Column(name = "first_name")

    val firstName: String? = null,


    @JsonIgnore

    @OneToOne(mappedBy = "student", orphanRemoval = true)
    val idCard: StudentIdCard? = null,


    @JsonIgnore
    @OneToMany(mappedBy = "student", orphanRemoval = true, cascade = [CascadeType.PERSIST,CascadeType.REMOVE])
    var books : MutableList<Book>? = null,

    @Column(name = "email")
    var email: String? = null,


    @Column(name = "age")
    val age : Int? = null

){
    fun addBook(book: Book){
        if (books?.contains(book) == false){
            books?.add(book)
            book.student = this
        }
    }
    fun removeBook(book: Book){
        if (books?.contains(book) == true){
            books?.remove(book)
            book.student = null
        }
    }
}

