package com.laboratory.workbench.view.datagrid;

/**
 * @author shixin
 *
 */
public interface IActionCommandHandler {

    public void performAction(ActionCommand command, Object... parameters);

}
