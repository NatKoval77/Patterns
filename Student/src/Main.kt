fun main() {
    try {
        val frst = Student(1, "Ralf", "Bobby", "Braun", "@RaBBiT", git = "github.com/RuMiJ")
        val sec = Student(2, "Ruby", "John", "Milligan", git = "github.com/RuMiJ", phone = "81234567890")
        val thrd = Student(3, "Tomb", "Raider", "Third", git = "github.com/RuMiJ", phone = "+78889990000")
        thrd.set_contacts(tg = "@adood")
        thrd.write()
        val ph = Student(4, "Tommy", "Doggy", "Poppy", email = "TDP@mail.ru")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}