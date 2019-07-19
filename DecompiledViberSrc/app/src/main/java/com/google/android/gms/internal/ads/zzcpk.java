package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzcpk extends zzapa
{
  private final zzcpj zzgdk;
  private zzbbs<JSONObject> zzgdl;
  private final JSONObject zzgdm = new JSONObject();

  @GuardedBy("this")
  private boolean zzgdn = false;

  public zzcpk(zzcpj paramzzcpj, zzbbs<JSONObject> paramzzbbs)
  {
    this.zzgdl = paramzzbbs;
    this.zzgdk = paramzzcpj;
    try
    {
      this.zzgdm.put("adapter_version", this.zzgdk.zzgdj.zzsx().toString());
      this.zzgdm.put("sdk_version", this.zzgdk.zzgdj.zzsy().toString());
      this.zzgdm.put("name", this.zzgdk.zzfir);
      return;
    }
    catch (RemoteException localRemoteException)
    {
    }
    catch (NullPointerException localNullPointerException)
    {
    }
    catch (JSONException localJSONException)
    {
    }
  }

  // ERROR //
  public final void onFailure(String paramString)
    throws RemoteException
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 34	com/google/android/gms/internal/ads/zzcpk:zzgdn	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: getfield 32	com/google/android/gms/internal/ads/zzcpk:zzgdm	Lorg/json/JSONObject;
    //   18: ldc 77
    //   20: aload_1
    //   21: invokevirtual 62	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   24: pop
    //   25: aload_0
    //   26: getfield 36	com/google/android/gms/internal/ads/zzcpk:zzgdl	Lcom/google/android/gms/internal/ads/zzbbs;
    //   29: aload_0
    //   30: getfield 32	com/google/android/gms/internal/ads/zzcpk:zzgdm	Lorg/json/JSONObject;
    //   33: invokevirtual 83	com/google/android/gms/internal/ads/zzbbs:set	(Ljava/lang/Object;)V
    //   36: aload_0
    //   37: iconst_1
    //   38: putfield 34	com/google/android/gms/internal/ads/zzcpk:zzgdn	Z
    //   41: goto -30 -> 11
    //   44: astore_2
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_2
    //   48: athrow
    //   49: astore 4
    //   51: goto -26 -> 25
    //
    // Exception table:
    //   from	to	target	type
    //   2	7	44	finally
    //   14	25	44	finally
    //   25	41	44	finally
    //   14	25	49	org/json/JSONException
  }

  public final void zzdc(String paramString)
    throws RemoteException
  {
    while (true)
    {
      try
      {
        boolean bool = this.zzgdn;
        if (bool)
          return;
        if (paramString == null)
        {
          onFailure("Adapter returned null signals");
          continue;
        }
      }
      finally
      {
      }
      try
      {
        this.zzgdm.put("signals", paramString);
        label43: this.zzgdl.set(this.zzgdm);
        this.zzgdn = true;
      }
      catch (JSONException localJSONException)
      {
        break label43;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcpk
 * JD-Core Version:    0.6.2
 */