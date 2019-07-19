package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@ShowFirstParty
@SafeParcelable.Class(creator="FieldMappingDictionaryEntryCreator")
public final class zal extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zal> CREATOR = new zao();

  @SafeParcelable.Field(id=2)
  final String className;

  @SafeParcelable.VersionField(id=1)
  private final int versionCode;

  @SafeParcelable.Field(id=3)
  final ArrayList<zam> zaqx;

  @SafeParcelable.Constructor
  zal(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) String paramString, @SafeParcelable.Param(id=3) ArrayList<zam> paramArrayList)
  {
    this.versionCode = paramInt;
    this.className = paramString;
    this.zaqx = paramArrayList;
  }

  zal(String paramString, Map<String, FastJsonResponse.Field<?, ?>> paramMap)
  {
    this.versionCode = 1;
    this.className = paramString;
    if (paramMap == null);
    ArrayList localArrayList;
    for (Object localObject = null; ; localObject = localArrayList)
    {
      this.zaqx = localObject;
      return;
      localArrayList = new ArrayList();
      Iterator localIterator = paramMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList.add(new zam(str, (FastJsonResponse.Field)paramMap.get(str)));
      }
    }
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.versionCode);
    SafeParcelWriter.writeString(paramParcel, 2, this.className, false);
    SafeParcelWriter.writeTypedList(paramParcel, 3, this.zaqx, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.server.response.zal
 * JD-Core Version:    0.6.2
 */