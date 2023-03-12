package com.zhiyixingnan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhiyixingnan.dao.AdministratorDao;
import com.zhiyixingnan.dao.StudentDao;
import com.zhiyixingnan.dao.TeacherDao;
import com.zhiyixingnan.dao.TutorDao;
import com.zhiyixingnan.domain.Student;
import com.zhiyixingnan.service.IStudentService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class IStudentServiceImpl extends ServiceImpl<StudentDao, Student>
    implements IStudentService {

  private final StudentDao studentDao;
  private final TeacherDao teacherDao;
  private final TutorDao tutorDao;
  private final AdministratorDao administratorDao;

  @Lazy
  public IStudentServiceImpl(
      StudentDao studentDao,
      TeacherDao teacherDao,
      TutorDao tutorDao,
      AdministratorDao administratorDao) {
    this.studentDao = studentDao;
    this.teacherDao = teacherDao;
    this.tutorDao = tutorDao;
    this.administratorDao = administratorDao;
  }

  @Override
  public Student selectOneStudentByIdAndDeleted(String id) {
    return studentDao.selectOne(
        new LambdaQueryWrapper<Student>().eq(Student::getId, id).eq(Student::getDeleted, 0));
  }

  @Override
  public Boolean isExistStudent(String id, String password) {
    LambdaQueryWrapper<Student> lqw = Wrappers.<Student>lambdaQuery();
    lqw.eq(Student::getDeleted, 0)
        .and(i -> i.eq(Student::getId, id).eq(Student::getPassword, password));
    return studentDao.selectOne(lqw) != null;
  }
}
