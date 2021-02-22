package exercise3

var employeesPosition: MutableMap<String, Int> = mutableMapOf()
var employeesList: MutableList<Funcionario> = mutableListOf()
var arrPosition: Int = 0

fun openSystem() {
    var doContinue : Int = 0

    while (doContinue != 1) {

        println("#####################################################")
        println("#                                                   #")
        println("#                  COMPANY XPTO                     #")
        println("#                    HR SYSTEM                      #")
        println("#                                                   #")
        println("#####################################################")
        println("Welcome! Please choose one of the following options to proceed:")
        println("1 - Add new employee")
        println("2 - Search employee")
        println("3 - Exit")


        var response : String = readLine() ?: "You haven't informed a valid option!"

        when(response) {
            "1" -> addNewEmployee()
            "2" -> searchEmployee()
            "3" -> doContinue = 1
            else -> println("Sorry, I didn't understand your option. Please try again.")
        }

        if (doContinue != 1) {
            println("")
            println("------------------------------------------------")
            println("Do you wish to continue or exit?")
            println("0 - Continue")
            println("1 - Exit")

            var continueExit : Int = readLine()?.toInt() ?: 0

            if (continueExit == 1) {
                doContinue = 1
            }
        }
    }
}

fun addNewEmployee() {
    println("#####################################################")
    println("#                                                   #")
    println("#                   COMPANY XPTO                    #")
    println("#                   NEW EMPLOYEE                    #")
    println("#                                                   #")
    println("#####################################################")
    println("What's the employee's name?")

    var addEmployeeName : String = readLine() ?: "You need to inform a name in order to proceed"

    println("And the ID?")

    var addEmployeeId : String = readLine() ?: "You need to inform an ID in order to proceed"

    println("And the CPF?")

    var addEmployeeCPF : String = readLine() ?: "You need to inform a CPF in order to proceed"

    println("Finally, what's the employee's salary?")

    var addEmployeeSalary : Double = readLine()?.toDouble() ?: 0.0

    println("Alright, we are almost done. Now select the appropriate option among the following:")
    println("1 - if the new employee is a MANAGER")
    println("2 - if the new employee is a PROGRAMMER")

    var employeeType : String = readLine() ?: "You need to inform the new employee's role in order to proceed"

    println("")
    println("------------------------------------------------")

    when (employeeType) {
        "1" -> println(addManager(managerName = addEmployeeName, managerId = addEmployeeId, managerCPF = addEmployeeCPF, managerSalary = addEmployeeSalary))
        "2" -> println(addProgrammer(programmerName = addEmployeeName, programmerId = addEmployeeId, programmerCPF = addEmployeeCPF, programmerSalary = addEmployeeSalary))
        else -> println("Role not found. Please try again.")
    }
}

fun addManager(managerName: String, managerId: String, managerCPF: String, managerSalary: Double) : String {
    employeesList.add(Gestor(nameGestor = managerName, IDGestor = managerId, CPFGestor = managerCPF, salaryGestor = managerSalary))
    employeesPosition.put(key = managerId, value = arrPosition)
    arrPosition += 1

    return "Manager $managerName added to the system!"

}

fun addProgrammer(programmerName: String, programmerId: String, programmerCPF: String, programmerSalary: Double) : String {
    employeesList.add(Programador(nameProgramador = programmerName, IDProgramador = programmerId, CPFProgramador = programmerCPF, salaryProgramador = programmerSalary))
    employeesPosition.put(key = programmerId, value = arrPosition)
    arrPosition += 1

    return "Programmer $programmerName added to the system!"
}

fun searchEmployee() {
    println("#####################################################")
    println("#                                                   #")
    println("#                   COMPANY XPTO                    #")
    println("#                  SEARCH EMPLOYEE                  #")
    println("#                                                   #")
    println("#####################################################")
    println("Who do you want to search for? (ID)")

    var employeeId : String = readLine() ?: "You need to inform an id in order to proceed"

    if (employeesPosition.containsKey(employeeId)) {
        println("")
        println("Select an option:")
        println("1 - Show employee's data")
        println("2 - Pay raise")

        var searchOption : String = readLine() ?: "Please select an option in order to proceed"

        when (searchOption) {
            "1" -> showEmployeeData(employeeId)
            "2" -> updateEmployeeSalary(employeeId)
            else -> println("Option not found. Please try again.")
        }
    } else {
        println("")
        println("!!")
        println("ID not found!")
    }

}

fun showEmployeeData(employeeId : String) {
    println("#####################################################")
    println("#                                                   #")
    println("#                   COMPANY XPTO                    #")
    println("#                 EMPLOYEE DETAILS                  #")
    println("#                                                   #")
    println("#####################################################")

    // as I've verified beforehand if it was null -> using non-null asserted
    var employeePosition : Int = employeesPosition[employeeId]!!.toInt()
    var searchedEmployee : Funcionario = employeesList[employeePosition]

    println("------------------------------------------------")
    println("Details of employee: $employeeId")
    println("------------------------------------------------")
    println("Name: ${searchedEmployee.name}")
    println("CPF: ${searchedEmployee.CPF}")
    println("Salary: ${searchedEmployee.salary}")

}

fun updateEmployeeSalary(employeeId : String) {
    println("#####################################################")
    println("#                                                   #")
    println("#                   COMPANY XPTO                    #")
    println("#                    PAY RAISE                      #")
    println("#                                                   #")
    println("#####################################################")

    var employeePosition : Int = employeesPosition[employeeId]!!.toInt()
    var searchedEmployee : Funcionario = employeesList[employeePosition]

    println("")
    println("------------------------------------------------")
    println(searchedEmployee.updateSalary())
    println("------------------------------------------------")
    println("Name: ${searchedEmployee.name}")
    println("CPF: ${searchedEmployee.CPF}")
    println("Salary: ${searchedEmployee.salary}")
}