package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public abstract class zzafa extends zzfn
  implements zzaez
{
  public zzafa()
  {
    super("com.google.android.gms.ads.internal.formats.client.INativeContentAd");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 2:
      IObjectWrapper localIObjectWrapper2 = zzrh();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localIObjectWrapper2);
    case 3:
    case 4:
    case 5:
    case 6:
    case 7:
    case 8:
    case 9:
    case 10:
    case 11:
    case 12:
    case 13:
    case 14:
    case 15:
    case 16:
    case 17:
    }
    while (true)
    {
      return true;
      String str5 = getHeadline();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str5);
      continue;
      List localList = getImages();
      paramParcel2.writeNoException();
      paramParcel2.writeList(localList);
      continue;
      String str4 = getBody();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str4);
      continue;
      zzaeh localzzaeh = zzrl();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzaeh);
      continue;
      String str3 = getCallToAction();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str3);
      continue;
      String str2 = getAdvertiser();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str2);
      continue;
      Bundle localBundle = getExtras();
      paramParcel2.writeNoException();
      zzfo.zzb(paramParcel2, localBundle);
      continue;
      destroy();
      paramParcel2.writeNoException();
      continue;
      zzaap localzzaap = getVideoController();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzaap);
      continue;
      performClick((Bundle)zzfo.zza(paramParcel1, Bundle.CREATOR));
      paramParcel2.writeNoException();
      continue;
      boolean bool = recordImpression((Bundle)zzfo.zza(paramParcel1, Bundle.CREATOR));
      paramParcel2.writeNoException();
      zzfo.writeBoolean(paramParcel2, bool);
      continue;
      reportTouchEvent((Bundle)zzfo.zza(paramParcel1, Bundle.CREATOR));
      paramParcel2.writeNoException();
      continue;
      zzadz localzzadz = zzrj();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzadz);
      continue;
      IObjectWrapper localIObjectWrapper1 = zzrk();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localIObjectWrapper1);
      continue;
      String str1 = getMediationAdapterClassName();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str1);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzafa
 * JD-Core Version:    0.6.2
 */