package com.facebook.react.modules.timepicker;

public enum TimePickerMode
{
  static
  {
    DEFAULT = new TimePickerMode("DEFAULT", 2);
    TimePickerMode[] arrayOfTimePickerMode = new TimePickerMode[3];
    arrayOfTimePickerMode[0] = CLOCK;
    arrayOfTimePickerMode[1] = SPINNER;
    arrayOfTimePickerMode[2] = DEFAULT;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.timepicker.TimePickerMode
 * JD-Core Version:    0.6.2
 */