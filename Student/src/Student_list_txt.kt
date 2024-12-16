import java.io.File
import java.io.IOException

class Student_list_txt(filePath: String) : Students_list(readFromTxt(filePath)) {
    companion object {
        fun readFromTxt(path: String): MutableList<Student> {
            val file = File(path)
            if (!file.exists() || !file.canRead()) throw IOException("Path is incorrect!")
            return file.readLines().map { Student(it) }.toMutableList()
        }
    }
    //a
    override fun readFromFile(path: String): MutableList<Student> {
        return readFromTxt(path)
    }
    //b
    override fun writeToFile(path: String) {
        val file = File(path)
        if (!file.exists() || !file.canWrite()) throw IOException("Path is incorrect!")
        students.map { file.appendText(it.toTxt().trim() + "\n") }
        println("Written to $path!\n")
    }
}

