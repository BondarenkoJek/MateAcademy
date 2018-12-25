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
  level ENUM ('JUNIOR', 'MIDDLE', 'SENIOR') NOT NULL ,
  developer_id INT NOT NULL ,
  FOREIGN KEY (developer_id) REFERENCES developers(developer_id)
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

# 1
ALTER TABLE developers
  ADD salary DOUBLE;

# 3
SELECT sum(salary)
FROM developers
  INNER JOIN skills
    ON developers.developer_id = skills.developer_id
WHERE skills.type = "JAVA";

# 4
ALTER TABLE projects
  ADD cost DOUBLE;

# 5
SELECT projects.name
FROM projects
WHERE cost = (
  SELECT min(cost)
  FROM projects);

# 6
SELECT avg(developers.salary) AS avgSalary
FROM projects
  INNER JOIN developersProjectsRelation
    ON projects.project_id = developersProjectsRelation.project_id
  INNER JOIN developers
    ON developersProjectsRelation.developer_id = developers.developer_id
WHERE projects.cost = ( SELECT min(cost)FROM projects);