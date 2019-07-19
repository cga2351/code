package com.facebook.react.common;

public enum LifecycleState
{
  static
  {
    LifecycleState[] arrayOfLifecycleState = new LifecycleState[3];
    arrayOfLifecycleState[0] = BEFORE_CREATE;
    arrayOfLifecycleState[1] = BEFORE_RESUME;
    arrayOfLifecycleState[2] = RESUMED;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.common.LifecycleState
 * JD-Core Version:    0.6.2
 */