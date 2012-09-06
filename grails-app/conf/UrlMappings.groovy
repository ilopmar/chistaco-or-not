class UrlMappings {

	static mappings = {

        name home: "/" { controller = 'home'; action = [GET:'jokes'] }
        name vote: "/vote" { controller = 'home'; action = [POST:'vote'] }
        
		"500"(view:'/error')
        
        // "/$controller/$action?/$id?"{
        //     constraints {
        //         // apply constraints here
        //     }
        // }
	}
}
