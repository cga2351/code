package com.viber.voip.contacts.adapters;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.SectionIndexer;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.voip.R.id;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.contacts.a;
import com.viber.voip.contacts.ui.m;
import com.viber.voip.model.c;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.util.e.e;
import com.viber.voip.widget.AvatarWithInitialsView;

public abstract class g extends BaseAdapter
  implements SectionIndexer
{
  private static final Logger j = ViberEnv.getLogger();
  protected a a;
  protected f b;
  protected Context c;
  protected e d;
  protected com.viber.voip.util.e.f e;
  protected Resources f;
  protected boolean g;
  protected boolean h;
  protected boolean i;
  private String[] k = new String[1];

  public g(Context paramContext, boolean paramBoolean, a parama, LayoutInflater paramLayoutInflater)
  {
    this.k[0] = String.valueOf(b.i);
    this.f = paramContext.getResources();
    this.a = parama;
    this.c = paramContext;
    this.b = a(paramContext, paramLayoutInflater);
    this.d = e.a(paramContext);
    this.e = com.viber.voip.util.e.f.b(paramContext);
    this.h = paramBoolean;
    this.i = ViberApplication.getInstance().getEngine(false).getCallHandler().isLocalVideoAvailable();
  }

  protected f a(Context paramContext, LayoutInflater paramLayoutInflater)
  {
    return new f(paramContext, paramLayoutInflater);
  }

  protected String a()
  {
    return "";
  }

  protected void a(int paramInt, View paramView, c paramc)
  {
    a locala = (a)paramView.getTag();
    locala.p = paramc;
    String str = paramc.k();
    locala.s.setText(str);
    locala.s.setGravity(19);
    if (locala.r != null)
    {
      locala.r.a(paramc.m(), true);
      this.d.a(paramc.o(), locala.r, this.e);
    }
  }

  public void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }

  public void b(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }

  public c c(int paramInt)
  {
    return this.a.c(paramInt);
  }

  protected View d(int paramInt)
  {
    return this.b.a(paramInt);
  }

  public int getCount()
  {
    return this.a.getCount();
  }

  public long getItemId(int paramInt)
  {
    c localc = c(paramInt);
    if (localc != null)
      return localc.getId();
    return -1L;
  }

  public int getItemViewType(int paramInt)
  {
    return 0;
  }

  public int getPositionForSection(int paramInt)
  {
    return 0;
  }

  public int getSectionForPosition(int paramInt)
  {
    return 0;
  }

  public Object[] getSections()
  {
    return this.k;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int m = getItemViewType(paramInt);
    a locala = null;
    if (paramView != null)
    {
      boolean bool = paramView.getTag() instanceof a;
      locala = null;
      if (bool)
        locala = (a)paramView.getTag();
    }
    c localc = c(paramInt);
    if (locala == null)
    {
      paramView = d(m);
      locala = (a)paramView.getTag();
    }
    locala.a(localc);
    if (localc != null)
      a(paramInt, paramView, localc);
    return paramView;
  }

  public int getViewTypeCount()
  {
    return 4;
  }

  public static class a extends m
  {
    public final int a;
    public final RelativeLayout b;
    public final TextView c;
    public final View d;
    public final View e;
    public final View f;
    public final View g;
    public final TextView h;
    public final TextView i;
    public final TextView j;
    public final View k;
    public final View l;
    public final ImageView m;
    public final View n;
    public final View o;
    public c p;

    public a(View paramView, int paramInt)
    {
      super();
      this.a = paramInt;
      this.b = ((RelativeLayout)paramView.findViewById(R.id.root));
      this.c = ((TextView)paramView.findViewById(R.id.call_badge));
      this.d = paramView.findViewById(R.id.invite_button);
      this.k = paramView.findViewById(R.id.callButtonView);
      this.l = paramView.findViewById(R.id.videoCallButtonView);
      this.e = paramView.findViewById(R.id.header);
      this.f = paramView.findViewById(R.id.top_divider);
      this.g = paramView.findViewById(R.id.header_letter);
      this.h = ((TextView)paramView.findViewById(R.id.label));
      this.i = ((TextView)paramView.findViewById(R.id.letter));
      this.j = ((TextView)paramView.findViewById(R.id.count));
      this.m = ((ImageView)paramView.findViewById(R.id.check));
      this.n = paramView.findViewById(R.id.bottom_divider);
      this.o = this.e;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.adapters.g
 * JD-Core Version:    0.6.2
 */