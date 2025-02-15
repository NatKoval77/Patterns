package mvc
import studentLists.StudentList

class DeleteController(var view:View,source:StudentList) {

    private val pg=source

    public fun deleteStudent(id:Int)
    {
        pg.deleteStudent(id)
    }
}