package com.google.android.gms.internal.base;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;

final class zai extends Drawable.ConstantState
{
  int mChangingConfigurations;
  int zanv;

  zai(zai paramzai)
  {
    if (paramzai != null)
    {
      this.mChangingConfigurations = paramzai.mChangingConfigurations;
      this.zanv = paramzai.zanv;
    }
  }

  public final int getChangingConfigurations()
  {
    return this.mChangingConfigurations;
  }

  public final Drawable newDrawable()
  {
    return new zae(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.base.zai
 * JD-Core Version:    0.6.2
 */