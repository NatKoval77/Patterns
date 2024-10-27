class Student(
    id: Int, surname: String, name: String, patronymic: String, tg: String? = null,
    git: String? = null, email: String? = null, phone: String? = null
) {
    var id: Int = id
        get() = field
        set(value) {
            field = value
        }
    var surname: String = surname
        get() = field
        set(value) {
            field = value
        }
    var name: String = name
        get() = field
        set(value) {
            field = value
        }
    var patronymic: String? = patronymic
        get() = field
        set(value) {
            field = value
        }
    var phone: String? = phone
        get() = field
        set(value) {
            field = value
        }
    var tg: String? = tg
        get() = field
        set(value) {
            field = value
        }
    var email: String? = email
        get() = field
        set(value) {
            field = value
        }
    var git: String? = git
        get() = field
        set(value) {
            field = value
        }

    fun write() {
        println(
            "Студент $id:\n" + "ФИО - $surname $name $patronymic; " + "Телеграм - ${tg?: "[не указано]"}; " +
                    "Гит - ${git?: "[не указано]"}; " + "Почта - ${email?: "[не указано]"}; " + "Телефон - ${phone?: "[не указано]"}.\n"
        )
    }
}
