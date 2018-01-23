<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript">
$('#carouselFade').carousel();
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Shine Food WebApp</title>
</head>
<body class="demo">

  		<jsp:include page="/WEB-INF/CommonHeader.jsp"></jsp:include>
  
    <div id="carouselFade" class="carousel slide carousel-fade" data-ride="carousel">

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">  
                <div class="carousel-caption">
                  <h3>Pizza</h3>
                  <p>Enjoy Tasty Pizzas with your desired flavors and toppings.  </p>
                </div>
            </div>
            <div class="item"> 
                <div class="carousel-caption">
                  <h3>Shawarma</h3>
                  <p>Tasty and Yummy Shawarma.</p>
                </div>
            </div>
            <div class="item"> 
                <div class="carousel-caption">
                  <h3>Burger</h3>
                  <p>Enjoy Variety of yummy Burgers.</p>
                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carouselFade" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carouselFade" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>
    <a href="hello">click here</a>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</body>
</html>