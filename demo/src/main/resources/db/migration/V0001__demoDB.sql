CREATE SEQUENCE HIBERNATE_SEQUENCE START WITH 100;

CREATE TABLE IF NOT EXISTS `label` (
  id BIGINT NOT NULL,
  name varchar(250) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS `band` (
  id BIGINT NOT NULL,
  name varchar(250) UNIQUE NOT NULL,
  style varchar(250),
  label_ref BIGINT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_band_label FOREIGN KEY (label_ref) REFERENCES label (id)
);

CREATE TABLE IF NOT EXISTS `record` (
  id BIGINT NOT NULL,
  title varchar(250) NOT NULL,
  year char(4) NOT NULL,
  band_ref BIGINT NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT FK_record_band FOREIGN KEY (band_ref) REFERENCES band (id)
);

INSERT INTO `label` (id, name) VALUES (1, 'Relapse');
INSERT INTO `label` (id, name) VALUES (2, 'Sargent House');
INSERT INTO `band` (id, name, style, label_ref) VALUES (1,'Mastodon', 'metal', 1);
INSERT INTO `band` (id, name, style, label_ref) VALUES (2,'Red Fang', 'rock', 1);
INSERT INTO `band` (id, name, style, label_ref) VALUES (3,'Russian Circles', 'post-rock', 2);
INSERT INTO `band` (id, name, style, label_ref) VALUES (4,'And so I watch you from afar', 'rock', 2);
INSERT INTO `record` (id, title, year, band_ref) VALUES (1, 'Emperor of sand', '2017', 1);