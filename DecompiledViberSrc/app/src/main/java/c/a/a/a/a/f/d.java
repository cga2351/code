package c.a.a.a.a.f;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import c.a.a.a.i;

public class d
  implements c
{
  private final SharedPreferences a;
  private final String b;
  private final Context c;

  public d(Context paramContext, String paramString)
  {
    if (paramContext == null)
      throw new IllegalStateException("Cannot get directory before context has been set. Call Fabric.with() first");
    this.c = paramContext;
    this.b = paramString;
    this.a = this.c.getSharedPreferences(this.b, 0);
  }

  @Deprecated
  public d(i parami)
  {
    this(parami.r(), parami.getClass().getName());
  }

  public SharedPreferences a()
  {
    return this.a;
  }

  @TargetApi(9)
  public boolean a(SharedPreferences.Editor paramEditor)
  {
    if (Build.VERSION.SDK_INT >= 9)
    {
      paramEditor.apply();
      return true;
    }
    return paramEditor.commit();
  }

  public SharedPreferences.Editor b()
  {
    return this.a.edit();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.f.d
 * JD-Core Version:    0.6.2
 */