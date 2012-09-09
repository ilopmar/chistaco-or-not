	<div class="jokes joke1" rel="${createLink(mapping:'vote', params:[j1:j1.statusId, j2:j2.statusId])}">
	    <g:render template="author" model="[author:j1.author]" />
	    <p class="clearfix">${j1.text}</p>
	</div>

	<div class="jokes joke2" rel="${createLink(mapping:'vote', params:[j1:j2.statusId, j2:j1.statusId])}">
	    <g:render template="author" model="[author:j2.author]" />
	    <p class="clearfix">${j2.text}</p>
	</div>
