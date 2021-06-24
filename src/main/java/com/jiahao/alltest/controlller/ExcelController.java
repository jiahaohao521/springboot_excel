package com.jiahao.alltest.controlller;

import com.jiahao.alltest.entity.CompanyInfo;
import com.jiahao.alltest.entity.Result;
import com.jiahao.alltest.entity.User;
import com.jiahao.alltest.util.ExcelUtils;
import com.jiahao.alltest.util.ExcelUtils2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author jiahao
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {

    private static final Logger log = LoggerFactory.getLogger(ExcelController.class);

    @GetMapping("get")
    public Result<User> getExcel() {
        log.info("环境搭建成功！！！");
        Result<User> result = new Result();
        User user = new User();
        user.age = 20;
        user.addr = "中国";
        user.name = "贾浩浩";

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
