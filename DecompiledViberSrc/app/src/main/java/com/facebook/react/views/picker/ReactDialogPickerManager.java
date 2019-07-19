package com.facebook.react.views.picker;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;

@ReactModule(name="AndroidDialogPicker")
public class ReactDialogPickerManager extends ReactPickerManager
{
  public static final String REACT_CLASS = "AndroidDialogPicker";

  protected ReactPicker createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactPicker(paramThemedReactContext, 0);
  }

  public String getName()
  {
    return "AndroidDialogPicker";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.picker.ReactDialogPickerManager
 * JD-Core Version:    0.6.2
 */