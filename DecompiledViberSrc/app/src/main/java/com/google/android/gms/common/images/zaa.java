package com.google.android.gms.common.images;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.internal.base.zak;

public abstract class zaa
{
  final zab zamu;
  private int zamv = 0;
  protected int zamw = 0;
  private boolean zamx = false;
  private boolean zamy = true;
  private boolean zamz = false;
  private boolean zana = true;

  public zaa(Uri paramUri, int paramInt)
  {
    this.zamu = new zab(paramUri);
    this.zamw = paramInt;
  }

  final void zaa(Context paramContext, Bitmap paramBitmap, boolean paramBoolean)
  {
    Asserts.checkNotNull(paramBitmap);
    zaa(new BitmapDrawable(paramContext.getResources(), paramBitmap), paramBoolean, false, true);
  }

  final void zaa(Context paramContext, zak paramzak)
  {
    if (this.zana)
      zaa(null, false, true, false);
  }

  final void zaa(Context paramContext, zak paramzak, boolean paramBoolean)
  {
    int i = this.zamw;
    Drawable localDrawable = null;
    if (i != 0)
    {
      int j = this.zamw;
      localDrawable = paramContext.getResources().getDrawable(j);
    }
    zaa(localDrawable, paramBoolean, false, false);
  }

  protected abstract void zaa(Drawable paramDrawable, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3);

  protected final boolean zaa(boolean paramBoolean1, boolean paramBoolean2)
  {
    return (this.zamy) && (!paramBoolean2) && (!paramBoolean1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.images.zaa
 * JD-Core Version:    0.6.2
 */