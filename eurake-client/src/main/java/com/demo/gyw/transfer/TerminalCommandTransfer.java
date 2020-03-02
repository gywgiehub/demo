package com.demo.gyw.transfer;

import com.demo.gyw.entity.Terminal;
import com.demo.gyw.entity.TerminalPrincipal;
import org.springframework.beans.BeanUtils;

/**
 * @author xinming
 */
public class TerminalCommandTransfer {

    public static TerminalPrincipal terminalPoToPrincipal(Terminal po) {
        TerminalPrincipal terminalPrincipal = new TerminalPrincipal();
        BeanUtils.copyProperties(po, terminalPrincipal);
        terminalPrincipal.setTerminalId(po.getId());
        terminalPrincipal.setTerminalName(po.getName());
        return terminalPrincipal;
    }
}
