package androidx.work.impl.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class e
{
  private Context a;
  private SharedPreferences b;

  public e(Context paramContext)
  {
    this.a = paramContext;
  }

  private SharedPreferences b()
  {
    try
    {
      if (this.b == null)
        this.b = this.a.getSharedPreferences("androidx.work.util.preferences", 0);
      SharedPreferences localSharedPreferences = this.b;
      return localSharedPreferences;
    }
    finally
    {
    }
  }

  public void a(boolean paramBoolean)
  {
    b().edit().putBoolean("reschedule_needed", paramBoolean).apply();
  }

  public boolean a()
  {
    return b().getBoolean("reschedule_needed", false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.utils.e
 * JD-Core Version:    0.6.2
 */