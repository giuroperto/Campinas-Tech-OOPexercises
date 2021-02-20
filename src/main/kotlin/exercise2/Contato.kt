package exercise2

class Contato() {

//    var contactsList: MutableMap<String, String> = mutableMapOf()
//    var contactsList: MutableMap<String, String> = mutableMapOf("giulia" to "010101")
    var contactsList: MutableMap<String, String> = mutableMapOf("010101" to "giulia", "020202" to "henrique", "030303" to "cristina", "040404" to "giulia")

    fun saveContact(name: String, phone: String): String {

        var existingContact : Boolean = checkContact(name = name, phone =  phone)
        var message : String

        if (!existingContact) {
            contactsList.put(phone, name.toLowerCase())
            println(contactsList)
            message = "New contact added to your contacts list!"
        } else {
            message = "This contact already exists!"
        }

        return message
    }

    fun removeContact(): String {
        return "remove contact"
    }

    fun searchContact(searchName: String) {

        var filteredList = contactsList.filter { it.value == searchName.toLowerCase() }

        if (filteredList.isNotEmpty()) {
            println(filteredList.map { (phone, name) -> "\n Name: ${name.capitalize()} - Phone: $phone" })
        } else {
            println("This contact is not in your contacts yet.")
        }
    }

    fun showAllContacts() {

        println(contactsList.map { (phone, name) -> "\n Name: ${name.capitalize()} - Phone: $phone" })

    }

    fun checkContact(name: String, phone: String) : Boolean {
        var listLength : Int = contactsList.size
        var isContact : Boolean = false

        for (i in 0..listLength) {
            if (contactsList[phone] == name.toLowerCase()) {
                isContact = true
            }
        }

        return isContact
    }
}