package com.chistacoOrNot

import grails.plugins.springsecurity.Secured

@Secured(['ROLE_ADMIN'])
class AuthorController {

    static scaffold = true
}
