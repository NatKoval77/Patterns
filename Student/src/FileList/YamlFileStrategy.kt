package FileList

import Student.Student
import org.yaml.snakeyaml.Yaml
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException

class YamlFileStrategy : FileStrategy {
    private val yaml = Yaml()
    override fun read(path: String): MutableList<Student> {
        val file = File(path)
        if (!file.exists() || !file.canRead()) throw IOException("Path is incorrect!")
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
    override fun write(path: String, students: MutableList<Student>) {
        val file = File(path)
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