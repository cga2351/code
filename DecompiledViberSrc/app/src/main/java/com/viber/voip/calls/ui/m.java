package com.viber.voip.calls.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.viber.jni.Engine;
import com.viber.voip.ViberApplication;
import com.viber.voip.flatbuffers.model.conference.ConferenceInfo;
import com.viber.voip.phone.call.CallHandler;

public abstract class m<M extends com.viber.voip.model.d> extends BaseAdapter
  implements ac.a<M>
{
  protected Context a;
  protected LayoutInflater b;
  protected final com.viber.provider.d c;
  protected boolean d;
  protected boolean e;
  protected a f;

  public m(Context paramContext, com.viber.provider.d paramd)
  {
    this.a = paramContext;
    this.b = ((LayoutInflater)this.a.getSystemService("layout_inflater"));
    this.c = paramd;
    this.e = ViberApplication.isTablet(paramContext);
    this.d = ViberApplication.getInstance().getEngine(false).getCallHandler().isLocalVideoAvailable();
  }

  public abstract View a(ViewGroup paramViewGroup, int paramInt);

  public M a(int paramInt)
  {
    return (com.viber.voip.model.d)this.c.b(paramInt);
  }

  public abstract void a(View paramView, M paramM, int paramInt);

  public void a(a parama)
  {
    this.f = parama;
  }

  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }

  public int getCount()
  {
    if (this.c == null)
      return 0;
    return this.c.getCount();
  }

  public long getItemId(int paramInt)
  {
    return paramInt;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || (!(paramView.getTag() instanceof ac)))
      paramView = a(paramViewGroup, paramInt);
    a(paramView, a(paramInt), paramInt);
    return paramView;
  }

  public static abstract interface a
  {
    public abstract void a(ConferenceInfo paramConferenceInfo);

    public abstract void a(String paramString, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.m
 * JD-Core Version:    0.6.2
 */