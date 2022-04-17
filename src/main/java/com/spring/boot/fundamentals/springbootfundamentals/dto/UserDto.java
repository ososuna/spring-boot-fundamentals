package com.spring.boot.fundamentals.springbootfundamentals.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class UserDto {

  private Long id;
  private String name;
  private LocalDate birthDate; 

}
