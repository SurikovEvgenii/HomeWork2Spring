CREATE TABLE category(id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY, description varchar(100));
CREATE TABLE shops(id int PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
                   name varchar(255),
                   address varchar(255),
                   telephone varchar(20),
                   email varchar(50),
                   site varchar(50),
                   category_id int,
                   description varchar(250),
                   FOREIGN KEY(category_id) REFERENCES category(id));

INSERT INTO category(description) VALUES ('Grocery store');
INSERT INTO category(description) VALUES ('Hardware store');
INSERT INTO category(description) VALUES ('Sports store');
INSERT INTO category(description) VALUES ('Music store');
INSERT INTO category(description) VALUES ('Electronics store');
INSERT INTO category(description) VALUES ('Clothing store');
INSERT INTO category(description) VALUES ('Shoe store');

INSERT INTO shops(name,address,telephone,email,site,category_id,description)
    VALUES ('Adidas','Parchomenko st., 10','88005553535','gosha@rub.ru','gosharub.ru',7,'Three strips on shoes');
INSERT INTO shops(name,address,telephone,email,site,category_id,description)
    VALUES ('Sportmaster','Vysotskii st., 30/1','88003431354','sport@master.ru','sportmaster.ru',3,'Hypermarket sport things');









