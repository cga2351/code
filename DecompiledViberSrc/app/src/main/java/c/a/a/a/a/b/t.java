package c.a.a.a.a.b;

import android.content.Context;
import android.content.pm.PackageManager;
import c.a.a.a.a.a.b;
import c.a.a.a.a.a.d;
import c.a.a.a.c;
import c.a.a.a.l;

public class t
{
  private final d<String> a = new d()
  {
    public String b(Context paramAnonymousContext)
      throws Exception
    {
      String str = paramAnonymousContext.getPackageManager().getInstallerPackageName(paramAnonymousContext.getPackageName());
      if (str == null)
        str = "";
      return str;
    }
  };
  private final b<String> b = new b();

  public String a(Context paramContext)
  {
    try
    {
      String str = (String)this.b.a(paramContext, this.a);
      boolean bool = "".equals(str);
      if (bool)
        str = null;
      return str;
    }
    catch (Exception localException)
    {
      c.g().e("Fabric", "Failed to determine installer package name", localException);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.b.t
 * JD-Core Version:    0.6.2
 */