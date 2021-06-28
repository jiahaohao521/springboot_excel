package com.jiahao.alltest.controlller;

import com.jiahao.alltest.common.ExceptionEnum;
import com.jiahao.alltest.entity.CompanyInfo;
import com.jiahao.alltest.entity.Result;
import com.jiahao.alltest.entity.User;
import com.jiahao.alltest.exception.CustomNullPointException;
import com.jiahao.alltest.util.ExcelUtils2;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @author jiahao
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {

    private static final Logger log = LoggerFactory.getLogger(ExcelController.class);

    /**
     * 测试自定义异常
     * @return
     */
    @GetMapping("get")
    public Result<User> getExcel() {
        log.info("环境搭建成功！！！");
        Result<User> result = new Result();
        User user = new User();
        user.age = 20;
        user.addr = "中国";
        user.name = "团团";

        result.setData(user);

        throw new CustomNullPointException(400, "错误");
    }

    /**
     * 测试其他异常
     * @return
     */
    @GetMapping("get2")
    public Result<User> getExcel2() {
        log.info("环境搭建成功！！！");
        Result<User> result = new Result();
        User user = new User();
        user.age = 20;
        user.addr = "中国";
        user.name = "圆圆";

        result.setData(user);

        throw new RuntimeException("失败");
    }

    /**
     * 返回成功
     * @return
     */
    @GetMapping("success")
    public Result<User> getSuccess() {
        Result<User> result = new Result();
        User user = new User();
        user.age = 20;
        user.addr = "中国";
        user.name = "圆圆2";

        result.setData(user);
        return result;
    }



    /**
     * 导出操作
     *
     * @return
     */
    @RequestMapping(value = "/exportExcel", method = RequestMethod.POST)
    public void importExcel(@RequestBody List<CompanyInfo> companyInfoList) {
        ExcelUtils2.writeExcel(companyInfoList, CompanyInfo.class, "导出文件名称.xlsx");
    }
}
