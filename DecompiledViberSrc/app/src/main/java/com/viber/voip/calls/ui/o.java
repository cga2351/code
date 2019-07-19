package com.viber.voip.calls.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.attr;
import com.viber.voip.calls.c;
import com.viber.voip.model.AggregatedCall;
import com.viber.voip.model.a;
import com.viber.voip.util.dc;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.e.f.b;

public class o extends m<AggregatedCall>
{
  protected final boolean g;
  private v h;
  private z i;
  private aa j;

  public o(Context paramContext, c paramc, v paramv, RecentCallsFragmentModeManager paramRecentCallsFragmentModeManager, boolean paramBoolean)
  {
    super(paramContext, paramc);
    this.h = paramv;
    p localp = new p(this);
    e locale = e.a(paramContext);
    int k = dc.a(paramContext, R.attr.contactDefaultPhoto);
    f localf1 = new f.a().b(Integer.valueOf(k)).a(Integer.valueOf(k)).c();
    this.i = new z(paramContext, paramRecentCallsFragmentModeManager, this.d, localp, locale, localf1, paramBoolean);
    f localf2 = f.a(k, f.b.b, false);
    this.j = new aa(paramContext, paramRecentCallsFragmentModeManager, this.d, localp, locale, localf2);
    this.g = paramBoolean;
  }

  private void a(AggregatedCall paramAggregatedCall)
  {
    boolean bool1 = true;
    if (this.f != null)
    {
      if (paramAggregatedCall.isTypeViberGroup())
        break label132;
      if (!this.e)
        break label101;
      bool2 = paramAggregatedCall.isTypeViberVideo();
      locala = this.f;
      str = paramAggregatedCall.getNumber();
      bool3 = paramAggregatedCall.isTypeViberOut();
      bool4 = paramAggregatedCall.isTypeVln();
      if ((paramAggregatedCall.getContact() == null) || (!paramAggregatedCall.getContact().p()))
        break label127;
      locala.a(str, bool3, bool2, bool4, bool1);
    }
    label101: label127: 
    while (!paramAggregatedCall.hasConferenceInfo())
      while (true)
      {
        boolean bool2;
        m.a locala;
        String str;
        boolean bool3;
        boolean bool4;
        return;
        if ((this.g) && (paramAggregatedCall.isTypeViberVideo()))
        {
          bool2 = bool1;
        }
        else
        {
          bool2 = false;
          continue;
          bool1 = false;
        }
      }
    label132: this.f.a(paramAggregatedCall.getConferenceInfo());
  }

  public View a(ViewGroup paramViewGroup, int paramInt)
  {
    a locala = a.values()[getItemViewType(paramInt)];
    if (a.a == locala);
    for (u localu = (u)this.i.c(this.b, paramViewGroup); ; localu = (u)this.j.c(this.b, paramViewGroup))
    {
      localu.a(this);
      View localView = localu.itemView;
      localView.setTag(localu);
      return localView;
      if (a.b != locala)
        break;
    }
    throw new IllegalStateException();
  }

  public void a(View paramView, AggregatedCall paramAggregatedCall)
  {
    a(paramAggregatedCall);
  }

  public void a(View paramView, AggregatedCall paramAggregatedCall, int paramInt)
  {
    u localu = (u)paramView.getTag();
    if ((paramAggregatedCall == null) || (localu == null));
    a locala;
    do
    {
      return;
      locala = a.values()[getItemViewType(paramInt)];
      if (a.a == locala)
      {
        this.i.b(localu, paramAggregatedCall, paramInt);
        return;
      }
    }
    while (a.b != locala);
    this.j.b(localu, paramAggregatedCall, paramInt);
  }

  public void b(View paramView, AggregatedCall paramAggregatedCall)
  {
    m.a locala;
    String str;
    boolean bool1;
    if (this.f != null)
    {
      locala = this.f;
      str = paramAggregatedCall.getNumber();
      bool1 = paramAggregatedCall.isTypeVln();
      if ((paramAggregatedCall.getContact() == null) || (!paramAggregatedCall.getContact().p()))
        break label69;
    }
    label69: for (boolean bool2 = true; ; bool2 = false)
    {
      locala.a(str, false, true, bool1, bool2);
      return;
    }
  }

  public int getItemViewType(int paramInt)
  {
    if (((AggregatedCall)a(paramInt)).isTypeViberGroup())
      return a.b.ordinal();
    return a.a.ordinal();
  }

  public int getViewTypeCount()
  {
    return a.values().length;
  }

  private static enum a
  {
    static
    {
      a[] arrayOfa = new a[2];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.o
 * JD-Core Version:    0.6.2
 */