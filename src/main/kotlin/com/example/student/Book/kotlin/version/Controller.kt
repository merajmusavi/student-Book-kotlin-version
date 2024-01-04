package com.example.student.Book.kotlin.version

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
    fun insertStudent(@RequestBody stu: Student){
        apiService.insertUser(stu);
    }

    @GetMapping("findByEmail/{email}")
    fun findStudentByEmail(@PathVariable email: String): Student {
       return apiService.findByEmail(email);
    }

    @GetMapping("all")
    fun findAllUsers():List<Student>{
        return apiService.findAllStudents();
    }

    @DeleteMapping
    fun deleteUser(map : Map<String,String>){
        return apiService.deleteUser(map.get("email"));
    }
}