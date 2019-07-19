package a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appboy.f.c;

public class dc
{
  private static final String a = c.a(dc.class);
  private final SharedPreferences b;

  public dc(Context paramContext)
  {
    this.b = paramContext.getSharedPreferences("persistent.com.appboy.storage.sdk_enabled_cache", 0);
  }

  public void a(boolean paramBoolean)
  {
    c.c(a, "Setting Appboy SDK disabled to: " + paramBoolean);
    this.b.edit().putBoolean("appboy_sdk_disabled", paramBoolean).apply();
  }

  public boolean a()
  {
    return this.b.getBoolean("appboy_sdk_disabled", false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.dc
 * JD-Core Version:    0.6.2
 */