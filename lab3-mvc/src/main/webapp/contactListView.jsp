<!--  header -->
<%@include file="includes/header.jsp"%>

<body>
	<h1>Contact Book</h1>

	<div class="container">
	
		<p>${message}</p>
				
			<c:forEach items="${requestScope.contacts}" var="entry">
				<div class="card">
 					<img src="images/avatar2.png" alt="Avatar" style="width:100%; height:100px">
  					<div class="container">
						<h4><b><c:out value="${entry.value.name}" /></b></h4> 
					   	<p><c:out value="${entry.value.telephone}" /></p>
					   	<a href="contactupdate?id=${entry.value.id}"><img src="./images/edit.png" width="30px"></a> 
						<a href="contactdelete?id=${entry.value.id}"><img src="./images/delete.png" width="30px"></a>
					</div>
				</div>
				<br>
			</c:forEach>
		
		<div class="bottom_links">
			<a href="contactEditView.jsp" class="button">New contact</a>
		</div>
	</div>

	<!-- footer -->
	<%@include file="includes/footer.jsp"%>