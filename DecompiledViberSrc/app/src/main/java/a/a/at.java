package a.a;

import android.content.Context;
import com.appboy.a;
import com.appboy.a.b;
import com.appboy.f.c;
import com.appboy.f.i;
import java.lang.reflect.Method;

public class at
{
  private static final String a = c.a(at.class);
  private static final String[] b = { "com.google.firebase.iid.FirebaseInstanceId" };
  private final Context c;

  public at(Context paramContext)
  {
    this.c = paramContext;
  }

  public static boolean a(Context paramContext, b paramb)
  {
    if (i.b(paramb.w()))
    {
      c.d(a, "Firebase Cloud Messaging requires a non-null and non-empty sender ID.");
      return false;
    }
    if (!dn.b(paramContext))
    {
      c.d(a, "Firebase Cloud Messaging requires the Google Play Store to be installed.");
      return false;
    }
    while (true)
    {
      int j;
      try
      {
        ClassLoader localClassLoader = at.class.getClassLoader();
        String[] arrayOfString = b;
        int i = arrayOfString.length;
        j = 0;
        if (j >= i)
          break;
        String str = arrayOfString[j];
        if (Class.forName(str, false, localClassLoader) == null)
        {
          c.d(a, "Automatic registration for Firebase Cloud Messaging requires the following class to be present: " + str);
          return false;
        }
      }
      catch (Exception localException)
      {
        c.d(a, "Caught error while checking for required classes for Firebase Cloud Messaging.", localException);
        return false;
      }
      j++;
    }
    return true;
  }

  private static String b(String paramString)
  {
    try
    {
      Method localMethod1 = du.a("com.google.firebase.iid.FirebaseInstanceId", "getInstance", new Class[0]);
      if (localMethod1 == null)
      {
        c.d(a, "Firebase Cloud Messaging 'getInstance' method could not obtained. Not registering for Firebase Cloud Messaging.");
        return null;
      }
      Object localObject1 = du.a(null, localMethod1, new Object[0]);
      if (localObject1 == null)
      {
        c.d(a, "Firebase Cloud Messaging 'InstanceId' object could not invoked. Not registering for Firebase Cloud Messaging.");
        return null;
      }
      Method localMethod2 = du.a(localObject1.getClass(), "getToken", new Class[] { String.class, String.class });
      if (localMethod2 == null)
      {
        c.d(a, "Firebase Cloud Messaging 'FirebaseInstanceId.getInstance().getToken()' method could not obtained. Not registering for Firebase Cloud Messaging.");
        return null;
      }
      Object localObject2 = du.a(localObject1, localMethod2, new Object[] { paramString, "FCM" });
      if ((localObject2 != null) && ((localObject2 instanceof String)))
      {
        String str = (String)localObject2;
        return str;
      }
      return null;
    }
    catch (Exception localException)
    {
      c.d(a, "Failed to register for Firebase Cloud Messaging", localException);
    }
    return null;
  }

  public void a(String paramString)
  {
    String str = b(paramString);
    if (!i.b(str))
    {
      a.a(this.c).e(str);
      return;
    }
    c.d(a, "Obtained an empty or null Firebase Cloud Messaging registration token. Not registering token.");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.at
 * JD-Core Version:    0.6.2
 */