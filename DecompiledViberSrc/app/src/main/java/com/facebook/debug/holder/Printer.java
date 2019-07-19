package com.facebook.debug.holder;

import com.facebook.debug.debugoverlay.model.DebugOverlayTag;

public abstract interface Printer
{
  public abstract void logMessage(DebugOverlayTag paramDebugOverlayTag, String paramString);

  public abstract void logMessage(DebugOverlayTag paramDebugOverlayTag, String paramString, Object[] paramArrayOfObject);

  public abstract boolean shouldDisplayLogMessage(DebugOverlayTag paramDebugOverlayTag);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.debug.holder.Printer
 * JD-Core Version:    0.6.2
 */