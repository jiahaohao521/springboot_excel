package com.jiahao.alltest.controlller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jiahao
 */
@RestController
@RequestMapping("/excel")
public class ExcelController {

    private static final Logger log = LoggerFactory.getLogger(ExcelController.class);

    @GetMapping("get")
    public String getExcel() {
        log.info("环境搭建成功！！！");
        return "success";
    }
}
