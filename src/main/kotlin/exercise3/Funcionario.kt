package exercise3

abstract class Funcionario(var ID: String, var name: String, var CPF: String, var salary: Double) {

    abstract fun updateSalary() : String

}

class Gestor(var IDGestor: String,
             var nameGestor: String,
             var CPFGestor: String,
             var salaryGestor: Double) : Funcionario(ID = IDGestor, name = nameGestor, CPF = CPFGestor, salary = salaryGestor) {

    override fun updateSalary(): String {
        salary *= 1.1
        return "Manager's salary updated!"
    }
}

class Programador(var IDProgramador: String,
             var nameProgramador: String,
             var CPFProgramador: String,
             var salaryProgramador: Double) : Funcionario(ID = IDProgramador, name = nameProgramador, CPF = CPFProgramador, salary = salaryProgramador) {

    override fun updateSalary(): String {
        salary *= 1.2
        return "Programmer's salary updated!"
    }
}