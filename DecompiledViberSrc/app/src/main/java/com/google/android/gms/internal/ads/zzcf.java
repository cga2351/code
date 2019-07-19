package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public abstract class zzcf<K, V>
{
  private static final String TAG = zzcf.class.getSimpleName();

  protected static <K, V> HashMap<K, V> zzal(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        HashMap localHashMap = (HashMap)new ObjectInputStream(new ByteArrayInputStream(Base64.decode(paramString.getBytes(), 0))).readObject();
        return localHashMap;
      }
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Log.d(TAG, "decode object failure");
      return null;
    }
    catch (IOException localIOException)
    {
      label41: break label41;
    }
  }

  public String toString()
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
      localObjectOutputStream.writeObject(zzca());
      localObjectOutputStream.close();
      String str = Base64.encodeToString(localByteArrayOutputStream.toByteArray(), 0);
      return str;
    }
    catch (IOException localIOException)
    {
    }
    return null;
  }

  protected abstract void zzak(String paramString);

  protected abstract HashMap<K, V> zzca();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcf
 * JD-Core Version:    0.6.2
 */