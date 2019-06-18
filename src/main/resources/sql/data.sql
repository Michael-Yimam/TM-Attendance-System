-- Insert data into block table



Insert Into Block(Block_Id, START_DATE, END_DATE, NUMBER_OF_MEDITATION, NUMBER_OF_WEEKS)
    values ('May 2019', '2019-04-29', '2019-05-23', 22, 4),
           ('June 2019', '2019-05-27', '2019-06-20', 22, 4);


-- Insert data into Faculty Table
Insert Into Faculty(FACULTY_ID, NAME, EMAIL)
    values ('tina11', 'Tina Xing', 'tina@mum.edu'),
           ('koraza11', 'koraza', 'koraza@mum.edu'),
           ('asad11', 'Asad saad', 'asad@mum.edu'),
           ('shereshta11', 'shereshta', 'shereshta@mum.edu'),
           ('kahan11', 'kahan', 'kahan@mum.edu'),
           ('kalu11', 'kalu', 'kalu@mum.edu'),
           ('renuka11', 'renuka mohnraj', 'renuk@mum.edu'),
           ('dawit11', 'dawit tesfaye', 'dawit@mum.edu');
--
--
Insert Into Course_Offer(COURSE_ID,COURSE_NAME, BLOCK_ID, FACULTY_ID)
values ('waajune2019', 'WAA', 'June 2019', 'tina11'),
       ('waamay2019', 'WAA', 'May 2019', 'tina11'),
        ('mwajune2019', 'MWA', 'June 2019', 'asad11'),
       ('wapjune2019', 'WAP', 'June 2019', 'shereshta11'),
       ('algomay2019', 'ALGORITHM', 'May 2019', 'koraza11'),
       ('algojune2019', 'ALGORITHM', 'June 2019', 'kahan11'),
       ('mlmay2019', 'machine learning', 'May 2019', 'kahan11'),
       ('sejune2019', 'SOFTWARE ENGINEERING', 'June 2019', 'kalu11'),
       ('mppjune2019', 'MPP', 'June 2019', 'renuka11');

Insert Into ROLE(ROLE_ID, ROLE)
values (1, 'ADMIN'),
       (2, 'STUDENT'),
       (3, 'FACULTY');

-- Insert Into User_Credentials(ACTIVE, PASSWORD, USER_ID, USER_ROLE)
-- values (1, '1234', '986957', 2),
--         (1, '123', 'tina11', 3);

Insert Into STUDENT(STUDENT_ID,BARCODE,ENTRY,NAME)
values ('986957','1234','november','michael fgf'),
       ('986958','1235','november','fisseha dfd'),
       ('986959','1236','february','mohamed dfd'),
       ('986960','1237','november','abeba dfg'),
       ('986955','1238','november','dawit sdfs'),
       ('986954','1239','august','john sdf'),
       ('986953','1230','november','lukas fgdf'),
       ('986952','1214','february','kong sdsdwer'),
       ('986951','1224','november','buba slsds'),
       ('986950','1244','may','eliyas welde');

Insert Into Admin(ID, NAME, EMAIL)
values ('admin', 'admin', 'admin@mum.edu');

Insert Into COURSE_ENROLLMENT(STUDENT_STUDENT_ID,COURSE_ID)
values ('986957','algojune2019'),
       ('986957','sejune2019'),
       ('986959','wapjune2019'),
       ('986960','mlmay2019'),
       ('986955','algojune2019'),
       ('986954','mwajune2019'),
       ('986952','algojune2019'),
       ('986958','algojune2019'),
       ('986950','algojune2019');

Insert Into USER_CREDENTIALS(ACTIVE, PASSWORD,USER_ID, role)
values (1, '123', '986957', 'STUDENT'),
       (1, '123', 'admin', 'ADMIN'),
       (1, '123', 'tina11', 'FACULTY');

