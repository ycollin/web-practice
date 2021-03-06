/**********************************/
/* テーブル名: users */
/**********************************/
CREATE TABLE users(
		id                            		INT		 NOT NULL AUTO_INCREMENT COMMENT 'id',
		name                          		VARCHAR(20)		 NULL  COMMENT 'name',
		birthday                      		DATE		 NULL  COMMENT 'birthday',
		sex                           		TINYINT		 NULL  COMMENT 'sex',
		prefecture_id                 		TINYINT		 NULL  COMMENT 'prefecture_id',
		password                      		VARCHAR(10)		 NULL  COMMENT 'password',
		PRIMARY KEY (id)
) COMMENT='users';

insert into users (id, name, birthday, sex, prefecture_id, password) values (1, 'name1', '1984-01-01', 2,2,'12345678');
insert into users (id, name, birthday, sex, prefecture_id, password) values (2, 'name2', '1984-01-02', 2,2,'12345678');


/**********************************/
/* テーブル名: prefectures */
/**********************************/
CREATE TABLE prefectures(
		id                            		TINYINT		 NULL  COMMENT 'id',
		name                          		VARCHAR(10)		 NULL  COMMENT 'name'
) COMMENT='prefectures';


insert into prefectures (id, name) values
 (1 , '北海道'),
 (2 , '青森県'),
 (3 , '岩手県'),
 (4 , '宮城県'),
 (5 , '秋田県'),
 (6 , '山形県'),
 (7 , '福島県'),
 (8 , '茨城県'),
 (9 , '栃木県'),
 (10, '群馬県'),
 (11, '埼玉県'),
 (12, '千葉県'),
 (13, '東京都'),
 (14, '神奈川県'),
 (15, '新潟県'),
 (16, '富山県'),
 (17, '石川県'),
 (18, '福井県'),
 (19, '山梨県'),
 (20, '長野県'),
 (21, '岐阜県'),
 (22, '静岡県'),
 (23, '愛知県'),
 (24, '三重県'),
 (25, '滋賀県'),
 (26, '京都府'),
 (27, '大阪府'),
 (28, '兵庫県'),
 (29, '奈良県'),
 (30, '和歌山県'),
 (31, '鳥取県'),
 (32, '島根県'),
 (33, '岡山県'),
 (34, '広島県'),
 (35, '山口県'),
 (36, '徳島県'),
 (37, '香川県'),
 (38, '愛媛県'),
 (39, '高知県'),
 (40, '福岡県'),
 (41, '佐賀県'),
 (42, '長崎県'),
 (43, '熊本県'),
 (44, '大分県'),
 (45, '宮崎県'),
 (46, '鹿児島県'),
 (47, '沖縄県');
