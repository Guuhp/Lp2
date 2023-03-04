package br.com.ifms.lp2.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ifms.lp2.Models.Student;
import br.com.ifms.lp2.Repositories.StudentRepository;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> listAll(){
        return studentRepository.findAll();
    }

    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    public Optional<Student> findById(Long id){
        return studentRepository.findById(id);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

}
