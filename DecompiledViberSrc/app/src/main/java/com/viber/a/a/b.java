package com.viber.a.a;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.StatFs;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.p;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class b
{
  public static int t = R.string.crash_report_mail;
  private static final Logger u = ViberEnv.getLogger();
  private static b w;
  String a;
  String b;
  String c;
  String d;
  String e;
  String f;
  String g;
  String h;
  String i;
  String j;
  String k;
  String l;
  String m;
  String n;
  String o;
  long p;
  String q;
  String r;
  HashMap<String, String> s = new HashMap();
  private Context v;

  public static b a()
  {
    if (w == null)
      w = new b();
    return w;
  }

  private void b(String paramString)
  {
    try
    {
      int i1 = new Random().nextInt(99999);
      String str = "stack-" + i1 + "_" + p.f() + ".stacktrace";
      BufferedWriter localBufferedWriter = new BufferedWriter(new FileWriter(p.h() + str));
      localBufferedWriter.write(paramString);
      localBufferedWriter.close();
      return;
    }
    catch (Exception localException)
    {
    }
  }

  private String e()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator = this.s.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      String str2 = (String)this.s.get(str1);
      localStringBuilder.append(str1).append(" = ").append(str2).append("\n");
    }
    return localStringBuilder.toString();
  }

  public void a(Context paramContext)
  {
    this.v = paramContext;
  }

  public void a(String paramString)
  {
    Date localDate = new Date();
    String str1 = "" + "Error Report collected on : " + localDate.toString();
    String str2 = str1 + "\n";
    String str3 = str2 + "\n";
    String str4 = str3 + "Informations :";
    String str5 = str4 + "\n";
    String str6 = str5 + "==============";
    String str7 = str6 + "\n";
    String str8 = str7 + "\n";
    String str9 = str8 + d();
    String str10 = str9 + "Custom Informations :\n";
    String str11 = str10 + "=====================\n";
    String str12 = str11 + e();
    String str13 = str12 + "\n\n";
    String str14 = str13 + "Stack : \n";
    String str15 = str14 + "======= \n";
    String str16 = str15 + paramString;
    String str17 = str16 + "\n";
    String str18 = str17 + "Cause : \n";
    String str19 = str18 + "======= \n";
    b(str19 + "****  End of current Report ***");
  }

  public void a(Thread paramThread, Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    String str = "";
    try
    {
      paramThrowable.printStackTrace(localPrintWriter);
      str = localStringWriter.toString();
      Throwable localThrowable;
      for (Object localObject = paramThrowable.getCause(); localObject != null; localObject = localThrowable)
      {
        ((Throwable)localObject).printStackTrace(localPrintWriter);
        str = str + localStringWriter.toString();
        localThrowable = ((Throwable)localObject).getCause();
      }
    }
    catch (Exception localException)
    {
      localPrintWriter.close();
      a(str);
    }
  }

  public long b()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    return localStatFs.getBlockSize() * localStatFs.getAvailableBlocks();
  }

  void b(Context paramContext)
  {
    try
    {
      PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramContext.getPackageName(), 0);
      this.a = localPackageInfo.versionName;
      this.b = localPackageInfo.packageName;
      this.d = Build.MODEL;
      this.e = Build.VERSION.RELEASE;
      this.f = Build.BOARD;
      this.g = Build.BRAND;
      this.h = Build.DEVICE;
      this.i = Build.DISPLAY;
      this.j = Build.FINGERPRINT;
      this.k = Build.HOST;
      this.l = Build.ID;
      this.m = Build.MODEL;
      this.n = Build.PRODUCT;
      this.o = Build.TAGS;
      this.p = Build.TIME;
      this.q = Build.TYPE;
      this.r = Build.USER;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }

  public long c()
  {
    StatFs localStatFs = new StatFs(Environment.getDataDirectory().getPath());
    return localStatFs.getBlockSize() * localStatFs.getBlockCount();
  }

  public String d()
  {
    b(this.v);
    String str1 = "" + "Viber Version : " + p.f();
    String str2 = str1 + "\n";
    String str3 = str2 + "Version : " + this.a;
    String str4 = str3 + "\n";
    String str5 = str4 + "Package : " + this.b;
    String str6 = str5 + "\n";
    String str7 = str6 + "FilePath : " + this.c;
    String str8 = str7 + "\n";
    String str9 = str8 + "Phone Model" + this.d;
    String str10 = str9 + "\n";
    String str11 = str10 + "Android Version : " + this.e;
    String str12 = str11 + "\n";
    String str13 = str12 + "Board : " + this.f;
    String str14 = str13 + "\n";
    String str15 = str14 + "Brand : " + this.g;
    String str16 = str15 + "\n";
    String str17 = str16 + "Device : " + this.h;
    String str18 = str17 + "\n";
    String str19 = str18 + "Display : " + this.i;
    String str20 = str19 + "\n";
    String str21 = str20 + "Finger Print : " + this.j;
    String str22 = str21 + "\n";
    String str23 = str22 + "Host : " + this.k;
    String str24 = str23 + "\n";
    String str25 = str24 + "ID : " + this.l;
    String str26 = str25 + "\n";
    String str27 = str26 + "Model : " + this.m;
    String str28 = str27 + "\n";
    String str29 = str28 + "Product : " + this.n;
    String str30 = str29 + "\n";
    String str31 = str30 + "Tags : " + this.o;
    String str32 = str31 + "\n";
    String str33 = str32 + "Time : " + this.p;
    String str34 = str33 + "\n";
    String str35 = str34 + "Type : " + this.q;
    String str36 = str35 + "\n";
    String str37 = str36 + "User : " + this.r;
    String str38 = str37 + "\n";
    String str39 = str38 + "Total Internal memory : " + c();
    String str40 = str39 + "\n";
    String str41 = str40 + "Available Internal memory : " + b();
    return str41 + "\n";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.a.a.b
 * JD-Core Version:    0.6.2
 */