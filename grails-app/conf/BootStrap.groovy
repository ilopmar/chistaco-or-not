import com.chistacoOrNot.*

class BootStrap {

    def init = { servletContext ->
        
        def a1 = new Author(name:'Pepe', twitter:"pepe", twitterId:"1111111", avatar:"avatar1")
        def a2 = new Author(name:'Juan', twitter:"juan", twitterId:"2222222", avatar:"avatar2")
        def a3 = new Author(name:'Luis', twitter:"luis", twitterId:"3333333", avatar:"avatar3")
		
       
        def j1 = new Joke(description:'Lorem ipsum dolor sit amet consectetur adipiscing elit nam aliquet facilisis nunc sit amet suscipit nisi blandit vitae sed scelerisque tincidunt nisi et scelerisque donec molestie eros sit amet ante ultricies tincidunt morbi rhoncus nisi neque... aaaaaa', externalJokeId:"aa")
        def j2 = new Joke(description:'Lorem ipsum dolor sit amet consectetur adipiscing elit nam aliquet facilisis nunc sit amet suscipit nisi blandit vitae sed scelerisque tincidunt nisi et scelerisque donec molestie eros sit amet ante ultricies tincidunt morbi rhoncus nisi neque... bbbbbb', externalJokeId:"bb")
        def j3 = new Joke(description:'Lorem ipsum dolor sit amet consectetur adipiscing elit nam aliquet facilisis nunc sit amet suscipit nisi blandit vitae sed scelerisque tincidunt nisi et scelerisque donec molestie eros sit amet ante ultricies tincidunt morbi rhoncus nisi neque... cccccc', externalJokeId:"bb")
        def j4 = new Joke(description:'Lorem ipsum dolor sit amet consectetur adipiscing elit nam aliquet facilisis nunc sit amet suscipit nisi blandit vitae sed scelerisque tincidunt nisi et scelerisque donec molestie eros sit amet ante ultricies tincidunt morbi rhoncus nisi neque... ddddd', externalJokeId:"bb")
        def j5 = new Joke(description:'Lorem ipsum dolor sit amet consectetur adipiscing elit nam aliquet facilisis nunc sit amet suscipit nisi blandit vitae sed scelerisque tincidunt nisi et scelerisque donec molestie eros sit amet ante ultricies tincidunt morbi rhoncus nisi neque... eeeeeeeee', externalJokeId:"bb")
        def j6 = new Joke(description:'Lorem ipsum dolor sit amet consectetur adipiscing elit nam aliquet facilisis nunc sit amet suscipit nisi blandit vitae sed scelerisque tincidunt nisi et scelerisque donec molestie eros sit amet ante ultricies tincidunt morbi rhoncus nisi neque... fffffff', externalJokeId:"bb")
        def j7 = new Joke(description:'Lorem ipsum dolor sit amet consectetur adipiscing elit nam aliquet facilisis nunc sit amet suscipit nisi blandit vitae sed scelerisque tincidunt nisi et scelerisque donec molestie eros sit amet ante ultricies tincidunt morbi rhoncus nisi neque... ggggggggggg', externalJokeId:"bb")
        def j8 = new Joke(description:'Lorem ipsum dolor sit amet consectetur adipiscing elit nam aliquet facilisis nunc sit amet suscipit nisi blandit vitae sed scelerisque tincidunt nisi et scelerisque donec molestie eros sit amet ante ultricies tincidunt morbi rhoncus nisi neque... hhhhhhhhhhhh', externalJokeId:"bb")
        def j9 = new Joke(description:'Lorem ipsum dolor sit amet consectetur adipiscing elit nam aliquet facilisis nunc sit amet suscipit nisi blandit vitae sed scelerisque tincidunt nisi et scelerisque donec molestie eros sit amet ante ultricies tincidunt morbi rhoncus nisi neque... iiiiiiiiii', externalJokeId:"bb")
        def j10 = new Joke(description:'Lorem ipsum dolor sit amet consectetur adipiscing elit nam aliquet facilisis nunc sit amet suscipit nisi blandit vitae sed scelerisque tincidunt nisi et scelerisque donec molestie eros sit amet ante ultricies tincidunt morbi rhoncus nisi neque... jjjjjjjjj', externalJokeId:"bb")
        
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
