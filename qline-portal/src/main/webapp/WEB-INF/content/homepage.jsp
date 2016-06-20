<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta content="indexLayout" name="decorator">
</head>

<body>
<div id="main">
 <div id="container">
    <div id="name">
   
    <div ui-view="start"></div>
    </div>
  </div>
</div>
<script>
	/* $(document).ready(function(){
		$('#startForm').on('submit', function(){
			$.post({
				data:$('#startForm').serialize(),
				url:
			});
			
		});		
	});
 */
</script>
</body>
</html>