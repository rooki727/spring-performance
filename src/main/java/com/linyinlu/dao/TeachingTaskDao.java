package com.linyinlu.dao;

import com.linyinlu.entity.TeachingTask;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeachingTaskDao {
   List<TeachingTask> getAllTask();
   List<TeachingTask> getTaskByUser(@Param("user_id") int user_id);
   void deleteTask(@Param("task_id") int task_id);
   void addTask(TeachingTask teachingTask);
   void updateTask(TeachingTask teachingTask);
   void checkStatus(TeachingTask teachingTask);
}
