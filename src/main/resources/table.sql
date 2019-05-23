CREATE TABLE  IF NOT EXISTS `article` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `content` longblob NOT NULL COMMENT '内容',
  `auther` int(11) NOT NULL COMMENT '作者',
  `create_date` datetime NOT NULL COMMENT '创建时间',
  `like` int(11) NOT NULL COMMENT '点赞数',
  `look` int(11) NOT NULL COMMENT '阅读数',
  `type` int(11) NOT NULL COMMENT '系统分类',
  `original` tinyint(1) NOT NULL COMMENT '原创',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `type` (
  `id` int(11) NOT NULL COMMENT 'id',
  `type_name` varchar(255) NOT NULL COMMENT '分类名称',
  `is_system` tinyint(1) NOT NULL COMMENT '是否为系统分类',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(255) NOT NULL COMMENT '账号',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `nickname` varchar(255) NOT NULL COMMENT '昵称',
  `email` varchar(255) DEFAULT NULL COMMENT '邮箱',
  `picture` varchar(255) DEFAULT NULL COMMENT '头像',
  `introduction` varchar(255) DEFAULT NULL COMMENT '简介',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;