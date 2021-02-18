package exercise1

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Month
import java.time.format.DateTimeFormatter
import java.util.*

data class Pessoa(private val nome: String, private val dataNasc: String, private val altura: Double) {
    fun getName() : String {
        return nome
    }

    fun getBirthDate() : String {
        return dataNasc
    }

    fun getHeight() : Double {
        return altura
    }

    fun whoAreYou() : String {
        var dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        var newDate = LocalDate.parse(dataNasc, dateFormatter)

        val mesNasc = when(newDate.month) {
            Month.JANUARY -> "Janeiro"
            Month.FEBRUARY -> "Fevereiro"
            Month.MARCH -> "Marco"
            Month.APRIL -> "Abril"
            Month.MAY -> "Maio"
            Month.JUNE -> "Junho"
            Month.JULY -> "Julho"
            Month.AUGUST -> "Agosto"
            Month.SEPTEMBER -> "Setembro"
            Month.OCTOBER -> "Outubro"
            Month.NOVEMBER -> "Novembro"
            Month.DECEMBER -> "Dezembro"

            else -> "Erro na insercao da data! Verificar se esta no formato dd-mm-aaaas"

        }

        return "$nome nasceu em ${newDate.dayOfMonth} de $mesNasc, tem ${getAge()} anos e possui ${altura}m de altura."
    }

    fun getAge() : Int {
        val personAge : Int
        var dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
        var newDate = LocalDate.parse(dataNasc, dateFormatter)

        val thisDate = LocalDateTime.now()

        if (newDate.month < thisDate.month) {
            personAge = thisDate.year - newDate.year
        } else {
            personAge = thisDate.year - newDate.year - 1
        }

        return personAge
    }
}