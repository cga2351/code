package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeMap;
import com.facebook.react.fabric.mounting.MountingManager;

public class UpdateLocalDataMountItem
  implements MountItem
{
  private final ReadableMap mNewLocalData;
  private final int mReactTag;

  public UpdateLocalDataMountItem(int paramInt, ReadableNativeMap paramReadableNativeMap)
  {
    this.mReactTag = paramInt;
    this.mNewLocalData = paramReadableNativeMap;
  }

  public void execute(MountingManager paramMountingManager)
  {
    paramMountingManager.updateLocalData(this.mReactTag, this.mNewLocalData);
  }

  public ReadableMap getNewLocalData()
  {
    return this.mNewLocalData;
  }

  public String toString()
  {
    return "UpdateLocalDataMountItem [" + this.mReactTag + "] - localData: " + this.mNewLocalData;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.fabric.mounting.mountitems.UpdateLocalDataMountItem
 * JD-Core Version:    0.6.2
 */