package com.google.android.gms.internal.ads;

import android.os.ParcelFileDescriptor;
import java.io.IOException;
import java.io.InputStream;

public final class zzcyb
{
  public static ParcelFileDescriptor zze(InputStream paramInputStream)
    throws IOException
  {
    ParcelFileDescriptor[] arrayOfParcelFileDescriptor = ParcelFileDescriptor.createPipe();
    ParcelFileDescriptor localParcelFileDescriptor1 = arrayOfParcelFileDescriptor[0];
    ParcelFileDescriptor localParcelFileDescriptor2 = arrayOfParcelFileDescriptor[1];
    zzaxh.zzdvr.execute(new zzcyc(paramInputStream, localParcelFileDescriptor2));
    return localParcelFileDescriptor1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcyb
 * JD-Core Version:    0.6.2
 */