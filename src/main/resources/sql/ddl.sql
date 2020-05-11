CREATE TABLE `dianping`.`user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `created` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `modified` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `telphone` varchar(40) NOT NULL,
  `password` varchar(200) NOT NULL,
  `nick_name` varchar(40) NOT NULL,
  `gender` int(0) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `telphone_unique_index`(`telphone`) USING BTREE
);