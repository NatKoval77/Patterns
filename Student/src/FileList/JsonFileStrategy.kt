package FileList

import Student.Student
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.IOException

class JsonFileStrategy : FileStrategy {
    private val gson = Gson()
    override fun read(path: String): MutableList<Student> {
        val file = File(path)
        if (!file.exists() || !file.canRead()) throw IOException("Path is incorrect!")
        return gson.fromJson(file.readText(), object : TypeToken<MutableList<Student>>() {}.type)
    }
    override fun write(path: String, students: MutableList<Student>) {
        val file = File(path)
        if (!file.exists() || !file.canWrite()) throw IOException("Path is incorrect!")
        file.writeText(gson.toJson(students))
    }
}