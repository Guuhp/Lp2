package br.com.ifms.lp2.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

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
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RestController
@RequestMapping(value = "students")
public class StudentController {

  @Autowired
  private StudentService studentService;
  
  @ApiResponses(value = {
    @ApiResponse(code = 200, message = "Alunos Listado com Sucesso"),
    @ApiResponse(code = 403, message = "Voce nao tem permissao para este recurso"),
    @ApiResponse(code = 500, message = "Foi Gerado excecao"),
  })
  @GetMapping("/list")
  public List<Student> listStudents(){
    return studentService.listAll();
  }

  
  @PostMapping("/create")
  public Student createStudent(@RequestBody @Valid Student student){
    return studentService.createStudent(student);
  }

  @GetMapping("/find/{id}")
  public Optional<Student> findById(@PathVariable("id")Long id){
    return studentService.findById(id);
  }

  @DeleteMapping("/delete/{id}")
  public void deleteStudent(@PathVariable("id")Long id) throws Exception{
    Optional<Student> student = studentService.findById(id);
    if(student.get().getId() > 0){
      studentService.deleteStudent(id);
    }else{
      System.out.println("Não Encontrado");
      throw new Exception("Id não encontrado");
    }
    
  }

  @PutMapping("/update/{id}")
  public Student updateStudent(@PathVariable("id")Long id, @RequestBody Student student) throws Exception{
    Optional<Student> studentById = studentService.findById(id);
    if(!studentById.isPresent()){
      throw new Exception("Id não encontrado");
    }
    var newstudent = new Student();
    BeanUtils.copyProperties(student, newstudent);

    return studentService.createStudent(newstudent);

  }

}
