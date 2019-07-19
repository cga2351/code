package com.viber.voip.messages.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.bot.b;
import com.viber.voip.bot.item.a;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.BotReplyConfig;
import com.viber.voip.flatbuffers.model.msginfo.publicaccount.bot.ReplyButton;
import com.viber.voip.messages.adapters.BotKeyboardView;
import com.viber.voip.messages.adapters.BotKeyboardView.a;
import com.viber.voip.ui.be;
import com.viber.voip.util.da;

public class t
  implements a, BotKeyboardView.a, ao.a
{
  private a a;
  protected final Context b;
  BotKeyboardView c;
  protected View d;
  protected ICdrController e;
  private BotReplyConfig f;
  private String g;
  private BotKeyboardView.a h;
  private be i;
  private int j;
  private int k = 5;

  public t(Context paramContext)
  {
    this(paramContext, 0, null, null, null);
  }

  public t(Context paramContext, int paramInt, be parambe, ICdrController paramICdrController, BotKeyboardView.a parama)
  {
    this.b = paramContext;
    this.j = paramInt;
    this.i = parambe;
    this.h = parama;
    this.e = paramICdrController;
  }

  private void a(boolean paramBoolean)
  {
    if (this.c == null);
    do
    {
      return;
      if (this.f != null)
      {
        d();
        this.c.a(this.f, paramBoolean);
        return;
      }
    }
    while (this.i == null);
    d();
    this.c.addView(this.i.b(k()), 2);
    this.c.a();
  }

  private void d()
  {
    if (this.d == null)
      return;
    if (this.i != null)
      this.i.c(this.d);
    if (this.d != null);
    for (ViewGroup localViewGroup = (ViewGroup)this.d.getParent(); ; localViewGroup = null)
    {
      if (localViewGroup != null)
        localViewGroup.removeView(this.d);
      this.d = null;
      return;
    }
  }

  public View a(View paramView)
  {
    if (paramView == null)
    {
      this.c = new BotKeyboardView(this.b);
      b();
      paramView = this.c;
      a(false);
    }
    return paramView;
  }

  public void a()
  {
    this.f = null;
  }

  protected void a(int paramInt)
  {
    if (this.e != null)
      if (3 != this.j)
        break label39;
    label39: for (int m = 2; ; m = 1)
    {
      this.e.handleReportInstantKeyboardOpen(paramInt, null, 1, m, this.c.getPublicAccountId());
      return;
    }
  }

  public void a(a parama)
  {
    this.a = parama;
    if (this.c != null)
      this.c.setBotKeyboardActionListener(this.a);
  }

  public void a(BotReplyConfig paramBotReplyConfig)
  {
    a(paramBotReplyConfig, false);
  }

  public void a(BotReplyConfig paramBotReplyConfig, boolean paramBoolean)
  {
    if ((this.f == null) || (!this.f.equals(paramBotReplyConfig)))
    {
      b.a().b("KEYBOARD_");
      this.f = paramBotReplyConfig;
      a(paramBoolean);
    }
  }

  public void a(String paramString)
  {
    this.g = paramString;
    if (this.c != null)
      this.c.setPublicAccountId(paramString);
  }

  public void a(String paramString, BotReplyConfig paramBotReplyConfig, ReplyButton paramReplyButton)
  {
    if (this.a != null)
      this.a.a(paramString, this.f, paramReplyButton);
  }

  public void a(String paramString1, String paramString2, BotReplyConfig paramBotReplyConfig, boolean paramBoolean1, boolean paramBoolean2)
  {
    a(paramBotReplyConfig, paramBoolean1);
    if (this.h != null)
      this.h.a(paramString1, paramString2, paramBotReplyConfig, paramBoolean1, paramBoolean2);
  }

  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.h != null)
      this.h.a(paramString1, paramString2, paramBoolean);
  }

  protected void b()
  {
    this.c.a(this.j);
    this.c.setBotKeyboardActionListener(this);
    this.c.setKeyboardStateListener(this);
    String str = c();
    if (!da.a(str))
      this.c.setPublicAccountId(str);
  }

  public void b(int paramInt)
  {
    this.k = paramInt;
  }

  public String c()
  {
    return da.h(this.g);
  }

  public int e()
  {
    return this.k;
  }

  public void f()
  {
    this.f = null;
  }

  public boolean g()
  {
    return this.f != null;
  }

  public void h()
  {
    ap.a(this);
  }

  public void i()
  {
    ap.b(this);
  }

  public void j()
  {
    ap.c(this);
  }

  protected final View k()
  {
    if (this.d == null)
      this.d = this.i.a();
    return this.d;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.t
 * JD-Core Version:    0.6.2
 */