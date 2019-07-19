package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.systrace.Systrace;

@DoNotStrip
public class BatchMountItem
  implements MountItem
{
  private final MountItem[] mMountItems;
  private final int mSize;

  public BatchMountItem(MountItem[] paramArrayOfMountItem, int paramInt)
  {
    if (paramArrayOfMountItem == null)
      throw new NullPointerException();
    if ((paramInt < 0) || (paramInt > paramArrayOfMountItem.length))
      throw new IllegalArgumentException("Invalid size received by parameter size: " + paramInt + " items.size = " + paramArrayOfMountItem.length);
    this.mMountItems = paramArrayOfMountItem;
    this.mSize = paramInt;
  }

  public void execute(MountingManager paramMountingManager)
  {
    Systrace.beginSection(0L, "FabricUIManager::mountViews (" + this.mSize + " items)");
    for (int i = 0; i < this.mSize; i++)
      this.mMountItems[i].execute(paramMountingManager);
    Systrace.endSection(0L);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.fabric.mounting.mountitems.BatchMountItem
 * JD-Core Version:    0.6.2
 */