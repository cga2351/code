package com.viber.voip.publicaccount.ui.holders;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.viber.common.dialogs.a.a;
import com.viber.common.dialogs.m;
import com.viber.common.dialogs.m.c;
import com.viber.common.dialogs.z;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.ap;
import com.viber.voip.ap.a;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.bv.t;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.k;
import com.viber.voip.model.entity.h;
import com.viber.voip.model.entity.r;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.ui.dialogs.DialogCode;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.util.cj;
import java.util.Map;

public class e
  implements m.c, c
{
  private static final Logger a = ViberEnv.getLogger();
  private final Fragment b;
  private final a c;
  private final com.viber.voip.publicaccount.ui.holders.general.create.c d;
  private final com.viber.voip.publicaccount.ui.holders.icon.a e;
  private final com.viber.voip.publicaccount.ui.holders.restriction.age.a f;
  private boolean g;
  private boolean h;
  private boolean i;
  private TextView j;
  private final Handler k;
  private final GroupController l;
  private final bv.t m;
  private int n = -1;
  private String o;
  private final o p;
  private String q;
  private long r;
  private long s;
  private String t;
  private d u = new d()
  {
    public void V_()
    {
    }

    public void a(c paramAnonymousc, boolean paramAnonymousBoolean)
    {
      e.a(e.this, paramAnonymousBoolean);
      e.d(e.this);
    }
  };
  private d v = new d()
  {
    public void V_()
    {
    }

    public void a(c paramAnonymousc, boolean paramAnonymousBoolean)
    {
      e.b(e.this, paramAnonymousBoolean);
      e.d(e.this);
    }
  };

  public e(Fragment paramFragment, a parama)
  {
    this.b = paramFragment;
    this.c = parama;
    this.d = new com.viber.voip.publicaccount.ui.holders.general.create.c(paramFragment, this.u);
    this.e = new com.viber.voip.publicaccount.ui.holders.icon.a(this.b, this.v, false);
    this.f = new com.viber.voip.publicaccount.ui.holders.restriction.age.a(true);
    this.k = av.a(av.e.a);
    this.l = ViberApplication.getInstance().getMessagesManager().d();
    this.p = o.a();
    this.m = new bv.t()
    {
      public void onPublicGroupCreateError(final int paramAnonymousInt1, final int paramAnonymousInt2)
      {
        e.c(e.this).post(new Runnable()
        {
          public void run()
          {
            if ((paramAnonymousInt1 == e.a(e.this)) && (e.b(e.this) != null))
              e.a(e.this, paramAnonymousInt2);
          }
        });
      }

      public void onPublicGroupCreated(final int paramAnonymousInt, final long paramAnonymousLong1, long paramAnonymousLong2, final String paramAnonymousString1, Map<String, Integer> paramAnonymousMap, String paramAnonymousString2, String paramAnonymousString3)
      {
        e.c(e.this).post(new Runnable()
        {
          public void run()
          {
            if ((paramAnonymousInt == e.a(e.this)) && (e.b(e.this) != null))
              e.a(e.this, paramAnonymousLong1, paramAnonymousString1, this.d, this.e);
          }
        });
      }
    };
  }

  private void a(int paramInt)
  {
    this.n = -1;
    z.b(this.b, DialogCode.D_PROGRESS);
    if ((9 == paramInt) && (!this.b.isDetached()))
      com.viber.voip.publicaccount.d.e.a(this.b);
  }

  private void a(long paramLong1, long paramLong2, String paramString1, String paramString2)
  {
    this.n = -1;
    this.s = paramLong1;
    this.q = paramString1;
    this.r = paramLong2;
    this.t = paramString2;
    z.b(this.b, DialogCode.D_PROGRESS);
    this.c.V_();
  }

  private void a(TextView paramTextView)
  {
    paramTextView.setText(Html.fromHtml(this.b.getString(R.string.create_public_account_terms_and_policy)), TextView.BufferType.SPANNABLE);
    paramTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }

  private void e()
  {
    if ((this.h) && (this.i));
    for (boolean bool = true; ; bool = false)
    {
      if (bool != this.g)
      {
        this.g = bool;
        this.c.a(this, this.g);
      }
      return;
    }
  }

  private void f()
  {
    SpannableString localSpannableString = new SpannableString(this.b.getString(R.string.learn_more));
    localSpannableString.setSpan(new UnderlineSpan(), 0, localSpannableString.length(), 0);
    this.j.setText(localSpannableString);
    this.j.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        String str = ap.c().an;
        GenericWebViewActivity.a(e.f(e.this).getActivity(), str, e.f(e.this).getString(R.string.vibes));
      }
    });
  }

  public void a()
  {
    this.d.a();
    this.e.a();
    this.f.a();
    if (this.j != null)
    {
      this.j.setOnClickListener(null);
      this.j = null;
    }
  }

  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!this.d.a(paramInt1, paramInt2, paramIntent))
      this.e.a(paramInt1, paramInt2, paramIntent);
  }

  public void a(Bundle paramBundle)
  {
    if (this.n != -1)
      paramBundle.putInt("pa_create_sequence", this.n);
    if (this.o != null)
      paramBundle.putString("pa_group_uri", this.o);
    if (this.s > 0L)
      paramBundle.putLong("conversation_id", this.s);
    if (this.q != null)
      paramBundle.putString("pa_id", this.q);
    if (this.t != null)
      paramBundle.putString("pa_auth_token", this.t);
    paramBundle.putLong("pa_group_id", this.r);
    paramBundle.putBoolean("pa_all_holders_valid", this.g);
    paramBundle.putBoolean("pa_general_fields_holder_valid", this.h);
    paramBundle.putBoolean("pa_icon_holder_valid", this.i);
    this.d.a(paramBundle);
    this.f.a(paramBundle);
    this.e.a(paramBundle);
  }

  public void a(View paramView)
  {
    this.d.a(paramView.findViewById(R.id.general_fields));
    this.e.a(paramView.findViewById(R.id.icon));
    this.f.a(paramView.findViewById(R.id.prefs_container));
    this.j = ((TextView)paramView.findViewById(R.id.btn_learn_more));
    f();
    a((TextView)paramView.findViewById(R.id.disclamer));
  }

  public void a(PublicAccount paramPublicAccount)
  {
    this.e.a(paramPublicAccount);
    this.d.a(paramPublicAccount);
    this.f.a(paramPublicAccount);
  }

  public void b()
  {
    if (this.n != -1)
    {
      this.p.a(this.m);
      if (!this.l.a(this.n))
        av.a(av.e.d).post(new Runnable()
        {
          public void run()
          {
            ab localab = ab.b();
            final r localr = localab.c(e.e(e.this));
            if (localr != null);
            for (final h localh = localab.b(localr.a()); ; localh = null)
            {
              e.c(e.this).post(new Runnable()
              {
                public void run()
                {
                  if ((e.b(e.this) != null) && (e.a(e.this) != -1))
                  {
                    if (localh != null)
                      e.a(e.this, localh.getId(), localh.k(), localr.b(), localr.o());
                  }
                  else
                    return;
                  e.a(e.this, 1);
                }
              });
              return;
            }
          }
        });
    }
  }

  public void b(Bundle paramBundle)
  {
    this.n = paramBundle.getInt("pa_create_sequence", -1);
    this.o = paramBundle.getString("pa_group_uri");
    this.s = paramBundle.getLong("conversation_id");
    this.q = paramBundle.getString("pa_id");
    this.r = paramBundle.getLong("pa_group_id");
    this.t = paramBundle.getString("pa_auth_token");
    this.g = paramBundle.getBoolean("pa_all_holders_valid", false);
    this.h = paramBundle.getBoolean("pa_general_fields_holder_valid", false);
    this.i = paramBundle.getBoolean("pa_icon_holder_valid", false);
    this.d.b(paramBundle);
    this.f.b(paramBundle);
    this.e.b(paramBundle);
  }

  public void b(PublicAccount paramPublicAccount)
  {
    paramPublicAccount.setConversationId(this.s);
    paramPublicAccount.setPublicAccountId(this.q);
    paramPublicAccount.setGroupID(this.r);
    paramPublicAccount.setAuthToken(this.t);
    this.e.b(paramPublicAccount);
    this.d.b(paramPublicAccount);
    this.f.b(paramPublicAccount);
  }

  public void c()
  {
    this.p.b(this.m);
  }

  public void c(PublicAccount paramPublicAccount)
  {
    if (cj.a(true))
    {
      ad.b().b(true).a(this.b).b(this.b);
      this.o = paramPublicAccount.getGroupUri();
      this.n = ViberApplication.getInstance().getEngine(false).getPhoneController().generateSequence();
      this.p.a(this.m);
      this.l.a(this.n, paramPublicAccount, new String[0]);
    }
  }

  public boolean d()
  {
    return this.d.k();
  }

  public void onDialogAction(m paramm, int paramInt)
  {
    if ((paramm.a(DialogCode.D_PROGRESS)) && (-1000 == paramInt) && (this.c != null))
      this.c.W_();
  }

  public static abstract interface a extends d
  {
    public abstract void W_();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.e
 * JD-Core Version:    0.6.2
 */