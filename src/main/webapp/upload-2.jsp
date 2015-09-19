<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8" />
<title>Image Resizing with Canvas</title>

<style type="text/css">
#component {
	width: 836px;
	height: 602px;
	display: inline-block;
}
</style>

</head>
<body>
	<div id="component">
	</div>


	<script type="text/javascript" src="resources/jquery-1.11.2.js"></script>
	<script type="text/javascript" src="resources/croppiC.js"></script>
	<script type="text/javascript" >
	var cropper = new Cropper({
		el: '#component',
		cropSize: {
			width: 800,
			height: 600
		},
		url: '/discover-spring/upload',
		uploaded: function(resp) {
			alert(resp);
		},
		debug: true
	});
	</script>
</body>
</html>
