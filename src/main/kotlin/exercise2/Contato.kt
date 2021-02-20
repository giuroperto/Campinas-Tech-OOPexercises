package exercise2

class Contato() {

    var contactsList: MutableMap<String, String> = mutableMapOf()

    fun saveContact(name: String, phone: String): String {

        var existingContact : Boolean = checkContact(name = name, phone =  phone)
        var message : String
        var existingPhone : Boolean = contactsList.containsKey(phone)

        if (!existingPhone && !existingContact) {
            contactsList.put(phone, name.toLowerCase())
            message = "New contact added to your contacts list!"
        } else {
            message = "This contact already exists!"
        }

        return message
    }

    fun removeContact(removeName: String, removePhone: String): String {

        var existingContact : Boolean = checkContact(name = removeName, phone =  removePhone)
        var message : String

        if (existingContact) {
            contactsList = contactsList.minus(key = removePhone).toMutableMap()
            message = "The contact was successfully deleted!"
        } else {
            message = "There is no such contact in the contact list, so no data was removed!"
        }

        return message
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

        if (contactsList.isNotEmpty()) {
            println(contactsList.map { (phone, name) -> "\n Name: ${name.capitalize()} - Phone: $phone" })
        } else {
            println("No data in your contact list!")
        }
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

    fun getListLength() : Int {
        return contactsList.size
    }
}