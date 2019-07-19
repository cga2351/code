package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.fabric.mounting.MountingManager;

public class DispatchCommandMountItem
  implements MountItem
{
  private final ReadableArray mCommandArgs;
  private final int mCommandId;
  private final int mReactTag;

  public DispatchCommandMountItem(int paramInt1, int paramInt2, ReadableArray paramReadableArray)
  {
    this.mReactTag = paramInt1;
    this.mCommandId = paramInt2;
    this.mCommandArgs = paramReadableArray;
  }

  public void execute(MountingManager paramMountingManager)
  {
    UiThreadUtil.assertOnUiThread();
    paramMountingManager.receiveCommand(this.mReactTag, this.mCommandId, this.mCommandArgs);
  }

  public String toString()
  {
    return "DispatchCommandMountItem [" + this.mReactTag + "] " + this.mCommandId;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.fabric.mounting.mountitems.DispatchCommandMountItem
 * JD-Core Version:    0.6.2
 */