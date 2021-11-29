package com.example.Thanks.Bonus.domain.products.creditCard;

import com.example.Thanks.Bonus.domain.Views;
import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CREDITCARD")
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class CreditCards {


	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@NotNull
	@Column(name = "NAME")
	private String name;
	@NotNull
	@Column(name = "GRPERIOD")
	private int grPeriod;
	@NotNull
	@Column(name = "LIMITS")
	private int limit;

	@Nullable
	@Column(name = "CASHBACK")
	private double cashback;
	//private double cashbackMax;




	public String ToString()
	{
		return name + ". Льготный период: " + Integer.toString(grPeriod) + " дней. Кредитный лимит: " + Integer.toString(limit);
	}
}