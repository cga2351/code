package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

@zzare
@SafeParcelable.Class(creator="HttpRequestParcelCreator")
public final class zzahz extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zzahz> CREATOR = new zzaia();

  @SafeParcelable.Field(id=1)
  private final String url;

  @SafeParcelable.Field(id=2)
  private final String[] zzdat;

  @SafeParcelable.Field(id=3)
  private final String[] zzdau;

  @SafeParcelable.Constructor
  zzahz(@SafeParcelable.Param(id=1) String paramString, @SafeParcelable.Param(id=2) String[] paramArrayOfString1, @SafeParcelable.Param(id=3) String[] paramArrayOfString2)
  {
    this.url = paramString;
    this.zzdat = paramArrayOfString1;
    this.zzdau = paramArrayOfString2;
  }

  public static zzahz zzh(zzr paramzzr)
    throws zza
  {
    Map localMap = paramzzr.getHeaders();
    int i = localMap.size();
    String[] arrayOfString1 = new String[i];
    String[] arrayOfString2 = new String[i];
    Iterator localIterator = localMap.entrySet().iterator();
    for (int j = 0; localIterator.hasNext(); j++)
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      arrayOfString1[j] = ((String)localEntry.getKey());
      arrayOfString2[j] = ((String)localEntry.getValue());
    }
    return new zzahz(paramzzr.getUrl(), arrayOfString1, arrayOfString2);
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, this.url, false);
    SafeParcelWriter.writeStringArray(paramParcel, 2, this.zzdat, false);
    SafeParcelWriter.writeStringArray(paramParcel, 3, this.zzdau, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzahz
 * JD-Core Version:    0.6.2
 */