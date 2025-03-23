package com.nt.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Entity
@Table(name="EMP")
@Data
public class Employee {
	
	@Id
//	@SequenceGenerator(name="gen1",sequenceName = "emp_id_seq",initialValue = 1,allocationSize = 1)
//	@GeneratedValue(generator ="gen1",strategy = GenerationType.SEQUENCE )
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empno;
	@Column(length = 20)
	private String ename;
	@Column(length = 20)
	private String job="CLEARK";
	private Double sal;
	
	
	
}
