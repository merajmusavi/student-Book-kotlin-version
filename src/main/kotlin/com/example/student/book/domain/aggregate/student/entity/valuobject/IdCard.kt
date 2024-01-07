package com.example.student.book.domain.aggregate.student.entity.valuobject

import exceptions.InvalidIdCardException
import java.lang.Exception
import java.lang.IllegalArgumentException

class IdCard private constructor(val value: String) {


    companion object {
        internal fun makeNew(idCard: String):Result<IdCard> {

           return try {

                validatedIdCard(idCard)

                Result.success(IdCard(idCard))


            }catch (e:Exception){
               Result.failure( IllegalArgumentException("invalid Id card Exception"))
            }
        }

        private fun validatedIdCard(idCard: String){
            if (!isValidCard(idCard)){
                throw InvalidIdCardException("invalid name")
            }
        }

        private fun isValidCard(idCard:String):Boolean{
            val idCardRegex = "^[0-9]{10,15}$"

            return idCard.matches(idCardRegex.toRegex())

        }
    }
}