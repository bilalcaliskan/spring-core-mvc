package com.bcaliskan.springmvc.services.mapservices;

import com.bcaliskan.springmvc.domain.Customer;
import com.bcaliskan.springmvc.domain.DomainObject;
import com.bcaliskan.springmvc.services.CustomerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Profile("map")
public class CustomerServiceImpl extends AbstractMapService implements CustomerService {

    @Override
    public List<DomainObject> listAll() {
        return super.listAll();
    }

    @Override
    public Customer getById(Integer id) {
        return (Customer) super.getById(id);
    }

    @Override
    public Customer saveOrUpdate(Customer domainObject) {
        return (Customer) super.saveOrUpdate(domainObject);
    }

    @Override
    public void delete(Integer id) {
        super.delete(id);
    }

}