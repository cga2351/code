package com.facebook.react.bridge;

import android.app.Activity;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public abstract class ReactContextBaseJavaModule extends BaseJavaModule
{
  private final ReactApplicationContext mReactApplicationContext;

  public ReactContextBaseJavaModule(@Nonnull ReactApplicationContext paramReactApplicationContext)
  {
    this.mReactApplicationContext = paramReactApplicationContext;
  }

  @Nullable
  protected final Activity getCurrentActivity()
  {
    return this.mReactApplicationContext.getCurrentActivity();
  }

  protected final ReactApplicationContext getReactApplicationContext()
  {
    return this.mReactApplicationContext;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ReactContextBaseJavaModule
 * JD-Core Version:    0.6.2
 */