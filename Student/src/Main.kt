fun main() {
    testThird()
}

fun testThird(){
    try {
        var pathR = ".//stud.txt"
        var pathW = ".//student.txt"
        val studentListManager = Student_list_txt(pathR)
        println("Found student: ${studentListManager.findById(2)}\n")
        studentListManager.writeToFile(pathW)
        println("Count: ${studentListManager.get_count()}\n")
        studentListManager.orderStudents()
        println("Ordered:\n")
        studentListManager.get_k_n_student_short_list(0,3)
        var idRem = 3
        studentListManager.removeById(idRem)
        println("After removing $idRem\n")
        studentListManager.get_k_n_student_short_list(0,3)
        println("Count: ${studentListManager.get_count()}\n")
        studentListManager.addStudent(
            Student(3, "Tomb", "Raider", "Third",
            git = "github.com/RuMiJ", phone = "+78889990000"))
        println("After adding:\n")
        studentListManager.get_k_n_student_short_list(0,5)
        studentListManager.replaceStudentById(2,
            Student(2, "Ruby", "John", "Milligan",
            git = "github.com/RuMiJ", phone = "81234567890"))
        println("After replacing:\n")
        studentListManager.get_k_n_student_short_list(0,3)
        println("- - - END OF TXT! - - -\n")

        pathR = ".//testR.json"
        val stListJson = Students_list_JSON(pathR)
        pathW = ".//testW.json"
        stListJson.writeToFile(pathW)
        stListJson.get_k_n_student_short_list(0,3)
        println("Found student: ${stListJson.findById(2)}\n")
        idRem = 3
        stListJson.removeById(idRem)
        println("After removing $idRem\n")
        stListJson.get_k_n_student_short_list(0,3)
        println("- - - END OF JSON! - - -\n")

        pathR = ".//read.yaml"
        val stListYaml = Students_list_YAML(pathR)
        pathW = ".//write.yaml"
        println("Found student: ${stListYaml.findById(2)}\n")
        stListYaml.writeToFile(pathW)
        stListYaml.orderStudents()
        println("Ordered:\n")
        stListYaml.get_k_n_student_short_list(0, 5)
        stListYaml.replaceStudentById(2,
            Student(2, "Ruby", "John", "Milligan",
            git = "github.com/RuMiJ", email = "rubymilligan@example.com", phone = "81234567890"))
        println("After replacing:\n")
        stListYaml.get_k_n_student_short_list(0, 5)
        println("- - - END OF YAML! - - -\n")
    }
    catch (e: Exception) {
        println(e.message)
    }
}

fun testSecond(){
    try {
        val st1 = Student_short(4, "Иванов И.И., github.com/ivanov, +79995456556")
        val st2 = Student_short(5, "Петров П.П.", "github.com/petrov", "petrov@mail.ru")
        val thrd = Student(6, "Сидоров", "Семен", "Сергеевич", "@sidrrr", "github.com/sidorov")
        val st3 = Student_short(thrd)
        val students = arrayOf(st1,st2,st3,st1,st2,st3,st1,st2,st3,)
        val studentList = Data_list_student_short(students)
        println("Имена аттрибутов: ${studentList.buildNames().joinToString()}")
        println("Сущности аттрибутов:\n${studentList.buildData()}")
        println("Сущности аттрибутов:\n${studentList.buildData()}")
    }
    catch (e: Exception) {
        println(e.message)
    }
}

fun testFirst(){
    try {
        val frst = Student(1, "Ralf", "Bobby", "Braun", "@RaBBiT", git = "github.com/RuMiJ")
        val sec = Student(2, "Ruby", "John", "Milligan", git = "github.com/RuMiJ", phone = "81234567890")
        val thrd = Student(3, "Tomb", "Raider", "Third", git = "github.com/RuMiJ", phone = "+78889990000")
        thrd.setContacts(tg = "@adood")
        thrd.write()
        val ph = Student(4, "Tommy", "Doggy", "Poppy", email = "TDP@mail.ru")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}