package com.demo.gyw.api;

import com.google.common.collect.Lists;
import com.demo.gyw.entity.Terminal;
import com.demo.gyw.entity.TerminalPrincipal;
import com.demo.gyw.transfer.TerminalCommandTransfer;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Intern {
    public static void main(String[] args) {
        List<Terminal> terminalList = new ArrayList<>();
        List<Terminal> list = terminalList.stream().map(Function.identity()).collect(Collectors.toList());

        List<Long> terminalIds = new ArrayList<>();
        for (int i = 0; i < 50000; i++) {
            Terminal entity = new Terminal();
            entity.setId(Long.valueOf(i));
            terminalIds.add(Long.valueOf(i));
        }
        Long a = System.currentTimeMillis();
        Map<String, String> keyToValueVolume = terminalIds.stream().collect(Collectors.toMap(item -> item.toString(), item -> "value"+item));
        List<TerminalPrincipal> principals = Optional.ofNullable(terminalList).orElse(Lists.newArrayList())
                .stream()
                .map(TerminalCommandTransfer::terminalPoToPrincipal).collect(Collectors.toList());
        Long b = System.currentTimeMillis();
        System.out.println(b-a);


        Long c = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
        }
        Long d = System.currentTimeMillis();
        System.out.println(d-c);
    }

    List<Long> list = new ArrayList<>();

    public static void foreach() {
        Long c = System.currentTimeMillis();

        Long d = System.currentTimeMillis();
        System.out.println(d-c);
    }
}
