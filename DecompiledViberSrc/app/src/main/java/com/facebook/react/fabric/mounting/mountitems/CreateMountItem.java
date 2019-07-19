package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.uimanager.ThemedReactContext;

public class CreateMountItem
  implements MountItem
{
  private final String mComponentName;
  private final boolean mIsVirtual;
  private final int mReactTag;
  private final ThemedReactContext mThemedReactContext;

  public CreateMountItem(ThemedReactContext paramThemedReactContext, String paramString, int paramInt, boolean paramBoolean)
  {
    this.mReactTag = paramInt;
    this.mThemedReactContext = paramThemedReactContext;
    this.mComponentName = paramString;
    this.mIsVirtual = paramBoolean;
  }

  public void execute(MountingManager paramMountingManager)
  {
    paramMountingManager.createView(this.mThemedReactContext, this.mComponentName, this.mReactTag, this.mIsVirtual);
  }

  public String getComponentName()
  {
    return this.mComponentName;
  }

  public ThemedReactContext getThemedReactContext()
  {
    return this.mThemedReactContext;
  }

  public String toString()
  {
    return "CreateMountItem [" + this.mReactTag + "] " + this.mComponentName;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.fabric.mounting.mountitems.CreateMountItem
 * JD-Core Version:    0.6.2
 */