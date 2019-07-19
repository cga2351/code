package com.facebook.imagepipeline.common;

import javax.annotation.Nullable;

public enum Priority
{
  static
  {
    HIGH = new Priority("HIGH", 2);
    Priority[] arrayOfPriority = new Priority[3];
    arrayOfPriority[0] = LOW;
    arrayOfPriority[1] = MEDIUM;
    arrayOfPriority[2] = HIGH;
  }

  public static Priority getHigherPriority(@Nullable Priority paramPriority1, @Nullable Priority paramPriority2)
  {
    if (paramPriority1 == null);
    do
    {
      return paramPriority2;
      if (paramPriority2 == null)
        return paramPriority1;
    }
    while (paramPriority1.ordinal() <= paramPriority2.ordinal());
    return paramPriority1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.imagepipeline.common.Priority
 * JD-Core Version:    0.6.2
 */