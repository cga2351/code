package com.facebook.react.bridge;

import android.content.Context;

public abstract class ContextBaseJavaModule extends BaseJavaModule
{
  private final Context mContext;

  public ContextBaseJavaModule(Context paramContext)
  {
    this.mContext = paramContext;
  }

  protected final Context getContext()
  {
    return this.mContext;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ContextBaseJavaModule
 * JD-Core Version:    0.6.2
 */