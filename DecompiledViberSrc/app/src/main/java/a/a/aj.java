package a.a;

import android.content.Context;
import com.amazon.device.messaging.ADM;
import com.amazon.device.messaging.development.ADMManifest;
import com.appboy.f.c;

public class aj
{
  private static final String c = c.a(aj.class);
  private final Context a;
  private final ay b;

  public aj(Context paramContext, ay paramay)
  {
    this.a = paramContext;
    this.b = paramay;
  }

  public static boolean a(Context paramContext)
  {
    return (b()) && (b(paramContext));
  }

  private static boolean b()
  {
    try
    {
      Class.forName("com.amazon.device.messaging.ADM");
      return true;
    }
    catch (Exception localException)
    {
      c.c(c, "com.amazon.device.messaging.ADM not found");
    }
    return false;
  }

  private static boolean b(Context paramContext)
  {
    try
    {
      ADMManifest.checkManifestAuthoredProperly(paramContext);
      return true;
    }
    catch (Exception localException)
    {
      c.c(c, "Manifest not authored properly to support ADM.");
      c.b(c, "ADM manifest exception: ", localException);
    }
    return false;
  }

  public void a()
  {
    if (this.b.a() != null)
    {
      c.c(c, "The device is already registered with the ADM server and is eligible to receive ADM messages.");
      c.c(c, "ADM registration id: " + this.b.a());
      this.b.a(this.b.a());
    }
    ADM localADM;
    do
    {
      return;
      localADM = new ADM(this.a);
    }
    while (!localADM.isSupported());
    c.c(c, "Registering with ADM server...");
    localADM.startRegister();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.aj
 * JD-Core Version:    0.6.2
 */