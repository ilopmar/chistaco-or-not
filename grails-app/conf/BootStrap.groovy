import com.chistacoOrNot.*

class BootStrap {

    def init = { servletContext ->
        
        def a1 = new Author(name:'Pepe')
        def a2 = new Author(name:'Juan')
        def a3 = new Author(name:'Luis')
        
        def j1 = new Joke(description:'Lorem ipsum aaaaaa')
        def j2 = new Joke(description:'Lorem ipsum bbbbbb')
        def j3 = new Joke(description:'Lorem ipsum cccccc')
        def j4 = new Joke(description:'Lorem ipsum ddddd')
        def j5 = new Joke(description:'Lorem ipsum eeeeeeeee')
        def j6 = new Joke(description:'Lorem ipsum fffffff')
        def j7 = new Joke(description:'Lorem ipsum ggggggggggg')
        def j8 = new Joke(description:'Lorem ipsum hhhhhhhhhhhh')
        def j9 = new Joke(description:'Lorem ipsum iiiiiiiiii')
        def j10 = new Joke(description:'Lorem ipsum jjjjjjjjj')
        
        a1.addToJokes(j1)
        a2.addToJokes(j2)
        a3.addToJokes(j3)
        a3.addToJokes(j4)
        a1.addToJokes(j5)
        a1.addToJokes(j6)
        a2.addToJokes(j7)
        a3.addToJokes(j8)
        a1.addToJokes(j9)
        a2.addToJokes(j10)
        
        a1.save()
        a2.save()
        a3.save()
    }
    def destroy = {
    }
}
