package com.viber.voip.viberout.ui.products.account;

import android.arch.lifecycle.h;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.story.StoryConstants.aa.a;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import com.viber.voip.viberout.a.e.a;
import com.viber.voip.viberout.a.g;
import com.viber.voip.viberout.a.g.a;
import javax.inject.Inject;

public class ViberOutAccountPresenter extends BaseMvpPresenter<e, State>
  implements e.a, g.a
{
  private static final Logger a = ViberEnv.getLogger();
  private final g b;
  private final com.viber.voip.viberout.a.e c;
  private final com.viber.voip.analytics.story.m.e d;
  private State e = new State();
  private String f;
  private String g;

  @Inject
  public ViberOutAccountPresenter(g paramg, com.viber.voip.viberout.a.e parame, com.viber.voip.analytics.story.m.e parame1)
  {
    this.b = paramg;
    this.c = parame;
    this.d = parame1;
  }

  public void a()
  {
    this.b.a();
  }

  public void a(AccountViewModel paramAccountViewModel)
  {
    this.e.account = paramAccountViewModel;
    ((e)this.mView).a(paramAccountViewModel);
  }

  public void a(PlanViewModel paramPlanViewModel)
  {
    ((e)this.mView).b(paramPlanViewModel);
  }

  protected void a(State paramState)
  {
    super.onViewAttached(paramState);
    this.b.a(this);
    this.c.a(this);
    if (paramState == null)
    {
      d();
      return;
    }
    this.e = paramState;
    if (this.e.account == null)
    {
      d();
      return;
    }
    ((e)this.mView).a(this.e.account);
  }

  public void a(String paramString)
  {
    this.f = paramString;
  }

  public void b()
  {
    ((e)this.mView).d();
  }

  public void b(String paramString)
  {
    this.g = paramString;
  }

  public void c()
  {
    ((e)this.mView).d();
  }

  public void d()
  {
    ((e)this.mView).c();
    this.b.a();
  }

  public void e()
  {
    ((e)this.mView).e();
  }

  public void f()
  {
    ((e)this.mView).f();
    this.d.b(StoryConstants.aa.a.a(this.g));
  }

  protected State g()
  {
    return this.e;
  }

  public void onDestroy(h paramh)
  {
    super.onDestroy(paramh);
    this.b.b(this);
    this.c.b(this);
  }

  static class State extends State
  {
    public static final Parcelable.Creator<State> CREATOR = new Parcelable.Creator()
    {
      public ViberOutAccountPresenter.State a(Parcel paramAnonymousParcel)
      {
        return new ViberOutAccountPresenter.State(paramAnonymousParcel);
      }

      public ViberOutAccountPresenter.State[] a(int paramAnonymousInt)
      {
        return new ViberOutAccountPresenter.State[paramAnonymousInt];
      }
    };
    AccountViewModel account;

    public State()
    {
    }

    protected State(Parcel paramParcel)
    {
      this.account = ((AccountViewModel)paramParcel.readParcelable(AccountViewModel.class.getClassLoader()));
    }

    public int describeContents()
    {
      return 0;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeParcelable(this.account, 0);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.account.ViberOutAccountPresenter
 * JD-Core Version:    0.6.2
 */