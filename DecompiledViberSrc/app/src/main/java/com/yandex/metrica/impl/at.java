package com.yandex.metrica.impl;

import android.net.Uri.Builder;
import com.yandex.metrica.impl.ob.nx;
import com.yandex.metrica.impl.ob.om;
import com.yandex.metrica.impl.ob.on;
import com.yandex.metrica.impl.ob.ow;
import com.yandex.metrica.impl.ob.pd;
import com.yandex.metrica.impl.ob.pe;
import java.io.IOException;

public abstract class at extends av
{
  private final pd a;
  private final nx b;
  private final on c;

  public at()
  {
    this(new p(), new ow(), new nx(), new om());
  }

  public at(ar paramar, pd parampd, nx paramnx, on paramon)
  {
    super(paramar);
    this.a = parampd;
    this.b = paramnx;
    this.c = paramon;
  }

  protected void F()
  {
    a(Long.valueOf(this.c.a()));
  }

  protected abstract void G();

  protected void a(Uri.Builder paramBuilder)
  {
    if (this.a.a() == pe.b)
      paramBuilder.appendQueryParameter("encrypted_request", "1");
  }

  public void a(byte[] paramArrayOfByte)
  {
    super.a(paramArrayOfByte);
  }

  public boolean c()
  {
    boolean bool = super.c();
    if ((bool) || (r()))
      G();
    return bool;
  }

  public boolean c(byte[] paramArrayOfByte)
  {
    try
    {
      byte[] arrayOfByte1 = this.b.a(paramArrayOfByte);
      boolean bool = false;
      if (arrayOfByte1 != null)
      {
        byte[] arrayOfByte2 = this.a.a(arrayOfByte1);
        bool = false;
        if (arrayOfByte2 != null)
        {
          a(arrayOfByte2);
          bool = true;
        }
      }
      return bool;
    }
    catch (IOException localIOException)
    {
    }
    return false;
  }

  public void f()
  {
    super.f();
    F();
  }

  protected boolean r()
  {
    return n() == 400;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.at
 * JD-Core Version:    0.6.2
 */