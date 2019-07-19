package com.viber.deviceinfo;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import android.text.Html;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.widget.RemoteViews;
import com.viber.common.d.a;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.ap;
import com.viber.voip.util.upload.o;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WidgetProvider extends AppWidgetProvider
{
  private CharSequence a(Context paramContext)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("Version", a());
    localLinkedHashMap.put("Model", b());
    localLinkedHashMap.put("Viber number", b(paramContext));
    localLinkedHashMap.put("Display", c(paramContext));
    localLinkedHashMap.put("Density", e(paramContext));
    localLinkedHashMap.put("RAM", h(paramContext));
    localLinkedHashMap.put("External storage", i(paramContext));
    localLinkedHashMap.put("Internal storage", j(paramContext));
    localLinkedHashMap.put("Heap size", k(paramContext));
    localLinkedHashMap.put("IP", l(paramContext));
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = localLinkedHashMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append("<br/>").append("<b>").append((String)localEntry.getKey()).append(":</b> ").append((String)localEntry.getValue());
    }
    localStringBuilder.delete(0, "<br/>".length());
    return Html.fromHtml(localStringBuilder.toString());
  }

  private String a()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Build.VERSION.RELEASE;
    arrayOfObject[1] = Integer.valueOf(Build.VERSION.SDK_INT);
    return String.format("%s (API %d)", arrayOfObject);
  }

  private String a(Context paramContext, StatFs paramStatFs)
  {
    long l1 = paramStatFs.getBlockSize();
    long l2 = paramStatFs.getBlockCount();
    long l3 = paramStatFs.getAvailableBlocks();
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Formatter.formatFileSize(paramContext, l3 * l1);
    arrayOfObject[1] = Formatter.formatFileSize(paramContext, l1 * l2);
    return String.format("%s of %s free", arrayOfObject);
  }

  private String b()
  {
    String str1 = Build.MANUFACTURER;
    String str2 = Build.MODEL;
    if (str2.startsWith(str1))
      return str2;
    return str1.toUpperCase() + " " + str2;
  }

  private String b(Context paramContext)
  {
    Account[] arrayOfAccount = AccountManager.get(paramContext).getAccounts();
    int i = arrayOfAccount.length;
    String str = "unknown";
    for (int j = 0; j < i; j++)
    {
      Account localAccount = arrayOfAccount[j];
      if (localAccount.type.startsWith("com.viber"))
        str = localAccount.name;
    }
    return str + " (" + ap.d() + ")";
  }

  private String c(Context paramContext)
  {
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = d(paramContext);
    arrayOfObject[1] = g(paramContext);
    arrayOfObject[2] = f(paramContext);
    return String.format("%s, %s-%s", arrayOfObject);
  }

  private String d(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    return localDisplayMetrics.widthPixels + "x" + localDisplayMetrics.heightPixels;
  }

  private String e(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics = paramContext.getResources().getDisplayMetrics();
    DecimalFormat localDecimalFormat = new DecimalFormat("#.##");
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(localDisplayMetrics.densityDpi);
    arrayOfObject[1] = localDecimalFormat.format(localDisplayMetrics.density);
    arrayOfObject[2] = localDecimalFormat.format(localDisplayMetrics.scaledDensity);
    return String.format("%ddpi (x%s dp, x%s sp)", arrayOfObject);
  }

  private String f(Context paramContext)
  {
    float f = paramContext.getResources().getDisplayMetrics().density;
    if (f >= 4.0D)
      return "xxxhdpi";
    if (f >= 3.0D)
      return "xxhdpi";
    if (f >= 2.0D)
      return "xhdpi";
    if (f >= 1.5D)
      return "hdpi";
    if (f >= 1.33D)
      return "tvdpi";
    if (f >= 1.0D)
      return "mdpi";
    return "ldpi";
  }

  private String g(Context paramContext)
  {
    switch (0xF & paramContext.getResources().getConfiguration().screenLayout)
    {
    default:
      return "undefined";
    case 4:
      return "xlarge";
    case 3:
      return "large";
    case 2:
      return "normal";
    case 1:
    }
    return "small";
  }

  private String h(Context paramContext)
  {
    ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
    ActivityManager.MemoryInfo localMemoryInfo = new ActivityManager.MemoryInfo();
    localActivityManager.getMemoryInfo(localMemoryInfo);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(Formatter.formatFileSize(paramContext, localMemoryInfo.availMem));
    if (a.a())
      localStringBuilder.append(" of ").append(Formatter.formatFileSize(paramContext, localMemoryInfo.totalMem));
    localStringBuilder.append(" free");
    return localStringBuilder.toString();
  }

  private String i(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    if (Environment.isExternalStorageEmulated())
      localArrayList.add("emulated");
    if (Environment.isExternalStorageRemovable());
    for (String str = "removable"; ; str = "built in")
    {
      localArrayList.add(str);
      localArrayList.add(o.e());
      localArrayList.add(a(paramContext, new StatFs(Environment.getExternalStorageDirectory().getPath())));
      return TextUtils.join(", ", localArrayList);
    }
  }

  private String j(Context paramContext)
  {
    return a(paramContext, new StatFs(Environment.getDataDirectory().getPath()));
  }

  private String k(Context paramContext)
  {
    ActivityManager localActivityManager = (ActivityManager)paramContext.getSystemService("activity");
    return localActivityManager.getMemoryClass() + "MB, " + localActivityManager.getLargeMemoryClass() + "MB(large)";
  }

  private String l(Context paramContext)
  {
    int i = ((WifiManager)paramContext.getSystemService("wifi")).getConnectionInfo().getIpAddress();
    Object[] arrayOfObject = new Object[4];
    arrayOfObject[0] = Integer.valueOf(i & 0xFF);
    arrayOfObject[1] = Integer.valueOf(0xFF & i >> 8);
    arrayOfObject[2] = Integer.valueOf(0xFF & i >> 16);
    arrayOfObject[3] = Integer.valueOf(0xFF & i >> 24);
    return String.format("%d.%d.%d.%d", arrayOfObject);
  }

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    super.onReceive(paramContext, paramIntent);
    if ("com.viber.deviceinfo.ACTION_UPDATE".equals(paramIntent.getAction()))
    {
      RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), R.layout.widget_deviceinfo);
      localRemoteViews.setTextViewText(R.id.info, a(paramContext));
      localRemoteViews.setTextViewText(R.id.version, "v11.0.1.0");
      AppWidgetManager.getInstance(paramContext).updateAppWidget(new ComponentName(paramContext, getClass()), localRemoteViews);
    }
  }

  public void onUpdate(Context paramContext, AppWidgetManager paramAppWidgetManager, int[] paramArrayOfInt)
  {
    RemoteViews localRemoteViews = new RemoteViews(paramContext.getPackageName(), R.layout.widget_deviceinfo);
    localRemoteViews.setTextViewText(R.id.info, a(paramContext));
    localRemoteViews.setTextViewText(R.id.version, "v11.0.1.0");
    localRemoteViews.setOnClickPendingIntent(R.id.root, PendingIntent.getBroadcast(paramContext, 0, new Intent(paramContext, getClass()).setAction("com.viber.deviceinfo.ACTION_UPDATE"), 0));
    paramAppWidgetManager.updateAppWidget(paramArrayOfInt, localRemoteViews);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.deviceinfo.WidgetProvider
 * JD-Core Version:    0.6.2
 */