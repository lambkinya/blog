-- No.1 建库
CREATE DATABASE IF NOT EXISTS tuor_blog DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- No.2 使用数据库
use tuor_blog;

-- No.3 建表
/*
   coder, article, category, label, comment
   tree_hole, essay, web_info, friend_link
   file_info, sweetheart, history_info
   im_chat_coder_friend, im_chat_group
   im_chat_group_member, im_chat_single_message
   im_chat_group_member
*/
CREATE TABLE IF NOT EXISTS `coder`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `no`          varchar(32)  NOT NULL COMMENT 'Coder编号',
    `username`    varchar(32)  NOT NULL COMMENT '用户名',
    `password`    varchar(255) NOT NULL COMMENT '密码',
    `gender`      tinyint(1)            DEFAULT NULL COMMENT '性别[1:男，2:女，0:保密]',
    `avatar`      varchar(255) NOT NULL DEFAULT '' COMMENT '头像地址',
    `website`     varchar(32)  NOT NULL DEFAULT '' COMMENT '个人网站地址',
    `github`      varchar(255) NOT NULL DEFAULT '' COMMENT 'github地址',
    `gitee`       varchar(255) NOT NULL DEFAULT '' COMMENT 'gitee地址',
    `email`       varchar(255) NOT NULL DEFAULT '' COMMENT '邮箱',
    `phone`       varchar(11)  NOT NULL DEFAULT '' COMMENT '用户手机号',
    `type`        tinyint(1)   NOT NULL DEFAULT 1 COMMENT '类型 0.admin 1.coder 2.游客',
    `saying`      varchar(32)  NOT NULL DEFAULT '' COMMENT '说点什么...',
    `status`      tinyint(1)   NOT NULL DEFAULT 1 COMMENT '是否启用[0:否，1:是]',

    `create_time` datetime              DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime              DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `yn`          tinyint(1)            DEFAULT '0' COMMENT '逻辑删除 0.未删除 1.已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `unique_username` (`username`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='Coder';


