package com.example.Thanks.Bonus.Controllers.parser;

import com.example.Thanks.Bonus.domain.Views;
import com.fasterxml.jackson.annotation.JsonView;
import com.sun.istack.NotNull;
import com.sun.istack.Nullable;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.text.DecimalFormat;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
public class creditCard {


	@NotNull
	private String name;
	@NotNull
	private int grPeriod;
	@NotNull
	private int limit;

	@Nullable
	private double cashback;
	//private double cashbackMax;

	public String ToString()
	{
			return name + ". Льготный период: " + Integer.toString(grPeriod) + " дней. Кредитный лимит: " + (new DecimalFormat( "###,###,###" ).format(limit));
	}
}
