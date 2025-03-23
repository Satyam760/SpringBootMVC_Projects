package com.nt.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="BOOT_EMP")
@Data
@SQLDelete(sql="UPDATE BOOT_EMP SET STATUS='delete' WHERE EMPNO=?") //for soft deletion
@Where(clause="STATUS <> 'deleted' ") //To  avoid softly deleted records not participating in any  persistence operations
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
	private  String  status="active";
	
}
