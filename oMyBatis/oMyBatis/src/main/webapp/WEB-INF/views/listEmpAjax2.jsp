<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String context = request.getContextPath();
    System.out.println("context->"+context);
%>
<html>
<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery.js"></script>


<script type="text/javascript" src="js/httpRequest.js"></script>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

<script id="entry-template" type="text/x-handlebars-template">
<table>
    <thead> 
        <th>부서코드</th> 
        <th>부서명</th> 
        <th>위치</th> 
    </thead> 
    <tbody> 
        {{#users}} 
        <tr> 
            <td>{{deptno}}</td> 
            <td>{{dname}}</td> 
            <td>{{loc}}</a></td> 
        </tr> 
        {{/users}} 
    </tbody> 
</table>
</script>

<script src="js/test.js"></script>

<script type="text/javascript">
   
    var contextPath='${pageContext.request.contextPath}';
	var src='${pageContext.request.contextPath}/images/';
	var contextPath='${pageContext.request.contextPath}';
	var i=2;
	var str="";
	var str2="";
	

	/* RestController TEST */
	function getDept(Vdeptno){
		console.log(Vdeptno);
		/* alert("Vdeptno->"+Vdeptno); */
		$.ajax({
			url:"<%=context%>/sample/sendVO2.do",
			data:{deptno : Vdeptno},
			dataType:'json',
			success:function(data){
				/*  alert(".ajax getDept Data"+data);  */
				str   = data.firstName + " " + data.lastName + " " + data.mno;
				alert(".ajax getDept str"+str); 
				$('#RestDept').val(str);     /*  input Tag */
			}
		});
	}

	/* RestController TEST */
	
	function getListDept(){
		str    = "";
		str2   = "";

		console.log("getListDept Run");
		alert("getListDept Run->");  
		$.ajax({
			url:"<%=context%>/sample/sendVO3.do",
			dataType:'json',
			success:function(data){
						//alert(".ajax getDept Data"+data);
						//str   = data[0].deptno + " " + data[0].dname ;
						var jsondata = JSON.stringify(data);
	        			alert("jsondata->"+jsondata);
						$('#Dept_list').append(jsondata);  
						//$('#Dept_list1').append(data);
						str  += "<select name='dept'>";
						//$('#Dept_list3').append(str);	
						$(data).each(
							function(){
								str2  = "<option value='" + this.deptno + "'> " + this.dname  + "</option> "; 
								//str2  = " " + this.deptno + "' " +this.dname  + "<br>";
								str  += str2 ;
								//$('#Dept_list').html( this.deptno + this.dname);
								// $('#Dept_list3').html(str2);	
							}
						);
						str += "</select><p>"
						$('#Dept_list3').append(str);
						alert(".ajax getListDept str->"+str); 
						//$('#Dept_list3').val(str);    
			}
		});
	}
	
	

	function getDeptName(Vdeptno){
		console.log(Vdeptno);
		/* alert("Vdeptno->"+Vdeptno); */
		$.ajax({
			url:"<%=context%>/getDeptName.do",
			data:{deptno : Vdeptno},
			dataType:'text',
			success:function(data){
				/* alert(".ajax Data"+data); */
			     $('#deptName').val(data);      /*	 input Tag */
				/* $('#deptName').text(data); */
				/*  $('#deptName').html(data);     */
				 $('#msg').html(data);         /* span  id Tag */
				/* $('#deptName').val("이미 사용중인 아이디."); */
			}
		});
	}
 </script>
</head>
<body>
<h2>회원 정보</h2>
<table>
	<tr><th>사번</th><th>이름</th><th>업무</th><th>부서</th><th>근무지</th></tr>
<c:forEach var="empDept" items="${listEmp}">
	<tr><td>${empDept.empno }</td><td>${empDept.ename }</td>
		<td>${empDept.job }</td><td>${empDept.deptno } 
		    <input type="button" id="btn_idCheck"    value="부서명"  
		    onmouseover="getDeptName(${empDept.deptno })">
		</td>
		<td>${empDept.loc }</td></tr>
</c:forEach>
</table>
	 
	deptName:  <input type="text" id="deptName"  readonly="readonly"><p>
    Message :  <span id="msg"></span><p>

    RestController sendVO2: <input type="text" id="RestDept"       readonly="readonly"><p>
	RestController sendVO2: sendVO2<input type="button" id="btn_Dept"     value="부서명"  onclick="getDept(10)"><p>
	
	
	RestController Java Script: sendVO2<input type="button" id="btn_script"     value="Java Script"  onclick="getTest()"><p>

    <input class="btn btn-primary btn-xs" type="button"		value="교번확인" onclick="teacherCheck();" /><p>
    
   <!--  RestController LISTVO3: <input type="text" id="RestDeptList"   readonly="readonly"><p> -->
	RestController LISTVO3: <input type="button" id="btn_Dept3"     value="부서명 LIST"  onclick="getListDept()"><p>
	                        <span id="RestDeptList"></span><p>
	                        			<div id="board_reply">
	Dept_list:	<div id="Dept_list"></div>

	Dept_list3:
	<div id="Dept_list3">

	</div>
</body>
</html>