package com.viber.voip.messages.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.cd;
import com.viber.voip.messages.controller.cd.a;
import com.viber.voip.messages.o;
import com.viber.voip.messages.o.a;
import com.viber.voip.util.dj;

public class PinDialogLayout extends RelativeLayout
{
  private Context a;
  private LayoutInflater b;
  private k c;
  private b d;
  private o e;
  private ViewGroup f;
  private cd g;
  private boolean h;
  private int i;
  private int j;
  private String k;
  private String l;
  private View m;
  private View n;
  private View o;
  private View.OnClickListener p = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      PinDialogLayout.a(PinDialogLayout.this).onClick(PinDialogLayout.this);
      Intent localIntent = new Intent("com.viber.voip.action.HIDDEN_CHATS");
      localIntent.putExtra("inner_screen", (byte)1);
      localIntent.putExtra("selected_item", R.string.pref_category_privacy_key);
      localIntent.setFlags(67108864);
      PinDialogLayout.b(PinDialogLayout.this).startActivity(localIntent);
    }
  };
  private View.OnClickListener q = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      PinDialogLayout.c(PinDialogLayout.this);
      PinDialogLayout.d(PinDialogLayout.this).performClick();
    }
  };
  private View.OnClickListener r = new View.OnClickListener()
  {
    public void onClick(View paramAnonymousView)
    {
      if (PinDialogLayout.e(PinDialogLayout.this).d() == o.a.g)
        PinDialogLayout.f(PinDialogLayout.this).b();
      PinDialogLayout.c(PinDialogLayout.this);
      PinDialogLayout.g(PinDialogLayout.this).performClick();
    }
  };
  private a s = new a()
  {
    public void a(o paramAnonymouso)
    {
      PinDialogLayout.a(PinDialogLayout.this, paramAnonymouso);
    }

    public void a(String paramAnonymousString)
    {
      PinDialogLayout.a(PinDialogLayout.this, paramAnonymousString);
    }
  };

  public PinDialogLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public PinDialogLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public PinDialogLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private o a(o.a parama)
  {
    if (parama == null)
      return null;
    o localo = new o(parama);
    switch (6.a[parama.ordinal()])
    {
    default:
    case 5:
    case 1:
    case 2:
    case 4:
    case 3:
    case 6:
    case 7:
    }
    while (true)
    {
      localo.c(this.k);
      return localo;
      localo.a(o.a.b);
      localo.a(R.drawable.hidden_chat_eye_icon);
      continue;
      localo.a(o.a.e);
      localo.a(R.string.hidden_chat_activity_enter_pin_hint, R.string.hidden_chat_activity_re_enter_pin_hint_clickable_span_text);
      localo.d(R.string.hidden_chat_activity_enter_pin_note);
      localo.c(this.p);
      continue;
      localo.b(R.string.hidden_chat_activity_re_enter_existing_pin_header);
      localo.a(o.a.e);
      continue;
      localo.a(R.string.hidden_chat_activity_validate_pin_hint, R.string.hidden_chat_activity_re_enter_pin_hint_clickable_span_text);
      localo.c(this.p);
      localo.d(R.string.hidden_chat_activity_enter_pin_note);
      continue;
      localo.a(o.a.f);
      continue;
      localo.a(null);
      localo.b(getResources().getString(R.string.dialog_button_yes).toUpperCase());
      continue;
      localo.a(this.l);
    }
  }

  private void a()
  {
    final o.a locala = o.a.a(this.i);
    if (locala.a())
    {
      this.g.a(new cd.a()
      {
        public void a(final String paramAnonymousString)
        {
          av.a(av.e.a).post(new Runnable()
          {
            public void run()
            {
              PinDialogLayout.a(PinDialogLayout.this, PinDialogLayout.1.this.a, paramAnonymousString);
            }
          });
        }
      });
      return;
    }
    b(a(locala));
  }

  private void a(Context paramContext)
  {
    this.a = paramContext;
    this.b = LayoutInflater.from(paramContext);
    this.g = ViberApplication.getInstance().getMessagesManager().g();
  }

  private void a(o.a parama, String paramString)
  {
    o localo;
    if ((paramString == null) || (paramString.length() == 0))
      localo = a(o.a.a);
    while (true)
    {
      b(localo);
      return;
      this.l = paramString;
      if (o.a.a == parama)
      {
        localo = a(o.a.c);
        localo.a(o.a.b);
      }
      else
      {
        localo = a(parama);
      }
    }
  }

  private void a(o paramo)
  {
    if (paramo == null);
    while (true)
    {
      return;
      this.k = "";
      o.a locala = paramo.d();
      o localo = a(paramo.f());
      switch (6.a[locala.ordinal()])
      {
      default:
      case 1:
      case 2:
      case 3:
      case 4:
      }
      while (localo != null)
      {
        b(localo);
        return;
        this.l = paramo.e();
        continue;
        this.h = true;
        localo.b(R.string.hidden_chat_activity_enter_new_pin_header);
        if (!this.l.equals(paramo.e()))
        {
          c();
          continue;
          if (this.l.equals(paramo.e()))
          {
            b();
            localo.a(this.l);
            dj.c(getFocusedChild());
            if (this.h)
              d();
            else
              this.o.performClick();
          }
          else
          {
            localo = a(locala);
            localo.a(paramo.f());
            localo.c(R.string.hidden_chat_activity_pin_doesnt_match);
            this.j = (1 + this.j);
            continue;
            String str = paramo.e();
            if ((str != null) && (str.length() == 4))
              if (this.l.equals(paramo.e()))
                d();
              else
                c();
          }
        }
      }
    }
  }

  private void b()
  {
    this.g.a(this.l);
  }

  private void b(o paramo)
  {
    if (this.f == null)
      this.f = ((ViewGroup)findViewById(R.id.dialog_content_container));
    this.e = paramo;
    this.f.removeAllViews();
    switch (6.a[paramo.d().ordinal()])
    {
    default:
    case 5:
    case 1:
    case 4:
    case 2:
    case 3:
    case 7:
    case 6:
    }
    while (true)
    {
      this.e.a(this.s);
      this.e.a(this.q);
      this.e.b(this.r);
      this.m = findViewById(R.id.btn_fake_close);
      this.n = findViewById(R.id.btn_fake_confirm);
      this.o = findViewById(R.id.btn_fake_neutral);
      this.c.a(this.e);
      return;
      this.c = new cc(this.b.inflate(R.layout.hidden_chat_welcome_layout, this.f, true));
      continue;
      this.c = new ca(this.b.inflate(R.layout.hidden_chat_set_pin_layout, this.f, true));
      continue;
      this.c = new ca(this.b.inflate(R.layout.hidden_chat_set_pin_layout, this.f, true));
      continue;
      this.c = new bz(this.b.inflate(R.layout.hidden_chat_confirm_pin_layout, this.f, true));
      continue;
      this.c = new cb(this.b.inflate(R.layout.hidden_chat_setted_layout, this.f, true));
      continue;
      this.c = new cc(this.b.inflate(R.layout.hidden_chat_welcome_layout, this.f, true));
    }
  }

  private void c()
  {
    if (this.q != null)
      this.q.onClick(this);
  }

  private void d()
  {
    if (this.r != null)
      this.r.onClick(this);
  }

  private void e()
  {
    View localView = getFocusedChild();
    if (localView != null)
      dj.c(localView.findFocus());
  }

  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.i = paramInt;
    this.k = paramString1;
    this.l = paramString2;
  }

  public o getScreen()
  {
    if (this.e != null)
    {
      this.e.a(this.l);
      this.e.c(this.k);
    }
    return this.e;
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if (this.e != null)
    {
      b(this.e);
      return;
    }
    a();
  }

  protected void onDetachedFromWindow()
  {
    if (this.d != null)
      this.d.a();
    super.onDetachedFromWindow();
  }

  public void setOnDetachListener(b paramb)
  {
    this.d = paramb;
  }

  public static abstract interface a
  {
    public abstract void a(o paramo);

    public abstract void a(String paramString);
  }

  public static abstract interface b
  {
    public abstract void a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.PinDialogLayout
 * JD-Core Version:    0.6.2
 */