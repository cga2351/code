package com.viber.voip.fcm;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.google.firebase.iid.FirebaseInstanceId;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.jni.gcm.GcmController;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import com.viber.voip.settings.d.u;
import com.viber.voip.util.ax;
import com.viber.voip.util.cc;
import com.viber.voip.util.dd;
import java.io.IOException;
import org.greenrobot.eventbus.EventBus;

public class c
{
  private static final Logger a = ViberEnv.getLogger();
  private final String[] b = { "MESSENGER", "AP" };
  private final Context c;
  private final Handler d;
  private final EventBus e;
  private final Engine f;

  public c(Context paramContext, Engine paramEngine, EventBus paramEventBus)
  {
    this.c = paramContext.getApplicationContext();
    this.f = paramEngine;
    this.d = av.e.b.a();
    this.e = paramEventBus;
    d();
  }

  private boolean a(String paramString)
  {
    return paramString.equals("373969298204");
  }

  private boolean b(String paramString)
  {
    String[] arrayOfString = this.b;
    int i = arrayOfString.length;
    for (int j = 0; j < i; j++)
      if (arrayOfString[j].equals(paramString))
        return false;
    return true;
  }

  private String c(h paramh, com.viber.common.b.d paramd, String paramString)
  {
    String str = paramh.d();
    if ((!TextUtils.isEmpty(str)) && (b(str)))
    {
      if (a(paramString))
        str = "GCM:" + str;
      return str;
    }
    if (dd.a())
    {
      this.d.post(new d(this, paramh, paramd, paramString));
      return "";
    }
    return d(paramh, paramd, paramString);
  }

  private String d(h paramh, com.viber.common.b.d paramd, String paramString)
  {
    Object localObject = "";
    try
    {
      String str = e(paramh, paramd, paramString);
      localObject = str;
      label17: if ((!TextUtils.isEmpty((CharSequence)localObject)) && (a(paramString)))
        localObject = "GCM:" + (String)localObject;
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      break label17;
    }
  }

  private void d()
  {
    if ((!TextUtils.isEmpty(d.u.a.d())) && (d.u.c.d() != cc.b()))
      f(d.u.a, d.u.c, "373969298204");
    if ((!TextUtils.isEmpty(d.u.b.d())) && (d.u.d.d() != cc.b()))
      f(d.u.b, d.u.d, "631272190743");
  }

  private String e(h paramh, com.viber.common.b.d paramd, String paramString)
  {
    FirebaseInstanceId localFirebaseInstanceId;
    if (ax.a(this.c))
      localFirebaseInstanceId = FirebaseInstanceId.getInstance();
    try
    {
      String str2 = localFirebaseInstanceId.getToken(paramString, "FCM");
      str1 = str2;
      if ((!TextUtils.isEmpty(str1)) && (b(str1)))
      {
        paramh.a(str1);
        paramd.a(cc.b());
        if ("631272190743".equalsIgnoreCase(paramString))
          this.e.post(new a(str1));
        if ("373969298204".equalsIgnoreCase(paramString))
          this.f.getGcmController().updatePushToken("GCM:" + str1);
        return str1;
      }
      paramh.a("");
      return "";
      return "";
    }
    catch (IOException localIOException)
    {
      while (true)
        String str1 = null;
    }
  }

  private void f(h paramh, com.viber.common.b.d paramd, String paramString)
  {
    this.d.post(new e(this, paramh, paramd, paramString));
  }

  void a()
  {
    f(d.u.a, d.u.c, "373969298204");
    f(d.u.b, d.u.d, "631272190743");
  }

  public String b()
  {
    return c(d.u.a, d.u.c, "373969298204");
  }

  public String c()
  {
    return c(d.u.b, d.u.d, "631272190743");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.fcm.c
 * JD-Core Version:    0.6.2
 */