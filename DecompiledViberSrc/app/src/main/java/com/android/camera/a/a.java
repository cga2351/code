package com.android.camera.a;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.net.Uri;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public abstract class a
  implements c
{
  private static final Logger i = ViberEnv.getLogger();
  protected ContentResolver a;
  protected Uri b;
  protected long c;
  protected String d;
  protected long e;
  protected final int f;
  protected String g;
  protected b h;
  private final long j;
  private String k;
  private final String l;
  private int m = -1;
  private int n = -1;

  protected a(b paramb, ContentResolver paramContentResolver, long paramLong1, int paramInt, Uri paramUri, String paramString1, long paramLong2, String paramString2, long paramLong3, String paramString3, String paramString4)
  {
    this.h = paramb;
    this.a = paramContentResolver;
    this.c = paramLong1;
    this.f = paramInt;
    this.b = paramUri;
    this.d = paramString1;
    this.e = paramLong2;
    this.g = paramString2;
    this.j = paramLong3;
    this.k = paramString3;
    this.l = paramString4;
  }

  public long a()
  {
    return this.j;
  }

  public Bitmap a(int paramInt1, int paramInt2)
  {
    return a(paramInt1, paramInt2, true, false);
  }

  public Bitmap a(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Uri localUri = this.h.a(this.c);
    Bitmap localBitmap;
    if (localUri == null)
      localBitmap = null;
    do
    {
      return localBitmap;
      localBitmap = com.android.camera.e.a(paramInt1, paramInt2, localUri, this.a, paramBoolean2);
    }
    while ((localBitmap == null) || (!paramBoolean1));
    return com.android.camera.e.a(localBitmap, b());
  }

  public int b()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof e)))
      return false;
    return this.b.equals(((e)paramObject).b);
  }

  public int hashCode()
  {
    return this.b.hashCode();
  }

  public String toString()
  {
    return this.b.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.camera.a.a
 * JD-Core Version:    0.6.2
 */