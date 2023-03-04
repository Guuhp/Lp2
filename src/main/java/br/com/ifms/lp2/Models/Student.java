package br.com.ifms.lp2.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {
  @ApiModelProperty(value = "codigo do aluno")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ApiModelProperty(value = "nome do aluno")
  @Column()
  private String name;

  @ApiModelProperty(value = "email do aluno")
  @Column()
  @Email(message = "Digite um email valido")
  private String email;

  @ApiModelProperty(value = "senha do aluno")
  @Column()
  @NotBlank(message = "o valor nap pode esta vazio")
  private String password;
}
