package ua.bondarenkojek.homework.jdbc.dao;

import ua.bondarenkojek.homework.jdbc.model.Company;

public interface CompanyDao {
    void addCompany(Company company);
    Company getCompany(long id);
    void updateCompany(Company company);
    void deleteCompany(long id);
}
