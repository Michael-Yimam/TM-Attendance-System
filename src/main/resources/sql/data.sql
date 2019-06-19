-- Insert data into block table



Insert Into Block(Block_Id, START_DATE, END_DATE, NUMBER_OF_MEDITATION, NUMBER_OF_WEEKS)
values ('November 2018', '2018-11-01', '2018-11-24', 21, 4),
       ('December 2018', '2018-11-26', '2018-12-08', 12, 2),
       ('January 2019', '2019-01-02', '2019-01-25', 21, 4),
       ('February 2019', '2019-01-28', '2019-02-20', 21, 4),
       ('March 2019', '2019-02-25', '2019-03-20', 21, 4),
       ('April 2019', '2019-03-25', '2019-04-17', 21, 4);


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
values ('waanovember2018', 'WAA', 'November 2018', 'tina11'),
       ('waadecember2018', 'WAA', 'December 2018', 'tina11'),
       ('mwajanuary2019', 'MWA', 'January 2019', 'asad11'),
       ('wapjanuary2019', 'WAP', 'January 2019', 'shereshta11'),
       ('algojanuary2019', 'ALGORITHM', 'January 2019', 'koraza11'),
       ('algofebruary2019', 'ALGORITHM', 'February 2019', 'kahan11'),
       ('mljanuary2019', 'machine learning', 'January 2019', 'kahan11'),
       ('semarch2019', 'SOFTWARE ENGINEERING', 'March 2019', 'kalu11'),
       ('mppapril2019', 'MPP', 'April 2019', 'renuka11');

Insert Into ROLE(ROLE_ID, ROLE)
values (1, 'ADMIN'),
       (2, 'STUDENT'),
       (3, 'FACULTY');

-- Insert Into User_Credentials(ACTIVE, PASSWORD, USER_ID, USER_ROLE)
-- values (1, '1234', '986957', 2),
--         (1, '123', 'tina11', 3);

Insert Into STUDENT(STUDENT_ID,BARCODE,ENTRY,NAME)
values ('986957','1234','november 2018','michael'),
       ('986958','1235','november 2018','fisseha'),
       ('986959','1236','february 2019','mohamed'),
       ('986960','1237','november 2018','abeba'),
       ('986955','1238','november 2018','dawit'),
       ('986954','1239','april 2018','john'),
       ('986953','1230','november 2018','lukas'),
       ('986952','1214','february 2019','kong'),
       ('986951','1224','november 2018','buba'),
       ('986950','1244','february 2019','eliyas');

Insert Into Admin(ID, NAME, EMAIL)
values ('admin', 'admin', 'admin@mum.edu');

Insert Into COURSE_ENROLLMENT(STUDENT_STUDENT_ID,COURSE_ID)
values ('986957','algofebruary2019'),
       ('986957','semarch2019'),
       ('986959','wapjanuary2019'),
       ('986960','mljanuary2019'),
       ('986955','algojanuary2019'),
       ('986954','mwajanuary2019'),
       ('986952','algofebruary2019'),
       ('986958','algojanuary2019'),
       ('986950','algofebruary2019');

Insert Into USER_CREDENTIALS(ACTIVE, PASSWORD,USER_ID, role)
values (1, '123', 'admin', 'ADMIN'),
       (1, '123', 'tina11', 'FACULTY');

Insert Into MEDITATION(DATE, LOCATION, TIME_TYPE, TYPE, BLOCK_BLOCK_ID)
values ('2018-11-01','DB','AM','REGULAR','November 2018'),
       ('2018-11-02','DB','AM','REGULAR','November 2018'),
       ('2018-11-03','DB','AM','REGULAR','November 2018'),
       ('2018-11-05','DB','AM','REGULAR','November 2018'),
       ('2018-11-06','DB','AM','REGULAR','November 2018'),
       ('2018-11-07','DB','AM','REGULAR','November 2018'),
       ('2018-11-08','DB','AM','REGULAR','November 2018'),
       ('2018-11-09','DB','AM','REGULAR','November 2018'),
       ('2018-11-10','DB','AM','REGULAR','November 2018'),
       ('2018-11-12','DB','AM','REGULAR','November 2018'),
       ('2018-11-13','DB','AM','REGULAR','November 2018'),
       ('2018-11-14','DB','AM','REGULAR','November 2018'),
       ('2018-11-15','DB','AM','REGULAR','November 2018'),
       ('2018-11-16','DB','AM','REGULAR','November 2018'),
       ('2018-11-17','DB','AM','REGULAR','November 2018'),
       ('2018-11-19','DB','AM','REGULAR','November 2018'),
       ('2018-11-20','DB','AM','REGULAR','November 2018'),
       ('2018-11-21','DB','AM','REGULAR','November 2018'),
       ('2018-11-22','DB','AM','REGULAR','November 2018'),
       ('2018-11-23','DB','AM','REGULAR','November 2018'),
       ('2018-11-24','DB','AM','REGULAR','November 2018'),

       ('2018-11-26','DB','AM','REGULAR','December 2018'),
       ('2018-11-27','DB','AM','REGULAR','December 2018'),
       ('2018-11-28','DB','AM','REGULAR','December 2018'),
       ('2018-11-29','DB','AM','REGULAR','December 2018'),
       ('2018-11-30','DB','AM','REGULAR','December 2018'),
       ('2018-12-01','DB','AM','REGULAR','December 2018'),
       ('2018-12-03','DB','AM','REGULAR','December 2018'),
       ('2018-12-04','DB','AM','REGULAR','December 2018'),
       ('2018-12-05','DB','AM','REGULAR','December 2018'),
       ('2018-12-06','DB','AM','REGULAR','December 2018'),
       ('2018-12-07','DB','AM','REGULAR','December 2018'),
       ('2018-12-08','DB','AM','REGULAR','December 2018'),

       ('2019-01-02','DB','AM','REGULAR','January 2019'),
       ('2019-01-03','DB','AM','REGULAR','January 2019'),
       ('2019-01-04','DB','AM','REGULAR','January 2019'),
       ('2019-01-05','DB','AM','REGULAR','January 2019'),
       ('2019-01-07','DB','AM','REGULAR','January 2019'),
       ('2019-01-08','DB','AM','REGULAR','January 2019'),
       ('2019-01-09','DB','AM','REGULAR','January 2019'),
       ('2019-01-10','DB','AM','REGULAR','January 2019'),
       ('2019-01-11','DB','AM','REGULAR','January 2019'),
       ('2019-01-12','DB','AM','REGULAR','January 2019'),
       ('2019-01-14','DB','AM','REGULAR','January 2019'),
       ('2019-01-15','DB','AM','REGULAR','January 2019'),
       ('2019-01-16','DB','AM','REGULAR','January 2019'),
       ('2019-01-17','DB','AM','REGULAR','January 2019'),
       ('2019-01-18','DB','AM','REGULAR','January 2019'),
       ('2019-01-19','DB','AM','REGULAR','January 2019'),
       ('2019-01-21','DB','AM','REGULAR','January 2019'),
       ('2019-01-22','DB','AM','REGULAR','January 2019'),
       ('2019-01-23','DB','AM','REGULAR','January 2019'),
       ('2019-01-24','DB','AM','REGULAR','January 2019'),
       ('2019-01-25','DB','AM','REGULAR','January 2019');

