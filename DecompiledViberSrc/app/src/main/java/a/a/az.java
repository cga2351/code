package a.a;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.appboy.a.b;
import com.appboy.f.c;

public class az
  implements ay
{
  private static final String b = c.a(az.class);
  final SharedPreferences a;
  private final b c;

  public az(Context paramContext, b paramb)
  {
    this.c = paramb;
    this.a = paramContext.getSharedPreferences("com.appboy.push_registration", 0);
  }

  private boolean b()
  {
    return (this.c.c()) || (this.c.u());
  }

  public String a()
  {
    while (true)
    {
      try
      {
        Object localObject2;
        if ((b()) && (this.a.contains("version_code")))
        {
          int i = this.c.i();
          int j = this.a.getInt("version_code", -2147483648);
          localObject2 = null;
          if (i != j)
            return localObject2;
        }
        String str1;
        if (this.a.contains("device_identifier"))
        {
          String str2 = this.a.getString("device_identifier", "");
          if (!ak.b().equals(str2))
          {
            c.c(b, "Device identifier differs from saved device identifier. Returning null token.");
            localObject2 = null;
            continue;
          }
        }
      }
      finally
      {
      }
      str1 = this.a.getString("registration_id", null);
      localObject2 = str1;
    }
  }

  public void a(String paramString)
  {
    if (paramString == null)
      try
      {
        throw new NullPointerException();
      }
      finally
      {
      }
    SharedPreferences.Editor localEditor = this.a.edit();
    localEditor.putString("registration_id", paramString);
    localEditor.putInt("version_code", this.c.i());
    localEditor.putString("device_identifier", ak.b());
    localEditor.apply();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.az
 * JD-Core Version:    0.6.2
 */