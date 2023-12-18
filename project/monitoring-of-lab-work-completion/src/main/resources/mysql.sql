DROP
DATABASE IF EXISTS monitoring_of_lab_work_completion;

CREATE
DATABASE monitoring_of_lab_work_completion;
USE
monitoring_of_lab_work_completion;

CREATE TABLE students
(
    id bigint PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50),
    last_name  VARCHAR(50)
);


CREATE TABLE disciplines
(
    id   bigint PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100)
);


CREATE TABLE assignments
(
    id   bigint PRIMARY KEY AUTO_INCREMENT,
    discipline_id   bigint,
    name VARCHAR(100),
    max_score       int,
    FOREIGN KEY (discipline_id) REFERENCES disciplines (id)
);


CREATE TABLE scores
(
    id      bigint PRIMARY KEY AUTO_INCREMENT,
    student_id    bigint,
    assignment_id bigint,
    value   INT,
    FOREIGN KEY (student_id) REFERENCES students (id),
    FOREIGN KEY (assignment_id) REFERENCES assignments (id)
);