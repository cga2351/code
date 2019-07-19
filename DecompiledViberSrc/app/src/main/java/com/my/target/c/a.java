package com.my.target.c;

import android.content.Context;
import android.view.View;
import com.my.target.az;
import com.my.target.bq;
import com.my.target.bq.b;
import com.my.target.dp;
import com.my.target.z;
import java.util.List;

public final class a extends com.my.target.common.a
{
  private final Context b;
  private com.my.target.b.b.a c;
  private com.my.target.c.a.a d;
  private a e;
  private int f = 0;

  public a(int paramInt, Context paramContext)
  {
    super(paramInt, "nativeads");
    this.b = paramContext.getApplicationContext();
    dp.c("NativeAd created. Version: 5.3.11");
  }

  private void a(com.my.target.b.c.b.a parama, String paramString)
  {
    if (this.e != null)
      if (parama != null)
        break label40;
    label40: for (com.my.target.b.c.a.a locala = null; locala == null; locala = parama.d())
    {
      a locala1 = this.e;
      if (paramString == null)
        paramString = "no ad";
      locala1.a(paramString, this);
      return;
    }
    this.c = com.my.target.b.b.a.a(this, locala);
    this.d = com.my.target.c.a.a.a(locala);
    this.e.a(this);
  }

  public final a a()
  {
    return this.e;
  }

  public final void a(int paramInt)
  {
    this.f = paramInt;
  }

  public final void a(View paramView, List<View> paramList)
  {
    if (this.c != null)
      this.c.a(paramView, paramList, this.f);
  }

  public final void a(a parama)
  {
    this.e = parama;
  }

  public final void a(boolean paramBoolean)
  {
    this.a.a(paramBoolean);
  }

  public final com.my.target.c.a.a b()
  {
    return this.d;
  }

  public final void c()
  {
    bq.a(this.a).a(new bq.b()
    {
      public void a(com.my.target.b.c.b.a paramAnonymousa, String paramAnonymousString)
      {
        a.a(a.this, paramAnonymousa, paramAnonymousString);
      }
    }).a(this.b);
  }

  public final void d()
  {
    if (this.c != null)
      this.c.a();
  }

  public static abstract interface a
  {
    public abstract void a(a parama);

    public abstract void a(String paramString, a parama);

    public abstract void b(a parama);

    public abstract void c(a parama);

    public abstract void d(a parama);

    public abstract void e(a parama);

    public abstract void f(a parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.c.a
 * JD-Core Version:    0.6.2
 */