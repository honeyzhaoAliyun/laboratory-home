package com.laboratory.workbench.widgets;

import com.vaadin.ui.Button;

/**
 * @author shixin
 *
 */
public class FormButton extends Button {

    private static final long serialVersionUID = -406899680853565593L;

    public FormButton() {
        super();
        setup();
    }

    public FormButton(String caption, ClickListener listener) {
        super(caption, listener);
        setup();
    }

    public FormButton(String caption) {
        super(caption);
        setup();
    }

    private void setup(){
        this.setStyleName("m-button-formbutton");
    }

}