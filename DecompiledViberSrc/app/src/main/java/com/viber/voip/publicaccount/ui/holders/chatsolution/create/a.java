package com.viber.voip.publicaccount.ui.holders.chatsolution.create;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.viber.voip.R.color;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.publicaccount.d.e;
import com.viber.voip.publicaccount.entity.CrmItem;
import com.viber.voip.publicaccount.entity.PublicAccount;
import com.viber.voip.publicaccount.ui.holders.d;
import com.viber.voip.ui.GenericWebViewActivity;
import com.viber.voip.util.dj;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class a
  implements View.OnClickListener, com.viber.voip.publicaccount.ui.holders.c
{
  private final Fragment a;
  private final a b;
  private final Context c;
  private final Resources d;
  private Dialog e;
  private CrmItem f;
  private final List<CrmItem> g;
  private Handler h;
  private Handler i;
  private View j;
  private View k;
  private Runnable l = new Runnable()
  {
    public void run()
    {
      ArrayList localArrayList = e.b();
      a.c(a.this).post(new b(this, localArrayList));
    }
  };

  public a(Fragment paramFragment, a parama, Handler paramHandler1, Handler paramHandler2)
  {
    this.a = paramFragment;
    this.b = parama;
    this.h = paramHandler1;
    this.i = paramHandler2;
    this.c = this.a.getContext();
    this.d = this.c.getResources();
    this.g = new ArrayList();
  }

  private void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str1 = this.d.getString(paramInt3);
    SpannableString localSpannableString1 = new SpannableString(str1);
    localSpannableString1.setSpan(new ForegroundColorSpan(ContextCompat.getColor(this.c, paramInt2)), 0, str1.length(), 33);
    localSpannableStringBuilder.append(localSpannableString1);
    localSpannableStringBuilder.append(' ');
    String str2 = this.d.getString(paramInt5);
    SpannableString localSpannableString2 = new SpannableString(str2);
    localSpannableString2.setSpan(new ChatSolutionUIHolder.1(this, str2, ContextCompat.getColor(this.c, paramInt4), paramBoolean), 0, str2.length(), 33);
    localSpannableString2.setSpan(new UnderlineSpan(), 0, str2.length(), 33);
    localSpannableStringBuilder.append(localSpannableString2);
    TextView localTextView = (TextView)paramView.findViewById(paramInt1);
    localTextView.setText(localSpannableStringBuilder);
    localTextView.setMovementMethod(LinkMovementMethod.getInstance());
  }

  private void a(View paramView, boolean paramBoolean)
  {
    TextView localTextView = (TextView)paramView.findViewById(R.id.public_account_solutions_section_subtitle);
    int m;
    View localView;
    int n;
    label51: RelativeLayout.LayoutParams localLayoutParams2;
    if (paramBoolean)
    {
      m = 5;
      localTextView.setGravity(m);
      localView = paramView.findViewById(R.id.public_account_solutions_section_icon);
      RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      if (!paramBoolean)
        break label99;
      n = 11;
      localLayoutParams1.addRule(n);
      localLayoutParams2 = (RelativeLayout.LayoutParams)paramView.findViewById(R.id.public_account_solutions_section).getLayoutParams();
      if (!paramBoolean)
        break label106;
    }
    label99: label106: for (int i1 = 0; ; i1 = 1)
    {
      localLayoutParams2.addRule(i1, localView.getId());
      return;
      m = 3;
      break;
      n = 9;
      break label51;
    }
  }

  private void a(boolean paramBoolean)
  {
    if ((this.j == null) || (this.k == null))
      return;
    dj.b(this.j, paramBoolean);
    View localView = this.j;
    if (paramBoolean);
    for (a locala = this; ; locala = null)
    {
      localView.setOnClickListener(locala);
      a(this.j, com.viber.common.d.c.a());
      dj.b(this.k, paramBoolean);
      return;
    }
  }

  private void b(View paramView)
  {
    this.j = paramView.findViewById(R.id.public_account_chat_solution_solutions_section);
    this.k = paramView.findViewById(R.id.public_account_chat_solution_sections_divider);
    View localView = paramView.findViewById(R.id.public_account_chat_solution_developers_section);
    localView.setOnClickListener(this);
    b(localView, com.viber.common.d.c.a());
    if (!this.g.isEmpty());
    for (boolean bool = true; ; bool = false)
    {
      a(bool);
      return;
    }
  }

  private void b(View paramView, boolean paramBoolean)
  {
    TextView localTextView = (TextView)paramView.findViewById(R.id.public_account_developers_section_subtitle);
    int m;
    View localView;
    int n;
    label51: RelativeLayout.LayoutParams localLayoutParams2;
    if (paramBoolean)
    {
      m = 5;
      localTextView.setGravity(m);
      localView = paramView.findViewById(R.id.public_account_developers_section_icon);
      RelativeLayout.LayoutParams localLayoutParams1 = (RelativeLayout.LayoutParams)localView.getLayoutParams();
      if (!paramBoolean)
        break label99;
      n = 11;
      localLayoutParams1.addRule(n);
      localLayoutParams2 = (RelativeLayout.LayoutParams)paramView.findViewById(R.id.public_account_developers_section).getLayoutParams();
      if (!paramBoolean)
        break label106;
    }
    label99: label106: for (int i1 = 0; ; i1 = 1)
    {
      localLayoutParams2.addRule(i1, localView.getId());
      return;
      m = 3;
      break;
      n = 9;
      break label51;
    }
  }

  private void c()
  {
    this.b.U_();
  }

  private void c(View paramView)
  {
    a(paramView, R.id.public_account_need_more_help, R.color.public_account_chat_solution_need_more_desc_color, R.string.create_public_account_chat_solution_need_more_help_description, R.color.link_text, R.string.create_public_account_chat_solution_need_more_help_action, true);
  }

  private void d()
  {
    String str1 = Locale.getDefault().getLanguage();
    String str2 = this.d.getString(R.string.public_account_chat_solution_need_more_help_url, new Object[] { str1 });
    GenericWebViewActivity.a(this.a.getContext(), str2, null);
  }

  private void d(View paramView)
  {
    a(paramView, R.id.public_account_skip_chatting, R.color.main_text, R.string.create_public_account_chat_solution_skip_chatting_description, R.color.link_text, R.string.create_public_account_chat_solution_skip_chatting_action, false);
  }

  private void e()
  {
    this.b.V_();
  }

  private void f()
  {
    this.e = com.viber.voip.publicaccount.b.a.a(this.a.getContext(), this.g, new com.viber.voip.publicaccount.b.b()
    {
      public void a(CrmItem paramAnonymousCrmItem)
      {
        a.a(a.this, paramAnonymousCrmItem);
        a.a(a.this);
        a.b(a.this);
      }
    }
    , this.a.getLayoutInflater());
    this.e.show();
  }

  private void g()
  {
    if (this.e != null)
    {
      this.e.dismiss();
      this.e = null;
    }
  }

  public void a()
  {
    g();
    this.i.removeCallbacks(this.l);
    this.j = null;
    this.k = null;
  }

  public void a(Bundle paramBundle)
  {
  }

  public void a(View paramView)
  {
    b(paramView);
    d(paramView);
    c(paramView);
  }

  public void a(PublicAccount paramPublicAccount)
  {
  }

  public void b()
  {
    this.i.removeCallbacks(this.l);
    this.i.post(this.l);
  }

  public void b(Bundle paramBundle)
  {
  }

  public void b(PublicAccount paramPublicAccount)
  {
    paramPublicAccount.setCrm(this.f);
    this.f = null;
  }

  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if (m == R.id.public_account_skip_chatting)
      c();
    do
    {
      return;
      if (m == R.id.public_account_need_more_help)
      {
        d();
        return;
      }
      if (m == R.id.public_account_chat_solution_solutions_section)
      {
        f();
        return;
      }
    }
    while (m != R.id.public_account_chat_solution_developers_section);
    e();
  }

  public static abstract interface a extends d
  {
    public abstract void U_();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.publicaccount.ui.holders.chatsolution.create.a
 * JD-Core Version:    0.6.2
 */