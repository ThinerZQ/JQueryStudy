CREATE TABLE province(
	pid INT,
	pname VARCHAR(20)
);
INSERT INTO  province VALUES(1,'四川');
DELETE FROM province WHERE pid=1;
CREATE TABLE city(
	cid INT ,
	cname VARCHAR(20),
	pid INT
)
INSERT INTO city(1,'广元',1);

CREATE TABLE county(
	tid INT,
	tname VARCHAR(20),
	cid INT
)
INSERT INTO county VALUES(1,'剑阁',1);

SELECT pid,pname FROM province ORDER BY pid;

