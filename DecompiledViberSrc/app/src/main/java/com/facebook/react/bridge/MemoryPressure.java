package com.facebook.react.bridge;

public enum MemoryPressure
{
  static
  {
    MODERATE = new MemoryPressure("MODERATE", 1);
    CRITICAL = new MemoryPressure("CRITICAL", 2);
    MemoryPressure[] arrayOfMemoryPressure = new MemoryPressure[3];
    arrayOfMemoryPressure[0] = UI_HIDDEN;
    arrayOfMemoryPressure[1] = MODERATE;
    arrayOfMemoryPressure[2] = CRITICAL;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.MemoryPressure
 * JD-Core Version:    0.6.2
 */