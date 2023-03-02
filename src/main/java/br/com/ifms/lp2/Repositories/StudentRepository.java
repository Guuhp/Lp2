package br.com.ifms.lp2.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.ifms.lp2.Models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
  
}
