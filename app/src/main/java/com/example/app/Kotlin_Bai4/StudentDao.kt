package com.example.app.Kotlin_Bai4

import androidx.room.*

@Dao
interface StudentDao {
    //Lấy tất cả dữ liệu user đã lưu ở trong database và sắp xếp lại
    @Query("SELECT * FROM student ORDER BY id DESC")
    fun getAllStudent(): List<Student>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(student: Student)

    @Update
    fun update(student: Student)

    @Delete
    fun deleteStudent(student: Student)
}