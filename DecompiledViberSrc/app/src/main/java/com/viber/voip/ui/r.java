package com.viber.voip.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnTouchListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.jni.Engine;
import com.viber.voip.R.attr;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.calls.ui.ac.a;
import com.viber.voip.calls.ui.u;
import com.viber.voip.model.AggregatedCall;
import com.viber.voip.phone.PhoneUtils;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.registration.ao;
import com.viber.voip.util.dc;
import com.viber.voip.util.dj;
import com.viber.voip.util.dr;
import com.viber.voip.util.e.e;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.a;
import com.viber.voip.util.e.f.b;
import com.viber.voip.widget.AvatarWithInitialsView;

public class r extends h
{
  private View a;
  private u<AvatarWithInitialsView> b;
  private final boolean c = ao.f();
  private boolean d;
  private e e;
  private f f;

  private void a(View paramView, View.OnClickListener paramOnClickListener, ac.a<AggregatedCall> parama, View.OnCreateContextMenuListener paramOnCreateContextMenuListener)
  {
    Context localContext = paramView.getContext();
    this.a = paramView.findViewById(R.id.add_to_contacts_view);
    this.a.setVisibility(8);
    this.b = new u(this.a);
    this.b.a(parama);
    this.b.a.setVisibility(8);
    if (this.c)
      this.b.b.setVisibility(8);
    while (true)
    {
      this.b.d.setOnClickListener(paramOnClickListener);
      this.b.d.setBackgroundResource(dc.a(paramView.getContext(), R.attr.list_selector));
      this.b.g.setOnCreateContextMenuListener(paramOnCreateContextMenuListener);
      int i = dc.a(localContext, R.attr.contactDefaultPhoto);
      this.e = e.a(localContext);
      this.f = new f.a().b(Integer.valueOf(i)).a(f.b.b).c();
      this.e.a(null, (ImageView)this.b.e, this.f);
      this.b.c.setVisibility(8);
      this.d = ViberApplication.getInstance().getEngine(false).getCallHandler().isLocalVideoAvailable();
      return;
      this.b.b.setVisibility(0);
      this.b.b.setText("+ " + localContext.getString(R.string.add_to_contacts));
      this.b.b.setTextColor(dc.d(localContext, R.attr.keypadAddContactTextColor));
      this.b.b.setCompoundDrawablePadding(0);
      this.b.b.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
    }
  }

  public void a(String paramString)
  {
    if (!e())
      return;
    if (!TextUtils.isEmpty(paramString));
    for (boolean bool = true; ; bool = false)
    {
      b(paramString);
      dj.b(this.a, bool);
      return;
    }
  }

  public void a(boolean paramBoolean, String paramString)
  {
    if (!e())
      return;
    if (paramBoolean)
    {
      d(true);
      this.a.setVisibility(8);
      return;
    }
    d(false);
    a(paramString);
  }

  public boolean a(View paramView, View.OnClickListener paramOnClickListener, ac.a<AggregatedCall> parama, View.OnCreateContextMenuListener paramOnCreateContextMenuListener, View.OnTouchListener paramOnTouchListener)
  {
    if (!super.a(paramView))
      return false;
    paramView.findViewById(16908292).setOnTouchListener(paramOnTouchListener);
    a(paramView, paramOnClickListener, parama, paramOnCreateContextMenuListener);
    return true;
  }

  public void b(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (e()))
    {
      String str = PhoneUtils.formatPhoneNumber(paramString);
      if ((!"-2".equals(str)) && (!"-1".equals(str)) && (this.b != null))
      {
        this.b.f.setText(str);
        if (this.d)
          dr.a(str, new s(this));
      }
    }
  }

  public void d(boolean paramBoolean)
  {
    super.d(paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.r
 * JD-Core Version:    0.6.2
 */