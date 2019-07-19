package com.viber.voip.messages.conversation.ui.b;

import android.content.Context;
import android.os.Parcelable;
import android.text.Spanned;
import android.util.Base64;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.memberid.Member;
import com.viber.voip.messages.controller.publicaccount.d;
import com.viber.voip.messages.conversation.ui.az;
import com.viber.voip.messages.extensions.c;
import com.viber.voip.messages.extensions.ui.o;
import com.viber.voip.messages.m;
import com.viber.voip.messages.shopchat.OpenShopChatPanelData;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.messages.ui.expanel.ExpandablePanelLayout;
import com.viber.voip.messages.ui.input.MessageComposerInputManager;
import com.viber.voip.messages.ui.t;
import com.viber.voip.publicaccount.d.e;
import com.viber.voip.publicaccount.d.e.a;
import com.viber.voip.util.da;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class z
{
  private static final Logger a = ViberEnv.getLogger();
  private final o b;
  private final com.viber.common.b.b c;
  private final h d;
  private final com.viber.voip.messages.ui.c.b e;
  private final MessageComposerInputManager f;
  private final ai g;
  private final Context h;
  private final az i;
  private final d j;
  private final c k;
  private final t l;
  private final com.viber.voip.analytics.g m;
  private Map<String, String> n = new HashMap();
  private ExpandablePanelLayout o;
  private boolean p = false;
  private boolean q = false;
  private boolean r = true;
  private boolean s;
  private final List<aa> t = new ArrayList();
  private CharSequence u = "";

  public z(o paramo, com.viber.common.b.b paramb, h paramh, com.viber.voip.messages.ui.c.b paramb1, MessageComposerInputManager paramMessageComposerInputManager, ai paramai, Context paramContext, az paramaz, d paramd, c paramc, t paramt, com.viber.voip.analytics.g paramg, ExpandablePanelLayout paramExpandablePanelLayout)
  {
    this.b = paramo;
    this.c = paramb;
    this.d = paramh;
    this.e = paramb1;
    this.f = paramMessageComposerInputManager;
    this.g = paramai;
    this.h = paramContext;
    this.i = paramaz;
    this.j = paramd;
    this.k = paramc;
    this.l = paramt;
    this.m = paramg;
    this.o = paramExpandablePanelLayout;
  }

  private void c(int paramInt, boolean paramBoolean)
  {
    a(false);
    if (paramBoolean);
    for (int i1 = 8; ; i1 = 5)
    {
      this.b.a(paramInt, i1);
      k();
      return;
    }
  }

  public String a(String paramString)
  {
    String str = null;
    if (paramString != null)
      str = (String)this.n.get(paramString);
    if (str == null)
      str = e().toString();
    return str;
  }

  public void a()
  {
    int i1 = this.t.size();
    for (int i2 = 0; i2 < i1; i2++)
      ((aa)this.t.get(i2)).c();
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    this.d.a("stickers");
    c(paramInt, paramBoolean);
  }

  public void a(Parcelable paramParcelable)
  {
    this.f.a(paramParcelable);
  }

  public void a(aa paramaa)
  {
    this.t.add(paramaa);
  }

  public void a(OpenShopChatPanelData paramOpenShopChatPanelData)
  {
    int i1 = this.t.size();
    for (int i2 = 0; i2 < i1; i2++)
      ((aa)this.t.get(i2)).a(paramOpenShopChatPanelData);
  }

  public void a(CharSequence paramCharSequence)
  {
    int i1 = this.t.size();
    for (int i2 = 0; i2 < i1; i2++)
      ((aa)this.t.get(i2)).a(paramCharSequence);
  }

  public void a(CharSequence paramCharSequence, String paramString)
  {
    c(da.a(this.g, paramCharSequence, Base64.decode(paramString, 19), false, true, aj.b));
  }

  public void a(String paramString1, String paramString2)
  {
    if (paramString1 == null)
      return;
    this.n.put(paramString1, paramString2);
    this.j.d(paramString1);
  }

  public void a(boolean paramBoolean)
  {
    int i1 = this.t.size();
    for (int i2 = 0; i2 < i1; i2++)
      ((aa)this.t.get(i2)).c(paramBoolean);
  }

  public boolean a(Member paramMember)
  {
    return com.viber.voip.block.g.a(paramMember);
  }

  public boolean a(e.a parama)
  {
    return e.a(this.h, parama);
  }

  public boolean a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.b.b())
    {
      if ((paramBoolean2) || (this.b.c() != 2))
        this.b.a(paramBoolean1);
      return true;
    }
    return false;
  }

  public void b()
  {
    int i1 = this.t.size();
    for (int i2 = 0; i2 < i1; i2++)
      ((aa)this.t.get(i2)).n();
  }

  public void b(int paramInt, boolean paramBoolean)
  {
    this.f.a(paramInt, paramBoolean);
  }

  public void b(aa paramaa)
  {
    this.t.remove(paramaa);
  }

  public void b(CharSequence paramCharSequence)
  {
    this.u = paramCharSequence;
  }

  public void b(boolean paramBoolean)
  {
    int i1 = this.t.size();
    for (int i2 = 0; i2 < i1; i2++)
      ((aa)this.t.get(i2)).b(paramBoolean);
  }

  public void c(CharSequence paramCharSequence)
  {
    this.f.a(paramCharSequence);
  }

  public void c(boolean paramBoolean)
  {
    this.r = paramBoolean;
  }

  public boolean c()
  {
    return da.a(this.u);
  }

  public void d(boolean paramBoolean)
  {
    this.d.a("giphy");
    c(0, paramBoolean);
  }

  public boolean d()
  {
    return da.b(this.u);
  }

  public CharSequence e()
  {
    if (d())
      return "";
    return this.u;
  }

  public void e(boolean paramBoolean)
  {
    this.q = paramBoolean;
  }

  public String f()
  {
    return this.h.getString(R.string.user_engagement_activate_shift_key);
  }

  public void f(boolean paramBoolean)
  {
    this.p = paramBoolean;
  }

  public void g(boolean paramBoolean)
  {
    this.b.a(paramBoolean);
  }

  public boolean g()
  {
    return this.r;
  }

  public CharSequence h()
  {
    CharSequence localCharSequence = this.f.a();
    if ((localCharSequence instanceof Spanned))
      m.a((Spanned)localCharSequence);
    return localCharSequence;
  }

  public void h(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }

  public boolean i()
  {
    return this.i.a();
  }

  public boolean j()
  {
    return (this.b.b()) && (this.b.c() == 1);
  }

  public void k()
  {
    this.e.a();
  }

  public void l()
  {
    this.f.d();
  }

  public boolean m()
  {
    return this.q;
  }

  public boolean n()
  {
    return this.p;
  }

  public boolean o()
  {
    return this.b.b();
  }

  public int p()
  {
    return this.b.c();
  }

  public boolean q()
  {
    return this.c.d();
  }

  public boolean r()
  {
    return this.f.c();
  }

  public Parcelable s()
  {
    return this.f.b();
  }

  public void t()
  {
    this.e.b();
  }

  public void u()
  {
    if (!this.n.isEmpty())
    {
      this.n.clear();
      this.j.a();
    }
  }

  public boolean v()
  {
    return this.l.g();
  }

  public boolean w()
  {
    return this.s;
  }

  public boolean x()
  {
    boolean bool1 = this.b.b();
    boolean bool2 = this.o.d();
    boolean bool3 = this.o.e();
    return (bool1) || (bool2) || (bool3);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.b.z
 * JD-Core Version:    0.6.2
 */