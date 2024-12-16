import org.yaml.snakeyaml.Yaml
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException

class Students_list_YAML(filePath: String) : Students_list(readFromYaml(filePath)) {
    private val yaml = Yaml()
    companion object {
        fun readFromYaml(path: String): MutableList<Student> {
            val file = File(path)
            if (!file.exists() || !file.canRead()) throw IOException("Path is incorrect!")
            val yaml = Yaml()
            val reader = FileReader(file)
            val yamlData = yaml.load(reader) as List<Map<String, Any>>
            return yamlData.map {
                Student(
                    id = (it["id"] as Number).toInt(),
                    surname = (it["surname"] as String),
                    name = (it["name"] as String),
                    patronymic = (it["patronymic"] as String),
                    tg = it["tg"]?.toString(),
                    git = it["git"]?.toString(),
                    email = it["email"]?.toString(),
                    phone = it["phone"]?.toString()
                )
            }.toMutableList()
        }
    }
    //a
    override fun readFromFile(path: String): MutableList<Student> {
        return readFromYaml(path)
    }
    //b
    override fun writeToFile(path: String) {
        val file = File(path)
        if (!file.exists() || !file.canRead()) throw IOException("Path is incorrect!")
        if (!file.exists()) file.createNewFile()
        val writer = FileWriter(file)
        val data = students.map {
            mapOf(
                "id" to it.id,
                "surname" to it.surname,
                "name" to it.name,
                "patronymic" to it.patronymic,
                "tg" to it.tg,
                "git" to it.git,
                "email" to it.email,
                "phone" to it.phone
            )
        }
        yaml.dump(data, writer)
        writer.close()
    }
}
