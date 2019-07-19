package com.viber.voip.ads.b.c.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.viber.voip.ads.b.c.b.e;
import com.viber.voip.messages.orm.entity.json.action.Action;
import com.viber.voip.messages.orm.entity.json.action.OpenUrlAction;
import com.viber.voip.messages.ui.MessagesFragmentModeManager;
import com.viber.voip.util.da;
import javax.annotation.Nullable;

public class c
  implements i
{
  private final Context a;

  @Nullable
  private final AdapterView.OnItemLongClickListener b;
  private final e c;
  private final ListView d;
  private final ListAdapter e;

  @Nullable
  private final MessagesFragmentModeManager f;

  public c(Context paramContext, @Nullable AdapterView.OnItemLongClickListener paramOnItemLongClickListener, e parame, ListView paramListView, ListAdapter paramListAdapter, @Nullable MessagesFragmentModeManager paramMessagesFragmentModeManager)
  {
    this.a = paramContext;
    this.b = paramOnItemLongClickListener;
    this.d = paramListView;
    this.e = paramListAdapter;
    this.c = parame;
    this.f = paramMessagesFragmentModeManager;
  }

  private int a()
  {
    return -1 + this.e.getCount();
  }

  private void a(View paramView)
  {
    View localView = (View)paramView.getParent();
    int i = this.d.getPositionForView(localView);
    long l = this.d.getItemIdAtPosition(i);
    this.d.performItemClick(localView, i, l);
  }

  private void a(com.viber.voip.ads.b.b.b.a parama)
  {
    this.c.a(parama, a());
    String str = parama.k();
    if (da.a(str))
      return;
    new OpenUrlAction(str).execute(this.a, null);
  }

  private void b(View paramView)
  {
    if (this.b == null)
      return;
    View localView = (View)paramView.getParent();
    int i = this.d.getPositionForView(localView);
    long l = this.d.getItemIdAtPosition(i);
    this.b.onItemLongClick(this.d, localView, i, l);
  }

  public void a(com.viber.voip.ads.b.b.b.a parama, View paramView)
  {
    if ((this.f == null) || (!this.f.l()))
      b(paramView);
  }

  public void a(com.viber.voip.ads.b.b.b.a parama, View paramView, String paramString)
  {
    if ((this.f != null) && (this.f.l()))
      a(paramView);
    boolean bool;
    do
    {
      do
      {
        return;
        bool = "menu icon".equals(paramString);
        if (!(parama instanceof com.viber.voip.ads.b.a.b.c.a))
          break;
        if ("button".equals(paramString))
        {
          OpenUrlAction localOpenUrlAction = new OpenUrlAction(parama.m());
          this.c.a(parama, a());
          localOpenUrlAction.execute(this.a, null);
          return;
        }
        if ("sponsored".equals(paramString))
        {
          String str = parama.l();
          if (!da.a(str))
          {
            this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return;
          }
          a(parama);
          return;
        }
      }
      while (bool);
      a(parama);
      return;
      if (((parama instanceof com.viber.voip.ads.b.a.b.b.a)) && (!bool))
      {
        this.c.a(parama, a());
        Intent localIntent = new Intent("android.intent.action.VIEW");
        localIntent.setData(Uri.parse(parama.k()));
        this.a.startActivity(localIntent);
        return;
      }
    }
    while (bool);
    a(parama);
  }

  public void b(com.viber.voip.ads.b.b.b.a parama, View paramView)
  {
    this.c.b(parama, a());
  }

  public void c(com.viber.voip.ads.b.b.b.a parama, View paramView)
  {
    this.c.p_();
  }

  public void d(com.viber.voip.ads.b.b.b.a parama, View paramView)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.c.a.c
 * JD-Core Version:    0.6.2
 */