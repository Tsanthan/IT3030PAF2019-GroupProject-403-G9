<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>     
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Products Form</title>
 <link href="../../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../../webjars/bootstrap/4.0.0/js/bootstrap.min.js"></script>
 <script src="../../webjars/jquery/3.0.0/js/jquery.min.js"></script>
</head>
<body>
 <div class="container">
  <spring:url value="/products/saveproducts" var="saveURL" />
  <h2>Products</h2>
  <form:form modelAttribute="productsForm" method="post" action="${saveURL }" cssClass="form" >
   <form:hidden path="id"/>
   <div class="form-group">
    <label>Product Name</label>
    <form:input path="name" cssClass="form-control" id="name" />
   </div>
   <div class="form-group">
    <label>Product Type</label>
    <form:input path="type" cssClass="form-control" id="type" />
   </div>
   <div class="form-group">
    <label>Description</label>
    <form:input path="description" cssClass="form-control" id="description" />
   </div>
   <div class="form-group">
    <label>Status</label>
    <form:input path="status" cssClass="form-control" id="status" />
   </div>
   <div class="form-group">
    <label>Date</label>
    <form:input path="date" cssClass="form-control" id="date" />
   </div>
   <div class="form-group">
    <label>Username</label>
    <form:input path="username" cssClass="form-control" id="username" />
   </div>
   <button type="submit" class="btn btn-primary">Save</button>
  </form:form>
  
 </div>
</body>
</html>