package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.fabric.mounting.MountingManager;

public class InsertMountItem
  implements MountItem
{
  private int mIndex;
  private int mParentReactTag;
  private int mReactTag;

  public InsertMountItem(int paramInt1, int paramInt2, int paramInt3)
  {
    this.mReactTag = paramInt1;
    this.mParentReactTag = paramInt2;
    this.mIndex = paramInt3;
  }

  public void execute(MountingManager paramMountingManager)
  {
    paramMountingManager.addViewAt(this.mParentReactTag, this.mReactTag, this.mIndex);
  }

  public int getIndex()
  {
    return this.mIndex;
  }

  public int getParentReactTag()
  {
    return this.mParentReactTag;
  }

  public String toString()
  {
    return "InsertMountItem [" + this.mReactTag + "] - parentTag: " + this.mParentReactTag + " - index: " + this.mIndex;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.fabric.mounting.mountitems.InsertMountItem
 * JD-Core Version:    0.6.2
 */