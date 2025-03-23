
function doValidations(frm){
	//empty old form validatio error message
	document.getElementById("enameErr").innerHTML="";
	document.getElementById("jobErr").innerHTML="";
	document.getElementById("salErr").innerHTML="";
	
	//read form comp value
	let name =frm.ename.value;
	  let desg=frm.job.value;
	  let salary = frm.sal.value;
	  
	  let isValide= true;
	  //write clint side form validatio logic 
	    if(name=="" || name.length==0){
			document.getElementById("enameErr").innerHTML="Employee name is mandatory";
			isValide=false;
		}
		else if(name.length<5 || name.length>15){
			document.getElementById("enameErr").innerHTML="Employee name must contain 5 to 15 char";
			isValide=false;
		}	
		
		if(desg=="" || desg.length==0){
			document.getElementById("jobErr").innerHTML="Employee job is mandatory";
			isValide=false;
		}
		else if(desg.length<5 || desg.length>10){
			document.getElementById("jobErr").innerHTML="Employee job must contain 5 to 30 char";
			isValide=false;
		}
		
		if(salary=="" || salary.length==0){
			document.getElementById("salErr").innerHTML="Employee salary is mandatory";
			isValide=false;
		}
		else if(salary<5000 || salary>200000){
			document.getElementById("salErr").innerHTML="Employee salary must must be in between 5000 to 200000";
			isValide=false;
		}	
		
		// change the hidden box (vflag) value to  true indicating that the client side form validations are done
	  frm.vflag.value="yes";
		
		return isValide;
	
	
}





