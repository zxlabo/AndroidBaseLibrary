package com

/**
 * author : Naruto
 * date   : 2021/5/14
 * desc   :
 * version:
 */
sealed class Day{

}

class Week : Day() {

}
sealed class Person{
    data class YellowPerson(val name:String):Person()
    data class WhitePerson(val name:String,val age:Int):Person()
    object BlackCat:Person()
}
fun name(person:Person):String=when(person){
    is Person.YellowPerson->person.name
    is Person.WhitePerson->person.name+person.age
    Person.BlackCat->{ ""}
}