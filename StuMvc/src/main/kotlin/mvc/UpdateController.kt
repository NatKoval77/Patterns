package mvc
import Student
import studentsLists.StudentList

class UpdateController(var view:View,source:StudentList) {
    private val pg=source

    fun updateStudent(id:Int,lastName:String,name:String,fatherName:String,phone:String,telegram:String,mail:String,git:String) {
        pg.replaceStudent(id,Student(_lastname = lastName,name,fatherName,phone,telegram,mail,git))
    }

    fun getStudent(id:Int): List<String?> {
        val stud = pg.getById(id)
        return listOf(stud?.lastname?:"",stud?.name?:"",stud?.fathername?:"",stud?.phone?:"",stud?.telegram?:"",stud?.mail?:"",stud?.git?:"")
    }
}