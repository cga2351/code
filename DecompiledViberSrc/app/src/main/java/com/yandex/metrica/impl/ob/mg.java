package com.yandex.metrica.impl.ob;

import android.content.Context;
import com.yandex.metrica.c;

public class mg
{
  private final mh a;
  private final c b;

  public mg(Context paramContext)
  {
    this(new mh(), mi.a(paramContext));
  }

  mg(mh parammh, c paramc)
  {
    this.a = parammh;
    this.b = paramc;
  }

  public void a(ku.a.a parama)
  {
    this.b.a("provided_request_schedule", this.a.a(parama));
  }

  public void a(ku.a.b paramb)
  {
    this.b.a("provided_request_result", this.a.a(paramb));
  }

  public void b(ku.a.a parama)
  {
    this.b.a("provided_request_send", this.a.a(parama));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.mg
 * JD-Core Version:    0.6.2
 */