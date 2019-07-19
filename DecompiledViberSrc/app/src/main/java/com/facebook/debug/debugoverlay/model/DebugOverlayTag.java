package com.facebook.debug.debugoverlay.model;

import javax.annotation.concurrent.Immutable;

@Immutable
public class DebugOverlayTag
{
  public final int color;
  public final String description;
  public final String name;

  public DebugOverlayTag(String paramString1, String paramString2, int paramInt)
  {
    this.name = paramString1;
    this.description = paramString2;
    this.color = paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.debug.debugoverlay.model.DebugOverlayTag
 * JD-Core Version:    0.6.2
 */