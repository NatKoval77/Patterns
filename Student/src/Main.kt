package src

import Data.Data_list_student_short
import FileList.JsonFileStrategy
import FileList.TxtFileStrategy
import FileList.YamlFileStrategy
import Student.Student
import Student.Student_list
import Student.Student_short
import java.io.File
import java.sql.DriverManager
import java.sql.Connection

fun main() {
    testDB()
}

fun execQ(q: String, con: Connection) {
    con.createStatement().use { statement ->
        val res = statement.executeQuery(q)
        println("Query result:")
        while (res.next()) {
            println("ID: ${res.getInt("id")}, Name: ${res.getString("name")}, " +
                    "Surname: ${res.getString("surname")}, Patronymic: ${res.getString("patronymic")}," +
                    "Tg: ${res.getString("tg")}, Git: ${res.getString("git")}," +
                    "Email: ${res.getString("email")}, Phone: ${res.getString("phone")}.")
        }
    }
}

fun testDB(){
    val url = "jdbc:postgresql://localhost:5432/postgres"
    val user = "postgres"
    val pass = "1234"
    var connection: Connection? = null
    try {
        connection = DriverManager.getConnection(url, user, pass)
        println("Connected to PostgreSQL database!")
        var sql = File("src/SQL/createTable.sql").readText()
        var stat = connection.createStatement()
        stat.execute(sql)
        println("SQL script exec success! (CREATE)")
        sql = File("src/SQL/insertData.sql").readText()
        stat = connection.createStatement()
        stat.execute(sql)
        println("SQL script exec success! (INSERT)")
        // first query - not null field "phone"
        // second query - all not null fiels
        // third query - no more than 1 null field
        val queries = File("src/SQL/selectData.sql").readText()
        queries.split(";").forEach { query ->
            val trimQ = query.trim()
            if (trimQ.isNotEmpty()) execQ(trimQ, connection)
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        connection?.close()
    }
}

fun testThird(){
    try {
        var pathR = ".//stud.txt"
        var pathW = ".//student.txt"
        val stListTxt = Student_list(TxtFileStrategy())
        stListTxt.readFromFile(pathR)
        println("Found student: ${stListTxt.findById(2)}\n")
        stListTxt.writeToFile(pathW)
        println("Count: ${stListTxt.get_count()}\n")
        stListTxt.orderStudents()
        println("Ordered:\n")
        stListTxt.get_k_n_student_short_list(0,3)
        var idRem = 3
        stListTxt.removeById(idRem)
        println("After removing $idRem\n")
        stListTxt.get_k_n_student_short_list(0,3)
        println("Count: ${stListTxt.get_count()}\n")
        stListTxt.addStudent(
            Student(3, "Tomb", "Raider", "Third",
            git = "github.com/RuMiJ", phone = "+78889990000")
        )
        println("After adding:\n")
        stListTxt.get_k_n_student_short_list(0,5)
        stListTxt.replaceStudentById(2,
            Student(2, "Ruby", "John", "Milligan",
            git = "github.com/RuMiJ", phone = "81234567890")
        )
        println("After replacing:\n")
        stListTxt.get_k_n_student_short_list(0,3)
        println("- - - END OF TXT! - - -\n")

        pathR = ".//testR.json"
        val stListJson = Student_list(JsonFileStrategy())
        stListJson.readFromFile(pathR)
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
        val stListYaml = Student_list(YamlFileStrategy())
        stListYaml.readFromFile(pathR)
        pathW = ".//write.yaml"
        println("Found student: ${stListYaml.findById(2)}\n")
        stListYaml.writeToFile(pathW)
        stListYaml.orderStudents()
        println("Ordered:\n")
        stListYaml.get_k_n_student_short_list(0, 5)
        stListYaml.replaceStudentById(2,
            Student(2, "Ruby", "John", "Milligan",
            git = "github.com/RuMiJ", email = "rubymilligan@example.com", phone = "81234567890")
        )
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