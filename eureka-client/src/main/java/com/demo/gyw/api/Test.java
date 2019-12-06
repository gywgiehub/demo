package com.demo.gyw.api;


import com.demo.gyw.vo.UaaOrganizationStructureReqVo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.demo.gyw.vo.UaaOrganizationStructurePropertyReqVo;
import org.apache.commons.lang.StringUtils;

import java.io.IOException;
import java.util.*;

public class Test {
    public static void main(String[] args) {

        /*UaaOrganizationStructurePropertyReqVo vo = new UaaOrganizationStructurePropertyReqVo();
        vo.setId(640366487936225280L);
        vo.setIsAllSelect(true);
        List<UaaOrganizationStructurePropertyReqVo> programs = new ArrayList<>();
        programs.add(vo);

        UaaOrganizationStructurePropertyReqVo vo2 = new UaaOrganizationStructurePropertyReqVo();
        vo2.setId(123L);
        vo2.setIsAllSelect(true);
        List<UaaOrganizationStructurePropertyReqVo> terminals = new ArrayList<>();
        terminals.add(vo2);

        UaaOrganizationStructureReqVo reqVo = new UaaOrganizationStructureReqVo();
        reqVo.setPrograms(programs);
        reqVo.setTerminals(terminals);
        System.out.println(reqVo.toString());*/



       String authority = "{\"programs\": \"[{\\\"id\\\": 640366487936225280, \\\"isAllSelect\\\": true}]\",\"terminals\":\"[{\\\"id\\\": 123, \\\"isAllSelect\\\": true}]\"}";

        System.out.println("需要解析的數據："+authority);
        try {
            if (StringUtils.isNotBlank(authority)) {
                UaaOrganizationStructureReqVo uaaOrganizationStructure = new ObjectMapper().readValue(authority,
                        new TypeReference<UaaOrganizationStructureReqVo>() {
                        });
                System.out.println(uaaOrganizationStructure.toString());

                String set2 = "[{\"id\":640366487936225280,\"isAllSelect\":true}]";
                String set = uaaOrganizationStructure.getPrograms();
                System.out.println(set2);
                System.out.println(set);
                //解析
                Set<UaaOrganizationStructurePropertyReqVo> attributes = new ObjectMapper().readValue(
                        set,
                        new TypeReference<Set<UaaOrganizationStructurePropertyReqVo>>() {}
                );
                System.out.println(Arrays.toString(attributes.toArray()));
                //筛选
                //List<UaaOrganizationStructureReqVo.UaaOrganizationStructurePropertyReqVo> terminals = uaaOrganizationStructure.getTerminals();
                //List<Long> terminalIds = terminals.stream().map(item -> item.getId()).collect(Collectors.toList());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

       /* Set<String> set = new HashSet<>();
        set.*/
    }
}
