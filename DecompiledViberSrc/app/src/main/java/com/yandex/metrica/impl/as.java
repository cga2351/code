package com.yandex.metrica.impl;

import android.net.Uri;
import android.net.Uri.Builder;
import com.yandex.metrica.impl.ob.io;
import com.yandex.metrica.impl.ob.iq;
import com.yandex.metrica.impl.ob.lu;
import com.yandex.metrica.impl.ob.lx;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class as
{
  private List<String> a;
  private Boolean b;
  private boolean c;
  protected String d;
  protected int e = 1;
  protected final Map<String, List<String>> f = new HashMap();
  protected byte[] g;
  protected int h;
  protected byte[] i;
  protected Map<String, List<String>> j;
  protected int k = -1;
  private Long l;
  private final lx m = new lu(3, E());

  public boolean A()
  {
    return (this.b != null) && (this.b.booleanValue());
  }

  public boolean B()
  {
    return this.b != null;
  }

  public Long C()
  {
    return this.l;
  }

  public Map<String, List<String>> D()
  {
    return this.f;
  }

  protected String E()
  {
    return "";
  }

  public String a()
  {
    return getClass().getName();
  }

  public String a(Boolean paramBoolean)
  {
    if (paramBoolean == null)
      return "";
    if (paramBoolean.booleanValue());
    for (String str = "1"; ; str = "0")
      return String.valueOf(str);
  }

  public void a(int paramInt)
  {
    this.h = paramInt;
  }

  protected abstract void a(Uri.Builder paramBuilder);

  public void a(Long paramLong)
  {
    this.l = paramLong;
  }

  public void a(String paramString)
  {
    this.d = paramString;
  }

  public void a(String paramString, String[] paramArrayOfString)
  {
    this.f.put(paramString, Arrays.asList(paramArrayOfString));
  }

  public void a(List<String> paramList)
  {
    this.a = paramList;
  }

  void a(Map<String, List<String>> paramMap)
  {
    this.j = paramMap;
  }

  public void a(boolean paramBoolean)
  {
    this.b = Boolean.valueOf(paramBoolean);
  }

  public void a(byte[] paramArrayOfByte)
  {
    this.e = 2;
    this.g = paramArrayOfByte;
  }

  public void b(byte[] paramArrayOfByte)
  {
    this.i = paramArrayOfByte;
  }

  public abstract boolean b();

  protected boolean b(int paramInt)
  {
    return (paramInt != 400) && (paramInt != 500);
  }

  public abstract boolean c();

  public lx d()
  {
    return this.m;
  }

  public io e()
  {
    return new iq().a(k());
  }

  public void f()
  {
    x();
    g();
  }

  protected void g()
  {
    Uri.Builder localBuilder = Uri.parse(u()).buildUpon();
    a(localBuilder);
    a(localBuilder.build().toString());
  }

  public void h()
  {
  }

  public void i()
  {
  }

  public void j()
  {
    this.b = Boolean.FALSE;
  }

  public String k()
  {
    return this.d;
  }

  public int l()
  {
    return this.e;
  }

  public byte[] m()
  {
    return this.g;
  }

  public int n()
  {
    return this.h;
  }

  public byte[] o()
  {
    return this.i;
  }

  Map<String, List<String>> p()
  {
    return this.j;
  }

  public boolean q()
  {
    return false;
  }

  protected boolean r()
  {
    return n() == 400;
  }

  public long s()
  {
    return 0L;
  }

  public int t()
  {
    return this.k;
  }

  protected String u()
  {
    return (String)this.a.get(t());
  }

  public List<String> v()
  {
    return this.a;
  }

  public boolean w()
  {
    return (!y()) && (1 + t() < this.a.size());
  }

  public void x()
  {
    this.k = (1 + this.k);
  }

  public boolean y()
  {
    return this.c;
  }

  public void z()
  {
    this.c = true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.as
 * JD-Core Version:    0.6.2
 */