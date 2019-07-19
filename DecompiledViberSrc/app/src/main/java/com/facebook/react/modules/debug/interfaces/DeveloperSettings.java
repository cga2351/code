package com.facebook.react.modules.debug.interfaces;

public abstract interface DeveloperSettings
{
  public abstract boolean isAnimationFpsDebugEnabled();

  public abstract boolean isElementInspectorEnabled();

  public abstract boolean isFpsDebugEnabled();

  public abstract boolean isJSDevModeEnabled();

  public abstract boolean isJSMinifyEnabled();

  public abstract boolean isNuclideJSDebugEnabled();

  public abstract boolean isRemoteJSDebugEnabled();

  public abstract void setRemoteJSDebugEnabled(boolean paramBoolean);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.debug.interfaces.DeveloperSettings
 * JD-Core Version:    0.6.2
 */