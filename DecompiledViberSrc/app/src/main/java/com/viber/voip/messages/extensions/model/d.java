package com.viber.voip.messages.extensions.model;

import android.net.Uri;
import com.viber.jni.slashkey.SlashItem;
import com.viber.voip.stickers.c.g;
import com.viber.voip.util.bv;
import com.viber.voip.util.bz;
import com.viber.voip.util.da;

public final class d
{
  private static final d[] a = new d[0];
  private String b;
  private boolean c;
  private String d;
  private boolean e;
  private String f;
  private Uri g;
  private boolean h;
  private boolean i;
  private int j;
  private String k;
  private int l;
  private int m;
  private int n;
  private int o;
  private int p;
  private boolean q;
  private String r;
  private boolean s;
  private boolean t;

  public static d a()
  {
    d locald = new d();
    locald.s = true;
    return locald;
  }

  public static d a(SlashItem paramSlashItem)
  {
    d locald = new d();
    locald.b(paramSlashItem.getName());
    locald.c(paramSlashItem.getDescription());
    locald.d(paramSlashItem.getImageUrl());
    locald.e(paramSlashItem.getUrl());
    locald.l = paramSlashItem.getImageSizeX();
    locald.m = paramSlashItem.getImageSizeY();
    locald.n = paramSlashItem.getFullImageSizeX();
    locald.o = paramSlashItem.getFullImageSizeY();
    locald.p = paramSlashItem.getVideoDuration();
    locald.q = paramSlashItem.isVideo();
    locald.r = paramSlashItem.getPreContent();
    return locald;
  }

  public static boolean a(String paramString)
  {
    return "stickers".equals(paramString);
  }

  public static d[] a(SlashItem[] paramArrayOfSlashItem)
  {
    if (paramArrayOfSlashItem == null)
      return a;
    d[] arrayOfd = new d[paramArrayOfSlashItem.length];
    for (int i1 = 0; i1 < arrayOfd.length; i1++)
      arrayOfd[i1] = a(paramArrayOfSlashItem[i1]);
    return arrayOfd;
  }

  private void b(String paramString)
  {
    this.b = paramString;
    if (!da.a(paramString));
    for (boolean bool = true; ; bool = false)
    {
      this.c = bool;
      return;
    }
  }

  private void c(String paramString)
  {
    this.d = paramString;
    if (!da.a(paramString));
    for (boolean bool = true; ; bool = false)
    {
      this.e = bool;
      return;
    }
  }

  private void d(String paramString)
  {
    this.h = bv.b(paramString);
    boolean bool;
    if ((paramString != null) && (paramString.startsWith("viber-sticker-id:")))
    {
      bool = true;
      this.i = bool;
      if (!this.i)
        break label84;
      this.j = bz.a(paramString.replace("viber-sticker-id:", ""));
    }
    label84: for (this.f = g.a(this.j, "80"); ; this.f = paramString)
    {
      if (paramString != null)
        this.g = Uri.parse(this.f);
      return;
      bool = false;
      break;
    }
  }

  private void e(String paramString)
  {
    if (paramString.startsWith("viber-sticker-id:"))
    {
      this.k = paramString.replace("viber-sticker-id:", "");
      return;
    }
    this.k = paramString;
  }

  public int a(int paramInt)
  {
    if (this.l > 0)
      paramInt = this.l;
    return paramInt;
  }

  public int b(int paramInt)
  {
    if (this.m > 0)
      paramInt = this.m;
    return paramInt;
  }

  public String b()
  {
    return this.b;
  }

  public int c(int paramInt)
  {
    if (this.n > 0)
      paramInt = this.n;
    return paramInt;
  }

  public boolean c()
  {
    return this.c;
  }

  public int d(int paramInt)
  {
    if (this.o > 0)
      paramInt = this.o;
    return paramInt;
  }

  public boolean d()
  {
    return this.e;
  }

  public boolean e()
  {
    return (c()) || (d());
  }

  public String f()
  {
    return this.d;
  }

  public String g()
  {
    return this.f;
  }

  public Uri h()
  {
    return this.g;
  }

  public boolean i()
  {
    return this.h;
  }

  public boolean j()
  {
    return this.i;
  }

  public int k()
  {
    return this.j;
  }

  public String l()
  {
    return this.k;
  }

  public int m()
  {
    return this.l;
  }

  public int n()
  {
    return this.m;
  }

  public boolean o()
  {
    return this.q;
  }

  public boolean p()
  {
    return this.s;
  }

  public boolean q()
  {
    return this.t;
  }

  public String toString()
  {
    return "SlashKeyboardExtensionItem{mTitle='" + this.b + '\'' + ", mHasTitle=" + this.c + ", mDescription='" + this.d + '\'' + ", mHasDescription=" + this.e + ", mImageUrl='" + this.f + '\'' + ", mImageUri=" + this.g + ", mIsGifUrl=" + this.h + ", mIsStickerUrl=" + this.i + ", mStickerId=" + this.j + ", mUrl='" + this.k + '\'' + ", mImageWidth=" + this.l + ", mImageHeight=" + this.m + ", mFullImageWidth=" + this.n + ", mFullImageHeight=" + this.o + ", mVideoDuration=" + this.p + ", mIsVideo=" + this.q + ", mPreContent='" + this.r + '\'' + ", mLoadingItem=" + this.s + ", mEmptyItem=" + this.t + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.model.d
 * JD-Core Version:    0.6.2
 */