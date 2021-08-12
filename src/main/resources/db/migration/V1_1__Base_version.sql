

CREATE TABLE departments(
    Id INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(250) NOT NULL
       );

CREATE TABLE students(
    Id INT AUTO_INCREMENT  PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    age INT NOT NULL,
    date_of_birth DATE NOT NULL,
    departments_name VARCHAR(250) NOT NULL,
    CONSTRAINT COMMAND_ACTION_FK FOREIGN KEY (departments_name) references departments(Name)

  );

CREATE TABLE courses(
    Id INT AUTO_INCREMENT  PRIMARY KEY,
    Name VARCHAR(250) NOT NULL
      );

CREATE TABLE students_courses(
    Students_first_name VARCHAR(250) NOT NULL,
    Courses_name VARCHAR(250) NOT NULL,
    CONSTRAINT COMMAND_ACTION_FK1 FOREIGN KEY (students_first_name) references students(first_name),
    CONSTRAINT COMMAND_ACTION_FK2 FOREIGN KEY (courses_name) references courses(Name)
  );

