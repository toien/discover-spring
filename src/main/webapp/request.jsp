<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>

</head>
<body>

	<input type="button" value="post" onclick="post()">
	<br>
	<input type="button" value="put" onclick="put()">
	<br>
	<input type="button" value="putJson" onclick="putJson()">
	<br>
	<input type="button" value="getJsonP Hello" onclick="getJsonP()">
	<input type="button" value="getJsonP Hello 2" onclick="getJsonP2()">
	
	<hr />
	<form:form method="put" action="json/putform">
		<p class="submit">
			<input name="name" type="text" value="Put As Form" />
			<input type="submit" value="Put As Form" />
		</p>
	</form:form>

	<script src="/discover-spring/resources/jquery-1.11.2.js"></script>
	
	<script>
		function post() {
			$.ajax({
				url : "/discover-spring/json/create",
				type : "POST",
				contentType : "application/json;chaset=UTF-8",
				data : JSON.stringify({
					"name" : "Hell"
				}),
				dataType : "json"
			});
		}

		function put() {
			$.ajax({
				url : "/discover-spring/json/put",
				type : "PUT",
				contentType : "application/json;chaset=UTF-8",
				data : JSON.stringify([{
					"name" : "Hell",
					"age" : 43,
					"pet": {
						id: 3,
						nickname: "asshole"
					}
				}]),
				dataType : "json"
			});
		}
		
		function putJson() {
			$.ajax({
				url : "/discover-spring/json/putjson?_method=put",
				type : "POST",
				contentType : "application/json;chaset=UTF-8",
				data : JSON.stringify({
					"name" : "Heal",
					"age" : 43
				}),
				dataType : "json"
			});
		}
		
		function getJsonP() {
			$.ajax({
				url : "http://127.0.0.1:8080/discover-spring/jsonp/hello",
				type : "GET",
				contentType : "application/json;chaset=UTF-8",
				data : {
					"name" : "hello"
				},
				jsonpCallback: "jsonpCallback",
				dataType : "jsonp"
			}).done(function(resp) {
				debugger
			}).error(function(resp) {
				debugger
			});
		}
		
		function getJsonP2() {
			$.ajax({
				url : "http://127.0.0.1:8080/discover-spring/jsonp/hello2",
				type : "GET",
				contentType : "application/json;chaset=UTF-8",
				data : {
					"name" : "hello"
				},
				jsonpCallback: "jsonpCallback",
				dataType : "jsonp"
			}).done(function(resp) {
				debugger
			}).error(function(resp) {
				debugger
			});
		}
		
		function jsonpCallback(data) {
			alert(data);
		}
	</script>
</body>

</html>
