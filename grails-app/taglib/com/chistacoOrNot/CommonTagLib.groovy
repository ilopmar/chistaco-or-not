package com.chistacoOrNot

class CommonTagLib {
	
    static namespace = 'con'
   
    def nl2br = {attrs, body ->
        out << attrs.text?.replaceAll('\n','<br/>')
    }

    def br2nl = {attrs, body ->
        out << attrs.text?.replaceAll('<br/>','\n')
    }
}
