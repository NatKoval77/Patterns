class Student(
    var id: Int, var surname: String, var name: String, var patronymic: String, var tg: String? = null,
    var git: String? = null, var email: String? = null, var phone: String? = null
) {
    init {
        println("Студент $id был добавлен успешно!")
        write()
    }

    constructor(id: Int, surname: String, name: String, patronymic: String):
            this(id, surname, name, patronymic, null, null, null, null)

    constructor(hashSt: HashMap<String, Any?>) : this(
        (hashSt["id"] as? Int) ?: throw IllegalArgumentException("ID обязателен"),
        (hashSt["surname"] as? String) ?: throw IllegalArgumentException("Фамилия обязательна"),
        (hashSt["name"] as? String) ?: throw IllegalArgumentException("Имя обязательно"),
        (hashSt["patronymic"] as? String) ?: throw IllegalArgumentException("Отчество обязательно"),
        hashSt["phone"]?.toString(),
        hashSt["tg"]?.toString(),
        hashSt["email"]?.toString(),
        hashSt["git"]?.toString()
    )

    fun write() {
        println(
            "Студент $id:\n" + "ФИО - $surname $name $patronymic; " + "Телеграм - ${tg?: "[не указано]"}; " +
                    "Гит - ${git?: "[не указано]"}; " + "Почта - ${email?: "[не указано]"}; " + "Телефон - ${phone?: "[не указано]"}.\n"
        )
    }

}
