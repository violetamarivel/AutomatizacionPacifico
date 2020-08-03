package com.pacifico.framework.controls.internals;

import com.pacifico.framework.controls.api.ImplementedBy;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.internal.WrapsElement;

@ImplementedBy(ControlBase.class)
public interface Control extends WebElement, WrapsElement, Locatable {
}

