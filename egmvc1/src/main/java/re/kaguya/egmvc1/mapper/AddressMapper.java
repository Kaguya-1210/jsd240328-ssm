package re.kaguya.egmvc1.mapper;

import re.kaguya.egmvc1.pojo.entity.Address;
import re.kaguya.egmvc1.utils.Result;

import java.util.List;

public interface AddressMapper {
    void addAddress(Address address);

    List<Address> selectAllEmp();

    void deleteAddress(Integer id);

    void updateAddress(Address address);
}
