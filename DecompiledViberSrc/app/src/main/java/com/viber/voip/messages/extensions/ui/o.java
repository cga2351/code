package com.viber.voip.messages.extensions.ui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.EditText;
import android.widget.TextView;
import com.slidingmenu.lib.SlidingMenu;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.integer;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.extensions.k.a;
import com.viber.voip.messages.extensions.model.a.a;
import com.viber.voip.messages.extensions.model.d;
import com.viber.voip.messages.ui.d.d.a;
import com.viber.voip.messages.ui.x.b;
import com.viber.voip.messages.ui.x.d;
import com.viber.voip.settings.d.n;
import com.viber.voip.stickers.entity.Sticker;
import com.viber.voip.stickers.i;
import com.viber.voip.util.cj;
import com.viber.voip.util.da;
import com.viber.voip.util.dj;
import java.util.ArrayList;
import java.util.List;

public final class o
  implements l.a, com.viber.voip.messages.ui.c.c
{
  private static final Logger a = ViberEnv.getLogger();
  private boolean A = false;
  private final Runnable B = new Runnable()
  {
    public void run()
    {
      dj.b(o.b(o.this), false);
    }
  };
  private final TextWatcher C = new TextWatcher()
  {
    public void afterTextChanged(Editable paramAnonymousEditable)
    {
    }

    public void beforeTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
    }

    public void onTextChanged(CharSequence paramAnonymousCharSequence, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      String str = com.viber.voip.messages.extensions.model.a.a(paramAnonymousCharSequence.toString());
      o.d(o.this).a(o.c(o.this), str);
    }
  };
  private final m.b D = new m.b()
  {
    public void a()
    {
      o.a(o.this, true);
    }

    public void a(String paramAnonymousString, long paramAnonymousLong)
    {
      o.a(o.this, paramAnonymousString, paramAnonymousLong);
    }
  };
  private LayoutInflater b;
  private final Context c;
  private final View d;
  private final EditText e;
  private final x.d f;
  private final d.a g;
  private final com.viber.voip.messages.extensions.a.a h;
  private final a i;
  private final n j;
  private m k;
  private com.viber.voip.messages.extensions.model.a[] l;
  private View m;
  private TextView n;
  private RecyclerView o;
  private l p;
  private RecyclerView.ItemDecoration q;
  private Handler r;
  private com.viber.voip.messages.extensions.k s;
  private Runnable t;
  private String u;
  private a.a v;
  private String w;
  private final ICdrController x;
  private long y = 0L;
  private boolean z;

  public o(Context paramContext, EditText paramEditText, x.b paramb, d.a parama, n paramn, a parama1, View paramView, LayoutInflater paramLayoutInflater)
  {
    this.f = paramb;
    this.g = parama;
    this.i = parama1;
    this.d = paramView;
    this.c = paramContext;
    this.b = paramLayoutInflater;
    this.e = paramEditText;
    this.r = av.a(av.e.a);
    this.h = ViberApplication.getInstance().getMessagesManager().j();
    this.x = ViberApplication.getInstance().getEngine(false).getCdrController();
    this.j = paramn;
    this.k = this.j.a(0);
  }

  private com.viber.voip.messages.extensions.model.a a(String paramString)
  {
    for (com.viber.voip.messages.extensions.model.a locala : m())
      if (locala.a().equals(paramString))
        return locala;
    return null;
  }

  private void a(int paramInt)
  {
    if (this.v != null)
      this.x.handleReportInstantKeyboardOpen(paramInt, this.v.a(), this.v.b(), 2, null);
  }

  private void a(List<d> paramList)
  {
    h();
    n();
    boolean bool = cj.b(this.c);
    if ((bool) && (!paramList.isEmpty()))
    {
      com.viber.voip.util.j.a.a.a(i(), 0);
      dj.b(i(), true);
    }
    while (!bool)
    {
      k().setText(R.string.keyboard_extension_no_suggestions_due_to_connection);
      dj.b(k(), true);
      return;
      dj.b(i(), false);
    }
    if (paramList.isEmpty())
    {
      k().setText(R.string.keyboard_extension_no_results);
      dj.b(k(), true);
      return;
    }
    dj.b(k(), false);
  }

  private void a(List<d> paramList, boolean paramBoolean)
  {
    this.r.removeCallbacks(g());
    l locall = l();
    locall.a(paramList);
    locall.notifyDataSetChanged();
    a(paramList);
  }

  private boolean a(String paramString, long paramLong)
  {
    if (this.u == null);
    com.viber.voip.messages.extensions.model.a locala;
    do
    {
      return false;
      if ((this.v == null) || (!this.v.c().equals(this.u)))
      {
        this.r.removeCallbacks(g());
        this.r.postDelayed(g(), 100L);
      }
      locala = a(this.u);
    }
    while (locala == null);
    com.viber.voip.messages.extensions.k localk = f();
    this.v = locala.c();
    this.w = paramString;
    localk.a(locala, paramString);
    this.r.removeCallbacks(localk);
    this.r.postDelayed(localk, paramLong);
    return true;
  }

  private void b(String paramString)
  {
    if (this.u != null)
      com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.story.g.d(Boolean.TRUE));
    if (this.v != null)
      this.x.handleReportShiftKeyMessageSent(this.v.a(), this.v.b(), paramString, da.e(this.w), null);
  }

  private void b(boolean paramBoolean)
  {
    this.e.removeTextChangedListener(this.C);
    c(paramBoolean);
  }

  private void c(boolean paramBoolean)
  {
    e(false);
    d(paramBoolean);
    this.v = null;
    if (this.s != null)
    {
      this.r.removeCallbacks(g());
      this.r.removeCallbacks(this.s);
      this.s.a();
    }
  }

  private void d(boolean paramBoolean)
  {
    this.i.a(false);
    if (paramBoolean)
    {
      this.B.run();
      return;
    }
    this.r.removeCallbacks(this.B);
    this.r.postDelayed(this.B, 500L);
  }

  private void e()
  {
    this.e.removeTextChangedListener(this.C);
    this.e.addTextChangedListener(this.C);
    String str = com.viber.voip.messages.extensions.model.a.a(this.e.getText().toString());
    this.k.b(this.D, str);
  }

  private void e(boolean paramBoolean)
  {
    if ((this.v != null) && (this.A))
    {
      this.A = false;
      ICdrController localICdrController = this.x;
      String str1 = this.v.a();
      int i1 = this.v.b();
      String str2 = da.e(this.w);
      int i2 = 0;
      if (paramBoolean)
        i2 = 1;
      localICdrController.handleReportShiftKeySearch(str1, i1, str2, i2, null);
    }
  }

  private com.viber.voip.messages.extensions.k f()
  {
    if (this.s == null)
      this.s = new com.viber.voip.messages.extensions.k(new k.a()
      {
        public void a(List<d> paramAnonymousList)
        {
          o.a(o.this, paramAnonymousList, false);
        }
      }
      , this.r);
    return this.s;
  }

  private Runnable g()
  {
    if (this.t == null)
      this.t = new Runnable()
      {
        public void run()
        {
          o.a(o.this);
        }
      };
    return this.t;
  }

  private View h()
  {
    if (this.m == null)
    {
      this.m = ((ViewStub)this.d.findViewById(R.id.keyboard_extension_suggestions_stub)).inflate();
      View localView = this.d.getRootView().findViewById(R.id.conversation_sliding_view);
      if ((localView != null) && ((localView instanceof SlidingMenu)))
        ((SlidingMenu)localView).a(this.m);
    }
    return this.m;
  }

  private RecyclerView i()
  {
    if (this.o == null)
    {
      this.o = ((RecyclerView)h().findViewById(R.id.keyboard_extension_suggestions_items));
      this.o.setAdapter(l());
      this.o.addItemDecoration(j());
    }
    return this.o;
  }

  private RecyclerView.ItemDecoration j()
  {
    if (this.q == null)
      this.q = new com.viber.voip.widget.a.c(this.c.getResources().getDimensionPixelOffset(R.dimen.keyboard_extension_suggestions_divider));
    return this.q;
  }

  private TextView k()
  {
    if (this.n == null)
      this.n = ((TextView)h().findViewById(R.id.keyboard_extension_no_suggestions_message));
    return this.n;
  }

  private l l()
  {
    if (this.p == null)
      this.p = new l(this, this.b);
    return this.p;
  }

  private com.viber.voip.messages.extensions.model.a[] m()
  {
    if (this.l == null)
      this.l = this.h.a();
    return this.l;
  }

  private void n()
  {
    this.i.a(true);
    this.r.removeCallbacks(this.B);
    dj.b(this.m, true);
  }

  private void o()
  {
    int i1 = this.c.getResources().getInteger(R.integer.chat_ex_loading_empty_views_number);
    ArrayList localArrayList = new ArrayList(i1);
    for (int i2 = 0; i2 < i1; i2++)
      localArrayList.add(d.a());
    a(localArrayList, true);
  }

  private void p()
  {
    if (this.s != null)
      this.s.b();
  }

  private Bundle q()
  {
    if (this.v == null)
      return null;
    Bundle localBundle = new Bundle(2);
    localBundle.putString("keyboard_extension_active_trigger", this.v.a());
    localBundle.putString("keyboard_extension_activation_source", "shiftkey tab");
    return localBundle;
  }

  public void a()
  {
    a(true);
    p();
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.u = d.n.c.d();
    this.z = true;
    this.k = this.j.a(paramInt1);
    this.A = true;
    e();
    a(paramInt2);
  }

  public void a(View paramView, d paramd)
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.y;
    if ((l2 >= 0L) && (l2 <= 500L))
      return;
    this.y = l1;
    e(true);
    if ((paramd.j()) && (this.g != null))
    {
      Sticker localSticker = i.a().u(paramd.k());
      this.g.a(localSticker, true, true, q());
      b(String.valueOf(paramd.k()));
    }
    while (true)
    {
      this.B.run();
      return;
      if (this.f != null)
      {
        this.f.a(paramd, q());
        b(paramd.l());
      }
    }
  }

  public void a(boolean paramBoolean)
  {
    this.z = false;
    b(paramBoolean);
    this.k = this.j.a(0);
  }

  public boolean b()
  {
    return this.z;
  }

  public int c()
  {
    return this.k.a();
  }

  public int d()
  {
    if (!b())
      return 0;
    switch (c())
    {
    default:
      return 0;
    case 0:
      return R.string.keyboard_extension_hint_text_giphy;
    case 1:
    }
    return R.string.keyboard_extension_hint_text_sticker;
  }

  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.ui.o
 * JD-Core Version:    0.6.2
 */