package com.viber.voip.publicaccount.ui.holders.recentmedia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.viber.voip.messages.conversation.aa;
import com.viber.voip.util.e.g;

public class c extends com.viber.voip.publicaccount.ui.holders.b<RecentMediaData, d>
{
  private LayoutInflater c;
  private Context d;
  private g e;
  private a f;
  private b g;

  public c(Context paramContext, b paramb, g paramg, a parama, LayoutInflater paramLayoutInflater)
  {
    this.d = paramContext.getApplicationContext();
    this.e = paramg;
    this.f = parama;
    this.g = paramb;
    this.c = paramLayoutInflater;
  }

  protected void a(d paramd, RecentMediaData paramRecentMediaData)
  {
    if ((com.viber.voip.publicaccount.d.d.A.a(((RecentMediaData)this.a).mRole, ((RecentMediaData)this.a).mPublicGroupType)) && (this.g.getCount() > 0));
    for (boolean bool = true; ; bool = false)
    {
      paramd.b();
      paramd.a(bool);
      return;
    }
  }

  protected Class<d> b()
  {
    return d.class;
  }

  protected d c(View paramView)
  {
    return new e(this.d, paramView, this.e, this.g, this.f, this.c);
  }

  protected RecentMediaData e()
  {
    return new RecentMediaData();
  }

  public static abstract interface a
  {
    public abstract void a(aa paramaa);

    public abstract void h();

    public abstract void i();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.recentmedia.c
 * JD-Core Version:    0.6.2
 */