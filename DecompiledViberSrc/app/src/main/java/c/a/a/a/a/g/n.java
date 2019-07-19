package c.a.a.a.a.g;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import c.a.a.a.a.b.i;
import c.a.a.a.c;
import c.a.a.a.l;

public class n
{
  public final String a;
  public final int b;
  public final int c;
  public final int d;

  public n(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramString;
    this.b = paramInt1;
    this.c = paramInt2;
    this.d = paramInt3;
  }

  public static n a(Context paramContext, String paramString)
  {
    if (paramString != null)
      try
      {
        int i = i.l(paramContext);
        c.g().a("Fabric", "App icon resource ID is " + i);
        BitmapFactory.Options localOptions = new BitmapFactory.Options();
        localOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(paramContext.getResources(), i, localOptions);
        n localn = new n(paramString, i, localOptions.outWidth, localOptions.outHeight);
        return localn;
      }
      catch (Exception localException)
      {
        c.g().e("Fabric", "Failed to load icon", localException);
      }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.g.n
 * JD-Core Version:    0.6.2
 */