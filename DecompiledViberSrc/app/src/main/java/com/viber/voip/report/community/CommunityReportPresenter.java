package com.viber.voip.report.community;

import android.arch.lifecycle.h;
import com.viber.voip.messages.conversation.ui.b.q;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import com.viber.voip.report.a.a.e;

public class CommunityReportPresenter extends BaseMvpPresenter<c, State>
  implements com.viber.voip.report.a.a.a.a, a.a
{
  private final com.viber.voip.report.a.a.a a;
  private final a b;
  private final q c;
  private long d;

  public CommunityReportPresenter(com.viber.voip.report.a.a.a parama, a parama1, q paramq)
  {
    this.a = parama;
    this.b = parama1;
    this.c = paramq;
  }

  private boolean d()
  {
    return this.d > 0L;
  }

  public void a()
  {
    this.a.b();
  }

  public void a(long paramLong)
  {
    this.d = paramLong;
    ((c)this.mView).a();
  }

  public void a(e parame)
  {
    if (parame == e.g)
      ((c)this.mView).b();
    do
    {
      return;
      if (parame == e.f)
      {
        this.c.a();
        return;
      }
    }
    while (!d());
    ((c)this.mView).a(true);
    this.a.a(this.d, parame, null);
  }

  public void a(String paramString)
  {
    if (d())
    {
      ((c)this.mView).a(true);
      this.a.a(this.d, e.g, paramString);
    }
  }

  public void b()
  {
    ((c)this.mView).a(false);
    ((c)this.mView).c();
  }

  public void c()
  {
    ((c)this.mView).a(false);
    ((c)this.mView).d();
  }

  public void onDestroy(h paramh)
  {
    super.onDestroy(paramh);
    this.a.a();
    this.b.b(this);
  }

  protected void onViewAttached(State paramState)
  {
    super.onViewAttached(paramState);
    this.a.a(this);
    this.b.a(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.report.community.CommunityReportPresenter
 * JD-Core Version:    0.6.2
 */