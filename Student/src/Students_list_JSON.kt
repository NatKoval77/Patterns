import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.io.IOException

class Students_list_JSON(filePath: String) : Students_list(readFromJson(filePath)) {
    private val gson = Gson()
    companion object {
        fun readFromJson(path: String): MutableList<Student> {
            val file = File(path)
            if (!file.exists() || !file.canRead()) throw IOException("Path is incorrect!")
            return Gson().fromJson(file.readText(), object : TypeToken<MutableList<Student>>() {}.type)
        }
    }
    //a
    override fun readFromFile(path: String): MutableList<Student> {
        return readFromJson(path)
    }
    //b
    override fun writeToFile(path: String) {
        val file = File(path)
        if (!file.exists() || !file.canWrite()) throw IOException("Path is incorrect!")
        file.writeText(gson.toJson(students))
    }
}

