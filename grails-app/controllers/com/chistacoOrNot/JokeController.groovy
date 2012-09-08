package com.chistacoOrNot

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class JokeController {

    static scaffold = true
}
