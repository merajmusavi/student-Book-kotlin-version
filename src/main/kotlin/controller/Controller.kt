package controller

import com.example.student.Book.kotlin.version.Student
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import service.Service

@RestController
class Controller(val apiService: Service) {


    @PostMapping("add")
    fun insertStudent(@RequestBody stu:Student ){
        apiService.insertUser(stu);
    }
}