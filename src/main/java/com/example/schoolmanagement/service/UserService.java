package com.example.schoolmanagement.service;

import com.example.schoolmanagement.entity.Courses;
import com.example.schoolmanagement.entity.RequestResponse;
import com.example.schoolmanagement.entity.User;
import com.example.schoolmanagement.repository.CoursesRepository;
import com.example.schoolmanagement.repository.UserRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserService {
    private UserRepository userRepository;

    private CoursesRepository coursesRepository;

    @Autowired
    public UserService(UserRepository userRepository, CoursesRepository coursesRepository) {
        this.userRepository = userRepository;
        this.coursesRepository = coursesRepository;
    }

    public List<User> findUserByEmail(String email){
        List<User> users = this.userRepository.findByEmail(email);
        if (users.size() == 0){
            return new ArrayList<>();
        } else {
            boolean exists = false;
            for (User user: users) {
                if (user.getEmail().equals(email)){
                    exists = true;
                }
            }
            if (exists){
                return users;
            } else {
                return new ArrayList<>();
            }
        }
    }

    public RequestResponse saveUser(User user) {
        if (this.findUserByEmail(user.getEmail()) != null && this.findUserByEmail(user.getEmail()).size() == 0){
            try {
                user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
                user.setActive(1);
                userRepository.save(user);
                return RequestResponse.builder().responseCode(0).data(user).message("success").build();
            } catch (Exception ignored){
                LoggerFactory.getLogger(LoggerFactory.class).error("Hatalı Kayıt", ignored);
                return RequestResponse.builder().responseCode(1).data(user).message("Üzgünüz, ayrıntılar kaydedilirken hata oluştu. Lütfen tekrar deneyin").build();
            }
        } else {
            return RequestResponse.builder().responseCode(1).data(user).message("Üzgünüz, bu e-posta adresi zaten başka bir kullanıcı tarafından kullanılıyor. lütfen başka bir e-posta adresi kullanmayı deneyin").build();
        }
    }

    public int getUsersCount(String role){
        return userRepository.countAllByRole(role);
    }

    public List<User> getUsersByRoleNotLoggedIn(String role, String email){
        return userRepository.findByRoleAndEmailNotOrderByIdDesc(role, email);
    }

    public User getUserById(long id){
        return userRepository.getOne(id);
    }

    public RequestResponse updateUserDetails(User user){
        User userToUpdate = this.getUserById(user.getId());
        if (userToUpdate != null){
            try {
                userToUpdate.setEmail(user.getEmail());
                userToUpdate.setFirstName(user.getFirstName());
                userToUpdate.setLastName(user.getLastName());
                userRepository.save(userToUpdate);
                return RequestResponse.builder().responseCode(0).data(userToUpdate).message("success").build();
            } catch (Exception ignored){
                LoggerFactory.getLogger(LoggerFactory.class).error("Hatalı Güncelleme", ignored);
                return RequestResponse.builder().responseCode(1).data(user).message("Üzgünüz, bilgiler güncellenirken hata oluştu. Lütfen tekrar deneyin").build();
            }
        } else {
            return RequestResponse.builder().responseCode(1).data(null).message("Üzgünüz, bu kullanıcı mevcut değil. Lütfen tekrar deneyin").build();
        }
    }

    public RequestResponse updateUserStatus(User user){
        User userToChangeStatus = this.getUserById(user.getId());
        if (userToChangeStatus != null){
            try {
                userToChangeStatus.setActive(user.getActive());
                userRepository.save(userToChangeStatus);
                return RequestResponse.builder().responseCode(0).data(userToChangeStatus).message("success").build();
            } catch (Exception ignored){
                LoggerFactory.getLogger(LoggerFactory.class).error("Hatalı Güncelleme", ignored);
                return RequestResponse.builder().responseCode(1).data(user).message("Üzgünüz, bilgiler güncellenirken hata oluştu. Lütfen tekrar deneyin").build();
            }
        } else {
            return RequestResponse.builder().responseCode(1).data(null).message("Üzgünüz, bu kullanıcı mevcut değil. Lütfen tekrar deneyin").build();
        }
    }

    public List<Courses> findCoursesByStudentId(String studentId){
        List<Courses> courses = coursesRepository.findByStudentIdOrderByIdDesc(studentId);
        if (courses.size() > 0){
            return courses;
        } else {
            return new ArrayList<>();
        }
    }

    public List<Courses> findByCourseNameAndStudentId(String studentId, String courseName){
        List<Courses> courses = coursesRepository.findByStudentIdAndCourseName(studentId, courseName);
        if (courses.size() > 0){
            return courses;
        } else {
            return new ArrayList<>();
        }
    }

    public RequestResponse registerCourse(Courses courses){
        if (this.findByCourseNameAndStudentId(courses.getStudentId(), courses.getCourseName()) != null && this.findByCourseNameAndStudentId(courses.getStudentId(), courses.getCourseName()).size() == 0){
            try {
                coursesRepository.save(courses);
                return RequestResponse.builder().responseCode(0).data(courses).message("success").build();
            } catch (Exception e){
                LoggerFactory.getLogger(LoggerFactory.class).error("Hatalı Güncelleme", e);
                return RequestResponse.builder().responseCode(1).data(courses).message("Üzgünüz, kursa kayıt olurken hata ile karşılaşıldı. Lütfen tekrar deneyin").build();
            }
        } else {
            return RequestResponse.builder().responseCode(1).data(courses).message("Üzgünüz, bu kursa zaten kayıtlıydınız. Lütfen başka bir kursa kaydolun").build();
        }
    }

    public Courses findCourseById(long id){
        return coursesRepository.getOne(id);
    }

    public RequestResponse updateCourseStatus(Courses courses){
        Courses courseToChangeStatus = this.findCourseById(courses.getId());
        if (courseToChangeStatus != null){
            try {
                courseToChangeStatus.setActive(courses.getActive());
                coursesRepository.save(courseToChangeStatus);
                return RequestResponse.builder().responseCode(0).data(courseToChangeStatus).message("success").build();
            } catch (Exception ignored){
                LoggerFactory.getLogger(LoggerFactory.class).error("Hatalı Güncelleme", ignored);
                return RequestResponse.builder().responseCode(1).data(courses).message("Üzgünüz, kurs ayrıntıları sırasında hata ile karşılaşıldı. Lütfen tekrar deneyin").build();
            }
        } else {
            return RequestResponse.builder().responseCode(1).data(null).message("Üzgünüz, bu kurs mevcut değil. Lütfen tekrar deneyin").build();
        }
    }
}
