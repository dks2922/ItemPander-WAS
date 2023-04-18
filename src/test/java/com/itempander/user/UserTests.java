package com.itempander.user;


import com.user.entity.UserCash;
import com.user.entity.UserMember;
import com.user.entity.UserMemberDetail;
import com.user.repository.UserCashRepository;
import com.user.repository.UserDetailRepository;
import com.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class UserTests {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserDetailRepository userDetailRepository;

    @Autowired
    UserCashRepository userCashRepository;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Test
    @Transactional
    public void testInsertUser() {

        try {
            UserMember userMember = new UserMember();

            userMember.setUserId("im25202110");
            UserMember findUser = userRepository.findByUserId(userMember.getUserId());

            System.out.println("findUser : " + findUser);
            if (findUser == null) {
                String ssn1 = "981106";
                String ssn2 = "1268228";


                UserMemberDetail userMemberDetail = new UserMemberDetail();
                userMemberDetail.setSsn(ssn1 + ssn2);

                UserMemberDetail findUserDetail = userDetailRepository.findBySsn(userMemberDetail.getSsn());

                System.out.println("findUserDetail : " + findUserDetail);
                if (findUserDetail == null) {

                    String password = "123";
                    userMember.setPassword(passwordEncoder.encode(password));
                    userMember.setAdminYn("N");
                    userMember.setSaveStatus("Y");
                    userMember.setSignDate("20230410");
                    userMember.setModifyDate("20230410");

                    UserMember userMember1 = userRepository.save(userMember);

                    userMemberDetail.setUserMember(userMember1);
                    userMemberDetail.setName("임현우");
                    userMemberDetail.setGender("W");
                    userMemberDetail.setSsn1(ssn1);
                    userMemberDetail.setSsn2(ssn2);
                    userMemberDetail.setPhone("01034685821");
                    userMemberDetail.setAddress("서울시 광진구 471-2");
                    userMemberDetail.setAddress1("서울시 광진구");
                    userMemberDetail.setAddress2("471-2");
                    userMemberDetail.setEmail("dk208@naver.com");
                    userMemberDetail.setEmailYn("Y");
                    userMemberDetail.setEmailDate("20230410");
                    userMemberDetail.setPrivacyDate("20230410");
                    userMemberDetail.setPrivacyYn("Y");
                    userMemberDetail.setTransLevel("1");
                    userMemberDetail.setTransPoint(10);
                    userMemberDetail.setBankAccount("458100430435");
                    userMemberDetail.setBankSeq("001");


                    userDetailRepository.save(userMemberDetail);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    @Test
    @Transactional
    public void testInsertUser2() {

        String userId = "em2u7110";
        String ssn1 = "920406";
        String ssn2 = "1262228";
        String password = "123";
        String userRegDate = "20230411";

        UserMember userMember = new UserMember();
        userMember.setUserId(userId);
        userMember.setPassword(passwordEncoder.encode(password));
        userMember.setAdminYn("N");
        userMember.setSaveStatus("Y");
        userMember.setSignDate(userRegDate);
        userMember.setModifyDate(userRegDate);


        UserMemberDetail userMemberDetail = new UserMemberDetail();
        userMemberDetail.setSsn(ssn1 + ssn2);
        userMemberDetail.setName("임현우");
        userMemberDetail.setGender("W");
        userMemberDetail.setSsn1(ssn1);
        userMemberDetail.setSsn2(ssn2);
        userMemberDetail.setPhone("01034685821");
        userMemberDetail.setAddress("서울시 광진구 471-2");
        userMemberDetail.setAddress1("서울시 광진구");
        userMemberDetail.setAddress2("471-2");
        userMemberDetail.setEmail("dk208@naver.com");
        userMemberDetail.setEmailYn("Y");
        userMemberDetail.setEmailDate(userRegDate);
        userMemberDetail.setPrivacyDate(userRegDate);
        userMemberDetail.setPrivacyYn("Y");
        userMemberDetail.setTransLevel("1");
        userMemberDetail.setTransPoint(10);
        userMemberDetail.setBankAccount("458100430435");
        userMemberDetail.setBankSeq("001");


        UserCash userCash = new UserCash();
        userCash.setMileage(0);
        userCash.setAcmMileage(0);
        userCash.setAmount(0);
        userCash.setAcmAmount(0);

        UserMember findUser = userRepository.findByUserId(userId);
        UserMemberDetail findUserDetail = userDetailRepository.findBySsn(userMemberDetail.getSsn());

        System.out.println("findUser : " + findUser);
        System.out.println("findUserDetail : " + findUserDetail);

        if (findUser != null) {
            System.out.println("User already exists: " + findUser);
            return;
        }

        if (findUserDetail != null) {
            System.out.println("User detail already exists: " + findUserDetail);
            return;
        }

        userMemberDetail.setUserMember(userMember);
        userCash.setUserMember(userMember);

        userRepository.save(userMember);
        userDetailRepository.save(userMemberDetail);
        userCashRepository.save(userCash);
    }


    @Test
    @Transactional
    public void dateTest(){

        String userId = "es12u7110";
        String ssn1 = "921106";
        String ssn2 = "1272228";
        String password = "123";
        String userRegDate = "20230411";

        UserMember userMember = new UserMember();
        userMember.setUserId(userId);
        userMember.setPassword(passwordEncoder.encode(password));
        userMember.setAdminYn("N");
        userMember.setSaveStatus("Y");
        userMember.setSignDate(userRegDate);
        userMember.setModifyDate(userRegDate);


        UserMemberDetail userMemberDetail = new UserMemberDetail();
        userMemberDetail.setSsn(ssn1 + ssn2);
        userMemberDetail.setName("임현우");
        userMemberDetail.setGender("W");
        userMemberDetail.setSsn1(ssn1);
        userMemberDetail.setSsn2(ssn2);
        userMemberDetail.setPhone("01034685821");
        userMemberDetail.setAddress("서울시 광진구 471-2");
        userMemberDetail.setAddress1("서울시 광진구");
        userMemberDetail.setAddress2("471-2");
        userMemberDetail.setEmail("dk208@naver.com");
        userMemberDetail.setEmailYn("Y");
        userMemberDetail.setEmailDate(userRegDate);
        userMemberDetail.setPrivacyDate(userRegDate);
        userMemberDetail.setPrivacyYn("Y");
        userMemberDetail.setTransLevel("1");
        userMemberDetail.setTransPoint(10);
        userMemberDetail.setBankAccount("458100430435");
        userMemberDetail.setBankSeq("001");


        UserCash userCash = new UserCash();
        userCash.setMileage(0);
        userCash.setAcmMileage(0);
        userCash.setAmount(0);
        userCash.setAcmAmount(0);

        // UserMember 엔티티 저장
        userRepository.save(userMember);

        // UserMember 엔티티와 UserCash 엔티티 간의 연관관계 설정
        userCash.setUserMember(userMember);

        // UserCash 엔티티 저장
        userCashRepository.save(userCash);

        // UserMember 엔티티와 UserMemberDetail 엔티티 간의 연관관계 설정
        userMemberDetail.setUserMember(userMember);

        // UserMemberDetail 엔티티 저장
        userDetailRepository.save(userMemberDetail);

    }
}
