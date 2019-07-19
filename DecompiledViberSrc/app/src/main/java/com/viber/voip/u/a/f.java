package com.viber.voip.u.a;

import android.content.Context;
import android.view.View;
import com.viber.voip.ui.ViberListView;
import java.util.HashSet;
import java.util.Iterator;

public class f
  implements a.a
{
  private final e a;
  private final c b;
  private final HashSet<a> c;

  public f(Context paramContext)
  {
    this.a = new e(paramContext);
    this.b = new c(this, this.a);
    this.c = new HashSet();
  }

  private void a(int paramInt)
  {
    Iterator localIterator = new HashSet(this.c).iterator();
    while (localIterator.hasNext())
      ((a)localIterator.next()).a(paramInt);
  }

  private void c()
  {
    Iterator localIterator = new HashSet(this.c).iterator();
    while (localIterator.hasNext())
      ((a)localIterator.next()).s();
  }

  private void d()
  {
    Iterator localIterator = new HashSet(this.c).iterator();
    while (localIterator.hasNext())
      ((a)localIterator.next()).t();
  }

  public c a(View paramView)
  {
    this.a.a(paramView);
    return new c()
    {
      public void a()
      {
        f.b(f.this).a();
      }

      public void a(ViberListView paramAnonymousViberListView, b.a paramAnonymousa)
      {
        f.a(f.this, (int)paramAnonymousa.a());
        f.a(f.this).a(paramAnonymousViberListView, paramAnonymousa);
      }

      public void a(Runnable paramAnonymousRunnable)
      {
        f.b(f.this).a(paramAnonymousRunnable);
      }

      public void b(Runnable paramAnonymousRunnable)
      {
        f.b(f.this).b(paramAnonymousRunnable);
      }
    };
  }

  public void a()
  {
    c();
  }

  public void a(a parama)
  {
    this.c.add(parama);
  }

  public void b()
  {
    d();
  }

  public void b(a parama)
  {
    this.c.remove(parama);
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);

    public abstract void s();

    public abstract void t();
  }

  public static abstract interface b
  {
    public abstract void a();

    public abstract void a(Runnable paramRunnable);

    public abstract void b(Runnable paramRunnable);
  }

  public static abstract interface c extends b, f.b
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.u.a.f
 * JD-Core Version:    0.6.2
 */