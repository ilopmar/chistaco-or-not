import com.chistacoOrNot.*

class BootStrap {

    def init = { servletContext ->

        def adminRole = Role.findByAuthority('ROLE_ADMIN') ?: new Role(authority: 'ROLE_ADMIN').save(failOnError: true)

        def admin = User.findByUsername('admin')
        if (!admin) {
            admin = new User()
            admin.username = "admin"
            admin.enabled = true
            // Change this password with console or scaffolding views
            admin.password = "pass"
            admin.save(flush:true, failOnError: true)
        
            UserRole.create(admin, adminRole)
        }
    }

    def destroy = {
    }
}
