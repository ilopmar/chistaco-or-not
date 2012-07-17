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
        
            <p class="text1">Elige el mejor chistaco de los dos:
            </p>
    
            <div class="jokes joke1">
                <p rel="${createLink(mapping:'vote', id:j1.id)}">${j1.description}</p>
            </div>
            
            <div class="jokes joke2">
                <p rel="${createLink(mapping:'vote', id:j2.id)}">${j2.description}</p>
            </div>
            
        </div>
		
	</body>
</html>
