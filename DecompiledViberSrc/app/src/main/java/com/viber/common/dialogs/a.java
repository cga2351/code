package com.viber.common.dialogs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.viber.common.d.c;
import java.io.Serializable;
import java.util.Locale;

public class a
  implements Serializable
{
  private String a;
  private int b;
  private transient CharSequence c;
  private int d;
  private int e;
  private int f;
  private String g;
  private int h;
  private String i;
  private boolean j;
  private transient Fragment k;
  private boolean l;
  private DialogCodeProvider m;
  private m.a n;
  private boolean o;
  private boolean p;
  private Object q;
  private boolean r;
  private boolean s;
  private int t;
  private boolean u;
  private Integer v;
  private boolean w;
  private int x;

  private a()
  {
  }

  protected a(a<?> parama)
  {
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.e = a.e(parama);
    this.f = a.f(parama);
    this.h = a.g(parama);
    this.j = a.h(parama);
    this.k = a.i(parama);
    this.l = a.j(parama);
    this.m = a.k(parama);
    this.n = a.l(parama);
    this.o = a.m(parama);
    this.g = a.n(parama);
    this.i = a.o(parama);
    this.p = a.p(parama);
    this.q = a.q(parama);
    this.r = a.r(parama);
    this.s = a.s(parama);
    this.t = a.t(parama);
    this.u = a.u(parama);
    this.v = a.v(parama);
    this.w = a.w(parama);
    this.x = a.x(parama);
  }

  private Intent a(Intent paramIntent, boolean paramBoolean)
  {
    paramIntent.setFlags(268435456);
    Bundle localBundle = new Bundle();
    a(localBundle);
    localBundle.putSerializable("dialog_instance", this);
    paramIntent.putExtra("all_isolated_extras", localBundle);
    if (paramBoolean)
      y.a(paramIntent);
    return paramIntent;
  }

  private m a(FragmentManager paramFragmentManager, boolean paramBoolean)
  {
    Bundle localBundle = new Bundle();
    b(localBundle);
    m localm = m.a(localBundle);
    if (this.k != null);
    return a(localm, paramFragmentManager, paramBoolean);
  }

  private m a(m paramm, FragmentManager paramFragmentManager, boolean paramBoolean)
  {
    if (!paramBoolean)
      try
      {
        paramm.show(c(paramFragmentManager), this.m.managerTag());
        return paramm;
      }
      catch (Exception localException2)
      {
      }
    try
    {
      c(paramFragmentManager).add(paramm, this.m.managerTag()).commitAllowingStateLoss();
      return paramm;
      c(paramFragmentManager).add(paramm, this.m.managerTag()).commitAllowingStateLoss();
      return paramm;
    }
    catch (Exception localException1)
    {
    }
    return paramm;
  }

  public static a<?> b()
  {
    return new a();
  }

  private FragmentTransaction c(FragmentManager paramFragmentManager)
  {
    FragmentTransaction localFragmentTransaction = paramFragmentManager.beginTransaction();
    Fragment localFragment = paramFragmentManager.findFragmentByTag(this.m.managerTag());
    if (localFragment != null)
      localFragmentTransaction.remove(localFragment);
    return localFragmentTransaction;
  }

  public a<?> a()
  {
    return new a(this);
  }

  public m a(Context paramContext)
  {
    if ((paramContext instanceof FragmentActivity))
      return a((FragmentActivity)paramContext);
    return null;
  }

  public m a(FragmentActivity paramFragmentActivity)
  {
    if (!paramFragmentActivity.isFinishing())
      return a(paramFragmentActivity.getSupportFragmentManager());
    return null;
  }

  public m a(FragmentManager paramFragmentManager)
  {
    return a(paramFragmentManager, false);
  }

  protected void a(Bundle paramBundle)
  {
    if (this.c != null)
      paramBundle.putCharSequence("intent_body", this.c);
    if ((this.q instanceof Parcelable))
    {
      paramBundle.putParcelable("intent_attached_parcelable_data", (Parcelable)this.q);
      this.q = null;
    }
  }

  public void a(Class<?> paramClass)
  {
    a(new Intent(y.a(), paramClass), true);
  }

  public Intent b(Class<?> paramClass)
  {
    return a(new Intent(y.a(), paramClass), false);
  }

  public m b(FragmentActivity paramFragmentActivity)
  {
    return b(paramFragmentActivity.getSupportFragmentManager());
  }

  public m b(FragmentManager paramFragmentManager)
  {
    return a(paramFragmentManager, true);
  }

  protected void b(Bundle paramBundle)
  {
    paramBundle.putString("title", this.a);
    paramBundle.putInt("title_id", this.b);
    paramBundle.putCharSequence("body", this.c);
    paramBundle.putInt("body_id", this.d);
    paramBundle.putInt("body_layout_id", this.e);
    paramBundle.putInt("cancel_action_request_code", this.f);
    paramBundle.putInt("dismiss_action_request_code", this.h);
    paramBundle.putBoolean("is_trackable", this.j);
    paramBundle.putParcelable("dialog_code", this.m);
    paramBundle.putSerializable("isolated_handler", this.n);
    paramBundle.putBoolean("has_callbacks", this.o);
    paramBundle.putString("analytics_cancel_action", this.g);
    paramBundle.putString("analytics_dismiss_action", this.i);
    paramBundle.putBoolean("is_cancelable", this.p);
    paramBundle.putBoolean("has_target_fragment", this.l);
    paramBundle.putBoolean("is_restorable", this.r);
    paramBundle.putBoolean("has_destroyable_underlay", this.s);
    paramBundle.putInt("custom_style", this.t);
    paramBundle.putBoolean("links_clickable", this.u);
    paramBundle.putBoolean("is_bottom_sheet", this.w);
    if (this.v != null)
      paramBundle.putInt("locked_orientation_current", this.v.intValue());
    if ((this.q instanceof Parcelable))
      paramBundle.putParcelable("attached_parcelable_data", (Parcelable)this.q);
    while (!(this.q instanceof Serializable))
      return;
    paramBundle.putSerializable("attached_serializable_data", (Serializable)this.q);
  }

  public void c()
  {
    a(BaseRemoteViberDialogsActivity.a("REMOTE_DIALOG"), true);
  }

  public Intent d()
  {
    return a(BaseRemoteViberDialogsActivity.a("REMOTE_DIALOG"), false);
  }

  m.a e()
  {
    return this.n;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool2;
    if (this == paramObject)
      bool2 = true;
    a locala;
    label120: 
    do
    {
      boolean bool6;
      do
      {
        int i5;
        int i6;
        do
        {
          int i3;
          int i4;
          do
          {
            int i1;
            int i2;
            do
            {
              boolean bool1;
              do
              {
                return bool2;
                bool1 = paramObject instanceof a;
                bool2 = false;
              }
              while (!bool1);
              locala = (a)paramObject;
              i1 = this.b;
              i2 = locala.b;
              bool2 = false;
            }
            while (i1 != i2);
            i3 = this.d;
            i4 = locala.d;
            bool2 = false;
          }
          while (i3 != i4);
          i5 = this.e;
          i6 = locala.e;
          bool2 = false;
        }
        while (i5 != i6);
        if (this.a == null)
          break;
        bool6 = this.a.equals(locala.a);
        bool2 = false;
      }
      while (!bool6);
      if (this.c == null)
        break label193;
      bool5 = this.c.equals(locala.c);
      bool2 = false;
    }
    while (!bool5);
    label193: 
    while (locala.c == null)
    {
      boolean bool5;
      boolean bool3 = this.w;
      boolean bool4 = locala.w;
      bool2 = false;
      if (bool3 != bool4)
        break;
      return z.a(this.m, locala.m);
      if (locala.a == null)
        break label120;
      return false;
    }
    return false;
  }

  public DialogCodeProvider f()
  {
    return this.m;
  }

  public Object g()
  {
    return this.q;
  }

  public int h()
  {
    return this.x;
  }

  public int hashCode()
  {
    int i1;
    int i2;
    if (this.a != null)
    {
      i1 = this.a.hashCode();
      i2 = 31 * (i1 * 31 + this.b);
      if (this.c == null)
        break label111;
    }
    label111: for (int i3 = this.c.hashCode(); ; i3 = 0)
    {
      int i4 = 31 * (31 * (31 * (31 * (i3 + i2) + this.d) + this.e) + this.m.code().hashCode());
      boolean bool = this.w;
      int i5 = 0;
      if (bool)
        i5 = 1;
      return i4 + i5;
      i1 = 0;
      break;
    }
  }

  public String toString()
  {
    return super.toString() + " {mCode=" + this.m.code() + "}";
  }

  public static class a<T extends a<T>>
  {
    private String a = null;
    private int b = -1;
    private CharSequence c = null;
    private int d = -1;
    private int e = -1;
    private int f = -1000;
    private int g = -2147483648;
    private boolean h = false;
    private transient Fragment i = null;
    private boolean j = false;
    private DialogCodeProvider k = DialogCodeProvider.UNKNOWN;
    private m.a l = null;
    private boolean m = false;
    private String n = "Dismiss";
    private String o = null;
    private boolean p = true;
    private transient Object q = null;
    private boolean r = true;
    private boolean s = false;
    private int t;
    private boolean u = true;
    private boolean v = false;
    private int w = 0;
    private Integer x = null;

    protected a()
    {
      y.c();
      a();
    }

    protected a(a parama)
    {
      this.a = a.a(parama);
      this.b = a.b(parama);
      this.c = a.c(parama);
      this.d = a.d(parama);
      this.e = a.e(parama);
      this.f = a.f(parama);
      this.g = a.g(parama);
      this.h = a.h(parama);
      this.i = a.i(parama);
      this.j = a.j(parama);
      this.k = a.k(parama);
      this.l = a.l(parama);
      this.m = a.m(parama);
      this.n = a.n(parama);
      this.o = a.o(parama);
      this.p = a.p(parama);
      this.q = a.q(parama);
      this.r = a.r(parama);
      this.s = a.s(parama);
      this.t = a.t(parama);
      this.u = a.u(parama);
      this.x = a.v(parama);
      this.v = a.w(parama);
      this.w = a.x(parama);
    }

    public T a(int paramInt)
    {
      this.x = Integer.valueOf(paramInt);
      return b();
    }

    public T a(int paramInt1, int paramInt2)
    {
      this.b = paramInt1;
      return d(paramInt2);
    }

    public T a(int paramInt1, int paramInt2, Object[] paramArrayOfObject)
    {
      this.d = paramInt1;
      return b(paramInt2, paramArrayOfObject);
    }

    public T a(int paramInt, CharSequence paramCharSequence)
    {
      this.d = paramInt;
      return a(paramCharSequence);
    }

    public T a(int paramInt, String paramString)
    {
      this.b = paramInt;
      return c(paramString);
    }

    public T a(int paramInt, Object[] paramArrayOfObject)
    {
      if (-1 == paramInt)
        return c(String.format(Locale.US, this.a, paramArrayOfObject));
      return c(y.a().getString(paramInt, paramArrayOfObject));
    }

    public T a(Activity paramActivity)
    {
      if (paramActivity != null);
      for (boolean bool = true; ; bool = false)
      {
        this.m = bool;
        this.i = null;
        this.j = false;
        this.l = null;
        return b();
      }
    }

    public T a(Bundle paramBundle)
    {
      this.c = paramBundle.getCharSequence("intent_body");
      if (paramBundle.containsKey("intent_attached_parcelable_data"))
        this.q = paramBundle.getParcelable("intent_attached_parcelable_data");
      return b();
    }

    public T a(Parcelable paramParcelable)
    {
      this.q = paramParcelable;
      return b();
    }

    public T a(Fragment paramFragment)
    {
      boolean bool1 = true;
      this.i = paramFragment;
      boolean bool2;
      if (paramFragment != null)
      {
        bool2 = bool1;
        this.j = bool2;
        if (paramFragment == null)
          break label42;
      }
      while (true)
      {
        this.m = bool1;
        this.l = null;
        return b();
        bool2 = false;
        break;
        label42: bool1 = false;
      }
    }

    public T a(DialogCodeProvider paramDialogCodeProvider)
    {
      this.k = paramDialogCodeProvider;
      return b();
    }

    public T a(m.a parama)
    {
      this.l = parama;
      if (parama != null);
      for (boolean bool = true; ; bool = false)
      {
        this.m = bool;
        this.i = null;
        this.j = false;
        return b();
      }
    }

    public T a(Serializable paramSerializable)
    {
      this.q = paramSerializable;
      return b();
    }

    public T a(CharSequence paramCharSequence)
    {
      this.c = paramCharSequence;
      return b();
    }

    public T a(String paramString)
    {
      this.n = paramString;
      return b();
    }

    public T a(boolean paramBoolean)
    {
      this.r = paramBoolean;
      return b();
    }

    public m a(Context paramContext)
    {
      if ((paramContext instanceof FragmentActivity))
        return f().a((FragmentActivity)paramContext);
      return null;
    }

    public m a(FragmentActivity paramFragmentActivity)
    {
      return f().a(paramFragmentActivity.getSupportFragmentManager());
    }

    public m a(FragmentManager paramFragmentManager)
    {
      return f().a(paramFragmentManager);
    }

    protected void a()
    {
      e(false);
      b(-1000);
      c(-2147483648);
      e(-1);
      a("Dismiss");
      b(null);
      a(DialogCodeProvider.UNKNOWN);
      b(true);
      a(true);
      d(false);
      f(true);
      c(false);
    }

    public void a(Class<?> paramClass)
    {
      f().a(paramClass);
    }

    public Intent b(Class<?> paramClass)
    {
      return f().b(paramClass);
    }

    protected T b()
    {
      return this;
    }

    public T b(int paramInt)
    {
      this.f = paramInt;
      return b();
    }

    public T b(int paramInt1, int paramInt2)
    {
      this.d = paramInt1;
      return f(paramInt2);
    }

    public T b(int paramInt, Object[] paramArrayOfObject)
    {
      if (-1 == paramInt)
        return a(String.format(Locale.US, this.c.toString(), c.a(paramArrayOfObject)));
      return a(c.a(y.a(), paramInt, paramArrayOfObject));
    }

    public T b(String paramString)
    {
      this.o = paramString;
      return b();
    }

    public T b(boolean paramBoolean)
    {
      this.p = paramBoolean;
      return b();
    }

    public m b(Context paramContext)
    {
      if ((paramContext instanceof FragmentActivity))
        return f().b((FragmentActivity)paramContext);
      return null;
    }

    public m b(Fragment paramFragment)
    {
      if (this.j);
      for (FragmentManager localFragmentManager = paramFragment.getChildFragmentManager(); ; localFragmentManager = paramFragment.getFragmentManager())
        return a(localFragmentManager);
    }

    public m b(FragmentActivity paramFragmentActivity)
    {
      return f().b(paramFragmentActivity.getSupportFragmentManager());
    }

    public m b(FragmentManager paramFragmentManager)
    {
      return f().b(paramFragmentManager);
    }

    public T c()
    {
      return b();
    }

    public T c(int paramInt)
    {
      this.g = paramInt;
      return b();
    }

    public T c(String paramString)
    {
      this.a = paramString;
      return b();
    }

    public T c(boolean paramBoolean)
    {
      this.v = paramBoolean;
      return b();
    }

    public m c(Fragment paramFragment)
    {
      if (this.j);
      for (FragmentManager localFragmentManager = paramFragment.getChildFragmentManager(); ; localFragmentManager = paramFragment.getFragmentManager())
        return b(localFragmentManager);
    }

    public T d(int paramInt)
    {
      return c(y.a().getString(paramInt));
    }

    public T d(boolean paramBoolean)
    {
      this.s = paramBoolean;
      return b();
    }

    public void d()
    {
      f().c();
    }

    public Intent e()
    {
      return f().d();
    }

    public T e(int paramInt)
    {
      this.e = paramInt;
      return b();
    }

    public T e(boolean paramBoolean)
    {
      this.h = paramBoolean;
      return b();
    }

    public T f(int paramInt)
    {
      return a(y.a().getString(paramInt));
    }

    public T f(boolean paramBoolean)
    {
      this.u = paramBoolean;
      return b();
    }

    a f()
    {
      return new a(this);
    }

    public T g(int paramInt)
    {
      this.w = paramInt;
      return b();
    }

    public T h(int paramInt)
    {
      this.t = paramInt;
      return b();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.dialogs.a
 * JD-Core Version:    0.6.2
 */