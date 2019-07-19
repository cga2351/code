package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import javax.annotation.Nonnull;

@DoNotStrip
public abstract interface NativeModule
{
  public abstract boolean canOverrideExistingModule();

  @Nonnull
  public abstract String getName();

  public abstract void initialize();

  public abstract void onCatalystInstanceDestroy();

  public static abstract interface NativeMethod
  {
    public abstract String getType();

    public abstract void invoke(JSInstance paramJSInstance, ReadableArray paramReadableArray);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.NativeModule
 * JD-Core Version:    0.6.2
 */