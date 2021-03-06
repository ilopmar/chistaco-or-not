<!doctype html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"><!--<![endif]-->
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<title><g:layoutTitle default="Grails"/></title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link rel="shortcut icon" href="${resource(dir: 'images', file: 'favicon.ico')}" type="image/x-icon">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'main.css')}" type="text/css">
		<link rel="stylesheet" href="${resource(dir: 'css', file: 'mobile.css')}" type="text/css">
		<g:layoutHead/>
        
        <r:require modules="application"/>
        
		<r:layoutResources />
    </head>
	<body>
		<div id="logo-wrapper">
            <g:link mapping="home"><r:img class="logo" dir="images" file="logo.png" height="128" width="128" border="0" /></g:link>
            <h1>Chistaco or not?</h1>
        </div>
		<g:layoutBody/>
		<div class="footer">
			<span>Chistaco or not by <a href="http://www.twitter.com/ilopmar" target="blank">Iván López (@ilopmar)</a></span>
            <p class="text2">
            	<g:link mapping="ranking">Ver ranking de #chistacos</g:link>
            </p>
        </div>

<r:script>
  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-34709509-1']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();
</r:script>
		<r:layoutResources />

	</body>
</html>