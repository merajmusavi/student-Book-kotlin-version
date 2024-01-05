package com.example.student.Book.kotlin.version

import jakarta.persistence.*
import org.hibernate.engine.internal.Cascade

@Entity(name = "student_id_card_kt")
@Table(name = "student_id_card_kt_tb")
data class StudentIdCard(

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(
        name = "id",
        nullable = false
    )
    @Id
    val id: Long? = null,


    @Column(
        name = "student_id_card",
        length = 15,
        columnDefinition = "TEXT"
    )
    var cardNumber:String? = null,

    @OneToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "student_id",
        referencedColumnName = "id"
        )
    var student : Student? = null
)