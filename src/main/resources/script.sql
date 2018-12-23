CREATE TABLE developers(
  developer_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(45) NOT NULL ,
  age INT NOT NULL ,
  number_of_skills INT NOT NULL ,
  number_of_projects INT
);

CREATE TABLE companies(
  company_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(100) NOT NULL ,
  number_of_projects INT
);

CREATE TABLE projects(
  project_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(100) NOT NULL ,
  number_of_developers INT
);

CREATE TABLE customers(
  customer_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(45) NOT NULL ,
  number_of_projects INT
);

CREATE TABLE skills(
  skill_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  type ENUM ('JAVA', 'CPP', 'C_SHARP','JS') NOT NULL ,
  level ENUM ('JUNIOR', 'MIDDLE', 'SENIOR') NOT NULL
);

CREATE TABLE developersSkillsRelation(
  developer_id INT NOT NULL ,
  skill_id INT NOT NULL ,
  FOREIGN KEY (developer_id) REFERENCES developers (developer_id),
  FOREIGN KEY (skill_id) REFERENCES skills (skill_id)
);

CREATE TABLE developersProjectsRelation(
  developer_id INT NOT NULL ,
  project_id INT NOT NULL ,
  FOREIGN KEY (developer_id) REFERENCES developers (developer_id),
  FOREIGN KEY (project_id) REFERENCES projects (project_id)
);

CREATE TABLE companiesProjectsRelation(
  company_id INT NOT NULL ,
  project_id INT NOT NULL ,
  FOREIGN KEY (company_id) REFERENCES companies (company_id),
  FOREIGN KEY (project_id) REFERENCES projects (project_id)
);

CREATE TABLE customersProjectsRelation(
  customer_id INT NOT NULL ,
  project_id INT NOT NULL ,
  FOREIGN KEY (customer_id) REFERENCES customers (customer_id),
  FOREIGN KEY (project_id) REFERENCES projects (project_id)
);
