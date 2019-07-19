package com.viber.common.dialogs;

import android.os.Bundle;
import java.util.Calendar;

public class f extends a
{
  private final int a;
  private final int b;
  private final int c;
  private final Long d;
  private final Long e;

  protected f(a<?> parama)
  {
    super(parama);
    this.a = a.a(parama);
    this.b = a.b(parama);
    this.c = a.c(parama);
    this.d = a.d(parama);
    this.e = a.e(parama);
  }

  public static a<?> j()
  {
    return new a();
  }

  protected void b(Bundle paramBundle)
  {
    paramBundle.putBoolean("has_date_picker", true);
    paramBundle.putInt("day_of_month", this.a);
    paramBundle.putInt("month_of_year", this.b);
    paramBundle.putInt("year", this.c);
    if (this.d != null)
      paramBundle.putLong("min_date_millis", this.d.longValue());
    if (this.e != null)
      paramBundle.putLong("max_date_millis", this.e.longValue());
    super.b(paramBundle);
  }

  public a<?> i()
  {
    return new a(this);
  }

  public static class a<T extends a<T>> extends a.a<T>
  {
    private int a;
    private int b;
    private int c;
    private Long d;
    private Long e;

    protected a()
    {
    }

    protected a(f paramf)
    {
      super();
      this.a = f.a(paramf);
      this.b = f.b(paramf);
      this.c = f.c(paramf);
      this.d = f.d(paramf);
      this.e = f.e(paramf);
    }

    public T a(long paramLong)
    {
      this.d = Long.valueOf(paramLong);
      return (a)b();
    }

    protected void a()
    {
      super.a();
      Calendar localCalendar = Calendar.getInstance();
      i(localCalendar.get(5));
      j(localCalendar.get(2));
      k(localCalendar.get(1));
    }

    public T b(long paramLong)
    {
      this.e = Long.valueOf(paramLong);
      return (a)b();
    }

    f g()
    {
      return new f(this);
    }

    public T i(int paramInt)
    {
      this.a = paramInt;
      return (a)b();
    }

    public T j(int paramInt)
    {
      this.b = paramInt;
      return (a)b();
    }

    public T k(int paramInt)
    {
      this.c = paramInt;
      return (a)b();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.dialogs.f
 * JD-Core Version:    0.6.2
 */