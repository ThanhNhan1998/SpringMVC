use spring82019;

insert into role(code,name) values('MANAGER','MANAGER');
insert into role(code,name) values('STAFF','STAFF');

insert into user(username,password,fullname,status)
values('nguyenvana', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyen van a',1);

insert into user(username,password,fullname,status)
values('nguyenvanb', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyen van b',1);

insert into user(username,password,fullname,status)
values('nguyenvanc', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyen van c',1);

insert into user(username,password,fullname,status)
values('nguyenvand', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyen van d',1);

insert into user(username,password,fullname,status)
values('nguyenvane', '$2a$10$/RUbuT9KIqk6f8enaTQiLOXzhnUkiwEJRdtzdrMXXwU7dgnLKTCYG','nguyen van e',1);

INSERT INTO user_role(userid,roleid) VALUES (1,1);
INSERT INTO user_role(userid,roleid) VALUES (2,2);
INSERT INTO user_role(userid,roleid) VALUES (3,2);
INSERT INTO user_role(userid,roleid) VALUES (4,2);

INSERT INTO `building` (id, createdby, createddate, modifiedby, modifieddate, name, numberofbasement, buildingarea, district, ward, street, structure, costrent, costdescription, servicecost, carcost, motorbikecost, overtimecost, electricitycost, deposit, payment, timerent, timedecorator, managername, managerphone, type) VALUES
(1,NULL,NULL,NULL,NULL,'Nam Giao Building',2,500,'QUAN_1','Phường 2','59 phan xích long',NULL,15,'15 triệu/m2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'thoa','123456','TANG_TRET,NGUYEN_CAN'),
(2,NULL,NULL,NULL,NULL,'ACM Tower',2,650,'QUAN_2','Phường 4','96 cao thắng',NULL,18,'18 triệu/m2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'cương','123456','NGUYEN_CAN'),
(3,NULL,NULL,NULL,NULL,'Alpha 2 Building',1,200,'QUAN_1','Phường 6','153 nguyễn đình chiểu',NULL,20,'20 triệu/m2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'huy','123456','NOI_THAT'),
(4,NULL,NULL,NULL,NULL,'IDD 1 Building',1,200,'QUAN_2','Phường 7','111 Lý Chính Thắng',NULL,12,'12 triệu/m2',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'vy','123456','TANG_TRET,NGUYEN_CAN,NOI_THAT'),
(31,NULL,NULL,NULL,NULL,'My house Building',2,500,'QUAN_3','Phuong 7','123 Trần Phú',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'NGUYEN_CAN,NOI_THAT'),
(32,NULL,NULL,NULL,NULL,'BITEXCOooo',NULL,200,'QUAN_4',NULL,'Ngô Đức Kế',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'TANG_TRET,NGUYEN_CAN,NOI_THAT'),
(33,NULL,NULL,NULL,NULL,'TPS',NULL,200,'QUAN_1','Bến Nghé','Ngô Đức Kế',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'TANG_TRET,NGUYEN_CAN,NOI_THAT'),
(83,NULL,NULL,NULL,NULL,'Test',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'NGUYEN_CAN');

INSERT INTO `rentarea` VALUES 
(2,NULL,NULL,NULL,NULL,200,2),
(3,NULL,NULL,NULL,NULL,300,2),
(4,NULL,NULL,NULL,NULL,400,2),
(6,NULL,NULL,NULL,NULL,300,3),
(7,NULL,NULL,NULL,NULL,400,3),
(8,NULL,NULL,NULL,NULL,500,3),
(9,NULL,NULL,NULL,NULL,100,4),
(10,NULL,NULL,NULL,NULL,400,4),
(11,NULL,NULL,NULL,NULL,250,4),
(38,NULL,NULL,NULL,NULL,200,31),
(39,NULL,NULL,NULL,NULL,600,31),
(40,NULL,NULL,NULL,NULL,100,32),
(41,NULL,NULL,NULL,NULL,200,32),
(42,NULL,NULL,NULL,NULL,300,32),
(43,NULL,NULL,NULL,NULL,500,32),
(44,NULL,NULL,NULL,NULL,100,33),
(45,NULL,NULL,NULL,NULL,200,33),
(46,NULL,NULL,NULL,NULL,300,33),
(179,NULL,NULL,NULL,NULL,50,83),
(186,NULL,NULL,NULL,NULL,100,1),
(187,NULL,NULL,NULL,NULL,200,1);
