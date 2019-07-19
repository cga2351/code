package com.facebook.react.uimanager;

public class ReactRootViewTagGenerator
{
  private static final int ROOT_VIEW_TAG_INCREMENT = 10;
  private static int sNextRootViewTag = 1;

  public static int getNextRootViewTag()
  {
    try
    {
      int i = sNextRootViewTag;
      sNextRootViewTag = 10 + sNextRootViewTag;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ReactRootViewTagGenerator
 * JD-Core Version:    0.6.2
 */