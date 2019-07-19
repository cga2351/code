package a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appboy.f.i;

public class gi
{
  private final SharedPreferences a;

  public gi(Context paramContext)
  {
    this.a = paramContext.getSharedPreferences("com.appboy.offline.storagemap", 0);
  }

  public String a()
  {
    return this.a.getString("last_user", "");
  }

  public void a(String paramString)
  {
    i.a(paramString);
    SharedPreferences.Editor localEditor = this.a.edit();
    localEditor.putString("last_user", paramString);
    localEditor.apply();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.gi
 * JD-Core Version:    0.6.2
 */