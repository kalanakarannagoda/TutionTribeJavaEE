package com.kalana.tutiontribe.entity;

import com.kalana.tutiontribe.entity.Branch;
import com.kalana.tutiontribe.entity.UserAttendance;
import com.kalana.tutiontribe.entity.UserRole;
import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2022-09-12T16:05:56")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> address;
    public static volatile SingularAttribute<User, String> gender;
    public static volatile SingularAttribute<User, String> contact;
    public static volatile SingularAttribute<User, String> name;
    public static volatile SingularAttribute<User, Long> id;
    public static volatile SetAttribute<User, UserAttendance> userAttendances;
    public static volatile SingularAttribute<User, UserRole> userRole;
    public static volatile SingularAttribute<User, Branch> branch;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, Integer> age;

}