package com.facebook.react.views.picker;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;

@ReactModule(name="AndroidDropdownPicker")
public class ReactDropdownPickerManager extends ReactPickerManager
{
  public static final String REACT_CLASS = "AndroidDropdownPicker";

  protected ReactPicker createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactPicker(paramThemedReactContext, 1);
  }

  public String getName()
  {
    return "AndroidDropdownPicker";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.picker.ReactDropdownPickerManager
 * JD-Core Version:    0.6.2
 */