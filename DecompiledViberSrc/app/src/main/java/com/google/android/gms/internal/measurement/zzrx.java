package com.google.android.gms.internal.measurement;

import android.content.ContentResolver;
import android.database.sqlite.SQLiteException;
import android.net.Uri;
import android.support.v4.util.ArrayMap;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class zzrx
  implements zzsb
{
  static final Map<Uri, zzrx> zzbrd = new ArrayMap();
  private static final String[] zzbri = { "key", "value" };
  private final Uri uri;
  private final ContentResolver zzbre;
  private final Object zzbrf = new Object();
  private volatile Map<String, String> zzbrg;
  private final List<zzsa> zzbrh = new ArrayList();

  private zzrx(ContentResolver paramContentResolver, Uri paramUri)
  {
    this.zzbre = paramContentResolver;
    this.uri = paramUri;
    this.zzbre.registerContentObserver(paramUri, false, new zzrz(this, null));
  }

  // ERROR //
  public static zzrx zza(ContentResolver paramContentResolver, Uri paramUri)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 31	com/google/android/gms/internal/measurement/zzrx:zzbrd	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 73 2 0
    //   12: checkcast 2	com/google/android/gms/internal/measurement/zzrx
    //   15: astore_3
    //   16: aload_3
    //   17: ifnonnull +29 -> 46
    //   20: new 2	com/google/android/gms/internal/measurement/zzrx
    //   23: dup
    //   24: aload_0
    //   25: aload_1
    //   26: invokespecial 75	com/google/android/gms/internal/measurement/zzrx:<init>	(Landroid/content/ContentResolver;Landroid/net/Uri;)V
    //   29: astore 4
    //   31: getstatic 31	com/google/android/gms/internal/measurement/zzrx:zzbrd	Ljava/util/Map;
    //   34: aload_1
    //   35: aload 4
    //   37: invokeinterface 79 3 0
    //   42: pop
    //   43: aload 4
    //   45: astore_3
    //   46: ldc 2
    //   48: monitorexit
    //   49: aload_3
    //   50: areturn
    //   51: astore_2
    //   52: ldc 2
    //   54: monitorexit
    //   55: aload_2
    //   56: athrow
    //   57: astore 7
    //   59: goto -13 -> 46
    //   62: astore 5
    //   64: aload 4
    //   66: astore_3
    //   67: goto -21 -> 46
    //
    // Exception table:
    //   from	to	target	type
    //   3	16	51	finally
    //   20	31	51	finally
    //   31	43	51	finally
    //   46	49	51	finally
    //   52	55	51	finally
    //   20	31	57	java/lang/SecurityException
    //   31	43	62	java/lang/SecurityException
  }

  private final Map<String, String> zztm()
  {
    try
    {
      Map localMap = (Map)zzsc.zza(new zzry(this));
      return localMap;
    }
    catch (SQLiteException localSQLiteException)
    {
      Log.e("ConfigurationContentLoader", "PhenotypeFlag unable to load ContentProvider, using default values");
      return null;
    }
    catch (SecurityException localSecurityException)
    {
      label20: break label20;
    }
  }

  public final Map<String, String> zztk()
  {
    Map localMap = this.zzbrg;
    if (localMap == null)
      synchronized (this.zzbrf)
      {
        localMap = this.zzbrg;
        if (localMap == null)
        {
          localMap = zztm();
          this.zzbrg = localMap;
        }
      }
    while (localMap == null)
      return Collections.emptyMap();
    return localMap;
  }

  public final void zztl()
  {
    synchronized (this.zzbrf)
    {
      this.zzbrg = null;
      zzsi.zztq();
      try
      {
        Iterator localIterator = this.zzbrh.iterator();
        while (localIterator.hasNext())
          ((zzsa)localIterator.next()).zztp();
      }
      finally
      {
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzrx
 * JD-Core Version:    0.6.2
 */