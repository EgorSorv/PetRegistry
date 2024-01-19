use petregistry;

# 7. В подключенном MySQL репозитории создать базу данных “Друзья человека”

create table FriendsOfMan
(
ID int primary key auto_increment,
Spiece varchar(20) not null default "Неизвестен",
Name varchar(25) not null default "Неизвестно",
Commands varchar(50),
Date_of_birth date not null
);

insert into FriendsOfMan (Spiece, Name, Commands, Date_of_birth)
values
("Собака", "Джек", "лежать, ждать, бег", "2022-03-05"),
("Кошка", "Мурка", "лежать", "2017-06-29"),
("Собака", "Тошка", "ждать", "2016-05-10"),
("Хомяк", "Тим", "лежать, бег", "2023-01-25"),
("Кошка", "Барсик", "ждать", "2021-07-30"),
("Хомяк", "Рыжик", "ждать", "2022-12-20"),
("Лошадь", "Пегас", "ждать, бег", "2019-09-17"),
("Верблюд", "Бо", "бег", "2018-08-01"),
("Верблюд", "Хорд", "бег", "2015-05-03"),
("Осел", "Пит", "бег, ждать", "2023-10-25"),
("Лошадь", "Жак", "бег, ждать", "2020-01-21"),
("Осел", "Эд", "ждать", "2019-04-11");

select* from FriendsOfMan;

# 8. Создать таблицы с иерархией из диаграммы в БД

create table Dogs
(
ID int primary key,
Name varchar(25) not null default "Неизвестно",
Commands varchar(50),
Date_of_birth date not null
);

create table Cats as select* from Dogs;
create table Humsters as select* from Dogs;
create table Horses as select* from Dogs;
create table Camels as select* from Dogs;
create table Donkeyes as select* from Dogs;

/*
9. Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения
*/

insert into Dogs (ID, Name, Commands, Date_of_birth)
select ID, Name, Commands, Date_of_birth from FriendsOfMan 
where Spiece = "Собака";

select* from Dogs;

insert into Cats (ID, Name, Commands, Date_of_birth)
select ID, Name, Commands, Date_of_birth from FriendsOfMan 
where Spiece = "Кошка";

select* from Cats;

insert into Humsters (ID, Name, Commands, Date_of_birth) 
select ID, Name, Commands, Date_of_birth from FriendsOfMan 
where Spiece = "Хомяк";

select* from Humsters;

insert into Horses (ID, Name, Commands, Date_of_birth)
select ID, Name, Commands, Date_of_birth from FriendsOfMan 
where Spiece = "Лошадь";

select* from Horses;

insert into Camels (ID, Name, Commands, Date_of_birth)
select ID, Name, Commands, Date_of_birth from FriendsOfMan 
where Spiece = "Верблюд";

select* from Camels;

insert into Donkeyes (ID, Name, Commands, Date_of_birth)
select ID, Name, Commands, Date_of_birth from FriendsOfMan 
where Spiece = "Осел";

select* from Donkeyes;

/* 
10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.
*/

delete from FriendsOfMan
where Spiece = "Верблюд";

select* from FriendsOfMan;

create table PackAnimals
select* from horses
union
select* from donkeyes;

select* from PackAnimals;

alter table PackAnimals
add Spiece varchar(20) not null default "Неизвестен";

update PackAnimals
join FriendsOfMan on packanimals.ID = friendsofman.id 
set packanimals.Spiece = friendsofman.Spiece;

select* from PackAnimals;

/* 
11.Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице
*/

create table youngAnimals
(
ID int primary key,
Spiece varchar(20) not null default "Неизвестен",
Name varchar(20) not null default "Неизвестен",
Commands varchar(50),
Date_of_birth date not null,
Age int
);

insert into youngAnimals (ID, Spiece, Name, Commands, Date_of_birth)
select* from friendsofman
where timestampdiff(year, friendsofman.	Date_of_birth, curdate()) >= 1 and timestampdiff(year, friendsofman.	Date_of_birth, curdate()) <= 3;

select* from youngAnimals;

update youngAnimals
set youngAnimals.Age = timestampdiff(year, youngAnimals.Date_of_birth, curdate());

select* from youngAnimals;

/*
12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам.
*/

create table animals
select* from friendsofman;

select* from animals;

alter table animals
add age_category varchar(20) not null default "Неизвестен",
add animal_type varchar(20) not null default "Неизвестен";

select* from animals;

update animals
set age_category = if(
timestampdiff(year, animals.Date_of_birth, curdate()) >= 1 and timestampdiff(year, animals.Date_of_birth, curdate()) <= 3, 
"Молодой", "Взрослый");

select* from animals;

update animals
left join packanimals on animals.ID = packanimals.id 
set animal_type = if(animals.ID = packanimals.id, "Вьючный", "Домашний");

select* from animals;
