package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@ShowFirstParty
@SafeParcelable.Class(creator="FieldMappingDictionaryCreator")
public final class zak extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<zak> CREATOR = new zan();

  @SafeParcelable.VersionField(id=1)
  private final int zale;
  private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zaqu;

  @SafeParcelable.Field(getter="getSerializedDictionary", id=2)
  private final ArrayList<zal> zaqv;

  @SafeParcelable.Field(getter="getRootClassName", id=3)
  private final String zaqw;

  @SafeParcelable.Constructor
  zak(@SafeParcelable.Param(id=1) int paramInt, @SafeParcelable.Param(id=2) ArrayList<zal> paramArrayList, @SafeParcelable.Param(id=3) String paramString)
  {
    this.zale = paramInt;
    this.zaqv = null;
    HashMap localHashMap1 = new HashMap();
    int i = paramArrayList.size();
    for (int j = 0; j < i; j++)
    {
      zal localzal = (zal)paramArrayList.get(j);
      String str = localzal.className;
      HashMap localHashMap2 = new HashMap();
      int k = localzal.zaqx.size();
      for (int m = 0; m < k; m++)
      {
        zam localzam = (zam)localzal.zaqx.get(m);
        localHashMap2.put(localzam.zaqy, localzam.zaqz);
      }
      localHashMap1.put(str, localHashMap2);
    }
    this.zaqu = localHashMap1;
    this.zaqw = ((String)Preconditions.checkNotNull(paramString));
    zacr();
  }

  public zak(Class<? extends FastJsonResponse> paramClass)
  {
    this.zale = 1;
    this.zaqv = null;
    this.zaqu = new HashMap();
    this.zaqw = paramClass.getCanonicalName();
  }

  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Iterator localIterator1 = this.zaqu.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      localStringBuilder.append(str1).append(":\n");
      Map localMap = (Map)this.zaqu.get(str1);
      Iterator localIterator2 = localMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        localStringBuilder.append("  ").append(str2).append(": ");
        localStringBuilder.append(localMap.get(str2));
      }
    }
    return localStringBuilder.toString();
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zale);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.zaqu.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localArrayList.add(new zal(str, (Map)this.zaqu.get(str)));
    }
    SafeParcelWriter.writeTypedList(paramParcel, 2, localArrayList, false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zaqw, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }

  public final void zaa(Class<? extends FastJsonResponse> paramClass, Map<String, FastJsonResponse.Field<?, ?>> paramMap)
  {
    this.zaqu.put(paramClass.getCanonicalName(), paramMap);
  }

  public final boolean zaa(Class<? extends FastJsonResponse> paramClass)
  {
    return this.zaqu.containsKey(paramClass.getCanonicalName());
  }

  public final void zacr()
  {
    Iterator localIterator1 = this.zaqu.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str = (String)localIterator1.next();
      Map localMap = (Map)this.zaqu.get(str);
      Iterator localIterator2 = localMap.keySet().iterator();
      while (localIterator2.hasNext())
        ((FastJsonResponse.Field)localMap.get((String)localIterator2.next())).zaa(this);
    }
  }

  public final void zacs()
  {
    Iterator localIterator1 = this.zaqu.keySet().iterator();
    while (localIterator1.hasNext())
    {
      String str1 = (String)localIterator1.next();
      Map localMap = (Map)this.zaqu.get(str1);
      HashMap localHashMap = new HashMap();
      Iterator localIterator2 = localMap.keySet().iterator();
      while (localIterator2.hasNext())
      {
        String str2 = (String)localIterator2.next();
        localHashMap.put(str2, ((FastJsonResponse.Field)localMap.get(str2)).zacl());
      }
      this.zaqu.put(str1, localHashMap);
    }
  }

  public final String zact()
  {
    return this.zaqw;
  }

  public final Map<String, FastJsonResponse.Field<?, ?>> zai(String paramString)
  {
    return (Map)this.zaqu.get(paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.server.response.zak
 * JD-Core Version:    0.6.2
 */