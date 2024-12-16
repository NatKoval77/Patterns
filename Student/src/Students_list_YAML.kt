import org.yaml.snakeyaml.Yaml
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.io.IOException

class Students_list_YAML(private var students: MutableList<Student>) {
    private val yaml = Yaml()
    constructor() : this(mutableListOf())
    constructor(filePath: String) : this(mutableListOf()) {
        students = readFromYaml(filePath)
    }
    //a
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
    //b
    fun writeToYaml(path: String) {
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
    //c
    fun findById(id: Int): Student {
        return students.first { it.id == id}
    }
    //d
    // n - начиная с какого элемента k - кол-во элементов
    fun get_k_n_student_short_list(n: Int, k: Int): Data_list<Student_short> {
        require(n >= 0) { "Индекс n должен быть больше или равен 0." }
        require(k > 0) { "Количество k должно быть больше 0." }
        return Data_list_student_short(students.drop(n).take(k).map { Student_short(it) }.toTypedArray())
    }
    //e
    fun orderStudents() {
        students = students.sortedWith(compareBy { it.getIn() }).toMutableList()
    }
    //f
    fun addStudent(newSt: Student) {
        val newId = if (students.isEmpty()) 1 else students.maxOf { it.id } + 1
        val student = Student(newId, newSt.surname, newSt.name, newSt.patronymic,
            newSt.tg, newSt.git, newSt.email, newSt.phone)
        students.add(student)
        println("Студент с ID ${student.id} добавлен!\n")
    }
    //g
    fun replaceStudentById(id: Int, updSt: Student): Boolean {
        val i = students.indexOfFirst { it.id == id }
        if (i != -1) {
            students[i] = Student(id, updSt.surname, updSt.name, updSt.patronymic,
                updSt.tg, updSt.git, updSt.email, updSt.phone)
            println("Студент с ID $id заменен!\n")
            return true
        } else {
            println("Студент с ID $id не найден!")
            return false
        }
    }
    //h
    fun removeById(id: Int) {
        students.removeIf { it.id == id }
    }
    //i
    fun get_count(): Int = students.count()
}
