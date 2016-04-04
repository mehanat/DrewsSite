-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Хост: 127.0.0.1
-- Время создания: Апр 04 2016 г., 14:35
-- Версия сервера: 5.6.17
-- Версия PHP: 5.5.12

DROP TABLE IF EXISTS buyings;
DROP TABLE IF EXISTS comments;
DROP TABLE IF EXISTS features;
DROP TABLE IF EXISTS items;



/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- База данных: `myshop`
--

-- --------------------------------------------------------

--
-- Структура таблицы `buyings`
--

CREATE TABLE buyings (
  Id SERIAL NOT NULL,
  itemId int NOT NULL,
  date date NOT NULL,
  PRIMARY KEY (Id)
);

--
-- Дамп данных таблицы `buyings`
--

INSERT INTO buyings (Id, itemId, date) VALUES
(1, 1, '2015-11-12'),
(2, 2, '2015-11-12'),
(3, 3, '2015-11-17'),
(4, 4, '2015-11-20'),
(5, 5, '2015-11-18');

-- --------------------------------------------------------

--
-- Структура таблицы `comments`
--

CREATE TABLE comments (
  id SERIAL NOT NULL,
  itemId int NOT NULL,
  authorName varchar NOT NULL,
  date date NOT NULL,
  text varchar(500) NOT NULL,
  PRIMARY KEY (id)
);

--
-- Дамп данных таблицы `comments`
--

INSERT INTO comments (id, itemId, authorName, date, text) VALUES
(6, 2, 'Анатолий', '2015-12-28', 'кенке'),
(8, 2, 'Anonymous', '2015-12-28', 'bjhkj'),
(9, 2, 'Drus', '2015-12-28', 'Самый четкий шоколад что я ел\r\nразводы на уровне!'),
(10, 2, 'ывывы', '2015-12-28', 'ывывыв'),
(11, 2, 'Anonymous', '2016-01-04', '<strong>коммент</strong>'),
(12, 2, 'вап', '2016-02-14', 'вап');

-- --------------------------------------------------------

--
-- Структура таблицы `features`
--

CREATE TABLE features (
  itemId INT NOT NULL,
  weight int NOT NULL,
  protein int NOT NULL,
  carbohydrates int NOT NULL,
  energy_value int NOT NULL,
  calories int NOT NULL
);

--
-- Дамп данных таблицы `features`
--

INSERT INTO features (itemId, weight, protein, carbohydrates, energy_value, calories) VALUES
(1, 100, 20, 30, 500, 12);

-- --------------------------------------------------------

--
-- Структура таблицы `items`
--

CREATE TABLE items (
  itemId SERIAL NOT NULL,
  name varchar  DEFAULT NULL,
  type varchar(50) DEFAULT NULL,
  cost int NOT NULL,
  description varchar NOT NULL,
  imagePath varchar NOT NULL,
  PRIMARY KEY (itemId)
);

--
-- Дамп данных таблицы `items`
--

INSERT INTO items (itemId, name, type, cost, description, imagePath) VALUES
(1, 'Name', 'fruit_black', 120, 'В одной такой плитке таится настоящий вихрь вкусовых наслаждений! Великолепный бельгийский шоколад класса Premium, наполненный невероятно-вкусной начинкой, м-м-м… Испытай страсть к изысканным сладостям вместе с любимыми людьми!', '../../resources/images/Items/item1.jpg'),
(2, 'Имя2', 'fruit_white', 130, '', '../../resources/images/Items/default.jpg'),
(3, 'Имя3', 'fruit_milk', 150, '', ''),
(4, 'Name2', 'flower_dark', 150, '', ''),
(5, 'Name3', 'flower_milk', 150, '', '');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
