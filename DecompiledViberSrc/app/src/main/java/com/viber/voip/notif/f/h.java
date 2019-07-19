package com.viber.voip.notif.f;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import com.viber.voip.R.drawable;
import com.viber.voip.util.dq;
import com.viber.voip.util.dx;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.j;

public class h
  implements d
{
  private final Context a;
  private final int b;
  private final int c;

  h(Context paramContext)
  {
    this.a = paramContext;
    this.b = this.a.getResources().getDimensionPixelSize(17104901);
    this.c = this.a.getResources().getDimensionPixelSize(17104902);
  }

  public int a()
  {
    return 2;
  }

  public g a(Uri paramUri, int paramInt)
  {
    if (paramInt > 0);
    for (int i = R.drawable.bg_wear_default; ; i = -1)
      return new a(paramUri, null, paramInt, i);
  }

  public g a(Uri paramUri, String paramString, int paramInt)
  {
    if (paramInt > 0);
    for (int i = R.drawable.bg_wear_default; ; i = -1)
      return new a(paramUri, paramString, paramInt, i);
  }

  public g a(Uri paramUri, String paramString, int paramInt1, int paramInt2)
  {
    return new a(paramUri, paramString, paramInt1, paramInt2);
  }

  Bitmap b(Uri paramUri, int paramInt)
  {
    if (dx.b(paramUri))
      paramUri = dx.b(paramUri.getLastPathSegment());
    Bitmap localBitmap = e.a(this.a, paramUri, true);
    if ((localBitmap == null) && (paramInt > 0))
      return dq.a(this.a.getResources(), paramInt);
    return j.a(j.a(localBitmap), 400, 400, false);
  }

  Bitmap b(Uri paramUri, String paramString, int paramInt)
  {
    Bitmap localBitmap = e.a(this.a, paramUri, false);
    boolean bool = false;
    if (localBitmap == null)
      bool = true;
    if ((bool) && (paramInt <= 0))
      return null;
    Resources localResources = this.a.getResources();
    if (bool)
      localBitmap = dq.a(localResources, paramInt);
    return j.a(this.a, localBitmap, this.b, this.c, paramString, bool);
  }

  private class a
    implements g
  {
    private final Uri b;
    private String c;
    private int d;
    private int e;

    a(Uri paramString, String paramInt1, int paramInt2, int arg5)
    {
      this.b = paramString;
      this.c = paramInt1;
      this.d = paramInt2;
      int i;
      this.e = i;
    }

    public Bitmap a()
    {
      return h.this.b(this.b, this.c, this.d);
    }

    public Bitmap b()
    {
      return h.this.b(this.b, this.e);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.f.h
 * JD-Core Version:    0.6.2
 */