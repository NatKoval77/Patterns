package FileList

import Student.Student

interface FileStrategy {
    fun read(path: String): MutableList<Student>
    fun write(path: String, students: MutableList<Student>)
}
