package com.viber.voip.calls.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.attr;
import com.viber.voip.calls.g;
import com.viber.voip.model.a;
import com.viber.voip.util.dc;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;

public class v extends m<a>
{
  private x g;

  public v(Context paramContext, g paramg)
  {
    super(paramContext, paramg);
    int i = dc.a(paramContext, R.attr.contactDefaultPhoto);
    e locale = e.a(paramContext);
    f localf = new f.a().b(Integer.valueOf(i)).a(Integer.valueOf(i)).c();
    this.g = new x(paramContext, this.d, new w(this), locale, localf);
  }

  private void a(View paramView)
  {
    y localy = (y)paramView.getTag();
    String str = localy.c();
    if (TextUtils.isEmpty(str));
    while (this.f == null)
      return;
    m.a locala = this.f;
    if (!localy.d());
    for (boolean bool = true; ; bool = false)
    {
      locala.a(str, bool, false, false, ((a)localy.e()).p());
      return;
    }
  }

  public View a(ViewGroup paramViewGroup, int paramInt)
  {
    y localy = (y)this.g.c(this.b, paramViewGroup);
    localy.a(this);
    View localView = localy.itemView;
    localView.setTag(localy);
    return localView;
  }

  public void a(View paramView, a parama)
  {
    a(paramView);
  }

  public void a(View paramView, a parama, int paramInt)
  {
    y localy = (y)paramView.getTag();
    if ((parama == null) || (localy == null))
      return;
    this.g.b(localy, parama, paramInt);
  }

  public void a(String paramString)
  {
    this.g.a(paramString);
  }

  public void b(View paramView, a parama)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.v
 * JD-Core Version:    0.6.2
 */