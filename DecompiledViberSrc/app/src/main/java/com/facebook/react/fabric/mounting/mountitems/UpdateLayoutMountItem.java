package com.facebook.react.fabric.mounting.mountitems;

import com.facebook.react.fabric.mounting.MountingManager;

public class UpdateLayoutMountItem
  implements MountItem
{
  private final int mHeight;
  private final int mReactTag;
  private final int mWidth;
  private final int mX;
  private final int mY;

  public UpdateLayoutMountItem(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mReactTag = paramInt1;
    this.mX = paramInt2;
    this.mY = paramInt3;
    this.mWidth = paramInt4;
    this.mHeight = paramInt5;
  }

  public void execute(MountingManager paramMountingManager)
  {
    paramMountingManager.updateLayout(this.mReactTag, this.mX, this.mY, this.mWidth, this.mHeight);
  }

  public int getHeight()
  {
    return this.mHeight;
  }

  public int getWidth()
  {
    return this.mWidth;
  }

  public int getX()
  {
    return this.mX;
  }

  public int getY()
  {
    return this.mY;
  }

  public String toString()
  {
    return "UpdateLayoutMountItem [" + this.mReactTag + "] - x: " + this.mX + " - y: " + this.mY + " - height: " + this.mHeight + " - width: " + this.mWidth;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.fabric.mounting.mountitems.UpdateLayoutMountItem
 * JD-Core Version:    0.6.2
 */