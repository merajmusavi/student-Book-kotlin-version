package com.example.student.book.domain.aggregate.student.entity

import com.example.student.book.domain.aggregate.student.entity.valuobject.Email
import com.example.student.book.domain.aggregate.student.entity.valuobject.FirstName
import com.example.student.book.domain.aggregate.student.entity.valuobject.IdCard
import exceptions.EmailInvalidException
import exceptions.FirstNameInvalidException
import exceptions.InvalidIdCardException
import java.lang.Exception
import java.lang.IllegalArgumentException

class StudentEn private constructor() {


    lateinit var email: Email;

    lateinit var firstName: FirstName

    lateinit var idCardValidator: IdCard


    private constructor(email: Email, firstName: FirstName, idCardValidator: IdCard):this()
    {
        this.email = email
        this.firstName = firstName
        this.idCardValidator = idCardValidator

    }
    companion object {



        fun makeNew(email: String, firstName: String, userIdCard: String): Result<StudentEn> {

                val emailResult = Email.makeNew(email)
                val firstNameResult = FirstName.makeNew(firstName)
                val idCardResult = IdCard.makeNew(userIdCard)

             return  if (emailResult.isSuccess && firstNameResult.isSuccess && idCardResult.isSuccess) {
                    Result.success(
                        StudentEn(
                            emailResult.getOrNull()!!,
                            firstNameResult.getOrNull()!!,
                            idCardResult.getOrNull()!!
                        )
                    )
                } else if (emailResult.isFailure) {
                    Result.failure(EmailInvalidException("Invalid Email Address"))
                } else if (firstNameResult.isFailure) {
                    Result.failure(FirstNameInvalidException("Invalid firstName"))

                } else if (idCardResult.isFailure) {
                    Result.failure(InvalidIdCardException("Invalid user ID card"))

                } else {
                    Result.failure(Exception("unrecognizable Error for Validation"))
                }
            }
        }
    }

