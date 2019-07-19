package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Looper;
import android.util.DisplayMetrics;
import android.view.View;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;
import java.util.UUID;

public final class zzef
{
  private static final char[] zzym = "0123456789abcdef".toCharArray();

  public static boolean isMainThread()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }

  public static long zza(double paramDouble, DisplayMetrics paramDisplayMetrics)
  {
    return Math.round(paramDouble / paramDisplayMetrics.density);
  }

  public static String zza(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    zzdma.zza(paramThrowable, new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }

  public static boolean zza(DisplayMetrics paramDisplayMetrics)
  {
    return (paramDisplayMetrics != null) && (paramDisplayMetrics.density != 0.0F);
  }

  public static String zzap(String paramString)
  {
    if ((paramString != null) && (paramString.matches("^[a-fA-F0-9]{8}-([a-fA-F0-9]{4}-){3}[a-fA-F0-9]{12}$")))
    {
      UUID localUUID = UUID.fromString(paramString);
      byte[] arrayOfByte = new byte[16];
      ByteBuffer localByteBuffer = ByteBuffer.wrap(arrayOfByte);
      localByteBuffer.putLong(localUUID.getMostSignificantBits());
      localByteBuffer.putLong(localUUID.getLeastSignificantBits());
      paramString = zzcg.zza(arrayOfByte, true);
    }
    return paramString;
  }

  public static boolean zzaq(String paramString)
  {
    return (paramString == null) || (paramString.isEmpty());
  }

  public static Activity zzc(View paramView)
  {
    int i = 0;
    View localView = paramView.getRootView();
    if (localView != null)
      paramView = localView;
    Context localContext = paramView.getContext();
    while (((localContext instanceof ContextWrapper)) && (i < 10))
    {
      if ((localContext instanceof Activity))
        return (Activity)localContext;
      localContext = ((ContextWrapper)localContext).getBaseContext();
      i++;
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzef
 * JD-Core Version:    0.6.2
 */