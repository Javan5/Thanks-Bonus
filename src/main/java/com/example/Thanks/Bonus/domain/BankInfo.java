package com.example.Thanks.Bonus.domain;

import com.example.Thanks.Bonus.repository.DateAndTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@ToString(of = {"id", "text"})
@EqualsAndHashCode(of = {"id"})
public class BankInfo {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@JsonView(Views.IdName.class)
	private Long id;
	@JsonView(Views.IdName.class)
	private String text;

	@Column(updatable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateAndTime.DEFAULT_PRESENTATION_BUSINESS_DATE_TIME_PATTERN)
	@JsonView(Views.FullDateBankInfo.class)
	private LocalDateTime dateTime;

}
