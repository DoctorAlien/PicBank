create table `t_users_base`
(
	`uid` int not null AUTO_INCREMENT COMMENT '用户编号',
	`user_name` varchar(20) not null collate utf8_general_ci comment '用户名',
	`password_` varchar(64) not null collate utf8_general_ci comment '用户密码',
	`user_ip` varchar(16) not null collate utf8_general_ci comment '用户IP',
	`reg_time` bigint not null collate utf8_general_ci comment '用户注册时间',
	`status_` tinyint not null collate utf8_general_ci default 1 comment '用户状态',
	primary key (`uid`),
	unique key `uid` (`uid`),
	unique key `user_name` (`user_name`)
)DEFAULT CHARSET=utf8;
create table `t_images_base`
(
	`iid` int not null AUTO_INCREMENT comment '图片编号',
	`uid` int not null collate utf8_general_ci comment '用户编号',
	`img_url` text not null collate utf8_general_ci comment '图片地址',
	`up_time` bigint not null collate utf8_general_ci comment '上传时间',
	`status_` tinyint not null collate utf8_general_ci default 1 comment '图片状态',
	primary key (`iid`),
	unique key `uid` (`iid`)
)DEFAULT CHARSET=utf8;
create table `t_users_admin`
(
	`aid` int not null AUTO_INCREMENT comment '管理员编号',
	`uid` int not null collate utf8_general_ci comment '用户编号',
	`level_` tinyint not null collate utf8_general_ci default 1 comment '管理员等级',
	`status_` tinyint not null collate utf8_general_ci default 1 comment '状态',
	primary key(`aid`),
	unique key `aid` (`aid`)
)DEFAULT CHARSET=utf8;
insert into `t_users_admin` values(1,1,1,1);