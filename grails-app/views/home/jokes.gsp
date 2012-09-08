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
    
            <div class="jokes joke1" rel="${createLink(mapping:'vote', params:[j1:j1.jId, j2:j2.jId])}">
                <g:render template="author" model="[author:j1.author]" />
                <p class="clearfix">${j1.text}</p>
            </div>
            
            <div class="jokes joke2" rel="${createLink(mapping:'vote', params:[j1:j2.jId, j2:j1.jId])}">
                <g:render template="author" model="[author:j2.author]" />
                <p class="clearfix">${j2.text}</p>
            </div>
        </div>
		
	</body>
</html>
