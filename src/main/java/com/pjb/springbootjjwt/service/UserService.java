package com.pjb.springbootjjwt.service;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.pjb.springbootjjwt.entity.User;
import com.pjb.springbootjjwt.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.*;

/**
 * @author yc
 * @date 2018-07-08 20:52
 */
@Service("UserService")
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class UserService {
    @Autowired
    UserMapper userMapper;


    public String selectIdBytoken( String token){ //根据token查找id
        System.out.println(token);
        return userMapper.selectIdBytoken(token);
    };


    public String selectNamerBytoken( String token){ //根据token姓名
        System.out.println(token);
        return userMapper.selectNameBytoken(token);
    };

    public boolean updatetoken(Integer id,String token){return userMapper.updatetoken(id,token);}


    public User findByUsername(User user){
        return userMapper.findByUsername(user.getUsername());
    }

    public boolean adduser(User user){
         boolean result=userMapper.adduser(user);
        return result;
    };
    public User findByUsernames(String username){
        return userMapper.findByUsername(username);
    }






/***

    //导入excel

     public Object batchImport(String fileName, MultipartFile file) throws Exception{
             JSONObject jsonObject = new JSONObject();
             boolean notNull = false;
             List<User> userList = new ArrayList<User>();
             if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
                 jsonObject.put("message", "上传文件格式不正确");
                 return jsonObject;
                 //throw new MyException("上传文件格式不正确");//判断文件格式

             }
             boolean isExcel2003 = true;
             if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
                 isExcel2003 = false;
             }
             InputStream is = file.getInputStream();
             Workbook wb = null;
             if (isExcel2003) {
                 wb = new HSSFWorkbook(is);
             } else {
                 wb = new XSSFWorkbook(is);
             }
             Sheet sheet = wb.getSheetAt(0);
             if(sheet!=null){
                 notNull = true;
             }
             User user;
             for (int r = 1; r <= sheet.getLastRowNum(); r++) {
                 Row row = sheet.getRow(r);
                 if (row == null){
                     continue;
                 }

                 user = new User();

                 row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
                 String stunumber = row.getCell(0).getStringCellValue();
                 if(stunumber==null || stunumber.isEmpty()){
                     jsonObject.put("message", "导入失败(第"+(r+1)+"行,学号未填写)");
                     return jsonObject;
                     //throw new MyException("导入失败(第"+(r+1)+"行,学号未填写)");
                 }

                 row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
                 String username = row.getCell(1).getStringCellValue();
                 if(username==null || username.isEmpty()){
                     jsonObject.put("message", "导入失败(第"+(r+1)+"行,姓名未填写)");
                     return jsonObject;
                     //throw new MyException("导入失败(第"+(r+1)+"行,姓名未填写)");
                 }

                 row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
                 String idcards = row.getCell(2).getStringCellValue();
                 if(idcards==null){
                     jsonObject.put("message", "导入失败(第"+(r+1)+"行,身份证号码未填写)");
                     return jsonObject;
                     //throw new MyException("导入失败(第"+(r+1)+"行,身份证号码未填写)");
                 }

                 row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
                 String role = row.getCell(3).getStringCellValue();
                 if(role==null){
                     jsonObject.put("message", "导入失败(第"+(r+1)+"行,角色未填写)");
                     return jsonObject;
                    // throw new MyException("导入失败(第"+(r+1)+"行,身份证号码未填写)");
                 }

                /** row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
                 String teacourseS = row.getCell(4).getStringCellValue();
                 Integer teacourse=Integer.parseInt(teacourseS);
                 if(teacourseS==null){
                     throw new MyException("导入失败(第"+(r+1)+"行,教师课程未填写)");
                 }**/

/**
                 user.setStunumber(stunumber);
                 user.setUsername(username);
                 user.setIdcards(idcards);
                 user.setRole(role);

                 userList.add(user);

                 if("student".equals(role)){
                     Student student=new Student();
                     student.setStudentnumber(stunumber);
                     student.setStuname(username);
                     int cnt = studentMapper.selectByStunumberReturnCount(stunumber);
                     if (cnt == 0) {
                         studentMapper.addStudent(student);
                         System.out.println(" 插入学生"+userList);
                     } else {
                         studentMapper.updateStudentInfo(student);
                         System.out.println(" 更新 学生"+userList);
                     }


                 }
                 if("zdteacher".equals(role)||"skteacher".equals(role))
                 {
                     Teacher teacher=new Teacher();
                     teacher.setTeachernumber(stunumber);
                     teacher.setTeaname(username);
                    // teacher.setTeacourse(teacourse);
                     int cnt = teacherMapper.selectByStunumberReturnCount(stunumber);
                     if (cnt == 0) {
                         teacherMapper.addTeacher(teacher);
                         System.out.println(" 插入老师 "+userList);
                     } else {
                         teacherMapper.updateTeacher(teacher);
                         System.out.println(" 更新老师 "+userList);
                     }


                 }
             }
             for (User userResord : userList) {
                 String stunumber = userResord.getStunumber();
                 String role=userResord.getRole();
                 int cnt = userMapper.selectByStunumberReturnCount(stunumber);
                 if (cnt == 0) {
                     userMapper.adduser(userResord);
                     System.out.println(" 插入 "+userResord);
                 } else {
                     userMapper.Updateuserrole(stunumber,role);
                     System.out.println(" 更新 "+userResord);
                 }
             }
            jsonObject.put("message","上传成功！！");

             return jsonObject;
         };


***/



}
