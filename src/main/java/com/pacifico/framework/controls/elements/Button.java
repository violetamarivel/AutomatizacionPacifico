package com.pacifico.framework.controls.elements;

import com.pacifico.framework.controls.api.ImplementedBy;
import com.pacifico.framework.controls.internals.Control;


@ImplementedBy(ButtonBase.class)
public interface Button extends Control {

    void PerformClick();

    String GetButtonText();

    void PerformSubmit();
}
