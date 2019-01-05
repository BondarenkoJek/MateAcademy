package ua.bondarenkojek.homework.jdbc.service.impl;

import ua.bondarenkojek.homework.jdbc.dao.CompanyDao;
import ua.bondarenkojek.homework.jdbc.model.Company;
import ua.bondarenkojek.homework.jdbc.service.CompanyService;

public class CompanyServiceImpl implements CompanyService {
    private CompanyDao companyDao;

    public CompanyServiceImpl(CompanyDao companyDao) {
        this.companyDao = companyDao;
    }

    @Override
    public void addCompany(Company company) {
        companyDao.addCompany(company);
    }

    @Override
    public Company getCompany(long id) {
        return companyDao.getCompany(id);
    }

    @Override
    public void updateCompany(Company company) {
        companyDao.updateCompany(company);
    }

    @Override
    public void deleteCompany(long id) {
        companyDao.deleteCompany(id);
    }
}
