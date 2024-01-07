package com.example.student.book.domain.aggregate.student.entity.valuobject

import exceptions.FirstNameInvalidException
import java.lang.IllegalArgumentException

class FirstName private constructor(val value : String)
{

    companion object {



        // at least 3 char and max char is 15
        private fun isValidName(firstName: String):Boolean{

            val firstNameRegex = "^[A-Za-z]{3,15}$"
            return firstName.matches(firstNameRegex.toRegex())
        }

        private fun validateFirstName(firstName: String){
            if (!isValidName(firstName)){
                throw FirstNameInvalidException("invalid name")
            }
        }

       internal fun makeNew(firstName:String):Result<FirstName>{

           return try {
               validateFirstName(firstName)
               Result.success(FirstName(firstName))
           }catch (e: Throwable){
               Result.failure( IllegalArgumentException(""))
           }
        }
    }




}