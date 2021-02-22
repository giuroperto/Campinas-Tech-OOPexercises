import exercise1.Pessoa
import exercise2.openContacts
import exercise3.openSystem

fun main() {
    // Exercise 1
    testEx1()

    // Exercise 2
    testEx2()

    // Exercise 3
    testEx3()

}

fun testEx1() {
    val pessoa = Pessoa(nome = "Giulia", dataNasc = "05-03-1991", altura = 1.73)

    // println(pessoa.nome)
    // println(pessoa.dataNasc)
    // println(pessoa.altura)

    println(pessoa.getName())
    println(pessoa.getBirthDate())
    println(pessoa.getHeight())
    println(pessoa.whoAreYou())
    println(pessoa.getAge())
}

fun testEx2() {
    openContacts()
}

fun testEx3() {
    openSystem()
}
