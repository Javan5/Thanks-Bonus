package com.example.Thanks.Bonus.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
public class bankInfo {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	private String text;

}
