package ua.bondarenkojek.homework.jdbc;

import ua.bondarenkojek.homework.jdbc.dao.CompanyDao;
import ua.bondarenkojek.homework.jdbc.dao.CompanyDaoImpl;
import ua.bondarenkojek.homework.jdbc.dao.CustomerDao;
import ua.bondarenkojek.homework.jdbc.dao.CustomerDaoImpl;
import ua.bondarenkojek.homework.jdbc.dao.DeveloperDaoImpl;
import ua.bondarenkojek.homework.jdbc.dao.ProjectDao;
import ua.bondarenkojek.homework.jdbc.dao.ProjectDaoImpl;
import ua.bondarenkojek.homework.jdbc.model.Company;
import ua.bondarenkojek.homework.jdbc.model.Customer;
import ua.bondarenkojek.homework.jdbc.model.Developer;
import ua.bondarenkojek.homework.jdbc.model.Project;
import ua.bondarenkojek.homework.jdbc.model.Skill;
import ua.bondarenkojek.homework.jdbc.service.DeveloperService;
import ua.bondarenkojek.homework.jdbc.service.DeveloperServiceImpl;
import ua.bondarenkojek.homework.jdbc.util.ConnectionUtil;

import java.time.LocalDate;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        DeveloperService service = new DeveloperServiceImpl(
                new DeveloperDaoImpl(ConnectionUtil.getConnection()));

//        System.out.println(service.getDeveloperById(7));

//        Developer developer = Developer.builder()
////                .id(5)
//                .name("Roma")
//                .age(25)
//                .salary(1000.0)
//                .skills(new HashSet<>())
//                .projects(new HashSet<>())
//                .build();


//        Skill skill1 = Skill
//                .builder()
////                .id(1)
//                .typeOfSkill(Skill.TypeOfSkill.JAVA)
//                .skillLevel(Skill.SkillLevel.MIDDLE)
//                .build();
//
//        Skill skill2 = Skill
//                .builder()
//                .id(4)
//                .typeOfSkill(Skill.TypeOfSkill.JS)
//                .skillLevel(Skill.SkillLevel.MIDDLE)
//                .build();
//
//        Project project = Project
//                .builder()
//                .name("Project")
//                .createDate(LocalDate.now())
//                .customer(Customer.builder().id(1).build())
//                .company(Company.builder().id(1).build())
//                .build();
//
//        developer.addSkill(skill1);
//        developer.addSkill(skill2);
//        developer.addProject(project);
//
//        service.addDeveloper(developer);

//        service.updateDeveloper(developer);

//        service.removeDeveloperById(7);

//        ProjectDao projectDao = new ProjectDaoImpl(ConnectionUtil.getConnection());
//        Project project = Project.builder()
//                .name("Project")
//                .createDate(new Date())
//                .developers(new HashSet<>())
//                .cost(20000.0)
//                .build();
//
//        CustomerDao customerDao = new CustomerDaoImpl(ConnectionUtil.getConnection());
//        Customer customer = Customer.builder().name("Customer").build();
//        customerDao.addCustomer(customer);
//        customer = customerDao.getCustomer(12);
//        customer.addProject(project);
//
//        CompanyDao companyDao = new CompanyDaoImpl(ConnectionUtil.getConnection());
//        Company company = Company.builder().name("Company").build();
//        companyDao.addCompany(company);
//        company = companyDao.getCompany(8);
//        company.addProject(project);
//
//        projectDao.addProject(project);

//        System.out.println(projectDao.getProjectById(5));

        service.findAllByLevelOfSkill("MIDDLE").forEach(System.out::println);
    }
}
