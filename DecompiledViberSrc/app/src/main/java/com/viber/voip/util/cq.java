package com.viber.voip.util;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Point;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore.Images.Media;
import android.view.Display;
import android.view.WindowManager;
import com.viber.common.d.a;
import com.viber.common.permission.c;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import java.lang.reflect.Method;

public class cq
{
  private static final Logger a = ViberEnv.getLogger();
  private static final String[] b = { "_data", "_display_name", "bucket_display_name", "datetaken", "title" };
  private Context c;
  private a d;
  private b e;
  private b f;
  private long g;
  private long h;
  private Runnable i = new Runnable()
  {
    public void run()
    {
      if (cq.a(cq.this) != null)
        cq.a(cq.this).l();
    }
  };

  static
  {
    if (a.a())
    {
      b = new String[] { "_data", "_display_name", "bucket_display_name", "datetaken", "title", "width", "height" };
      return;
    }
  }

  public cq(Context paramContext)
  {
    this.c = paramContext.getApplicationContext();
  }

  private void a(Uri paramUri)
  {
    Point localPoint = c();
    Context localContext = this.c;
    String[] arrayOfString1 = b;
    String[] arrayOfString2 = new String[2];
    arrayOfString2[0] = Long.toString(Math.max(this.g, this.h));
    arrayOfString2[1] = Long.toString(System.currentTimeMillis());
    Cursor localCursor = af.a(localContext, paramUri, arrayOfString1, "datetaken BETWEEN ? AND ?", "date_added DESC LIMIT 1", arrayOfString2);
    long l1 = 0L;
    String str1;
    long l2;
    int j;
    int k;
    if (af.c(localCursor))
    {
      str1 = localCursor.getString(localCursor.getColumnIndex("_data"));
      String str2 = localCursor.getString(localCursor.getColumnIndex("_display_name"));
      String str3 = localCursor.getString(localCursor.getColumnIndex("bucket_display_name"));
      l2 = localCursor.getLong(localCursor.getColumnIndex("datetaken"));
      String str4 = localCursor.getString(localCursor.getColumnIndex("title"));
      boolean bool = a.a();
      j = 0;
      k = 0;
      if (bool)
      {
        k = localCursor.getInt(localCursor.getColumnIndex("width"));
        j = localCursor.getInt(localCursor.getColumnIndex("height"));
      }
      if (((str1 == null) || (!str1.toLowerCase().contains("screenshot"))) && ((str2 == null) || (!str2.toLowerCase().contains("screenshot"))) && ((str3 == null) || (!str3.toLowerCase().contains("screenshot"))) && ((str4 != null) && (str4.toLowerCase().contains("screenshot")) && ((k != 0) && (j != 0))));
    }
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inJustDecodeBounds = true;
      BitmapFactory.decodeFile(str1, localOptions);
      k = localOptions.outWidth;
      j = localOptions.outHeight;
      if ((k > 0) && (j > 0) && ((k != localPoint.x) || (j != localPoint.y)))
      {
        if (j == localPoint.x)
        {
          int m = localPoint.y;
          if (k != m);
        }
      }
      else
        l1 = l2;
      af.a(localCursor);
      if (l1 > 0L)
      {
        this.g = l1;
        av.e.a.a().post(this.i);
      }
      return;
    }
    catch (Exception localException)
    {
      while (true)
        l1 = l2;
    }
  }

  private Point c()
  {
    Point localPoint = new Point();
    WindowManager localWindowManager = (WindowManager)this.c.getSystemService("window");
    if (a.b())
    {
      localWindowManager.getDefaultDisplay().getRealSize(localPoint);
      return localPoint;
    }
    try
    {
      Method localMethod1 = Display.class.getMethod("getRawWidth", new Class[0]);
      Method localMethod2 = Display.class.getMethod("getRawHeight", new Class[0]);
      localPoint.set(((Integer)localMethod1.invoke(localWindowManager.getDefaultDisplay(), new Object[0])).intValue(), ((Integer)localMethod2.invoke(localWindowManager.getDefaultDisplay(), new Object[0])).intValue());
      return localPoint;
    }
    catch (Exception localException)
    {
      localPoint.set(localWindowManager.getDefaultDisplay().getWidth(), localWindowManager.getDefaultDisplay().getHeight());
    }
    return localPoint;
  }

  public void a()
  {
    if (!c.a(this.c).a(new String[] { "android.permission.READ_EXTERNAL_STORAGE" }));
    do
    {
      return;
      this.h = System.currentTimeMillis();
      if (this.e == null)
      {
        this.e = new b(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        this.c.getContentResolver().registerContentObserver(this.e.a(), false, this.e);
      }
    }
    while (this.f != null);
    this.f = new b(MediaStore.Images.Media.INTERNAL_CONTENT_URI);
    this.c.getContentResolver().registerContentObserver(this.f.a(), false, this.f);
  }

  public void a(a parama)
  {
    this.d = parama;
  }

  public void b()
  {
    this.h = 0L;
    if (this.e != null)
    {
      this.c.getContentResolver().unregisterContentObserver(this.e);
      this.e = null;
    }
    if (this.f != null)
    {
      this.c.getContentResolver().unregisterContentObserver(this.f);
      this.f = null;
    }
  }

  public static abstract interface a
  {
    public abstract void l();
  }

  private class b extends ContentObserver
  {
    Uri a;

    b(Uri arg2)
    {
      super();
      Object localObject;
      this.a = localObject;
    }

    Uri a()
    {
      return this.a;
    }

    public void onChange(boolean paramBoolean)
    {
      super.onChange(paramBoolean);
      cq.a(cq.this, this.a);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.cq
 * JD-Core Version:    0.6.2
 */