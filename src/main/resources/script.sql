CREATE TABLE developers(
  developer_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(45) NOT NULL ,
  age INT NOT NULL
);

CREATE TABLE companies(
  company_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(100) NOT NULL
);

CREATE TABLE customers(
  customer_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(45) NOT NULL
);

CREATE TABLE projects(
  project_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(100) NOT NULL ,
  date DATE NOT NULL ,
  company_id INT NOT NULL ,
  customer_id INT NOT NULL ,
  FOREIGN KEY (company_id) REFERENCES companies(company_id) ,
  FOREIGN KEY (customer_id) REFERENCES customers (customer_id)
);

CREATE TABLE skills(
  skill_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  type ENUM ('JAVA', 'CPP', 'C_SHARP','JS') NOT NULL ,
  level ENUM ('JUNIOR', 'MIDDLE', 'SENIOR') NOT NULL ,
  developer_id INT NOT NULL ,
  FOREIGN KEY (developer_id) REFERENCES developers(developer_id)
);

CREATE TABLE developers_projects(
  developer_id INT NOT NULL ,
  project_id INT NOT NULL ,
  FOREIGN KEY (developer_id) REFERENCES developers (developer_id),
  FOREIGN KEY (project_id) REFERENCES projects (project_id)
);


# 1
ALTER TABLE developers
  ADD salary DOUBLE;

# 2
SELECT
  projects.name AS name,
  sum(developers.salary) AS sumSalary
FROM projects
  INNER JOIN developers_projects
    ON projects.project_id = developers_projects.project_id
  INNER JOIN developers
    ON developers_projects.developer_id = developers.developer_id
GROUP BY projects.project_id
ORDER BY sumSalary DESC
LIMIT 1;

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
SELECT name,  cost
FROM projects
ORDER BY cost
LIMIT 1;

# 6
SELECT avg(developers.salary) AS avgSalary
FROM projects
  INNER JOIN developers_projects
    ON projects.project_id = developers_projects.project_id
  INNER JOIN developers
    ON developers_projects.developer_id = developers.developer_id
WHERE projects.cost = ( SELECT min(cost)FROM projects);