/*
============================================================================
*/
/*
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
       ('986950','algojune2019'),
       ('986958','waajune2019'),
       ('986950','waajune2019');

Insert Into USER_CREDENTIALS(ACTIVE, PASSWORD,USER_ID, role)
values (1, '123', '986957', 'STUDENT'),
       (1, '123', 'admin', 'ADMIN'),
       (1, '123', 'tina11', 'FACULTY');


Insert Into TMATTENDANCE(DATE, STUDENT_ID,BARCODE, Location, Meditation_Time_Type)
values ('2019-06-10', '986957', '1234', 'DH', 'EAM'),
       ('2019-06-10', '986959', '1235', 'DH', 'AM'),
       ('2019-06-10', '986960', '1236', 'DH', 'AM'),
       ('2019-06-10', '986955', '1237', 'DH', 'EAM'),
       ('2019-06-10', '986954', '1238', 'DH', 'EAM'),
       ('2019-06-10', '986952', '1239', 'DH', 'AM'),
       ('2019-06-10', '986958', '1245', 'DH', 'EAM'),
       ('2019-06-10', '986950', '1247', 'DH', 'AM'),
       ('2019-06-11', '986957', '1234', 'DH', 'AM'),
       ('2019-06-11', '986959', '1235', 'DH', 'AM'),
       ('2019-06-11', '986960', '1236', 'DH', 'EAM'),
       ('2019-06-11', '986955', '1237', 'DH', 'EAM'),
       ('2019-06-11', '986954', '1238', 'DH', 'EAM'),
       ('2019-06-11', '986952', '1239', 'DH', 'AM'),
       ('2019-06-11', '986958', '1242', 'DH', 'AM'),
       ('2019-06-11', '986950', '1247', 'DH', 'EAM'),
       ('2019-06-12', '986957', '1234', 'DH', 'AM'),
       ('2019-06-12', '986959', '1235', 'DH', 'EAM'),
       ('2019-06-12', '986960', '1236', 'DH', 'AM'),
       ('2019-06-12', '986955', '1237', 'DH', 'EAM'),
       ('2019-06-12', '986954', '1238', 'DH', 'AM'),
       ('2019-06-12', '986952', '1239', 'DH', 'EAM'),
       ('2019-06-12', '986950', '1243', 'DH', 'AM'),
       ('2019-06-12', '986958', '1245', 'DH', 'AM'),
       ('2019-06-13', '986950', '1247', 'DH', 'AM'),
       ('2019-05-12', '986957', '1234', 'DH', 'EAM'),
       ('2019-05-12', '986959', '1235', 'DH', 'EAM'),
       ('2019-05-12', '986960', '1236', 'DH', 'AM'),
       ('2019-05-12', '986955', '1237', 'DH', 'AM'),
       ('2019-05-12', '986954', '1238', 'DH', 'EAM'),
       ('2019-05-12', '986952', '1239', 'DH', 'EAM'),
       ('2019-05-12', '986958', '1242', 'DH', 'AM'),
       ('2019-05-12', '986950', '1243', 'DH', 'AM'),
       ('2019-05-13', '986958', '1245', 'DH', 'AM'),
       ('2019-05-13', '986950', '1247', 'DH', 'AM'),
       ('2019-05-14', '986957', '1234', 'DH', 'EAM'),
       ('2019-05-15', '986959', '1235', 'DH', 'EAM'),
       ('2019-05-15', '986960', '1236', 'DH', 'AM'),
       ('2019-05-15', '986955','1237', 'DH', 'EAM'),
       ('2019-05-15', '986954', '1238', 'DH', 'AM'),
       ('2019-05-15', '986952', '1239', 'DH', 'EAM'),
       ('2019-05-15', '986958', '1242', 'DH', 'AM'),
       ('2019-05-15', '986950', '1243', 'DH', 'AM'),
       ('2019-05-16', '986958', '1245', 'DH', 'EAM'),
       ('2019-05-16', '986950', '1247', 'DH', 'AM');*/
