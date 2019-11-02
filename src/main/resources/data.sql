insert into course_details(id, full_name, creation_date, updated_date) values(10001,'JPA in 50 Steps', sysdate(), sysdate());
insert into course_details(id, full_name, creation_date, updated_date) values(10002,'Spring in 50 Steps', sysdate(), sysdate());
insert into course_details(id, full_name, creation_date, updated_date) values(10003,'Spring Boot in 100 Steps', sysdate(), sysdate());
insert into course_details(id, full_name, creation_date, updated_date) values(10004,'Spring Boot in 12 Steps', sysdate(), sysdate());
insert into course_details(id, full_name, creation_date, updated_date) values(10005,'Spring Boot in 12 Steps', sysdate(), sysdate());

insert into passport(id, number) values(2000, 'Z12345');
insert into passport(id, number) values(2001, 'Z12346');
insert into passport(id, number) values(2002, 'Z12347');
insert into passport(id, number) values(2003, 'Z12348');

insert into student(id, name, age, percent, passport_id) values(1100,'Lakshmi', '10', '85.5', '2000');
insert into student(id, name, age, percent, passport_id) values(1101,'Arun', '10', '95.5', '2001');
insert into student(id, name, age, percent, passport_id) values(1102,'Akshay', '10', '80', '2002');
insert into student(id, name, age, percent, passport_id) values(1103,'Akash', '10', '70', '2003');
insert into student(id, name, age, percent, passport_id) values(1105,'Akash', '10', '70', '2003');



insert into review(id,rating,description,course_id)
values(50001,'5', 'Great Course',10001);
insert into review(id,rating,description,course_id)
values(50002,'4', 'Wonderful Course',10001);
insert into review(id,rating,description,course_id)
values(50003,'5', 'Awesome Course',10003);



insert into department(did, created_date, dname, loc, updated_date) values(100, sysdate(), 'Police', 'Bangalore', sysdate());
insert into department(did, created_date, dname, loc, updated_date) values(108, sysdate(), 'Medical', 'Mysore', sysdate());
insert into department(did, created_date, dname, loc, updated_date) values(105, sysdate(), 'IndianRailways', 'Dehli', sysdate());
insert into department(did, created_date, dname, loc, updated_date) values(99, sysdate(), 'Cinema', 'Gandhinagar Bangalore', sysdate());



insert into employee(id, name, sal, dept, deptdetails_did) values(106730,'Reeta', '35000', 'Outsource', '100');
insert into employee(id, name, sal, dept, deptdetails_did) values(106731,'Seeta', '75000', 'IT', '108');
insert into employee(id, name, sal, dept, deptdetails_did) values(106732,'Shweetha', '55000', 'CorpHR', '105');
insert into employee(id, name, sal, dept, deptdetails_did) values(106733,'Geetha', '5000', 'Receiption', '99');
insert into employee(id, name, sal, dept, deptdetails_did) values(106734,'Kavya', '33000', 'FresherIT', '100');
insert into employee(id, name, sal, dept, deptdetails_did) values(106735,'Yamuna', '30000', 'Junior', '105');


insert into STUDENT_COURSE(STUDENT_ID, COURSE_ID) values(1100, 10002)




