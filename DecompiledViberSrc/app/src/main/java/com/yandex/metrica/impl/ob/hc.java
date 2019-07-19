package com.yandex.metrica.impl.ob;

import android.content.Context;

public class hc
{
  private os a;

  public hc(Context paramContext)
  {
    this(new os(paramContext));
  }

  hc(os paramos)
  {
    this.a = paramos;
  }

  public gd<kt.a> a()
  {
    return new gb(new gi(), new ot("AES/CBC/PKCS5Padding", this.a.a(), this.a.b()));
  }

  public gd<kq.a> b()
  {
    return new gb(new gc(), new ot("AES/CBC/PKCS5Padding", this.a.a(), this.a.b()));
  }

  public gd<ks.a> c()
  {
    return new gb(new gh(), new ot("AES/CBC/PKCS5Padding", this.a.a(), this.a.b()));
  }

  public gd<kr.a> d()
  {
    return new gb(new gg(), new ot("AES/CBC/PKCS5Padding", this.a.a(), this.a.b()));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.hc
 * JD-Core Version:    0.6.2
 */