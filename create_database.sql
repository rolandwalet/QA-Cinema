CREATE TABLE IF NOT EXISTS `classification` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(500) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `director` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `film` (
  `id` INT NOT NULL,
  `title` VARCHAR(255) NOT NULL,
  `release_date` DATE NOT NULL,
  `end_date` DATE NOT NULL,
  `run_time` INT(3) NOT NULL,
  `poster` VARCHAR(100) NOT NULL,
  `synopsis` VARCHAR(500) NOT NULL,
  `classification_id` INT NOT NULL,
  `director_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_film_classification_idx` (`classification_id` ASC),
  INDEX `fk_film_director1_idx` (`director_id` ASC),
  CONSTRAINT `fk_film_classification`
    FOREIGN KEY (`classification_id`)
    REFERENCES `classification` (`id`),
  CONSTRAINT `fk_film_director1`
    FOREIGN KEY (`director_id`)
    REFERENCES `director` (`id`));

CREATE TABLE IF NOT EXISTS `genre` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `film_has_genre` (
  `film_id` INT NOT NULL,
  `genre_id` INT NOT NULL,
  PRIMARY KEY (`film_id`, `genre_id`),
    FOREIGN KEY (`film_id`)
    REFERENCES `film` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`genre_id`)
    REFERENCES `genre` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `actor` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `film_has_actor` (
  `film_id` INT NOT NULL,
  `actor_id` INT NOT NULL,
  PRIMARY KEY (`film_id`, `actor_id`),
    FOREIGN KEY (`film_id`)
    REFERENCES `film` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`actor_id`)
    REFERENCES `actor` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `screen_type` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `number_or_seats` INT(3) NOT NULL,
  `seating_plan` VARCHAR(45) NOT NULL,
  `decor` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `screen` (
  `id` INT NOT NULL,
  `screen_type_id` INT NOT NULL,
  PRIMARY KEY (`id`),
    FOREIGN KEY (`screen_type_id`)
    REFERENCES `screen_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `showing` (
  `id` INT NOT NULL,
  `film_id` INT NOT NULL,
  `time` VARCHAR(45) NOT NULL,
  `date` DATE NOT NULL,
  `screen_id` INT NOT NULL,
  PRIMARY KEY (`id`),
    FOREIGN KEY (`screen_id`)
    REFERENCES `screen` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`film_id`)
    REFERENCES `film` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `booking` (
  `id` INT NOT NULL,
  `showing_id` INT NOT NULL,
  `customer_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
    FOREIGN KEY (`showing_id`)
    REFERENCES `showing` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

CREATE TABLE IF NOT EXISTS `ticket_type` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `price` INT(2) NOT NULL,
  PRIMARY KEY (`id`));

CREATE TABLE IF NOT EXISTS `ticket` (
  `id` INT NOT NULL,
  `ticket_type_id` INT NOT NULL,
  `booking_id` INT NOT NULL,
  `quantity` INT(2) NOT NULL,
  PRIMARY KEY (`id`),
    FOREIGN KEY (`ticket_type_id`)
    REFERENCES `ticket_type` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
    FOREIGN KEY (`booking_id`)
    REFERENCES `booking` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);