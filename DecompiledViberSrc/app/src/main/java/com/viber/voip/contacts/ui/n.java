package com.viber.voip.contacts.ui;

import android.support.v4.util.ArrayMap;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.b.a.a.a;
import com.viber.common.permission.c;
import com.viber.provider.d;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.contacts.b.a;
import com.viber.voip.messages.ui.view.SearchNoResultsView;
import com.viber.voip.util.dj;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class n
{
  private final boolean a;
  private final boolean b;
  private final a c;
  private final View d;
  private final SearchNoResultsView e;
  private final View f;
  private final View g;
  private final View h;
  private final c i;
  private final com.viber.voip.contacts.b j;
  private final com.viber.voip.calls.b k;
  private final Map<d, Boolean> l = new ArrayMap(2);

  public n(a parama, View paramView1, SearchNoResultsView paramSearchNoResultsView, View paramView2, View paramView3, View paramView4, c paramc, com.viber.voip.contacts.b paramb, com.viber.voip.calls.b paramb1, boolean paramBoolean1, boolean paramBoolean2, View.OnClickListener paramOnClickListener)
  {
    this.c = parama;
    this.d = paramView1;
    this.e = paramSearchNoResultsView;
    this.f = paramView2;
    this.g = paramView3;
    this.h = paramView4;
    this.i = paramc;
    this.j = paramb;
    this.k = paramb1;
    this.a = paramBoolean1;
    this.b = paramBoolean2;
    a(paramView1, paramOnClickListener);
    b(paramb);
    b(paramb1);
  }

  private void a()
  {
    this.c.b(this.e, true);
    this.c.b(this.d, false);
  }

  private void a(View paramView, View.OnClickListener paramOnClickListener)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(R.id.permission_icon);
    TextView localTextView = (TextView)paramView.findViewById(R.id.permission_description);
    localImageView.setImageResource(R.drawable.ic_permission_contacts);
    localTextView.setText(R.string.contact_list_permission_description);
    paramView.findViewById(R.id.button_request_permission).setOnClickListener(paramOnClickListener);
  }

  private void a(boolean paramBoolean)
  {
    dj.c(this.g, paramBoolean);
    dj.c(this.f, paramBoolean);
  }

  private void b()
  {
    this.c.b(this.d, true);
    this.c.b(this.e, false);
    a(false);
  }

  private void b(d paramd)
  {
    this.l.put(paramd, Boolean.valueOf(false));
  }

  private void c()
  {
    this.c.b(this.e, false);
    this.c.b(this.d, false);
    if (!this.a)
      a(true);
  }

  private void c(d paramd)
  {
    if (!this.l.containsKey(paramd))
      return;
    this.l.put(paramd, Boolean.valueOf(true));
  }

  private boolean d()
  {
    Iterator localIterator = this.l.keySet().iterator();
    while (localIterator.hasNext())
    {
      d locald = (d)localIterator.next();
      if ((!locald.b()) && (!((Boolean)this.l.get(locald)).booleanValue()))
        return false;
    }
    return true;
  }

  public void a(d paramd)
  {
    c(paramd);
    if ((!this.a) && (!this.j.x_()) && (this.j.w().getCount() == 0))
    {
      if (this.i.a(com.viber.voip.permissions.n.j))
      {
        this.e.setText(R.string.noViberContacts);
        a();
      }
      while (!d())
        return;
      b();
      return;
    }
    c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.n
 * JD-Core Version:    0.6.2
 */