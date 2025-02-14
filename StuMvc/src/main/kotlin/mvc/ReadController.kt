package mvc
import DataListStudentShort
import studentsLists.StudentList

class ReadController(var view:View,source:StudentList) {
    private val pg=source
    var currentPage = 0
        set(value)
        {
            if(value<=pg.getStudentShortCount()/studentsPerPage&&value>=0)
            {
                field=value
            }
        }
    private var studentsPerPage=5
    var currentFilter =""
    private lateinit var studentShorts:DataListStudentShort

    fun refresh_data() {
        studentShorts=pg.getKNStudentShort(currentPage,studentsPerPage,"")
        view.updatePageLabel( "${currentPage + 1}/${Math.ceil(pg.getKNStudent(0, pg.getStudentShortCount(), currentFilter).size.toDouble() / studentsPerPage.toDouble()).toInt()}")
    }
}