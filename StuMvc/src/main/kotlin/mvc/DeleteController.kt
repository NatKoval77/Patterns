package mvc
import studentsLists.StudentList

class DeleteController(var view:View, source:StudentList) {
    private val pg=source

    fun deleteStudent(id:Int) {
        pg.deleteStudent(id)
    }
}