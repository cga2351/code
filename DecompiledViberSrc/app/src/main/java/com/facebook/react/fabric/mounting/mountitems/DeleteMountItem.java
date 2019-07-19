package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.fabric.mounting.MountingManager;

public class DeleteMountItem
  implements MountItem
{
  private int mReactTag;

  public DeleteMountItem(int paramInt)
  {
    this.mReactTag = paramInt;
  }

  public void execute(MountingManager paramMountingManager)
  {
    paramMountingManager.deleteView(this.mReactTag);
  }

  public String toString()
  {
    return "DeleteMountItem [" + this.mReactTag + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.fabric.mounting.mountitems.DeleteMountItem
 * JD-Core Version:    0.6.2
 */