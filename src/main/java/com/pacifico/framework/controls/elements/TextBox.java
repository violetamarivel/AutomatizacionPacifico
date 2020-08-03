package com.pacifico.framework.controls.elements;

import com.pacifico.framework.controls.api.ImplementedBy;
import com.pacifico.framework.controls.internals.Control;


@ImplementedBy(TextBoxBase.class)
public interface TextBox extends Control {

    void EnterText(String text);

    String GetTextValue();

}
