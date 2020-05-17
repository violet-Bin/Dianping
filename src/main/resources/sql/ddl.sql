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

CREATE TABLE `dianping`.`seller`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(80) NOT NULL,
  `created` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `modified` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `remark_score` decimal(2, 1) NOT NULL,
  `disabled_flag` int(0) NOT NULL,
  PRIMARY KEY (`id`)
);


CREATE TABLE `dianping`.`category`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `created` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `modified` timestamp(0) NOT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `name` varchar(20) NOT NULL,
  `icon_url` varchar(200) NOT NULL,
  `sort` int(0) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_unique_in`(`name`) USING BTREE
);

CREATE TABLE `dianping`.`shop`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `created` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `modified` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  `name` varchar(80) NOT NULL DEFAULT '',
  `remark_score` decimal(2, 1) NOT NULL DEFAULT 0,
  `price_per_man` int(0) NOT NULL DEFAULT 0,
  `latitude` decimal(10, 6) NOT NULL DEFAULT 0,
  `longitude` decimal(10, 6) NOT NULL DEFAULT 0,
  `category_id` int(0) NOT NULL DEFAULT 0,
  `tags` varchar(2000) NOT NULL DEFAULT '',
  `start_time` varchar(200) NOT NULL DEFAULT '',
  `end_time` varchar(200) NOT NULL DEFAULT '',
  `address` varchar(200) NOT NULL DEFAULT '',
  `seller_id` int(0) NOT NULL DEFAULT 0,
  `icon_url` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
);