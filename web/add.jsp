<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="java.sql.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<% request.setCharacterEncoding("UTF-8"); %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<style type="text/css">
			tr{front-family:微软雅黑;vertical-align:middle;line-height:14pt;font-size:14pt}	
			td{front-family:微软雅黑;vertical-align:middle;line-height:14pt;font-size:14pt}
			th{vertical-align:middle;}	
		</style>
	</head>
  <body>
 	<form method="post">    <!-- 容易出错！！看准页面 -->
 	  <table align="center" width="50%" border="1">
 	  	<caption>添加员工信息</caption>
 	  	<tr>
 	  	   <th width="30%">员工编号：</th>
 	  	   <td width="70%"><input name="employee_id" type="text"/></td>
 	  	</tr>
 	  	<tr>
 	  	   <th width="30%">员工名：</th>
 	  	   <td width="70%"><input name="first_name" type="text"/></td>
 	  	</tr>
		  <tr>
			  <th width="30%">员工姓：</th>
			  <td width="70%"><input name="last_name" type="text"/></td>
		  </tr>
 	  	<tr>
 	  	   <th width="30%">邮箱地址：</th>
 	  	   <td width="70%"><input name="email" type="text"/></td>
 	  	</tr>
 	  	<tr>
 	  	   <th width="30%">电话号码：</th>
 	  	   <td width="70%"><input name="phone_number" type="text"/></td>
 	  	</tr>
 	  	<tr>
 	  	   <th width="30%">入职日期：</th>
 	  	   <td width="70%"><input name="hire_date" type="text"/></td>
 	  	</tr>
 	  	<tr>
 	  	   <th width="30%">职位编号：</th>
 	  	   <td width="70%"><input name="job_id" type="text"/></td>
 	  	</tr>
 	  	<tr>
 	  	   <th width="30%">工资：</th>
 	  	   <td width="70%"><input name="salary" type="text"/></td>
 	  	</tr>
 	  	<tr>
 	  	   <th width="30%">奖金：</th>
 	  	   <td width="70%"><input name="commission_pct" type="text"/></td>
 	  	</tr>
 	  	<tr>
 	  	<tr>
 	  	   <th width="30%">所属领导编号：</th>
 	  	   <td width="70%"><input name="manager_id" type="text"/></td>
 	  	</tr>
 	  	<tr>
 	  	<tr>
 	  	   <th width="30%">所属部门编号：</th>
 	  	   <td width="70%"><input name="department_id" type="text"/></td>
 	  	</tr>
 	  	<tr>
 	  	   <th colspan="2">
 	  	    <input name="submit" type="submit" value="添加"/>
 	  	    <input value="重置" type="reset"/>
 	  	   </th> 	  	   
 	  	</tr>
 	  </table>
 	</form>
	<!--
	1、标签<input>里name的值与request.getParameter()里的值不对应；
	2、中文与英文不对应，容易造成后续编程错误；
	3、<input>标签没有关闭；
	4、非常量，变量名不要大写；
	-->
 	<%
 	   String submit=request.getParameter("submit");
 	   if(submit!=null && !submit.equals(""))
 	   {
 	        String employee_id = request.getParameter("employee_id").trim();
 	   		String first_name = request.getParameter("first_name").trim();
 	   		String last_name = request.getParameter("last_name").trim();//容易出错！！！
 	   		String email = request.getParameter("email").trim();
 	   		String phone_number = request.getParameter("phone_number").trim();
 	   		String hire_date = request.getParameter("hire_date").trim();
 	   		String job_id = request.getParameter("job_id").trim();
 	   		String salary = request.getParameter("salary").trim();
 	   		String commission_pct = request.getParameter("commission_pct").trim();
 	   		String manager_id = request.getParameter("manager_id").trim();
 	   		String department_id = request.getParameter("department_id").trim();
		    /*SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date date = sdf.parse(hire_date);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());*/
 	   try{
			Class.forName("oracle.jdbc.driver.OracleDriver");}
	   catch(Exception e){
 	       e.printStackTrace();
		}
		   Connection con = null;
		   Statement stmt = null;
		   int i = 0;
		try{
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:booksales", "bobby", "human");
			stmt = con.createStatement();
			/*
			* 数据库中的number类型在java类对应的类型：
 			1.如果number类没有设置小数位位数，默认小数位数为0，则在java类中可以使用int或者long对应；
			2.如果number类设置小数位位数，在java类中可以使用double类进行对应。
			注：也可以使用基本类型的包装类进行对于，比如double的包装类为Double.
			* */

			/*
			* Oracle中数据类型number(m,n)中m表示的是所有有效数字的位数，n表示的是小数位的位数。
			* 有效位：从左边第一个不为0的数算起的位数。
				s的情况：
					s   >   0
     			 精确到小数点右边s位，并四舍五入。然后检验有效位是否   <=   p。
					s   <   0
      			精确到小数点左边s位，并四舍五入。然后检验有效位是否   <=   p   +   |s|。
					s   =   0
      			此时NUMBER表示整数。

      			eg:

			* */
			String sql = "INSERT INTO employees" +
					" values(" + Integer.parseInt(employee_id) + ",'" + first_name + "','"  + last_name + "','"  + email + "','"  + phone_number + "',"  +
					"to_date('" + hire_date + "','" + "yyyy-mm-dd'" + ")" +",'"  + job_id + "',"  + Double.parseDouble(salary) +","  + Double.parseDouble(commission_pct)
					+ ","  + Integer.parseInt(manager_id) + ","  + Integer.parseInt(department_id) + ")";
			//String sql = "INSERT INTO datetest" + " values(" + "to_date('" + hire_date + "','" + "yyyy-mm-dd')" + ")";
			System.out.println("sql = " + sql);
			//i表示插入语句完成后表受影响的行数
			i = stmt.executeUpdate(sql);   // out.println("成功6666666666666");// 此处sno是字符变量，"sno"代表其真值，+表示java的连接符。但values('sringa','stringb',3);
			String sql2 = "commit";
			stmt.executeUpdate(sql2);
			stmt.close();
			con.close();
		}catch(SQLException e) {
	       e.printStackTrace();
		}
       if(i == 1)
       {
       	 out.println("<script language='javaScript'>alert('添加成功，单击确定跳转到主页！');</script>");
        response.setHeader("refresh","1;url=index.jsp");
       }
       else
       {
         out.print("<script language='javaScript'>alert('添加失败，单击确定跳转到本页！');</script>");
       	 response.setHeader("refresh","1;url=add.jsp");
       }
       }        
 	 %>
  </body>
</html>
</html>
