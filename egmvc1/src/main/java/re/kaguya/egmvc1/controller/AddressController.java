package re.kaguya.egmvc1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import re.kaguya.egmvc1.mapper.AddressMapper;
import re.kaguya.egmvc1.pojo.entity.Address;
import re.kaguya.egmvc1.utils.Result;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    /*
1）添加收货地址
请求地址：/address/insert
请求方法：POST
请求体数据：receiver=收件人、address=收件地址、email=邮箱、mobile=手机号、tag=标签
返回响应：String "添加成功"
     */
    @Autowired
    private AddressMapper addrMapper;

    @PostMapping("/insert")
    public Result addAddress(String receiver, String address, String email, String mobile, String tag) {
        Address address1 = new Address();
        address1.setReceiver(receiver);
        address1.setAddress(address);
        address1.setEmail(email);
        address1.setMobile(mobile);
        address1.setTag(tag);
        addrMapper.addAddress(address1);
        return new Result().success(address1);
    }

    /*
   请求地址：/address/select

请求方法：GET

查询参数：无

返回响应：List<Address> 查询所有字段，放到实体类即可，无须创建VO类了
     */
    @GetMapping("/select")
    public Result<List<Address>> selectAllEmp() {
        return new Result<List<Address>>().success(addrMapper.selectAllEmp());
    }

    /*
    3）删除收货地址
请求地址：/address/delete

请求方法：POST

请求体数据：id=地址id

返回响应：String "删除成功"

     */
    @PostMapping("/delete")
    public Result<String> deleteAddress(Integer id) {
        addrMapper.deleteAddress(id);
        return Result.success("删除成功");
    }

    /*
    4）修改收货地址
请求地址：/address/update
请求方法：POST
请求体数据：id=xx&receiver=xx&address=xx&email=xxx&mobile=xx&tag=xx
返回响应：String "修改成功"
     */
    @PostMapping("update")
    public Result<Address> updateAddress(Address address) {
        addrMapper.updateAddress(address);
        return Result.success(address);
    }
}
