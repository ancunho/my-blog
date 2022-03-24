-- POST表
CREATE TABLE IF NOT EXISTS `cunho_post` (
                                        `POST_ID` INT NOT NULL AUTO_INCREMENT,
                                        `POST_CATEGORY` INT NULL COMMENT '文章分类',
                                        `POST_AUTHOR` VARCHAR(45) NULL COMMENT '作者',
                                        `POST_TITLE` VARCHAR(200) NOT NULL COMMENT '标题',
                                        `POST_EXCERPT` VARCHAR(500) NULL COMMENT '文章摘要',
                                        `POST_CONTENT` VARCHAR(5000) NULL COMMENT '详细内容',
                                        `POST_STATUS` ENUM('PUBLISH', 'DRAFT', 'PRIVATE') NULL DEFAULT 'PUBLISH' COMMENT '文章状态 PUBLISH: 已发表, DRAFT:草稿, PRIVATE:私人内容(不会被公开)',
                                        `COMMENT_STATUS` ENUM('OPEN', 'CLOSED', 'REGISTER_ONLY') NULL DEFAULT 'OPEN' COMMENT 'comment状态',
                                        `POST_TYPE` VARCHAR(10) NULL DEFAULT 0 COMMENT '文章类型',
                                        `POST_PASSWORD` VARCHAR(45) NULL,
                                        `POST_PARENT` INT NULL,
                                        `OPTION01` VARCHAR(45) NULL,
                                        `OPTION02` VARCHAR(45) NULL,
                                        `OPTION03` VARCHAR(45) NULL,
                                        `OPTION04` VARCHAR(45) NULL,
                                        `OPTION05` VARCHAR(45) NULL,
                                        `CREATE_TIME` DATETIME NULL COMMENT '生成时间',
                                        `UPDATE_TIME` DATETIME NULL DEFAULT NOW() COMMENT '更新时间',
PRIMARY KEY (`POST_ID`)
)
ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- 用户表
CREATE TABLE IF NOT EXISTS `cunho_user` (
                                        `USER_ID` INT NOT NULL AUTO_INCREMENT,
                                        `USERNAME` VARCHAR(45) NULL,
                                        `PASSWORD` VARCHAR(100) NULL,
                                        `USER_NICENAME` VARCHAR(45) NULL,
                                        `USER_EMAIL` VARCHAR(45) NULL,
                                        `USER_PHONE` VARCHAR(20) NULL,
                                        `USER_WECHAT` VARCHAR(45) NULL,
                                        `USER_QQ` VARCHAR(45) NULL,
                                        `USER_COUNTRY` VARCHAR(45) NULL,
                                        `USER_CITY` VARCHAR(45) NULL,
                                        `USER_LEVEL` INT(2) NULL COMMENT '0~10, 0:最低, 10:最高',
                                        `USER_STATUS` VARCHAR(10) NULL,
                                        `OPTION01` VARCHAR(45) NULL,
                                        `OPTION02` VARCHAR(45) NULL,
                                        `OPTION03` VARCHAR(45) NULL,
                                        `OPTION04` VARCHAR(45) NULL,
                                        `OPTION05` VARCHAR(45) NULL,
                                        `CREATE_TIME` DATETIME NULL,
                                        `UPDATE_TIME` DATETIME NULL,
PRIMARY KEY (`USER_ID`)
)
ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;