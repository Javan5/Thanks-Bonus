package com.example.Thanks.Bonus.domain.User;

import com.example.Thanks.Bonus.domain.Views;
import com.example.Thanks.Bonus.repository.DateAndTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class User {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;

	@NotNull
	@Column(name = "NAME")
	private String Name;

	@Nullable
	@Column(name = "PATRONYMIC")
	private String Patronymic;

	@NotNull
	@Column(name = "SURNAME")
	private String Surname;

	@NotNull
	@Column(name = "DATEOFBIRTH")
	private LocalDateTime dateOfBirth;

	@NotNull
	@Column(name = "DATEOFREGISTER")
	private LocalDateTime dateTimeOfRegister;

	@NotNull
	@Column(name = "ROLE")
	@Enumerated(EnumType.STRING)
	private RoleEnum role;
}
