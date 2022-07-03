package com.example.demo.models;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@NoArgsConstructor
@Getter
@Setter
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(name = "email", unique = true)
  private String email;
  private String password;
  @Column(name = "phone_number", unique = true)
  private String phoneNumber;
  private String name;
  @OneToMany(mappedBy = "reservedByUser")
  private List<Book> reservedBooks;
  @OneToMany(mappedBy = "theUser")
  private List<Book> books;
}
