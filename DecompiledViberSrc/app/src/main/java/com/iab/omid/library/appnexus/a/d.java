package com.iab.omid.library.appnexus.a;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings.System;

public final class d extends ContentObserver
{
  private final Context a;
  private final AudioManager b;
  private final a c;
  private final c d;
  private float e;

  public d(Handler paramHandler, Context paramContext, a parama, c paramc)
  {
    super(paramHandler);
    this.a = paramContext;
    this.b = ((AudioManager)paramContext.getSystemService("audio"));
    this.c = parama;
    this.d = paramc;
  }

  private boolean a(float paramFloat)
  {
    return paramFloat != this.e;
  }

  private float c()
  {
    int i = this.b.getStreamVolume(3);
    int j = this.b.getStreamMaxVolume(3);
    return this.c.a(i, j);
  }

  private void d()
  {
    this.d.a(this.e);
  }

  public void a()
  {
    this.e = c();
    d();
    this.a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
  }

  public void b()
  {
    this.a.getContentResolver().unregisterContentObserver(this);
  }

  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    float f = c();
    if (a(f))
    {
      this.e = f;
      d();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.a.d
 * JD-Core Version:    0.6.2
 */