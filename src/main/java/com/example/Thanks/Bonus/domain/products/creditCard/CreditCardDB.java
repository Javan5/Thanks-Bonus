package com.example.Thanks.Bonus.domain.products.creditCard;

import com.example.Thanks.Bonus.domain.Views;
import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class CreditCardDB {


	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	@NotNull
	private String name;
	@NotNull
	private int grPeriod;
	@NotNull
	private int limit;

	@Nullable
	private double cashback;
	//private double cashbackMax;


	public CreditCardDB(Long id, String name, int grPeriod, int limit, double cashback) {
		this.id = id;
		this.name = name;
		this.grPeriod = grPeriod;
		this.limit = limit;
		this.cashback = cashback;
	}

	public String ToString()
	{
		return name + ". Льготный период: " + Integer.toString(grPeriod) + " дней. Кредитный лимит: " + Integer.toString(limit);
	}
}