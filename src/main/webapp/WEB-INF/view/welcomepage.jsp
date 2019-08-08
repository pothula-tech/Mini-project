<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<html>
   <head>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
      <meta http-equiv="X-UA-Compatible" content="IE=edge,Chrome=1">
      <meta http-equiv="Pragma" content="no-cache">
      <meta http-equiv="Cache-Control" content="no-cache">
      <meta http-equiv="Expires" content="sat,01 Dec 2001 00:00:00 GMT">
      <Title>Kuliza-Tab|home</title>
      <link href="static/css/bootstrap.min.css" rel="stylesheet">
      <link href="static/css/style.css" rel="stylesheet">
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
   </head>
   <body>
      <div role="navigation">
         <div class="navbar navbar-inverse">
            <a href="/welcome" class="navbar-brand">Kuliza</a>
            <div class="navbar-collapse collapse">
               <ul class="nav navbar-nav">
                  <li><a href="/login">Login</a></li>
                  <li><a href="/register">New Registration</a></li>
                  <li><a href="/show-users">All Users</a></li>
               </ul>
            </div>
         </div>
      </div>
      <c:choose>
         <c:when test="${mode=='MODE_HOME'}">
            <script src="static/js/jquery-1.11.1.min.js"></script>
            <script src="static/js/bootstrap.min.js"></script>
            <div class="jumbotron text-center">
               <h1>Welcome to Kuliza</h1>
               <h3>Please Login For User Authentication</h3>
            </div>
         </c:when>
         <c:when test="${mode=='MODE_REGISTER'}">
            <div class="container text-center">
               <h3>New Registration</h3>
               <hr>
               <form class="form-horizontal" method="POST" action="save-user">
                  <input type="hidden" name="id" value="${user.id}"/>
                  <div class="form-group">
                     <label class="control-label col-xs-5">Username</label>
                     <div class="col-xs-3">
                        <input type ="text" class="form-control" name="username" value="${user.username}"/>
                     </div>
                  </div>
                  <div class="form-group">
                     <label class="control-label col-xs-5">First Name</label>
                     <div class="col-xs-3">
                        <input type ="text" class="form-control" name="firstname" value="${user.firstname}"/>
                     </div>
                  </div>
                  <div class="form-group">
                     <label class="control-label col-xs-5">Last Name</label>
                     <div class="col-xs-3">
                        <input type ="text" class="form-control" name="lastname" value="${user.lastname}"/>
                     </div>
                  </div>
                  <div class="form-group">
                     <label class="control-label col-xs-5">Age</label>
                     <div class="col-xs-3">
                        <input type ="text" class="form-control" name="age" value="${user.age}"/>
                     </div>
                  </div>
                  <div class="form-group">
                     <label class="control-label col-xs-5">Password</label>
                     <div class="col-xs-3">
                        <input type ="password" class="form-control" name="password" value="${user.password}"/>
                     </div>
                  </div>
                  <div class="form-group">
                  <div class="col-xs-14">
                     <input type ="submit" class="btn btn-primary" value="Register"/>
                   </div>
                  </div>
               </form>
            </div>
         </c:when>
         <c:when test="${mode=='MODE_SUCCESS'}">
            <div class="alert alert-success">
               <strong>Congratulations!You have successfully registered</strong>
            </div>
         </c:when>
         <c:when test="${mode=='ALL_USERS'}">
            <div class="container text-center" id="tasksDiv">
               <h3>All Users</h3>
               <hr>
               <div class="table-responsive">
                  <table class="table table-striped table-bordered">
                     <thead>
                        <tr>
                           <th>Id</th>
                           <th>UserName</th>
                           <th>FirstName</th>
                           <th>LastName</th>
                           <th>Age</th>
                        </tr>
                     </thead>
                     <tbody>
                        <c:forEach var="user" items="${users}">
                           <tr>
                              <th>${user.id}</th>
                              <th>${user.username}</th>
                              <th>${user.firstname}</th>
                              <th>${user.lastname}</th>
                              <th>${user.age}</th>
                           </tr>
                        </c:forEach>
                     </tbody>
                  </table>
               </div>
            </div>
         </c:when>
         <c:when test="${mode=='MODE_LOGIN'}">
         <div class="container text-center">
               <h3>User Login</h3>
               <hr>
               <form class="form-horizontal" method="POST" action="/login-user">
                  <c:if test ="${not empty error}">
                     <div class="alert alert-danger">
                        <c:out value="${error}"></c:out>
                     </div>
                  </c:if>
                  
                  <div class="form-group">
                     <label class="control-label col-xs-5">Username</label>
                     <div class="col-xs-3">
                        <input type ="text" class="form-control" name="username" value="${user.username}"/>
                     </div>
                  </div>
                  
                 
                  <div class="form-group">
                     <label class="control-label col-xs-5">Password</label>
                     <div class="col-xs-3">
                        <input type ="password" class="form-control" name="password" value="${user.password}"/>
                     </div>
                  </div>
                 
                  <div class="form-group">
                  <div class="col-xs-12">
                     <input type ="submit" class="btn btn-primary" value="LOGIN"/>
                  </div>
                  </div>
               </form>
            </div>
         </c:when>
      </c:choose>
   </body>
</html>