package com.microsoft.codepush.react;

import android.content.Context;
import android.content.res.Resources;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.devsupport.DevInternalSettings;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.uimanager.ViewManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class a
  implements ReactPackage
{
  private static boolean a = false;
  private static boolean b = false;
  private static boolean c = false;
  private static String d = null;
  private static String k = "https://codepush.azurewebsites.net/";
  private static String n;
  private static n o;
  private static a p;
  private boolean e;
  private String f;
  private g g;
  private e h;
  private o i;
  private String j;
  private Context l;
  private final boolean m;

  private boolean a(JSONObject paramJSONObject)
  {
    try
    {
      String str1 = paramJSONObject.optString("binaryModifiedTime", null);
      Long localLong = null;
      if (str1 != null)
        localLong = Long.valueOf(Long.parseLong(str1));
      String str2 = paramJSONObject.optString("appVersion", null);
      long l1 = e();
      if ((localLong != null) && (localLong.longValue() == l1))
        if (!m())
        {
          boolean bool = d.equals(str2);
          if (!bool);
        }
        else
        {
          return true;
        }
      return false;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      throw new f("Error in reading binary modified date from package metadata", localNumberFormatException);
    }
  }

  public static void b(String paramString)
  {
    d = paramString;
  }

  private boolean b(JSONObject paramJSONObject)
  {
    String str = paramJSONObject.optString("appVersion", null);
    return !d.equals(str);
  }

  public static boolean m()
  {
    return c;
  }

  static ReactInstanceManager o()
  {
    if (o == null)
      return null;
    return o.a();
  }

  private void p()
  {
    JSONObject localJSONObject = this.g.e();
    this.i.a(localJSONObject);
    this.g.g();
    this.i.d();
  }

  public String a(String paramString)
  {
    this.f = paramString;
    String str1 = "assets://" + paramString;
    try
    {
      String str3 = this.g.a(this.f);
      str2 = str3;
      if (str2 == null)
      {
        j.c(str1);
        a = true;
        return str1;
      }
    }
    catch (d locald)
    {
      String str2;
      while (true)
      {
        j.b(locald.getMessage());
        n();
        str2 = null;
      }
      JSONObject localJSONObject = this.g.e();
      if (a(localJSONObject))
      {
        j.c(str2);
        a = false;
        return str2;
      }
      this.e = false;
      if ((!this.m) || (b(localJSONObject)))
        n();
      j.c(str1);
      a = true;
    }
    return str1;
  }

  public void a(ReactInstanceManager paramReactInstanceManager)
  {
    boolean bool = false;
    if (paramReactInstanceManager != null)
    {
      DevSupportManager localDevSupportManager = paramReactInstanceManager.getDevSupportManager();
      bool = false;
      if (localDevSupportManager != null)
        bool = ((DevInternalSettings)localDevSupportManager.getDevSettings()).isReloadOnJSChangeEnabled();
    }
    if ((this.m) && (this.i.b(null)) && (!bool))
    {
      File localFile = new File(this.l.getFilesDir(), "ReactNativeDevBundle.js");
      if (localFile.exists())
        localFile.delete();
    }
  }

  public void a(boolean paramBoolean)
  {
    b = paramBoolean;
  }

  public boolean a()
  {
    return this.e;
  }

  public String b()
  {
    return d;
  }

  public String c()
  {
    return this.f;
  }

  public List<NativeModule> createNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    CodePushNativeModule localCodePushNativeModule = new CodePushNativeModule(paramReactApplicationContext, this, this.g, this.h, this.i);
    CodePushDialog localCodePushDialog = new CodePushDialog(paramReactApplicationContext);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(localCodePushNativeModule);
    localArrayList.add(localCodePushDialog);
    return localArrayList;
  }

  public List<ViewManager> createViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    return new ArrayList();
  }

  public String d()
  {
    return n;
  }

  long e()
  {
    try
    {
      String str = this.l.getPackageName();
      int i1 = this.l.getResources().getIdentifier("CODE_PUSH_APK_BUILD_TIME", "string", str);
      long l1 = Long.parseLong(this.l.getResources().getString(i1).replaceAll("\"", ""));
      return l1;
    }
    catch (Exception localException)
    {
      throw new f("Error in getting binary resources modified time", localException);
    }
  }

  public String f()
  {
    return this.j;
  }

  public String g()
  {
    return k;
  }

  void h()
  {
    this.e = false;
    JSONObject localJSONObject1 = this.i.b();
    if (localJSONObject1 != null)
    {
      JSONObject localJSONObject2 = this.g.e();
      if ((localJSONObject2 == null) || ((!a(localJSONObject2)) && (b(localJSONObject2))))
        j.b("Skipping initializeUpdateAfterRestart(), binary version is newer");
    }
    else
    {
      return;
    }
    try
    {
      if (localJSONObject1.getBoolean("isLoading"))
      {
        j.b("Update did not finish loading the last time, rolling back to a previous version.");
        b = true;
        p();
        return;
      }
    }
    catch (JSONException localJSONException)
    {
      throw new f("Unable to read pending update metadata stored in SharedPreferences", localJSONException);
    }
    this.e = true;
    this.i.a(localJSONObject1.getString("hash"), true);
  }

  void i()
  {
    p = null;
  }

  boolean j()
  {
    return this.m;
  }

  boolean k()
  {
    return a;
  }

  boolean l()
  {
    return b;
  }

  public void n()
  {
    this.g.h();
    this.i.d();
    this.i.c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.microsoft.codepush.react.a
 * JD-Core Version:    0.6.2
 */