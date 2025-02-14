import com.fasterxml.jackson.annotation.JsonProperty
open class StudentSuper {
    @field:JsonProperty("id") var id: Int =-1
        set(value)
        {
            if(value>0)
                field=value
        }
    @field:JsonProperty("git") var git: String? = null
        set(value)
        {
            if(validateGit(value))
            {
                field=value
            }
        }

    companion object
    {
        var ids = 0

        fun validatePhone(value:String?): Boolean{
            return value?.matches(Regex("""\+?\d{11}""")) ?: true
        }

        fun validateNames(value:String): Boolean{
            return value.matches(Regex("""[A-Я]{1}[a-я]*"""))
        }

        fun validateTelegram(value:String?): Boolean{
            return value?.matches(Regex("""\@{1}.*""")) ?: true
        }

        fun validateMail(value:String?): Boolean{
            return value?.matches(Regex("""\w*\@\w*\.\w*""")) ?: true
        }

        fun validateGit(value:String?): Boolean{
            return value?.matches(Regex("""https://github.com/.*""")) ?: true
        }
    }

    init
    {
        ids++
    }
}