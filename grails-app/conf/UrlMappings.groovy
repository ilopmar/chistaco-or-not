class UrlMappings {

	static mappings = {

        // Spring security        
        name loginIndex: "/login/index" {controller = 'login'; action = 'index'}
        name loginAuth: "/login/auth" {controller = 'login'; action = 'auth'}
        name loginAuthAjax: "/login/authAjax" {controller = 'login'; action = 'authAjax'}
        name loginDenied: "/login/denied" {controller = 'login'; action = 'denied'}
        name loginFull: "/login/full" {controller = 'login'; action = 'full'}
        name loginAuthFail: "/login/authfail" {controller = 'login'; action = 'authfail'}
        name loginAjaxSuccess: "/login/ajaxSuccess" {controller = 'login'; action = 'ajaxSuccess'}
        name loginAjaxDenied: "/login/ajaxDenied" {controller = 'login'; action = 'ajaxDenied'}
        name logoutIndex: "/logout/index" {controller = 'logout'; action = 'index'}

        // Console
        name console: "/console" {controller = 'console'}

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
