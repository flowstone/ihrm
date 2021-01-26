CREATE TABLE `bs_user`(
    `id`                 varchar(40)  NOT NULL COMMENT 'ID',
    `mobile`             varchar(40)  NOT NULL COMMENT '手机号码',
    `username`           varchar(255) NOT NULL COMMENT '用户名称',
    `password`           varchar(255) DEFAULT NULL COMMENT '密码',
    `enable_state`       int(2)       DEFAULT '1' COMMENT '启用状态 0是禁用，1是启用',
    `create_time`        datetime     DEFAULT NULL COMMENT '创建时间',
    `department_id`      varchar(40)  DEFAULT NULL COMMENT '部门ID',
    `time_of_entry`      datetime     DEFAULT NULL COMMENT '入职时间',
    `form_of_employment` int(1)       DEFAULT NULL COMMENT '聘用形式',
    `work_number`        varchar(20)  DEFAULT NULL COMMENT '工号',
    `form_of_management` varchar(8)   DEFAULT NULL COMMENT '管理形式',
    `working_city`       varchar(16)  DEFAULT NULL COMMENT '工作城市',
    `correction_time`    datetime     DEFAULT NULL COMMENT '转正时间',
    `in_service_status`  int(1)       DEFAULT NULL COMMENT '在职状态 1.在职 2.离职',
    `company_id`         varchar(40)  DEFAULT NULL COMMENT '企业ID',
    `company_name`       varchar(40)  DEFAULT NULL,
    `department_name`    varchar(40)  DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_user_phone` (`mobile`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4