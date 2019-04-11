CREATE TABLE `yc_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
   `username`  varchar(200) NOT NULL COMMENT '姓名',
  `password` varchar(200) NOT NULL DEFAULT '123456'COMMENT '密码',
  `token` varchar(255) DEFAULT NULL,
  
  
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `yc_user` VALUES ('1', 'admin','123456', ' ');


CREATE TABLE `yc_dayily` (
  `day` int(111) NOT NULL AUTO_INCREMENT,
   `up`  int(100) NOT NULL COMMENT '早起天数',
   `sleep`  int(100) NOT NULL COMMENT '晚睡天数',
  `English`  int(100) NOT NULL COMMENT '单词数量',
  `movement`  int(100) NOT NULL COMMENT '运动小时数',
  `game`  int(100) NOT NULL COMMENT '游戏小时数',
  `love`  int(100) NOT NULL COMMENT '恋爱小时数',
  `work`  int(100) NOT NULL COMMENT '实验室小时数',
  `smoke`  int(100) NOT NULL COMMENT '抽烟跟数',
  `daima`  int(100) NOT NULL COMMENT '代码行数',
  `money`  int(100) NOT NULL COMMENT '今日开销',
  `diary`  text  COMMENT '日记',
  PRIMARY KEY (`day`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO `yc_dayily` VALUES ('1', '1','1', '0','0','1','1','4','15','1000','65','今天好热啊，今天是网站的第一天');
INSERT INTO `yc_dayily` VALUES ('2', '1','1', '0','0','1','1','5','17','700','40','今天没啥好说的，lgd牛逼');