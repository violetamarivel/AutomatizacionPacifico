package com.pacifico.framework.controls.elements;

import com.pacifico.framework.controls.api.ImplementedBy;
import com.pacifico.framework.controls.internals.Control;


@ImplementedBy(HyperLinkBase.class)
public interface HyperLink extends Control {


    void ClickLink();

    String GetUrlText();

    boolean CheckUrlTextContains(String containsText);
}

