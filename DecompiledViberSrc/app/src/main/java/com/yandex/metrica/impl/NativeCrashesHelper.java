package com.yandex.metrica.impl;

import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;
import java.util.concurrent.ExecutorService;

class NativeCrashesHelper
{
  private String a;
  private final Context b;
  private boolean c;
  private boolean d;

  NativeCrashesHelper(Context paramContext)
  {
    this.b = paramContext;
  }

  private static boolean b(boolean paramBoolean)
  {
    try
    {
      logsEnabled(paramBoolean);
      return true;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  private boolean c()
  {
    return this.a != null;
  }

  private static native void cancelSetUpNativeUncaughtExceptionHandler();

  private boolean d()
  {
    return (c()) && (this.c);
  }

  private static native void logsEnabled(boolean paramBoolean);

  private static native void setUpNativeUncaughtExceptionHandler(String paramString);

  void a(bj parambj, ExecutorService paramExecutorService)
  {
    try
    {
      if (d())
      {
        paramExecutorService.execute(new a(parambj, this));
        this.c = false;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void a(boolean paramBoolean)
  {
    if (paramBoolean);
    while (true)
    {
      try
      {
        if ((!this.d) && (b()))
        {
          b(false);
          this.a = (this.b.getFilesDir().getAbsolutePath() + "/YandexMetricaNativeCrashes");
        }
        this.d = true;
        if (c())
        {
          setUpNativeUncaughtExceptionHandler(this.a);
          this.c = true;
        }
        return;
      }
      catch (Throwable localThrowable2)
      {
        this.c = false;
        continue;
      }
      finally
      {
      }
      try
      {
        if (d())
          cancelSetUpNativeUncaughtExceptionHandler();
        label109: this.c = false;
      }
      catch (Throwable localThrowable1)
      {
        break label109;
      }
    }
  }

  public boolean a()
  {
    return this.c;
  }

  boolean b()
  {
    try
    {
      System.loadLibrary("YandexMetricaNativeModule");
      return true;
    }
    catch (Throwable localThrowable)
    {
    }
    return false;
  }

  private static class a
    implements Runnable
  {
    private final bj a;
    private final NativeCrashesHelper b;

    a(bj parambj, NativeCrashesHelper paramNativeCrashesHelper)
    {
      this.b = paramNativeCrashesHelper;
      this.a = parambj;
    }

    public void run()
    {
      String str1 = NativeCrashesHelper.a(this.b);
      String[] arrayOfString = NativeCrashesHelper.a(this.b, str1);
      int i = arrayOfString.length;
      int j = 0;
      while (j < i)
      {
        String str2 = arrayOfString[j];
        String str3 = str1 + "/" + str2;
        try
        {
          String str4 = w.b(w.a(str3));
          if (str4 != null)
            this.a.a(str4);
          new File(str3).delete();
          j++;
        }
        catch (Exception localException)
        {
          while (true)
            new File(str3).delete();
        }
        finally
        {
          new File(str3).delete();
        }
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.NativeCrashesHelper
 * JD-Core Version:    0.6.2
 */