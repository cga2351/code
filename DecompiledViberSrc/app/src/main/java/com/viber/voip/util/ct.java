package com.viber.voip.util;

import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.Resources;
import com.viber.dexshared.Logger;
import com.viber.svg.jni.AndroidSvgObject;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class ct
{
  private static final Logger a = ViberEnv.getLogger();
  private static HashMap<String, WeakReference<AndroidSvgObject>> b = new HashMap();
  private static final AndroidSvgObject c = new AndroidSvgObject("dummy", 0);

  public static AndroidSvgObject a(String paramString)
  {
    try
    {
      Object localObject2 = c(paramString);
      if (localObject2 == null)
      {
        AndroidSvgObject localAndroidSvgObject = a(paramString, new a()
        {
          public InputStream a()
            throws IOException
          {
            return ViberApplication.getApplication().getResources().getAssets().open(this.a);
          }
        });
        localObject2 = localAndroidSvgObject;
      }
      return localObject2;
    }
    finally
    {
    }
  }

  private static AndroidSvgObject a(String paramString, a parama)
  {
    AndroidSvgObject localAndroidSvgObject = new AndroidSvgObject(paramString, 0);
    try
    {
      localAndroidSvgObject.parseBuffer(bj.a(parama.a()));
      localAndroidSvgObject.prepare(1, 1);
      WeakReference localWeakReference = new WeakReference(localAndroidSvgObject);
      b.put(paramString, localWeakReference);
      return localAndroidSvgObject;
    }
    catch (IOException localIOException)
    {
    }
    return c;
  }

  public static AndroidSvgObject b(String paramString)
  {
    try
    {
      Object localObject2 = c(paramString);
      if (localObject2 == null)
      {
        AndroidSvgObject localAndroidSvgObject = a(paramString, new a()
        {
          public InputStream a()
            throws IOException
          {
            return new FileInputStream(this.a);
          }
        });
        localObject2 = localAndroidSvgObject;
      }
      return localObject2;
    }
    finally
    {
    }
  }

  private static AndroidSvgObject c(String paramString)
  {
    WeakReference localWeakReference = (WeakReference)b.get(paramString);
    if (localWeakReference == null)
      return null;
    return (AndroidSvgObject)localWeakReference.get();
  }

  private static abstract interface a
  {
    public abstract InputStream a()
      throws IOException;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.ct
 * JD-Core Version:    0.6.2
 */