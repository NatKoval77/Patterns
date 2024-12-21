package src.Student

import Student.Student
import Student.Student_short
import java.sql.Connection
import java.sql.DriverManager
import java.sql.ResultSet

class Student_list_DB private constructor() {
    // singleton
    companion object {
        @Volatile
        private var INSTANCE: Student_list_DB? = null
        fun getInstance(): Student_list_DB = INSTANCE ?: synchronized(this) {
            INSTANCE ?: Student_list_DB().also { INSTANCE = it }
        }
    }
    private lateinit var connection: Connection
    init {
        try {
            connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/postgres",
                "postgres",
                "1234"
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    fun executeQuery(query: String): ResultSet? {
        return try {
            val stat = connection.createStatement()
            stat.executeQuery(query)
        } catch (e: Exception) {
            // e.printStackTrace()
            null
        }
    }
    // Получение студента по ID
    fun findById(id: Int) {
        val res = executeQuery("SELECT * FROM student WHERE id = ${id};")
        if (res != null) {
            while (res.next()) {
                for (stud in 1..res.metaData.columnCount) print("${res.getString(stud)}\t")
                println()
            }
        }
    }
    // Получение подсписка студентов
    fun get_k_n_student_short_list(k: Int, n: Int): MutableList<Student_short> {
        val res = executeQuery("Select * FROM student WHERE id > ${k * n} ORDER BY id LIMIT ${n};")
        val studList = mutableListOf<Student_short>()
        res?.let {
            while (it.next()) {
                val input = (2..it.metaData.columnCount).joinToString(" ") { index -> it.getString(index) }
                studList.add(Student_short(Student(input)))
            }
        }
        return studList
    }

    fun addStudent(student: Student) {
        val input = buildString {
            append("'${student.surname}', '${student.name}', '${student.patronymic}'")
            append(", ${student.tg?.let { "'$it'" } ?: "NULL"}")
            append(", ${student.git?.let { "'$it'" } ?: "NULL"}")
            append(", ${student.email?.let { "'$it'" } ?: "NULL"}")
            append(", ${student.phone?.let { "'$it'" } ?: "NULL"}")
        }
        executeQuery("INSERT INTO student (surname, name, patronymic, tg, git, email, phone) VALUES ($input);")
    }
    fun removeById(id: Int) {
        executeQuery("DELETE FROM student WHERE id=${id};")
    }
    fun get_count(): Int {
        val res = executeQuery("SELECT COUNT(*) FROM student;")
        return if (res?.next() == true) res.getInt("count")
        else 0
    }
    fun replaceStudentById(id: Int, student: Student) {
        val input = buildString {
            append("'${student.surname}', '${student.name}', '${student.patronymic}'")
            append(", ${student.tg?.let { "'$it'" } ?: "NULL"}")
            append(", ${student.git?.let { "'$it'" } ?: "NULL"}")
            append(", ${student.email?.let { "'$it'" } ?: "NULL"}")
            append(", ${student.phone?.let { "'$it'" } ?: "NULL"}")
        }
        executeQuery("UPDATE student SET (surname, name, patronymic, tg, git, email, phone) = ($input) WHERE id = $id;")
    }
}