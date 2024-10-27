fun main() {
    try {
        val frst = Student(1, "Ralf", "Bobby", "Braun", "@RaBBiT")
        val sec = Student(2, "Ruby", "John", "Milligan", git = "github.com/RuMiJ")
        val thrd = Student(3, "Tomb", "Raider", "Third", phone = "+78889990000")
        val ph = Student(4, "Tommy", "Doggy", "Poppy", email = "TDP@mail.ru",phone = "81234567890")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}