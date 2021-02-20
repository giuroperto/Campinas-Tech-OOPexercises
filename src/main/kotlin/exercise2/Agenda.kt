package exercise2

// TODO: 19/02/2021 remove listSize from function + create a loop to access all the options wanted

fun openContacts(listSize : Int) {

//    var listSize : Int =
    var isFull : Boolean = false

    if (listSize >= 9) {
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
    println(newContact)

}

fun deleteContactScreen() {
    println("#####################################################")
    println("#                                                   #")
    println("#                     CONTACTS                      #")
    println("#                  DELETE CONTACT                   #")
    println("#                                                   #")
    println("#####################################################")

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