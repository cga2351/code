package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.fabric.mounting.MountingManager;

public class UpdatePropsMountItem
  implements MountItem
{
  private final int mReactTag;
  private final ReadableMap mUpdatedProps;

  public UpdatePropsMountItem(int paramInt, ReadableMap paramReadableMap)
  {
    this.mReactTag = paramInt;
    this.mUpdatedProps = paramReadableMap;
  }

  public void execute(MountingManager paramMountingManager)
  {
    paramMountingManager.updateProps(this.mReactTag, this.mUpdatedProps);
  }

  public String toString()
  {
    return "UpdatePropsMountItem [" + this.mReactTag + "] - props: " + this.mUpdatedProps;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.fabric.mounting.mountitems.UpdatePropsMountItem
 * JD-Core Version:    0.6.2
 */