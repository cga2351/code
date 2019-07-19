package a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.UUID;

public class ak
  implements aw
{
  final SharedPreferences a;

  public ak(Context paramContext)
  {
    this.a = paramContext.getSharedPreferences("com.appboy.device", 0);
  }

  private void a(String paramString)
  {
    SharedPreferences.Editor localEditor = this.a.edit();
    localEditor.putString("device_id", paramString);
    localEditor.putString("persistent_device_id", b());
    localEditor.apply();
  }

  static String b()
  {
    if ("android_id" != null)
      return String.valueOf("android_id".hashCode());
    return "";
  }

  private boolean c()
  {
    boolean bool1 = this.a.contains("persistent_device_id");
    boolean bool2 = false;
    if (bool1)
    {
      String str = this.a.getString("persistent_device_id", "");
      boolean bool3 = b().equals(str);
      bool2 = false;
      if (!bool3)
        bool2 = true;
    }
    return bool2;
  }

  public String a()
  {
    String str1 = this.a.getString("device_id", null);
    boolean bool = c();
    String str2 = null;
    if (bool);
    while (true)
    {
      if (str2 == null)
      {
        str2 = UUID.randomUUID().toString();
        a(str2);
      }
      while (this.a.contains("persistent_device_id"))
        return str2;
      a(str2);
      return str2;
      str2 = str1;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.ak
 * JD-Core Version:    0.6.2
 */