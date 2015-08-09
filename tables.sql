/*
DROP TABLE weather_data;
DROP TABLE clouds;
DROP TABLE coord;
DROP TABLE main;
DROP TABLE rain;
DROP TABLE snow;
DROP TABLE sys;
DROP TABLE weather;
DROP TABLE wind;

DROP SEQUENCE clouds_oid;
DROP SEQUENCE coord_oid;
DROP SEQUENCE main_oid;
DROP SEQUENCE rain_oid;
DROP SEQUENCE snow_oid;
DROP SEQUENCE sys_oid;
DROP SEQUENCE weather_oid;
DROP SEQUENCE wind_oid;
DROP SEQUENCE weather_data_oid;


 */


CREATE SEQUENCE clouds_oid;
CREATE TABLE clouds (
  clouds_oid BIGINT NOT NULL,
  _all INT
);

ALTER TABLE clouds
ADD CONSTRAINT pk_clouds PRIMARY KEY (clouds_oid);
-------------------------------------------------------
CREATE SEQUENCE coord_oid;
CREATE TABLE coord (
  coord_oid BIGINT NOT NULL,
  lon DECIMAL,
  lat DECIMAL
);

ALTER TABLE coord
ADD CONSTRAINT pk_coord PRIMARY KEY (coord_oid);
-------------------------------------------------------
CREATE SEQUENCE main_oid;
CREATE TABLE main (
  main_oid        BIGINT NOT NULL,
  temp       DECIMAL,
  pressure   INT,
  humidity   INT,
  temp_min   DECIMAL,
  temp_max   DECIMAL,
  sea_level  DECIMAL,
  grnd_level DECIMAL
);

ALTER TABLE main
ADD CONSTRAINT pk_main PRIMARY KEY (main_oid);
-------------------------------------------------------
CREATE SEQUENCE rain_oid;
CREATE TABLE rain (
  rain_oid BIGINT NOT NULL,
  _3h INT
);

ALTER TABLE rain
ADD CONSTRAINT pk_rain PRIMARY KEY (rain_oid);
-------------------------------------------------------
CREATE SEQUENCE snow_oid;
CREATE TABLE snow (
  snow_oid BIGINT NOT NULL,
  _3h INT
);

ALTER TABLE snow
ADD CONSTRAINT pk_snow PRIMARY KEY (snow_oid);
-------------------------------------------------------
CREATE SEQUENCE sys_oid;
CREATE TABLE sys (
  sys_oid     BIGINT NOT NULL,
  type    INT,
  id      INT,
  message DECIMAL,
  country VARCHAR(64),
  sunrise BIGINT,
  sunset  BIGINT
);

ALTER TABLE sys
ADD CONSTRAINT pk_sys PRIMARY KEY (sys_oid);
-------------------------------------------------------
CREATE SEQUENCE weather_oid;
CREATE TABLE weather (
  weather_oid  BIGINT NOT NULL,
  weather_data_oid BIGINT,
  id   INT,
  main VARCHAR(64),
  description VARCHAR(64),
  icon VARCHAR(3)
);


ALTER TABLE weather
ADD CONSTRAINT pk_weather PRIMARY KEY (weather_oid);
-------------------------------------------------------
CREATE SEQUENCE wind_oid;
CREATE TABLE wind(
  wind_oid  BIGINT NOT NULL,
  speed DECIMAL,
  deg INT
);

ALTER TABLE wind
ADD CONSTRAINT pk_wind PRIMARY KEY (wind_oid);
-------------------------------------------------------
CREATE SEQUENCE weather_data_oid;
CREATE TABLE weather_data(
  weather_data_oid BIGINT NOT NULL,
  coord_coord_oid BIGINT,
  base VARCHAR(64),
  main_main_oid BIGINT,
  wind_wind_oid BIGINT,
  clouds_clouds_oid BIGINT,
  rain_rain_oid BIGINT,
  dt BIGINT,
  sys_sys_oid BIGINT,
  id BIGINT,
  name VARCHAR(64),
  cod INT,
  visibility INT
);

ALTER TABLE weather_data
ADD CONSTRAINT pk_weather_data PRIMARY KEY (weather_data_oid);
ALTER TABLE weather_data
ADD CONSTRAINT fk_weather_data_coord FOREIGN KEY(coord_coord_oid) REFERENCES coord(coord_oid);
ALTER TABLE weather_data
ADD CONSTRAINT fk_weather_data_main FOREIGN KEY(main_main_oid) REFERENCES main(main_oid);
ALTER TABLE weather_data
ADD CONSTRAINT fk_weather_data_wind FOREIGN KEY(wind_wind_oid) REFERENCES wind(wind_oid);
ALTER TABLE weather_data
ADD CONSTRAINT fk_weather_data_clouds FOREIGN KEY(clouds_clouds_oid) REFERENCES clouds(clouds_oid);
ALTER TABLE weather_data
ADD CONSTRAINT fk_weather_data_rain FOREIGN KEY(rain_rain_oid) REFERENCES rain(rain_oid);
ALTER TABLE weather_data
ADD CONSTRAINT fk_weather_data_sys FOREIGN KEY(sys_sys_oid) REFERENCES sys(sys_oid);

