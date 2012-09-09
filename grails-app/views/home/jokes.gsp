<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page defaultCodec="HTML" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Chistaco or not?</title>
	</head>
	<body>
    
        <div id="jokes-wrapper">
            <p class="text1">Elige el mejor chistaco de los dos:</p>
    
            <div id="the-jokes">
                <g:render template="jokes" model="[j1:j1, j2:j2]" />
            </div>
        </div>
		
	</body>
</html>
