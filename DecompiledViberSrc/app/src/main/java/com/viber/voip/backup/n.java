package com.viber.voip.backup;

import android.annotation.SuppressLint;
import android.net.Uri;
import com.viber.voip.backup.c.d;

class n
  implements Runnable
{
  private int a;
  private Uri b;
  private int c;
  private d d;
  private j e;

  public n()
  {
    a();
  }

  public n(n paramn)
  {
    this.a = paramn.a;
    this.b = paramn.b;
    this.c = paramn.c;
    this.d = paramn.d;
  }

  public n a(Uri paramUri)
  {
    this.a = 3;
    this.b = paramUri;
    return this;
  }

  public n a(Uri paramUri, int paramInt)
  {
    this.a = 1;
    this.b = paramUri;
    this.c = paramInt;
    this.d = null;
    return this;
  }

  public n a(Uri paramUri, d paramd)
  {
    this.a = 2;
    this.b = paramUri;
    this.d = paramd;
    return this;
  }

  public n a(j paramj)
  {
    this.e = paramj;
    return this;
  }

  public void a()
  {
    c();
    d();
  }

  public Uri b()
  {
    return this.b;
  }

  public n b(Uri paramUri)
  {
    this.a = 4;
    this.b = paramUri;
    return this;
  }

  public void b(j paramj)
  {
    a(paramj);
    run();
  }

  public void c()
  {
    this.a = 0;
    this.b = null;
    this.c = 0;
    this.d = null;
  }

  public void d()
  {
    this.e = null;
  }

  public boolean e()
  {
    return this.a != 1;
  }

  @SuppressLint({"SwitchIntDef"})
  public void run()
  {
    if ((this.a != 0) && (this.b != null) && (this.e != null))
      switch (this.a)
      {
      default:
      case 1:
      case 3:
      case 4:
      case 2:
      }
    while (true)
    {
      d();
      return;
      this.e.a(this.b, this.c);
      continue;
      this.e.b(this.b);
      continue;
      this.e.c(this.b);
      continue;
      if (this.d == null)
        this.d = new d("Error is happened by reason is missed.");
      this.e.a(this.b, this.d);
    }
  }

  public String toString()
  {
    return "EventTask{mEventType=" + this.a + ", mUri=" + this.b + ", mPercentage=" + this.c + ", mBackupException=" + this.d + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.n
 * JD-Core Version:    0.6.2
 */