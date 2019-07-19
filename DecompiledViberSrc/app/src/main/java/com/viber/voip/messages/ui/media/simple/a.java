package com.viber.voip.messages.ui.media.simple;

import android.net.Uri;
import com.viber.voip.util.da;
import com.viber.voip.util.links.d;
import com.viber.voip.util.links.f;

public class a
{
  private final SimpleMediaViewItem a;
  private boolean b;
  private Uri c;
  private int d;
  private int e;
  private Boolean f;

  public a(SimpleMediaViewItem paramSimpleMediaViewItem)
  {
    this.a = paramSimpleMediaViewItem;
  }

  public String a()
  {
    return this.a.getMediaUrl();
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.d = paramInt1;
    this.e = paramInt2;
  }

  public void a(Uri paramUri)
  {
    this.c = paramUri;
  }

  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public String b()
  {
    return da.b(this.a.getUrlToFavorite(), this.a.getMediaUrl());
  }

  public final int c()
  {
    return this.a.getMediaType();
  }

  public boolean d()
  {
    return this.a.isSecretMode();
  }

  public long e()
  {
    return this.a.getMessageId();
  }

  public int f()
  {
    return this.a.getMessageType();
  }

  public long g()
  {
    return this.a.getMessageDate();
  }

  public boolean h()
  {
    return this.a.isImageOrGifType();
  }

  public boolean i()
  {
    return this.a.isGifFile();
  }

  public boolean j()
  {
    return this.a.isImageType();
  }

  public boolean k()
  {
    return this.a.isVideoType();
  }

  public boolean l()
  {
    return this.b;
  }

  public boolean m()
  {
    if (this.f == null)
    {
      String str = b();
      d locald = f.d().a(str);
      if ((locald == null) || (!str.equalsIgnoreCase(locald.b)))
        break label53;
    }
    label53: for (boolean bool = true; ; bool = false)
    {
      this.f = Boolean.valueOf(bool);
      return this.f.booleanValue();
    }
  }

  public Uri n()
  {
    return this.c;
  }

  public String o()
  {
    if (this.c != null)
      return this.c.toString();
    return "";
  }

  public int p()
  {
    return this.d;
  }

  public int q()
  {
    return this.e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.simple.a
 * JD-Core Version:    0.6.2
 */