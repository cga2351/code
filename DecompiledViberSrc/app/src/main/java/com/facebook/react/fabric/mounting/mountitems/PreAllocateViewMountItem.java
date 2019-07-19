package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.uimanager.ThemedReactContext;

public class PreAllocateViewMountItem
  implements MountItem
{
  private final String mComponent;
  private final ThemedReactContext mContext;
  private final int mRootTag;

  public PreAllocateViewMountItem(ThemedReactContext paramThemedReactContext, int paramInt, String paramString)
  {
    this.mContext = paramThemedReactContext;
    this.mComponent = paramString;
    this.mRootTag = paramInt;
  }

  public void execute(MountingManager paramMountingManager)
  {
    paramMountingManager.preallocateView(this.mContext, this.mComponent);
  }

  public String toString()
  {
    return "[" + this.mRootTag + "] - Preallocate " + this.mComponent;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.fabric.mounting.mountitems.PreAllocateViewMountItem
 * JD-Core Version:    0.6.2
 */