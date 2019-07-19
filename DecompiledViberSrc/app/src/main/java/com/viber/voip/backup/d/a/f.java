package com.viber.voip.backup.d.a;

import com.viber.voip.backup.d.a.a.a;
import com.viber.voip.backup.d.a.a.a.a;
import com.viber.voip.backup.d.a.a.c.a;
import java.util.List;

class f extends c
{
  private final Long b;

  public f(b paramb, Long paramLong)
  {
    super(paramb);
    this.b = paramLong;
  }

  public List<com.viber.voip.backup.d.a.a.c> a()
  {
    List localList = super.a();
    if (this.b != null)
      localList.add(new c.a().a(" AND ", "token", this.b, false).b());
    return localList;
  }

  public List<a> b()
  {
    List localList = super.b();
    localList.add(new a.a().a("token").a());
    return localList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.d.a.f
 * JD-Core Version:    0.6.2
 */