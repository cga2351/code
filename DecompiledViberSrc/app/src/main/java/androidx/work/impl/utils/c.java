package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class c
{
  private final Context a;
  private SharedPreferences b;
  private boolean c;

  public c(Context paramContext)
  {
    this.a = paramContext;
  }

  private int a(String paramString)
  {
    int i = this.b.getInt(paramString, 0);
    int j = 0;
    if (i == 2147483647);
    while (true)
    {
      a(paramString, j);
      return i;
      j = i + 1;
    }
  }

  private void a(String paramString, int paramInt)
  {
    this.b.edit().putInt(paramString, paramInt).apply();
  }

  private void b()
  {
    if (!this.c)
    {
      this.b = this.a.getSharedPreferences("androidx.work.util.id", 0);
      this.c = true;
    }
  }

  public int a()
  {
    try
    {
      b();
      int i = a("next_alarm_manager_id");
      return i;
    }
    finally
    {
    }
  }

  public int a(int paramInt1, int paramInt2)
  {
    while (true)
    {
      int i;
      try
      {
        b();
        i = a("next_job_scheduler_id");
        if ((i < paramInt1) || (i > paramInt2))
        {
          a("next_job_scheduler_id", paramInt1 + 1);
          return paramInt1;
        }
      }
      finally
      {
      }
      paramInt1 = i;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.utils.c
 * JD-Core Version:    0.6.2
 */