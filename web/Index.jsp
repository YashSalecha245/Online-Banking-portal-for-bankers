<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>Bootstrap Login &amp; Register Templates</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="assets/css/form-elements.css">
        <link rel="stylesheet" href="assets/css/style.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="assets/ico/favicon.png">
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

    </head>
   
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <script>
      function dil(form)
      {
          if(document.f1.emppassword.value!=document.f1.reemppassword.value)
          {
              alert("Check Confirm Password");
              document.f1.reemppassword.value="";
              document.f1.reemppassword.focus();
              return false;
          }
              
      }
  </script>
    <body>

        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                	
                   
                    
                    <div class="row">
                        <div class="col-sm-5">
                        	
                        	<div class="form-box">
	                        	<div class="form-top">
	                        		<div class="form-top-left">
	                        			<h3>Login to our site</h3>
	                            		<p>Enter username and password to log on:</p>
	                        		</div>
	                        		<div class="form-top-right">
	                        			<i class="fa fa-lock"></i>
	                        		</div>
	                            </div>
	                            <div class="form-bottom">
				                    <form role="form" action="Login" method="post" class="login-form">
				                    	 <div class="form-group">
                                            <label class="sr-only" for="form-employeeid">Employee Id</label>
                                            <i class="glyphicon glyphicon-pencil"></i><strong> Employee Id</strong><input type="password" name="empid" placeholder="Employee Id..." class="form-password form-control" id="form-password">
                                        </div>
                                        <div class="form-group">
				                    		<label class="sr-only" for="form-username">Employee Name</label>
				                        	<i class="glyphicon glyphicon-user"></i> <strong> Employee Name</strong> <input type="text" name="empname" placeholder="Employee Name..." class="form-username form-control" id="form-username">
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-password">Password</label>
				                        <i class="glyphicon glyphicon-lock"></i><strong> Password </strong><input type="password" name="emppassword" placeholder="Password..." class="form-password form-control" id="form-password">
				                        </div>
                                       
				                        <button type="submit" class="btn btn-success"> <i class="fa fa-lock"></i>  Log In</button>
				                    </form>
			                    </div>
		                    </div>
		               	</div>
                        
                        <div class="col-sm-1 middle-border"></div>
                        <div class="col-sm-1"></div>
                        	
                        <div class="col-sm-5">
                        	
                        	<div class="form-box">
                        		<div class="form-top1">
	                        		<div class="form-top-left">
	                        			<h3>Sign up now</h3>
	                            		<p>Fill in the form below to get instant access:</p>
	                        		</div>
	                        		<div class="form-top-right">
	                        			<i class="fa fa-pencil"></i>
	                        		</div>
	                            </div>
	                            <div class="form-bottom">
                                        <form role="form" action="Signup" method="post" class="registration-form" name="f1" onsubmit="return dil(this)">
				                    	<div class="form-group">
				                    		<label class="sr-only" for="form-first-name">Existing Employee ID</label>
				                        	<i class="glyphicon glyphicon-pencil"></i><strong> Existing Employee ID </strong><input type="password" name="empidold" placeholder="Existing Employee ID..." class="form-first-name form-control" id="form-first-name">
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-last-name">Last name</label>
				                        	<i class="glyphicon glyphicon-lock"></i><strong> Employee Password </strong><input type="password" name="emppasswordold" placeholder="Employee Password..." class="form-last-name form-control" id="form-last-name">
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-email">New Employee ID</label>
				                        	<i class="glyphicon glyphicon-pencil"></i><strong> New Employee ID</strong><input type="password" name="empid" placeholder="Employee ID..." class="form-email form-control" id="form-email">
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-email">New Employee Name</label>
				                        	<i class="glyphicon glyphicon-user"></i><strong> New Employee Name</strong><input type="text" name="empname" placeholder="Employee Name..." class="form-email form-control" id="form-email">
				                        </div>
				                        
                                        <div class="form-group">
				                        	<label class="sr-only" for="form-email">New Password</label>
				                        	<i class="glyphicon glyphicon-lock"></i><strong> New Password </strong><input type="password" name="emppassword" placeholder="Password..." class="form-email form-control" id="form-email">
				                        </div>
				                        
  										<div class="form-group">
				                        	<label class="sr-only" for="form-email">Re Enter Password</label>
				                        	<i class="glyphicon glyphicon-lock"></i><strong> Re Enter Password </strong><input type="password" name="reemppassword" placeholder="Re-Enter Password..." class="form-email form-control" id="form-email">
				                        </div>
				                                                        
                                        <div class="form-group">
				                        	<label class="sr-only" for="form-email">Phone</label>
				                        	<i class="glyphicon glyphicon-earphone"></i><strong> Phone </strong><input type="number" maxlength="10" name="empphone" placeholder="Phone" class="form-email form-control" id="form-email">
				                        </div>
				                        <div class="form-group">
				                        	<label class="sr-only" for="form-email">Address</label>
				                        	<i class="glyphicon glyphicon-envelope"></i><strong> Address </strong><input type="text" name="empaddress" placeholder="Address..." class="form-email form-control" id="form-email">
				                        </div>
				                       <button type="submit" class="btn"> <i class="fa fa-pencil"></i> Sign Up</button>
				                    </form>
			                    </div>
                        	</div>
                        	
                        </div>
                    </div>
                    
                </div>
            </div>
            
        </div>

        <!-- Footer -->
       

        <!-- Javascript -->
        <script src="assets/js/jquery-1.11.1.min.js"></script>
        <script src="assets/bootstrap/js/bootstrap.min.js"></script>
        <script src="assets/js/jquery.backstretch.min.js"></script>
        <script src="assets/js/scripts.js"></script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>