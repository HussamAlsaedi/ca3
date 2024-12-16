package com.example.marketing.Repostiroy;

import com.example.marketing.Model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query("select c from Company c where c.company_id=:company_id")
  Company  findCompanyByCompany_id(@Param("company_id") Integer company_id);

}
