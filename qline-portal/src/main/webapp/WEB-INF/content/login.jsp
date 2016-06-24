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
    <div id="form">
    <form:form id="signin" action="login" method="post" autocomplete="off">
         
            <div style="display:block;" id="account" class="form-section">
              <div class="form-section-content">
              
                 <div class="errorMsg" id="errorMsg" style="display: none">
              <p id="err_j_username"></p>
              <p id="err_j_password"></p>
              </div>
              
                 <c:if test="${not empty param.login_error}">
	 	 	<div class="errorMsg">
         			<p><span class="error">
         			<c:choose>
                               <c:when test="${requestScope.badAttempts == 4}">
                                   <s:message code="AbstractUserDetailsAuthenticationProvider.locked" text="Total number of log-in attempts has exceeded. Please use Forgot password to reset the Password."/>    
                               </c:when>
                               <c:otherwise>
                                   ${SPRING_SECURITY_LAST_EXCEPTION.message}
                               </c:otherwise>
                    </c:choose>
         			</span></p>
   			</div>
   			
	    </c:if>
	     <div class="sectionHead">
                  <!--  <h1 class="hide">heading</h1> -->
                  <h2 class="headTxt"><s:message code="label.signin.to.account" text="Sign in to Account"></s:message></h2>
                </div>
                <div class="contentBlock">
                 <fieldset class="gutterTB20">
                     <legend class="hide" aria-hidden="true"><s:message code="label.signin.to.account" text="Sign in to Account"></s:message></legend>
                    <div class="control-group offsetB10">
                    <label class="" for="j_username"><s:message code="label.start.username" text="Username"></s:message></label>
                    <input type="text" name="j_username" id="j_username" value="${username}" class="" maxlength="256"> 
                   
                    </div>
                     <div class="control-group offsetB20">
                    <label class="" for="j_password"> <s:message code="label.password" text="Password"></s:message></label>
                    <input type="password" name="j_password" id="j_password" value="" class=""> 
                   
                    </div>
                  <div class="control-group offsetB30">
              		<label for="_spring_security_remember_me" class="checkbox">
                		<input type="checkbox" checked="" id="_spring_security_remember_me" name="_spring_security_remember_me">
               			<s:message code="label.remember.me" text="Remember Me"/>
               		</label>
            		</div>
                 
                  <div class="control-group offsetT10 ">
					<input type="submit" onclick="$('.errorMsg').hide();$('#errorMsg').show();" value="<s:message code="label.rightContent.SignIn" text="Sign In"></s:message>" class="primaryButton offsetR20">
                    <s:message code="label.forgot.your" text="Forgot Your"/><a href="forgotPassword"><s:message code="label.password" text="Password"/>?</a>
                  </div>
                   </fieldset>
                 
                </div>
               
              </div>
              
            </div>
              </form:form>
   
    </div>
  </div>
 
</div>
</body>
</html>