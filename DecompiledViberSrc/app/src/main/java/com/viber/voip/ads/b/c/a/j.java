package com.viber.voip.ads.b.c.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.View;
import com.viber.voip.ads.b.c.b.e;
import com.viber.voip.messages.orm.entity.json.action.Action;
import com.viber.voip.messages.orm.entity.json.action.OpenUrlAction;
import com.viber.voip.util.da;

public class j
  implements i
{
  private final Context a;
  private final e b;
  private final RecyclerView.Adapter c;

  public j(Context paramContext, e parame, RecyclerView.Adapter paramAdapter)
  {
    this.a = paramContext;
    this.c = paramAdapter;
    this.b = parame;
  }

  private int a()
  {
    return -1 + this.c.getItemCount();
  }

  private void a(com.viber.voip.ads.b.b.b.a parama)
  {
    this.b.a(parama, a());
    String str = parama.k();
    if (da.a(str))
      return;
    new OpenUrlAction(str).execute(this.a, null);
  }

  public void a(com.viber.voip.ads.b.b.b.a parama, View paramView)
  {
  }

  public void a(com.viber.voip.ads.b.b.b.a parama, View paramView, String paramString)
  {
    boolean bool = "menu icon".equals(paramString);
    String str3;
    if ((parama instanceof com.viber.voip.ads.b.a.b.c.a))
      if ("button".equals(paramString))
      {
        str3 = parama.m();
        if (da.a(str3))
          a(parama);
      }
    do
    {
      String str1;
      do
      {
        do
        {
          return;
          OpenUrlAction localOpenUrlAction = new OpenUrlAction(str3);
          this.b.a(parama, a());
          localOpenUrlAction.execute(this.a, null);
          return;
          if ("sponsored".equals(paramString))
          {
            String str2 = parama.l();
            if (da.a(str2))
            {
              a(parama);
              return;
            }
            this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str2)));
            return;
          }
        }
        while (bool);
        a(parama);
        return;
        if ((!(parama instanceof com.viber.voip.ads.b.a.b.b.a)) || (bool))
          break;
        str1 = parama.k();
      }
      while (da.a(str1));
      this.b.a(parama, a());
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.setData(Uri.parse(str1));
      this.a.startActivity(localIntent);
      return;
    }
    while (bool);
    a(parama);
  }

  public void b(com.viber.voip.ads.b.b.b.a parama, View paramView)
  {
    this.b.b(parama, a());
  }

  public void c(com.viber.voip.ads.b.b.b.a parama, View paramView)
  {
    this.b.p_();
  }

  public void d(com.viber.voip.ads.b.b.b.a parama, View paramView)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.c.a.j
 * JD-Core Version:    0.6.2
 */