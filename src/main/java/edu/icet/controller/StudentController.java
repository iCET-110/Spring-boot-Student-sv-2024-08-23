package edu.icet.controller;

import edu.icet.dto.Student;
import edu.icet.service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/student")
@RequiredArgsConstructor
@Slf4j
public class StudentController {

    final StudentService service;

    @GetMapping
    public Map getStudents() {
        return service.getStudent();
    }
    @PostMapping
    public void addStudent(@RequestBody Student student,
                           HttpServletRequest request)  {

        String os = request.getHeader("sec-ch-ua");


        log.info("Request Received  {} {}",student,os);
        service.addStudent(student);
    }













    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Integer id){
        service.deleteStudentById(id);
    }
    @PutMapping
    public void updateStudent(@RequestBody Student student){
        service.addStudent(student);
    }

    @GetMapping("/find-by-name/{name}")
    public List<Student> findByName(@PathVariable String name){
        return service.findByName(name);
    }
}
