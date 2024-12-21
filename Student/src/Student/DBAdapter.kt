package src.Student

import FileList.FileStrategy
import Student.Student
import Student.Student_short

class DBAdapter : FileStrategy {
    private val dbInstance = Student_list_DB.getInstance()

    override fun read(path: String): MutableList<Student> {
        val students = mutableListOf<Student>()
        val count = dbInstance.get_count()
        for (id in 1..count) {
            val result = dbInstance.executeQuery("SELECT * FROM student WHERE id = $id;")
            result?.let {
                while (it.next()) {
                    students.add(
                        Student(
                            id = it.getInt("id"),
                            surname = it.getString("surname"),
                            name = it.getString("name"),
                            patronymic = it.getString("patronymic"),
                            tg = it.getString("tg"),
                            git = it.getString("git"),
                            email = it.getString("email"),
                            phone = it.getString("phone")
                        )
                    )
                }
            }
        }
        return students
    }

    override fun write(path: String, students: MutableList<Student>) {
        students.forEach { dbInstance.addStudent(it) }
    }

    fun findById(id: Int): Student? {
        val res = dbInstance.executeQuery("SELECT * FROM student WHERE id = $id;")
        return if (res != null && res.next()) {
            Student(
                id = res.getInt("id"),
                surname = res.getString("surname"),
                name = res.getString("name"),
                patronymic = res.getString("patronymic"),
                tg = res.getString("tg"),
                git = res.getString("git"),
                email = res.getString("email"),
                phone = res.getString("phone")
            )
        } else null
    }

    fun get_k_n_student_short_list(n: Int, k: Int): List<Student_short> {
        return dbInstance.get_k_n_student_short_list(n, k)
    }

    fun orderStudents(): List<Student> {
        val res = dbInstance.executeQuery("SELECT * FROM student ORDER BY surname;")
        val students = mutableListOf<Student>()
        res?.let {
            while (it.next()) {
                students.add(
                    Student(
                        id = it.getInt("id"),
                        surname = it.getString("surname"),
                        name = it.getString("name"),
                        patronymic = it.getString("patronymic"),
                        tg = it.getString("tg"),
                        git = it.getString("git"),
                        email = it.getString("email"),
                        phone = it.getString("phone")
                    )
                )
            }
        }
        return students
    }

    fun addStudent(newSt: Student) {
        dbInstance.addStudent(newSt)
    }

    fun replaceStudentById(id: Int, updSt: Student): Boolean {
        dbInstance.replaceStudentById(id, updSt)
        return true
    }

    fun removeById(id: Int) {
        dbInstance.removeById(id)
    }

    fun get_count(): Int {
        return dbInstance.get_count()
    }
}
