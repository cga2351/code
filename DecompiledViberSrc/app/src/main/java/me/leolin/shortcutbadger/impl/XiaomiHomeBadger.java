package me.leolin.shortcutbadger.impl;

import android.annotation.TargetApi;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import me.leolin.shortcutbadger.b;

@Deprecated
public class XiaomiHomeBadger
  implements me.leolin.shortcutbadger.a
{
  private ResolveInfo a;

  @TargetApi(16)
  private void a(Context paramContext, int paramInt)
    throws b
  {
    if (this.a == null)
    {
      Intent localIntent = new Intent("android.intent.action.MAIN");
      localIntent.addCategory("android.intent.category.HOME");
      this.a = paramContext.getPackageManager().resolveActivity(localIntent, 65536);
    }
    NotificationManager localNotificationManager;
    Notification localNotification;
    if (this.a != null)
    {
      localNotificationManager = (NotificationManager)paramContext.getSystemService("notification");
      localNotification = new Notification.Builder(paramContext).setContentTitle("").setContentText("").setSmallIcon(this.a.getIconResource()).build();
    }
    try
    {
      Object localObject = localNotification.getClass().getDeclaredField("extraNotification").get(localNotification);
      Class localClass = localObject.getClass();
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Integer.TYPE;
      Method localMethod = localClass.getDeclaredMethod("setMessageCount", arrayOfClass);
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Integer.valueOf(paramInt);
      localMethod.invoke(localObject, arrayOfObject);
      localNotificationManager.notify(0, localNotification);
      return;
    }
    catch (Exception localException)
    {
      throw new b("not able to set badge", localException);
    }
  }

  public List<String> a()
  {
    return Arrays.asList(new String[] { "com.miui.miuilite", "com.miui.home", "com.miui.miuihome", "com.miui.miuihome2", "com.miui.mihome", "com.miui.mihome2", "com.i.miui.launcher" });
  }

  public void a(Context paramContext, ComponentName paramComponentName, int paramInt)
    throws b
  {
    Intent localIntent;
    try
    {
      Object localObject2 = Class.forName("android.app.MiuiNotification").newInstance();
      Field localField = localObject2.getClass().getDeclaredField("messageCount");
      localField.setAccessible(true);
      Object localObject3;
      if (paramInt == 0)
        localObject3 = "";
      try
      {
        while (true)
        {
          localField.set(localObject2, String.valueOf(localObject3));
          if (Build.MANUFACTURER.equalsIgnoreCase("Xiaomi"))
            a(paramContext, paramInt);
          return;
          Integer localInteger = Integer.valueOf(paramInt);
          localObject3 = localInteger;
        }
      }
      catch (Exception localException2)
      {
        while (true)
          localField.set(localObject2, Integer.valueOf(paramInt));
      }
    }
    catch (Exception localException1)
    {
      localIntent = new Intent("android.intent.action.APPLICATION_MESSAGE_UPDATE");
      localIntent.putExtra("android.intent.extra.update_application_component_name", paramComponentName.getPackageName() + "/" + paramComponentName.getClassName());
      if (paramInt != 0);
    }
    for (Object localObject1 = ""; ; localObject1 = Integer.valueOf(paramInt))
    {
      while (true)
      {
        localIntent.putExtra("android.intent.extra.update_application_message_text", String.valueOf(localObject1));
        try
        {
          me.leolin.shortcutbadger.a.a.b(paramContext, localIntent);
        }
        catch (b localb)
        {
        }
      }
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     me.leolin.shortcutbadger.impl.XiaomiHomeBadger
 * JD-Core Version:    0.6.2
 */