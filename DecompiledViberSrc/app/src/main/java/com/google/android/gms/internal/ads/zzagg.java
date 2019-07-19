package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public abstract class zzagg extends zzfn
  implements zzagf
{
  public zzagg()
  {
    super("com.google.android.gms.ads.internal.formats.client.IUnifiedNativeAd");
  }

  protected final boolean dispatchTransaction(int paramInt1, Parcel paramParcel1, Parcel paramParcel2, int paramInt2)
    throws RemoteException
  {
    switch (paramInt1)
    {
    default:
      return false;
    case 2:
      String str7 = getHeadline();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str7);
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
    case 18:
    case 19:
    case 20:
    case 21:
    case 22:
    case 23:
    case 24:
    case 25:
    case 26:
    case 27:
    case 28:
    case 29:
    }
    while (true)
    {
      return true;
      List localList2 = getImages();
      paramParcel2.writeNoException();
      paramParcel2.writeList(localList2);
      continue;
      String str6 = getBody();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str6);
      continue;
      zzaeh localzzaeh = zzri();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzaeh);
      continue;
      String str5 = getCallToAction();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str5);
      continue;
      String str4 = getAdvertiser();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str4);
      continue;
      double d = getStarRating();
      paramParcel2.writeNoException();
      paramParcel2.writeDouble(d);
      continue;
      String str3 = getStore();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str3);
      continue;
      String str2 = getPrice();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str2);
      continue;
      zzaap localzzaap = getVideoController();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzaap);
      continue;
      String str1 = getMediationAdapterClassName();
      paramParcel2.writeNoException();
      paramParcel2.writeString(str1);
      continue;
      destroy();
      paramParcel2.writeNoException();
      continue;
      zzadz localzzadz = zzrj();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzadz);
      continue;
      performClick((Bundle)zzfo.zza(paramParcel1, Bundle.CREATOR));
      paramParcel2.writeNoException();
      continue;
      boolean bool2 = recordImpression((Bundle)zzfo.zza(paramParcel1, Bundle.CREATOR));
      paramParcel2.writeNoException();
      zzfo.writeBoolean(paramParcel2, bool2);
      continue;
      reportTouchEvent((Bundle)zzfo.zza(paramParcel1, Bundle.CREATOR));
      paramParcel2.writeNoException();
      continue;
      IObjectWrapper localIObjectWrapper2 = zzrh();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localIObjectWrapper2);
      continue;
      IObjectWrapper localIObjectWrapper1 = zzrk();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localIObjectWrapper1);
      continue;
      Bundle localBundle = getExtras();
      paramParcel2.writeNoException();
      zzfo.zzb(paramParcel2, localBundle);
      continue;
      IBinder localIBinder = paramParcel1.readStrongBinder();
      Object localObject;
      if (localIBinder == null)
        localObject = null;
      while (true)
      {
        zza((zzagc)localObject);
        paramParcel2.writeNoException();
        break;
        IInterface localIInterface = localIBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.IUnconfirmedClickListener");
        if ((localIInterface instanceof zzagc))
          localObject = (zzagc)localIInterface;
        else
          localObject = new zzage(localIBinder);
      }
      cancelUnconfirmedClick();
      paramParcel2.writeNoException();
      continue;
      List localList1 = getMuteThisAdReasons();
      paramParcel2.writeNoException();
      paramParcel2.writeList(localList1);
      continue;
      boolean bool1 = isCustomMuteThisAdEnabled();
      paramParcel2.writeNoException();
      zzfo.writeBoolean(paramParcel2, bool1);
      continue;
      zza(zzaaj.zzf(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      zza(zzaaf.zze(paramParcel1.readStrongBinder()));
      paramParcel2.writeNoException();
      continue;
      zzro();
      paramParcel2.writeNoException();
      continue;
      recordCustomClickGesture();
      paramParcel2.writeNoException();
      continue;
      zzaed localzzaed = zzrp();
      paramParcel2.writeNoException();
      zzfo.zza(paramParcel2, localzzaed);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzagg
 * JD-Core Version:    0.6.2
 */