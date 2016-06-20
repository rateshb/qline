<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"	prefix="decorator"%>
<!DOCTYPE html>
<html lang="${pageContext.response.locale}">
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1.0" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
	<jsp:include page="/includes/style.jsp" />
	<decorator:head />
</head>
 
<body id="dotGov" class="home">
	<%@ include file="/includes/_header.jsp"%>
	
	<!-- master container-->
	<div class="container">
		<div class="row">	
			<div class="col-md-12">
				<decorator:body/>
			</div>
		</div>
	</div>

	<!-- master footer-->
	<jsp:include page="/includes/_footer.jsp" />
</body>
</html>
