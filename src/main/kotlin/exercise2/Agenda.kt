package exercise2

// TODO: 19/02/2021 remove listSize from function + fix add and remove contact

var globalListLength : Int = 0


fun openContacts() {
    var isFull : Boolean = false
    var doContinue : Int = 0

    println("List Size $globalListLength")

    while (doContinue != 1) {
        if (globalListLength >= 9) {
            isFull = true

            println("#####################################################")
            println("#                                                   #")
            println("#                     CONTACTS                      #")
            println("#                                                   #")
            println("#####################################################")
            println("Welcome! Unfortunately your contacts list has reached its limit, hence you cannot add a new contact until you delete one.")
            println("Choose one of the following to proceed:")
            println("2 - Delete contact")
            println("3 - Search contact")
            println("4 - Show all contacts")
        } else {
            isFull = false

            println("#####################################################")
            println("#                                                   #")
            println("#                    CONTACTS                       #")
            println("#                                                   #")
            println("#####################################################")
            println("Welcome! Please choose one of the following options to proceed:")
            println("1 - Create new contact")
            println("2 - Delete contact")
            println("3 - Search contact")
            println("4 - Show all contacts")
        }

        var response : String = readLine() ?: "You haven't informed a valid option!"

        if (isFull) {
            when(response) {
                "1" -> println("Your contacts list is full. You cannot add a new contact!")
                "2" -> deleteContactScreen()
                "3" -> searchContactScreen()
                "4" -> showContactScreen()
                else -> "Sorry, I didn't understand your option. Please try again."
            }
        } else {
            when(response) {
                "1" -> saveContactScreen()
                "2" -> deleteContactScreen()
                "3" -> searchContactScreen()
                "4" -> showContactScreen()
                else -> "Sorry, I didn't understand your option. Please try again."
            }
        }

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

fun saveContactScreen() {
    println("#####################################################")
    println("#                                                   #")
    println("#                     CONTACTS                      #")
    println("#               CREATE NEW CONTACT                  #")
    println("#                                                   #")
    println("#####################################################")
    println("What's your contact's name?")

    var contactName : String = readLine() ?: "You need to inform a name in order to proceed"
    println("And the phone?")
    var contactPhone : String = readLine() ?: "You need to inform a phone in order to proceed"

    var newContact : String = Contato().saveContact(name = contactName, phone = contactPhone)
    println("")
    println("------------------------------------------------")
    println(newContact)

    globalListLength = Contato().getListLength()
    println(globalListLength)

}

fun deleteContactScreen() {
    println("#####################################################")
    println("#                                                   #")
    println("#                     CONTACTS                      #")
    println("#                  DELETE CONTACT                   #")
    println("#                                                   #")
    println("#####################################################")
    println("Who do you want to delete from your contacts?")

    var contactName : String = readLine() ?: "You need to inform a name in order to proceed"
    println("And what is this person's phone?")
    var contactPhone : String = readLine() ?: "You need to inform a phone in order to proceed"

    var deletedContact : String = Contato().removeContact(removeName = contactName, removePhone = contactPhone)
    println("")
    println("------------------------------------------------")
    println(deletedContact)

    globalListLength = Contato().getListLength()
    println(globalListLength)

}

fun searchContactScreen() {
    println("#####################################################")
    println("#                                                   #")
    println("#                     CONTACTS                      #")
    println("#                  SEARCH CONTACT                   #")
    println("#                                                   #")
    println("#####################################################")
    println("Who do you want to search for?")

    var contactName : String = readLine() ?: "You need to inform a name in order to proceed"

    Contato().searchContact(contactName)
}

fun showContactScreen() {
    println("#####################################################")
    println("#                                                   #")
    println("#                     CONTACTS                      #")
    println("#                SHOW ALL CONTACTS                  #")
    println("#                                                   #")
    println("#####################################################")

    Contato().showAllContacts()
}