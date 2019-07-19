package com.viber.voip.viberout.ui.products;

import android.arch.lifecycle.h;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.viber.common.b.b;
import com.viber.common.b.d;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.analytics.story.StoryConstants.z.a;
import com.viber.voip.analytics.story.m.e;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import com.viber.voip.util.ae;
import com.viber.voip.util.cj;
import com.viber.voip.util.cj.a;
import com.viber.voip.util.cj.b;
import com.viber.voip.util.da;
import com.viber.voip.viberout.a.g;
import com.viber.voip.viberout.a.g.a;
import com.viber.voip.viberout.a.j;
import com.viber.voip.viberout.a.j.a;
import com.viber.voip.viberout.a.l;
import com.viber.voip.viberout.a.p;
import com.viber.voip.viberout.a.p.a;
import com.viber.voip.viberout.ui.products.account.AccountViewModel;
import com.viber.voip.viberout.ui.products.model.CreditModel;
import com.viber.voip.viberout.ui.products.model.PlanModel;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;

public class ViberOutProductsPresenter extends BaseMvpPresenter<i, State>
  implements g.a, j.a, p.a
{
  private final p a;
  private final j b;
  private final g c;
  private final cj d;
  private final l e;
  private final ICdrController f;
  private final d g;
  private final b h;
  private final e i;
  private final cj.b j = new cj.a()
  {
    public void connectivityChanged(int paramAnonymousInt1, int paramAnonymousInt2)
    {
      if (paramAnonymousInt1 == -1)
      {
        ViberOutProductsPresenter.a(ViberOutProductsPresenter.this).noConnection = true;
        ((i)ViberOutProductsPresenter.b(ViberOutProductsPresenter.this)).a(true);
      }
      while (!ViberOutProductsPresenter.a(ViberOutProductsPresenter.this).noConnection)
        return;
      ViberOutProductsPresenter.a(ViberOutProductsPresenter.this).noConnection = false;
      ((i)ViberOutProductsPresenter.c(ViberOutProductsPresenter.this)).a(false);
      if (ViberOutProductsPresenter.a(ViberOutProductsPresenter.this).selectedTab == 0)
      {
        ViberOutProductsPresenter.e(ViberOutProductsPresenter.this).a(ViberOutProductsPresenter.d(ViberOutProductsPresenter.this));
        return;
      }
      ViberOutProductsPresenter.f(ViberOutProductsPresenter.this).a(ViberOutProductsPresenter.d(ViberOutProductsPresenter.this));
    }
  };
  private State k = new State();
  private String l;
  private String m;

  @Inject
  public ViberOutProductsPresenter(p paramp, j paramj, g paramg, cj paramcj, l paraml, ICdrController paramICdrController, e parame, d paramd, b paramb)
  {
    this.a = paramp;
    this.b = paramj;
    this.c = paramg;
    this.d = paramcj;
    this.e = paraml;
    this.f = paramICdrController;
    this.i = parame;
    this.g = paramd;
    this.h = paramb;
  }

  public void a()
  {
  }

  public void a(int paramInt)
  {
    int n = this.k.selectedTab;
    this.g.a(paramInt);
    this.k.selectedTab = paramInt;
    if ((this.m != null) && (n != paramInt))
      this.i.a(StoryConstants.z.a.a(paramInt), this.m, ae.b());
  }

  protected void a(State paramState)
  {
    super.onViewAttached(paramState);
    if (paramState != null)
    {
      this.k = paramState;
      if (this.k.noConnection)
      {
        ((i)this.mView).a(true);
        ((i)this.mView).a(this.k.selectedTab);
      }
    }
    while (true)
    {
      this.d.a(this.j);
      this.a.a(this);
      this.b.a(this);
      this.c.a(this);
      return;
      if (!this.k.userBlocked)
        break;
      ((i)this.mView).b();
      break;
      ((i)this.mView).a(this.g.d());
      this.i.b();
      this.i.a(StoryConstants.z.a.a(this.g.d()), this.m, ae.b());
    }
  }

  public void a(AccountViewModel paramAccountViewModel)
  {
  }

  public void a(String paramString)
  {
    this.l = paramString;
  }

  public void a(Collection<List<PlanModel>> paramCollection, boolean paramBoolean)
  {
  }

  public void a(List<CreditModel> paramList, int paramInt)
  {
  }

  public void b()
  {
  }

  public void b(String paramString)
  {
    this.m = paramString;
  }

  public void c()
  {
    if (this.h.d())
      ((i)this.mView).a();
  }

  public void c(String paramString)
  {
    this.k.isRequestHandled = true;
    ((i)this.mView).b(paramString);
  }

  public void d()
  {
    this.k.userBlocked = true;
    ((i)this.mView).b();
  }

  public void d(String paramString)
  {
    if (!da.b(paramString))
      ((i)this.mView).a(paramString);
  }

  public void e()
  {
  }

  public void f()
  {
    this.e.a();
  }

  protected State g()
  {
    return this.k;
  }

  public void h()
  {
    ((i)this.mView).c();
  }

  public void i()
  {
    this.a.a(this.l);
  }

  public void j()
  {
    this.k.isRequestHandled = true;
    this.f.handleReportVOSendInviteScreen(0);
    ((i)this.mView).d();
  }

  public void onDestroy(h paramh)
  {
    super.onDestroy(paramh);
    this.d.b(this.j);
    this.a.b(this);
    this.c.b(this);
  }

  static class State extends State
  {
    public static final Parcelable.Creator<State> CREATOR = new Parcelable.Creator()
    {
      public ViberOutProductsPresenter.State a(Parcel paramAnonymousParcel)
      {
        return new ViberOutProductsPresenter.State(paramAnonymousParcel);
      }

      public ViberOutProductsPresenter.State[] a(int paramAnonymousInt)
      {
        return new ViberOutProductsPresenter.State[paramAnonymousInt];
      }
    };
    boolean isRequestHandled;
    boolean noConnection;
    int selectedTab;
    boolean userBlocked;

    public State()
    {
    }

    protected State(Parcel paramParcel)
    {
      boolean bool2;
      boolean bool3;
      if (paramParcel.readByte() != 0)
      {
        bool2 = bool1;
        this.isRequestHandled = bool2;
        if (paramParcel.readByte() == 0)
          break label62;
        bool3 = bool1;
        label30: this.noConnection = bool3;
        if (paramParcel.readByte() == 0)
          break label68;
      }
      while (true)
      {
        this.userBlocked = bool1;
        this.selectedTab = paramParcel.readInt();
        return;
        bool2 = false;
        break;
        label62: bool3 = false;
        break label30;
        label68: bool1 = false;
      }
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = 1;
      int j;
      int k;
      if (this.isRequestHandled)
      {
        j = i;
        paramParcel.writeByte((byte)j);
        if (!this.noConnection)
          break label64;
        k = i;
        label29: paramParcel.writeByte((byte)k);
        if (!this.userBlocked)
          break label70;
      }
      while (true)
      {
        paramParcel.writeByte((byte)i);
        paramParcel.writeInt(this.selectedTab);
        return;
        j = 0;
        break;
        label64: k = 0;
        break label29;
        label70: i = 0;
      }
    }
  }

  @Retention(RetentionPolicy.SOURCE)
  static @interface a
  {
    public static class a
    {
      public static int a(String paramString)
      {
        if ("world credits".equals(paramString))
          return 1;
        return 0;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.ViberOutProductsPresenter
 * JD-Core Version:    0.6.2
 */