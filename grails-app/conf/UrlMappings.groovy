class UrlMappings {

	static mappings = {

        name home: "/" { controller = 'home'; action = 'jokes' }
        name vote: "/vote" { controller = 'home'; action = 'vote' }
        
		"500"(view:'/error')
        
        "/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }
	}
}
