class Student_list(private var fileStrategy: FileStrategy, protected var students: MutableList<Student> = mutableListOf()) {
    fun readFromFile(path: String): MutableList<Student> {
        students = fileStrategy.read(path)
        return students
    }
    fun writeToFile(path: String) {
        fileStrategy.write(path, students)
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
