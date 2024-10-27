class Student(
    var id: Int, var surname: String, var name: String, var patronymic: String, var tg: String? = null,
    var git: String? = null, var email: String? = null, var phone: String? = null
) {
    companion object {
        fun isValidPhone(phone: String): Boolean {
            return phone.matches(Regex("^(\\+7[0-9]{10}|8[0-9]{10})\$"))
        }
    }

    init {
        if (phone != null && !isValidPhone(phone!!))
            throw IllegalArgumentException("Неверный формат номера!")
        println("Студент $id был добавлен успешно!")
        write()
    }

    constructor(id: Int, surname: String, name: String, patronymic: String):
            this(id, surname, name, patronymic, null, null, null, null)

    constructor(hashStudents: HashMap<String, Any?>) : this(
        (hashStudents["id"] as? Int) ?: throw IllegalArgumentException("ID обязателен"),
        (hashStudents["surname"] as? String) ?: throw IllegalArgumentException("Фамилия обязательна"),
        (hashStudents["name"] as? String) ?: throw IllegalArgumentException("Имя обязательно"),
        (hashStudents["patronymic"] as? String) ?: throw IllegalArgumentException("Отчество обязательно"),
        hashStudents["phone"]?.toString(),
        hashStudents["tg"]?.toString(),
        hashStudents["email"]?.toString(),
        hashStudents["git"]?.toString()
    )

    fun write() {
        println(
            "Студент $id:\n" + "ФИО - $surname $name $patronymic; " + "Телеграм - ${tg?: "[не указано]"}; " +
                    "Гит - ${git?: "[не указано]"}; " + "Почта - ${email?: "[не указано]"}; " + "Телефон - ${phone?: "[не указано]"}.\n"
        )
    }

}
