<%@ page language="java" contentType="text/html"%>
  		<jsp:include page="/WEB-INF/views/CommonHeader.jsp"></jsp:include>
<br>
<br>
<br>
<br>

	<form action="perform_login" method="post">
		<table align="center">
			<thead bgcolor="pink">
				<th colspan="2">Login</th>
			</thead>
			<tr bgcolor="gray">
				<td>User Name</td>
				<td><input type="text" name="username" required /></td>
			</tr>
			<tr bgcolor="gray">
				<td>Password</td>
				<td><input type="password" name="password" required /></td>
			</tr>
			</tr>
			<tr bgcolor="pink">
				<td colspan="2"><center>
						<input type="submit" value="SUBMIT" />
					</center></td>
			</tr>
		</table>
	</form>


</body>
</html>