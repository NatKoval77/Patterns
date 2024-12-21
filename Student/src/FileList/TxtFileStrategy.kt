package FileList

import Student.Student
import java.io.File
import java.io.IOException

class TxtFileStrategy : FileStrategy {
    override fun read(path: String): MutableList<Student> {
        val file = File(path)
        if (!file.exists() || !file.canRead()) throw IOException("Path is incorrect!")
        return file.readLines().map { Student(it) }.toMutableList()
    }
    override fun write(path: String, students: MutableList<Student>) {
        val file = File(path)
        if (!file.exists() || !file.canWrite()) throw IOException("Path is incorrect!")
        students.map { file.appendText(it.toTxt().trim() + "\n") }
    }
}