CREATE TABLE IF NOT EXISTS `article`
(
    `id`               bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `no`               varchar(32)  NOT NULL COMMENT '文章编号',
    `coder_no`         varchar(32)  NOT NULL COMMENT 'Coder编号',
    `category_no`      varchar(32)           DEFAULT NULL COMMENT '所属分类编号',
    `label_no`           varchar(128)          DEFAULT NULL COMMENT '所属标签编号',

    `title`            varchar(256)          DEFAULT NULL COMMENT '标题',
    `content`          longtext COMMENT '文章内容',
    `cover`            varchar(256)          DEFAULT NULL COMMENT '封面',
    `view_count`       int          NOT NULL DEFAULT 0 COMMENT '访问量',
    `like_count`       int          NOT NULL DEFAULT 0 COMMENT '点赞数',

    `recommend_status` tinyint(1)   NOT NULL DEFAULT 0 COMMENT '是否推荐[0:否，1:是]',
    `comment_status`   tinyint(1)            DEFAULT 0 COMMENT '是否允许评论 0否，1是',
    `view_status`      tinyint(1)   NOT NULL COMMENT '文章是否可见 0否，1是',
    `tips`             varchar(128)          DEFAULT '' COMMENT '提示',
    `password`         varchar(128) NOT NULL DEFAULT '' COMMENT '密码',

    `create_time`      datetime              DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`      datetime              DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `yn`               tinyint(1)            DEFAULT '0' COMMENT '逻辑删除 0.未删除 1.已删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='文章表';


CREATE TABLE IF NOT EXISTS `category`
(
    `id`          bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `no`          varchar(32) NOT NULL COMMENT '分类编号',

    `name`        varchar(128)         DEFAULT NULL COMMENT '分类名',
    `description` varchar(512)         DEFAULT NULL COMMENT '描述',
    `type`        tinyint(1)  NOT NULL DEFAULT 1 COMMENT '分类类型[0:导航栏分类，1:普通分类]',
    `priority`    int                  DEFAULT 0 COMMENT '导航栏分类优先级：数字小的在前面',

    `create_time` datetime             DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime             DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `yn`          tinyint(1)           DEFAULT '0' COMMENT '逻辑删除 0.未删除 1.已删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='分类表';


CREATE TABLE IF NOT EXISTS `label`
(
    `id`          bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `no`          varchar(32) NOT NULL COMMENT '标签编号',
    `category_no` varchar(32) NOT NULL COMMENT '分类编号',

    `name`        varchar(128) DEFAULT NULL COMMENT '标签名',
    `description` varchar(500) DEFAULT NULL COMMENT '描述',

    `create_time` datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `yn`          tinyint(1)   DEFAULT '0' COMMENT '逻辑删除 0.未删除 1.已删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='标签表';


CREATE TABLE IF NOT EXISTS `comment`
(
    `id`              bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `no`              varchar(32)  NOT NULL COMMENT '评论编号',

    `source`          varchar(32)           DEFAULT NULL COMMENT '来源',
    `type`            tinyint(1)   NOT NULL COMMENT '评论类型（1文章 2祝福 3树洞）',

    `coder_no`        varchar(32)  NOT NULL COMMENT '评论者编号',
    `root_comment_no` varchar(32)           DEFAULT '-1' COMMENT '根评论编号',
    `to_coder_no`     varchar(32)           DEFAULT '-1' COMMENT '所回复的目标评论的用户编号',
    `to_comment_no`   varchar(32)           DEFAULT '-1' COMMENT '所回复的目标评论的评论编号',

    `content`         varchar(512)          DEFAULT NULL COMMENT '评论内容',
    `other_info`      varchar(256) NOT NULL DEFAULT '' COMMENT '评论额外信息',
    `like_count`      int          NOT NULL DEFAULT 0 COMMENT '点赞数量',
    `status`          tinyint(1)            DEFAULT 2 COMMENT '评论是否通过 0.未通过 1.已通过 2.待审核',

    `create_time`     datetime              DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`     datetime              DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `yn`              tinyint(1)            DEFAULT '0' COMMENT '逻辑删除 0.未删除 1.已删除',
    PRIMARY KEY (`id`),
    KEY `source` (`source`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='评论表';


CREATE TABLE `tree_hole`
(
    `id`          bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `no`          varchar(32) NOT NULL COMMENT '编号',

    `avatar`      varchar(256) DEFAULT NULL COMMENT '头像',
    `message`     varchar(64) NOT NULL COMMENT '留言',

    `create_time` datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `yn`          tinyint(1)   DEFAULT '0' COMMENT '逻辑删除 0.未删除 1.已删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='树洞表';


CREATE TABLE `essay`
(
    `id`          bigint(20)    NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `no`          varchar(32)   NOT NULL COMMENT '编号',
    `coder_no`    varchar(32)   NOT NULL COMMENT 'coder编号',

    `content`     varchar(1024) NOT NULL COMMENT '内容',
    `like_count`  int           NOT NULL DEFAULT 0 COMMENT '点赞数',

    `type`        tinyint(1)    NOT NULL COMMENT '类型（1朋友圈）',
    `source`      varchar(32)   NOT NULL DEFAULT '' COMMENT '来源',
    `view_status`   tinyint(1)    NOT NULL DEFAULT 0 COMMENT '是否公开[0:仅自己可见，1:所有人可见]',

    `create_time` datetime               DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime               DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `yn`          tinyint(1)             DEFAULT '0' COMMENT '逻辑删除 0.未删除 1.已删除',
    PRIMARY KEY (`id`),
    KEY `coder_no` (`coder_no`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='随笔表';


CREATE TABLE `website_info`
(
    `id`               bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `no`               varchar(32)  NOT NULL COMMENT '编号',

    `name`             varchar(16)  NOT NULL COMMENT '网站名称',
    `title`            varchar(512) NOT NULL COMMENT '网站信息',
    `notices`          varchar(512)          DEFAULT NULL COMMENT '公告',
    `footer`           varchar(256) NOT NULL COMMENT '页脚',
    `background_image` varchar(256)          DEFAULT NULL COMMENT '背景',
    `avatar`           varchar(256) NOT NULL COMMENT '头像',
    `random_avatar`    text                  DEFAULT NULL COMMENT '随机头像',
    `random_name`      varchar(4096)         DEFAULT NULL COMMENT '随机名称',
    `random_cover`     text                  DEFAULT NULL COMMENT '随机封面',
    `waifu_json`       text                  DEFAULT NULL COMMENT '看板娘消息',
    `status`           tinyint(1)   NOT NULL DEFAULT 1 COMMENT '是否启用[0:否，1:是]',

    `create_time`      datetime              DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`      datetime              DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `yn`               tinyint(1)            DEFAULT '0' COMMENT '逻辑删除 0.未删除 1.已删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='网站信息表';


CREATE TABLE IF NOT EXISTS `friend_link`
(
    `id`           bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `no`           varchar(32) NOT NULL COMMENT '友链编号',

    `title`        varchar(64) NOT NULL COMMENT '标题',
    `classify`     tinyint(1)   DEFAULT NULL COMMENT '分类',
    `cover`        varchar(256) DEFAULT NULL COMMENT '封面',
    `introduction` varchar(128) DEFAULT NULL COMMENT '简介',
    `url`          varchar(128) DEFAULT NULL COMMENT '链接',
    `type`         varchar(32) NOT NULL COMMENT '资源类型',
    `remark`       text         DEFAULT NULL COMMENT '备注',

    `status`       tinyint(1)   DEFAULT 0 COMMENT '是否启用[0:否，1:是]',

    `create_time`  datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`  datetime     DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `yn`           tinyint(1)   DEFAULT 0 COMMENT '逻辑删除 0.未删除 1.已删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='友链表';


CREATE TABLE `file_info`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `coder_no`    varchar(32)  NOT NULL COMMENT 'coder编号',

    `type`        varchar(32)  NOT NULL COMMENT '资源类型',
    `path`        varchar(256) NOT NULL COMMENT '资源路径',
    `size`        int                   DEFAULT NULL COMMENT '资源内容的大小，单位：字节',
    `mime_type`   varchar(256)          DEFAULT NULL COMMENT '资源的 MIME 类型',
    `status`      tinyint(1)   NOT NULL DEFAULT 1 COMMENT '是否启用[0:否，1:是]',
    `store_type`  tinyint(1)            DEFAULT NULL COMMENT '存储平台 1.七牛云',

    `create_time` datetime              DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime              DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `yn`          tinyint(1)            DEFAULT 0 COMMENT '逻辑删除 0.未删除 1.已删除',
    PRIMARY KEY (`id`),
    UNIQUE KEY `ya_path` (`path`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 COMMENT ='coder资源信息表';


CREATE TABLE `sweetheart`
(
    `id`              bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `no`              varchar(32)  NOT NULL COMMENT '编号',
    `coder_no`        varchar(32)  NOT NULL COMMENT 'coder编号',

    `background`      varchar(256) NOT NULL COMMENT '背景封面',
    `man_avatar`      varchar(256) NOT NULL COMMENT '男生头像',
    `woman_avatar`    varchar(256) NOT NULL COMMENT '女生头像',
    `man_pet_name`    varchar(32)  NOT NULL COMMENT '男生昵称',
    `wife_pet_name`   varchar(32)  NOT NULL COMMENT '女生昵称',
    `loving_time`     date         NOT NULL COMMENT '相恋时间',
    `countdown_title` varchar(32)           DEFAULT NULL COMMENT '倒计时标题',
    `countdown_time`  varchar(32)           DEFAULT NULL COMMENT '倒计时时间',
    `blessing_count`  int          NOT NULL DEFAULT 0 COMMENT '祝福数量',

    `other_info`      varchar(1024)         DEFAULT NULL COMMENT '额外信息',
    `status`          tinyint(1)   NOT NULL DEFAULT 1 COMMENT '是否启用[0:否，1:是]',

    `create_time`     datetime              DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`     datetime              DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `yn`              tinyint(1)            DEFAULT '0' COMMENT '逻辑删除 0.未删除 1.已删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='恋人表';


CREATE TABLE `history_info`
(
    `id`          bigint(20)   NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `no`          varchar(32)  NOT NULL COMMENT '编号',
    `coder_no`    varchar(32)  NOT NULL DEFAULT '' COMMENT 'coder编号',

    `ip`          varchar(128) NOT NULL COMMENT 'ip',
    `nation`      varchar(64)           DEFAULT NULL COMMENT '国家',
    `province`    varchar(64)           DEFAULT NULL COMMENT '省份',
    `city`        varchar(64)           DEFAULT NULL COMMENT '城市',

    `create_time` datetime              DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime              DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `yn`          tinyint(1)            DEFAULT '0' COMMENT '逻辑删除 0.未删除 1.已删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='历史信息';


CREATE TABLE `im_chat_coder_friend`
(
    `id`            bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `no`            varchar(32) NOT NULL COMMENT '编号',

    `coder_no`      varchar(32) NOT NULL COMMENT 'coder编号',
    `friend_no`     varchar(32) NOT NULL COMMENT '好友编号',
    `friend_status` tinyint(2)  NOT NULL COMMENT '好友状态[0:未审核，1:审核通过]',
    `remark`        varchar(32) DEFAULT NULL COMMENT '备注',

    `create_time`   datetime    DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`   datetime    DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `yn`            tinyint(1)  DEFAULT '0' COMMENT '逻辑删除 0.未删除 1.已删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='好友表';


CREATE TABLE `im_chat_group`
(
    `id`           bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `no`           varchar(32) NOT NULL COMMENT '编号',

    `master_no`    varchar(32) NOT NULL DEFAULT NULL COMMENT '群主编号',
    `group_name`   varchar(32) NOT NULL COMMENT '群名称',
    `avatar`       varchar(256)         DEFAULT NULL COMMENT '群头像',
    `introduction` varchar(128)         DEFAULT NULL COMMENT '简介',
    `notice`       varchar(1024)        DEFAULT NULL COMMENT '公告',
    `in_type`      tinyint(1)  NOT NULL DEFAULT 1 COMMENT '进入方式[0:无需验证，1:需要群主或管理员同意]',
    `group_type`   tinyint(1)  NOT NULL DEFAULT 1 COMMENT '类型[1:聊天群，2:话题]',

    `create_time`  datetime             DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`  datetime             DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `yn`           tinyint(1)           DEFAULT '0' COMMENT '逻辑删除 0.未删除 1.已删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='聊天群';


CREATE TABLE `im_chat_group_member`
(
    `id`              bigint(20)  NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `no`              varchar(32) NOT NULL COMMENT '编号',
    `group_no`        varchar(32) NOT NULL COMMENT '群编号',

    `coder_no`        varchar(32) NOT NULL COMMENT 'coder编号',
    `verify_coder_no` varchar(32)          DEFAULT NULL COMMENT '审核用户编号',
    `remark`          varchar(1024)        DEFAULT NULL COMMENT '备注',
    `admin_flag`      tinyint(1)  NOT NULL DEFAULT 0 COMMENT '是否管理员[0:否，1:是]',
    `coder_status`    tinyint(1)  NOT NULL COMMENT '用户状态[0:未审核，1:审核通过，2:禁言]',

    `create_time`     datetime             DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`     datetime             DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `yn`              tinyint(1)           DEFAULT '0' COMMENT '逻辑删除 0.未删除 1.已删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='聊天群成员表';


CREATE TABLE `im_chat_single_message`
(
    `id`             bigint(20)    NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `no`             varchar(32)   NOT NULL COMMENT '编号',

    `from_no`        varchar(32)   NOT NULL COMMENT '发送ID',
    `to_no`          varchar(32)   NOT NULL COMMENT '接收ID',
    `content`        varchar(1024) NOT NULL COMMENT '内容',
    `message_status` tinyint(1)    NOT NULL DEFAULT 0 COMMENT '是否已读[0:未读，1:已读]',

    `create_time`    datetime               DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time`    datetime               DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `yn`             tinyint(1)             DEFAULT '0' COMMENT '逻辑删除 0.未删除 1.已删除',
    PRIMARY KEY (`id`),
    KEY `union_index` (`to_no`, `message_status`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='单聊记录表';


CREATE TABLE `im_chat_group_message`
(
    `id`          bigint(20)    NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `no`          varchar(32)   NOT NULL COMMENT '编号',

    `group_no`    varchar(32)   NOT NULL COMMENT '群ID',
    `from_no`     varchar(32)   NOT NULL COMMENT '发送ID',
    `to_no`       varchar(32) DEFAULT NULL COMMENT '接收ID',
    `content`     varchar(1024) NOT NULL COMMENT '内容',

    `create_time` datetime    DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` datetime    DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
    `yn`          tinyint(1)  DEFAULT '0' COMMENT '逻辑删除 0.未删除 1.已删除',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4
  COLLATE = utf8mb4_general_ci COMMENT ='群聊记录表';


-- No.4 初始化数据
INSERT INTO `coder` (`id`, `no`, `username`, `password`, `gender`, `avatar`, `website`, `github`, `gitee`, `email`,
                     `phone`, `type`, `saying`, `status`, `create_time`, `update_time`, `yn`)
VALUES (1, 'YA238192378218', 'lambkinya', '$2a$10$i.tORE2bNlF92nq0AmOkZ.ymg4aVxwbGzpNIYpLmoMRvaT92hrqgO', 0,
        'http://s10nnt6yg.hb-bkt.clouddn.com/2023/09/16/YA251651564-e49da37d9989481b845648d1a32986a9.png',
        'http://lambkinya.com', '', '', '', '', 0, '', 1, '2023-09-17 12:58:57', '2023-09-17 12:58:57', 0);

INSERT INTO `im_chat_group` (`id`, `no`, `master_no`, `group_name`, `avatar`, `introduction`, `notice`, `in_type`,
                             `group_type`, `create_time`, `update_time`, `yn`)
VALUES (1, 'GN27389134783', '1', '公共聊天室', NULL, '公共聊天室', NULL, 1, 1, '2023-09-17 12:53:41',
        '2023-09-17 12:53:41', 0);

INSERT INTO `im_chat_group_member` (`id`, `no`, `group_no`, `coder_no`, `verify_coder_no`, `remark`, `admin_flag`,
                                    `coder_status`, `create_time`, `update_time`, `yn`)
VALUES (1, 'GMN3279872', '-1', 'YA238192378218', NULL, NULL, 1, 1, '2023-09-17 12:57:39', '2023-09-17 12:57:39', 0);

INSERT INTO `website_info` (`id`, `no`, `name`, `title`, `notices`, `footer`, `background_image`, `avatar`,
                            `random_avatar`, `random_name`, `random_cover`, `waifu_json`, `status`)
VALUES (1, 'WIN4648465468441', 'Lambkin', '花灯随烟波铺江上', '[]', '月下闲读，红袖添香。', '', '', '[]', '[]', '[]', '{
  "mouseover": [
    {
      "selector": "#live2d",
      "text": [
        "我是一个特别固执的人，我从来不会在意别人跟我说什么，让我去做，让我去怎么做，我不管。如果，你也可以像我一样，那我觉得，这件事情，太酷辣!!!"
      ]
    },
    {
      "selector": "#waifu-tool .fa-street-view",
      "text": [
        "喜欢换装 PLAY 吗？"
      ]
    },
    {
      "selector": "#waifu-tool .fa-times",
      "text": [
        "到了要说再见的时候了吗？"
      ]
    }
  ],
  "click": [
    {
      "selector": "#live2d",
      "text": [
        "你看到我的小熊了吗？"
      ]
    }
  ],
  "seasons": [
    {
      "date": "01/01",
      "text": "<span>元旦</span>了呢，新的一年又开始了，今年是{year}年～"
    },
    {
      "date": "02/14",
      "text": "又是一年<span>情人节</span>，{year}年找到对象了嘛～"
    },
    {
      "date": "03/08",
      "text": "今天是<span>国际妇女节</span>！"
    },
    {
      "date": "03/12",
      "text": "今天是<span>植树节</span>，要保护环境呀！"
    },
    {
      "date": "04/01",
      "text": "悄悄告诉你一个秘密～<span>今天是愚人节，不要被骗了哦～</span>"
    },
    {
      "date": "05/01",
      "text": "今天是<span>五一劳动节</span>，计划好假期去哪里了吗～"
    },
    {
      "date": "06/01",
      "text": "<span>儿童节</span>了呢，快活的时光总是短暂，要是永远长不大该多好啊…"
    },
    {
      "date": "09/03",
      "text": "<span>中国人民抗日战争胜利纪念日</span>，铭记历史、缅怀先烈、珍爱和平、开创未来。"
    },
    {
      "date": "09/10",
      "text": "<span>教师节</span>，在学校要给老师问声好呀～"
    },
    {
      "date": "10/01",
      "text": "<span>国庆节</span>到了，为祖国母亲庆生！"
    },
    {
      "date": "11/05-11/12",
      "text": "今年的<span>双十一</span>是和谁一起过的呢～"
    },
    {
      "date": "12/20-12/31",
      "text": "这几天是<span>圣诞节</span>，主人肯定又去剁手买买买了～"
    }
  ]
}', 1);
