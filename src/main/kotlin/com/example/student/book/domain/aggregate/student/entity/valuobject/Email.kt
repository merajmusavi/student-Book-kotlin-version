package com.example.student.book.domain.aggregate.student.entity.valuobject

import exceptions.EmailInvalidException
import java.lang.IllegalArgumentException
import java.util.regex.Pattern

data class Email private constructor(val value:String){

    companion object {
        fun makeNew(email: String): Result<Email> {

            return try {
                if (isEmailValid(email)){
                     Result.success(Email(email))
                } else {
                     Result.failure(EmailInvalidException("invalid name Exception"))
                }

            }catch (e:Throwable){
                 Result.failure(e)
            }

        }
       private fun isEmailValid(email: String): Boolean {
            val emailRegex = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})$"
            val pattern = Pattern.compile(emailRegex)
            return pattern.matcher(email).matches()
        }
    }



}