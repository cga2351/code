package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.fabric.jsi.EventEmitterWrapper;
import com.facebook.react.fabric.mounting.MountingManager;

public class UpdateEventEmitterMountItem
  implements MountItem
{
  private final EventEmitterWrapper mEventHandler;
  private final int mReactTag;

  public UpdateEventEmitterMountItem(int paramInt, EventEmitterWrapper paramEventEmitterWrapper)
  {
    this.mReactTag = paramInt;
    this.mEventHandler = paramEventEmitterWrapper;
  }

  public void execute(MountingManager paramMountingManager)
  {
    paramMountingManager.updateEventEmitter(this.mReactTag, this.mEventHandler);
  }

  public String toString()
  {
    return "UpdateEventEmitterMountItem [" + this.mReactTag + "]";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.fabric.mounting.mountitems.UpdateEventEmitterMountItem
 * JD-Core Version:    0.6.2
 */