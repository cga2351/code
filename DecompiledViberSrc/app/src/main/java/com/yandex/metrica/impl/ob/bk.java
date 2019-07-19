package com.yandex.metrica.impl.ob;

import android.net.Uri.Builder;
import com.yandex.metrica.impl.av;
import com.yandex.metrica.impl.bw;
import com.yandex.metrica.impl.i;
import com.yandex.metrica.impl.p;

public class bk extends av
{
  private final bn a;
  private final i b;
  private final bo c;
  private final bl.a l;
  private final on m;
  private nx n;
  private final String o;
  private bm p;

  public bk(bn parambn, i parami, bo parambo)
  {
    this(parambn, parami, parambo, new bl.a(), new om(), new nx());
  }

  public bk(bn parambn, i parami, bo parambo, bl.a parama, on paramon, nx paramnx)
  {
    super(new p());
    this.a = parambn;
    this.b = parami;
    this.c = parambo;
    this.l = parama;
    this.m = paramon;
    this.n = paramnx;
    this.o = (getClass().getName() + "@" + Integer.toHexString(hashCode()));
  }

  protected String E()
  {
    return "diagnostic";
  }

  public String a()
  {
    return this.o;
  }

  protected void a(Uri.Builder paramBuilder)
  {
    paramBuilder.appendPath("diagnostic");
    paramBuilder.appendQueryParameter("deviceid", this.p.q());
    paramBuilder.appendQueryParameter("uuid", this.p.r());
    paramBuilder.appendQueryParameter("app_platform", this.p.k());
    paramBuilder.appendQueryParameter("analytics_sdk_version_name", this.p.h());
    paramBuilder.appendQueryParameter("analytics_sdk_build_number", this.p.i());
    paramBuilder.appendQueryParameter("analytics_sdk_build_type", this.p.j());
    paramBuilder.appendQueryParameter("app_version_name", this.p.p());
    paramBuilder.appendQueryParameter("app_build_number", this.p.o());
    paramBuilder.appendQueryParameter("model", this.p.l());
    paramBuilder.appendQueryParameter("manufacturer", this.p.f());
    paramBuilder.appendQueryParameter("os_version", this.p.m());
    paramBuilder.appendQueryParameter("os_api_level", String.valueOf(this.p.n()));
    paramBuilder.appendQueryParameter("screen_width", String.valueOf(this.p.u()));
    paramBuilder.appendQueryParameter("screen_height", String.valueOf(this.p.v()));
    paramBuilder.appendQueryParameter("screen_dpi", String.valueOf(this.p.w()));
    paramBuilder.appendQueryParameter("scalefactor", String.valueOf(this.p.x()));
    paramBuilder.appendQueryParameter("locale", this.p.y());
    paramBuilder.appendQueryParameter("device_type", this.p.A());
    paramBuilder.appendQueryParameter("app_id", this.p.c());
    paramBuilder.appendQueryParameter("api_key_128", this.p.b());
    paramBuilder.appendQueryParameter("app_debuggable", this.p.C());
    paramBuilder.appendQueryParameter("is_rooted", this.p.s());
    paramBuilder.appendQueryParameter("app_framework", this.p.t());
  }

  public boolean b()
  {
    this.p = this.a.f();
    boolean bool1 = this.p.e();
    boolean bool2 = bw.a(this.p.a());
    if ((bool1) && (!bool2));
    for (int i = 1; i == 0; i = 0)
      return false;
    a(this.p.a());
    byte[] arrayOfByte1 = this.l.a(this.b, this.p, this.c).a();
    try
    {
      byte[] arrayOfByte3 = this.n.a(arrayOfByte1);
      arrayOfByte2 = arrayOfByte3;
      if (!bw.a(arrayOfByte2))
      {
        a("Content-Encoding", new String[] { "gzip" });
        a(arrayOfByte2);
        return true;
      }
    }
    catch (Exception localException)
    {
      while (true)
      {
        byte[] arrayOfByte2 = null;
        continue;
        arrayOfByte2 = arrayOfByte1;
      }
    }
  }

  public void f()
  {
    super.f();
    a(Long.valueOf(this.m.a()));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.bk
 * JD-Core Version:    0.6.2
 */