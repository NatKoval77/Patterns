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

    fun write() {
        println(
            "Студент $id:\n" + "ФИО - $surname $name $patronymic; " + "Телеграм - ${tg?: "[не указано]"}; " +
                    "Гит - ${git?: "[не указано]"}; " + "Почта - ${email?: "[не указано]"}; " + "Телефон - ${phone?: "[не указано]"}.\n"
        )
    }

}
