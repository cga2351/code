package com.viber.voip.messages.conversation.ui;

import android.app.Activity;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils.TruncateAt;
import android.widget.TextView;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.util.bt;
import com.viber.voip.util.dj;

public class bb
  implements ci
{
  private static final Logger a = ViberEnv.getLogger();
  private final ConversationFragment b;
  private final Handler c;
  private boolean d;
  private bt e;
  private final Runnable f = new Runnable()
  {
    public void run()
    {
      bb.a(bb.this);
    }
  };

  public bb(ConversationFragment paramConversationFragment)
  {
    this.b = paramConversationFragment;
    this.c = av.a(av.e.a);
  }

  private void e()
  {
    this.c.removeCallbacks(this.f);
    j();
  }

  private void f()
  {
    j();
    this.c.removeCallbacks(this.f);
    this.c.postDelayed(this.f, 1500L);
  }

  private void g()
  {
    TextView localTextView = k();
    if (localTextView != null)
      localTextView.setEllipsize(TextUtils.TruncateAt.END);
  }

  private void h()
  {
    TextView localTextView = k();
    if (localTextView != null)
      localTextView.setEllipsize(null);
  }

  private void i()
  {
    TextView localTextView = k();
    if (localTextView != null)
    {
      j();
      if (this.e == null)
        this.e = new bt(localTextView);
      this.e.a();
    }
  }

  private void j()
  {
    if (this.e != null)
      this.e.b();
  }

  private TextView k()
  {
    FragmentActivity localFragmentActivity = this.b.getActivity();
    if (localFragmentActivity == null)
      return null;
    if (ViberApplication.isTablet(localFragmentActivity))
      return (TextView)localFragmentActivity.findViewById(com.viber.voip.R.id.abs__action_bar_subtitle);
    return dj.g(localFragmentActivity.findViewById(android.support.design.R.id.action_bar));
  }

  public void a()
  {
    if (this.d)
      f();
  }

  public void b()
  {
    this.d = true;
    h();
    f();
  }

  public void c()
  {
    this.d = false;
    e();
    g();
  }

  public void d()
  {
    e();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.ui.bb
 * JD-Core Version:    0.6.2
 */