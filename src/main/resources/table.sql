CREATE TABLE IF NOT EXISTS `t_user`
(
  `id`       INT         NOT NULL,
  `username` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `nickname` VARCHAR(12) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE = INNODB
  DEFAULT CHARSET = utf8;