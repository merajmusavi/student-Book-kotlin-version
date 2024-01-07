package com.example.student.book.domain.aggregate.book.entity.valueobject

import exceptions.InvalidIdCardException

data class Name private constructor(val value: String){
    companion object{
       private fun issValidName(name:String):Boolean{
           // at least two chars and maximum 20 chars. it contain digits and characters

           val nameRegex = """^[a-zA-Z0-9]{2,20}$""".toRegex()

          return name.matches(nameRegex)
       }
        fun makeNew(name:String):Result<Name>{
         return if (issValidName(name)){
                 Result.success(Name(name))
            }else{
                Result.failure(InvalidBookException("invalid Book"))
            }
        }
    }
    class InvalidBookException(message: String) : Exception(message)
}
