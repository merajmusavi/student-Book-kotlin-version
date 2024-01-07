package com.example.student.book.kotlin.version

import com.example.student.book.domain.aggregate.student.entity.StudentEn
import com.fasterxml.jackson.databind.util.JSONPObject
import exceptions.EmailInvalidException
import exceptions.FirstNameInvalidException
import exceptions.InvalidIdCardException
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("api/v1")
class Controller(val apiService: Service) {


    @PostMapping("/add")
    fun insertStudent(@RequestBody stu: Student) {
        apiService.insertUser(stu);
    }

    @GetMapping("findByEmail/{email}")
    fun findStudentByEmail(@PathVariable email: String): Student? {
        return apiService.findByEmail(email);
    }

    @GetMapping("all")
    fun findAllUsers(): List<Student> {
        return apiService.findAllStudents();
    }

    @DeleteMapping
    fun deleteUser(map: Map<String, String>) {
        return apiService.deleteUser(map.get("email").toString());
    }

    @PostMapping("idcard")
    fun InsertStudentWithIdCard(@RequestBody stu: StudentIdCard) {
        apiService.SaveIdCardAndStudent(stu)
        println(stu.cardNumber)
        println(stu.student?.id.toString())
    }

    @PostMapping("findByCardNumber")
    fun findByCardNumber(@RequestBody map: Map<String, String>): StudentIdCard {
        return apiService.findBasedOnUserIdCard(map.get("card"));
    }

    @GetMapping("test")
    fun testStudentEn(): Any {
        try {
            val result = StudentEn.makeNew("validgmail.com", "hbvhjed", "09434505942")
            if (result.isFailure) {
                throw result.exceptionOrNull()!!
            }

            val email = result.getOrNull()?.email!!.value.toString() // Safe accessor to ensure result is not null
            val firstName = result.getOrNull()?.firstName!!.value
            val idCard = result.getOrNull()?.idCardValidator!!.value

            val student = StudentDataClass(
                name = firstName,
                email = email,
                idCard = idCard
            )
            return student
        } catch (e: EmailInvalidException) {
            return "Invalid email: ${e.message}"
        } catch (e: FirstNameInvalidException) {
            return "Invalid first name: ${e.message}"
        } catch (e: InvalidIdCardException) {
            return "Invalid user ID card: ${e.message}"
        } catch (e: Exception) {
            return "Unknown validation error: ${e.message}"
        }
    }




}