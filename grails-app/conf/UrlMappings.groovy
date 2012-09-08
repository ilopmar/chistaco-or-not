class UrlMappings {

	static mappings = {

        name home: "/" { controller = 'home'; action = [GET:'jokes'] }
        name vote: "/vote" { controller = 'home'; action = [POST:'vote'] }
        name ranking: "/ranking" { controller = 'home'; action = [GET:'ranking'] }
        
		"500"(view:'/error')
        
        "/admin/$controller/$action?/$id?"{
            constraints {
                // apply constraints here
            }
        }
	}
}
