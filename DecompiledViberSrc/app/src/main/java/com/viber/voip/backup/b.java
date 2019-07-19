package com.viber.voip.backup;

import android.content.Context;
import android.os.Bundle;
import com.viber.common.b.e;
import com.viber.voip.backup.auto.d;
import com.viber.voip.schedule.c;
import com.viber.voip.schedule.p;
import com.viber.voip.schedule.p.a;

public class b
{
  private final Context a;
  private final e b;
  private final com.viber.voip.backup.auto.b c;
  private final d d;
  private final p.a e;

  public b(Context paramContext, e parame, com.viber.voip.backup.auto.b paramb, d paramd, p.a parama)
  {
    this.a = paramContext;
    this.b = parame;
    this.c = paramb;
    this.d = paramd;
    this.e = parama;
  }

  public a a()
  {
    return a.a(this.b.d());
  }

  public void a(a parama)
  {
    if (parama != a())
    {
      this.b.a(parama.a());
      if (!parama.b())
        break label65;
      Bundle localBundle = p.a(c.a(parama.a()));
      this.e.a(this.a, localBundle, true);
    }
    while (true)
    {
      this.c.a();
      this.d.b();
      return;
      label65: this.e.c(this.a);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backup.b
 * JD-Core Version:    0.6.2
 */