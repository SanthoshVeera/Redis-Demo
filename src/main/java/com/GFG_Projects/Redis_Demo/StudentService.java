package com.GFG_Projects.Redis_Demo;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class StudentService {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;


    public Student addStudentToLocalRedisDB(Student student) {
//        ObjectMapper mapper = new ObjectMapper();
//         mapper.convertValue(student, Map.class);
//
//         byte [] studentStream = new JdkSerializationRedisSerializer().serialize(student);

        redisTemplate.opsForHash().put("Student::", student.ID, student);
        return student;
    }


    public Student getStudentFromRedis(String id) {
       return (Student) redisTemplate.opsForHash().get("Student::", id);
    }

}
