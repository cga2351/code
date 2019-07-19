package com.facebook.react.uimanager;

import java.util.Comparator;

public class ViewAtIndex
{
  public static Comparator<ViewAtIndex> COMPARATOR = new Comparator()
  {
    public int compare(ViewAtIndex paramAnonymousViewAtIndex1, ViewAtIndex paramAnonymousViewAtIndex2)
    {
      return paramAnonymousViewAtIndex1.mIndex - paramAnonymousViewAtIndex2.mIndex;
    }
  };
  public final int mIndex;
  public final int mTag;

  public ViewAtIndex(int paramInt1, int paramInt2)
  {
    this.mTag = paramInt1;
    this.mIndex = paramInt2;
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (paramObject.getClass() != getClass()));
    ViewAtIndex localViewAtIndex;
    do
    {
      return false;
      localViewAtIndex = (ViewAtIndex)paramObject;
    }
    while ((this.mIndex != localViewAtIndex.mIndex) || (this.mTag != localViewAtIndex.mTag));
    return true;
  }

  public String toString()
  {
    return "[" + this.mTag + ", " + this.mIndex + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.ViewAtIndex
 * JD-Core Version:    0.6.2
 */