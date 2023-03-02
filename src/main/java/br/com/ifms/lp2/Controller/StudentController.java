package br.com.ifms.lp2.Controller;

import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.NotFound;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifms.lp2.Models.Student;
import br.com.ifms.lp2.Service.StudentService;
import net.bytebuddy.implementation.ExceptionMethod;

@Controller
@RestController
@RequestMapping(value = "students")
public class StudentController {

  @Autowired
  private StudentService studentService;
  
  @GetMapping("/list")
  public List<Student> listStudents(){
    return studentService.listAll();
  }

  @PostMapping("/create")
  public Student createStudent(@RequestBody Student student){
    return studentService.createStudent(student);
  }

  @GetMapping("/find/{id}")
  public Optional<Student> findById(@PathVariable("id")Long id){
    return studentService.findById(id);
  }

  @DeleteMapping("/delete/{id}")
  public String deleteStudent(@PathVariable("id")Long id){
    return studentService.deleteStudent(id);
  }

  @PutMapping("/update/{id}")
  public Student updateStudent(@PathVariable("id")Long id, @RequestBody Student student){
    Optional<Student> studentById = studentService.findById(id);
    if(studentById.isPresent()){
    }
    var newstudent = new Student();
    BeanUtils.copyProperties(student, newstudent);

    return studentService.createStudent(newstudent);

  }

}
