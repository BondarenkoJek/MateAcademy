package ua.bondarenkojek.homework.jdbc;

import ua.bondarenkojek.homework.jdbc.dao.impl.CompanyDaoImpl;
import ua.bondarenkojek.homework.jdbc.dao.impl.CustomerDaoImpl;
import ua.bondarenkojek.homework.jdbc.dao.impl.DeveloperDaoImpl;
import ua.bondarenkojek.homework.jdbc.dao.impl.ProjectDaoImpl;
import ua.bondarenkojek.homework.jdbc.model.Company;
import ua.bondarenkojek.homework.jdbc.model.Customer;
import ua.bondarenkojek.homework.jdbc.model.Developer;
import ua.bondarenkojek.homework.jdbc.model.Project;
import ua.bondarenkojek.homework.jdbc.model.Skill;
import ua.bondarenkojek.homework.jdbc.service.CompanyService;
import ua.bondarenkojek.homework.jdbc.service.CustomerService;
import ua.bondarenkojek.homework.jdbc.service.DeveloperService;
import ua.bondarenkojek.homework.jdbc.service.ProjectService;
import ua.bondarenkojek.homework.jdbc.service.impl.CompanyServiceImpl;
import ua.bondarenkojek.homework.jdbc.service.impl.CustomerServiceImpl;
import ua.bondarenkojek.homework.jdbc.service.impl.DeveloperServiceImpl;
import ua.bondarenkojek.homework.jdbc.service.impl.ProjectServiceImpl;
import ua.bondarenkojek.homework.jdbc.util.ConnectionUtil;

import java.sql.Connection;
import java.time.LocalDate;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Connection connection = ConnectionUtil.getConnection();
        CustomerService customerService = new CustomerServiceImpl(new CustomerDaoImpl(connection));
        CompanyService companyService = new CompanyServiceImpl(new CompanyDaoImpl(connection));
        ProjectService projectService = new ProjectServiceImpl(new ProjectDaoImpl(connection));
        DeveloperService developerService = new DeveloperServiceImpl(new DeveloperDaoImpl(connection));

        System.out.println(developerService.getDeveloperById(8));

//        Customer customer = Customer
//                .builder()
//                .id(2)
//                .name("FirstCustomer")
//                .projects(new HashSet<>())
//                .build();
//        customerService.addCustomer(customer);

//        Company company = Company
//                .builder()
//                .id(2)
//                .name("FirstCompany")
//                .projects(new HashSet<>())
//                .build();
//        companyService.addCompany(company);

//        Project project = Project
//                .builder()
//                .name("FirstProject")
//                .createDate(LocalDate.now())
//                .cost(19999.00)
//                .developers(new HashSet<>())
//                .build();
//        customer.addProject(project);
//        company.addProject(project);
//        projectService.addProject(project);

//        Skill skill = Skill
//                .builder()
//                .typeOfSkill(Skill.TypeOfSkill.JAVA)
//                .skillLevel(Skill.SkillLevel.MIDDLE)
//                .build();

//        Developer developer = Developer
//                .builder()
//                .name("FirstDeveloper")
//                .age(25)
//                .salary(1000)
//                .skills(new HashSet<>())
//                .projects(new HashSet<>())
//                .build();
//        developer.addSkill(skill);
//        developerService.addDeveloper(developer);
//        project = projectService.getProjectById(3);
//        developer = developerService.getDeveloperById(10);
//        projectService.addDeveloperForProject(project, developer);

//        Project project = projectService.getProjectById(3);
//        System.out.println(projectService.getAllSalaryByProject(project));
//        developerService.findAllDevelopersByProject(project).forEach(System.out::println);
//        developerService.findAllByTypeOfSkill("Java").forEach(System.out::println);
//        developerService.findAllByLevelOfSkill("middle").forEach(System.out::println);
//        projectService.findAll().forEach(p ->
//                System.out.println("date: " + p.getCreateDate()
//                        + " name: " + p.getName()
//                        + " developers amount: " + p.getDevelopers().size()));
    }
}
