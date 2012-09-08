<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page defaultCodec="HTML" %>
<!doctype html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Chistaco or not?</title>
	</head>
	<body>

        <div id="ranking">
            <p class="text1">Este es el ranking de los mejores #chistacos</p>
            <ul>
            <g:each in="${ranking}" var="joke">
                <li class="clearfix">
                    <g:render template="author" model="[author:joke.author]" />
                    <p class="desc">${joke.text}</p>
                    <p class="points">${joke.points}</p>
                </li>
            </g:each>
            </ul>
        <div>
		
	</body>
</html>
