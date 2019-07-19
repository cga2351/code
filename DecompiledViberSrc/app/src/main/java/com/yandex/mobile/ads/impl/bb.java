package com.yandex.mobile.ads.impl;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class bb
  implements Parcelable
{
  public static final Parcelable.Creator<bb> CREATOR = new Parcelable.Creator()
  {
  };
  private final List<bc> a;
  private final Map<String, String> b;

  protected bb(Parcel paramParcel)
  {
    this.a = new ArrayList();
    paramParcel.readList(this.a, bc.class.getClassLoader());
    int i = paramParcel.readInt();
    this.b = new HashMap(i);
    for (int j = 0; j < i; j++)
    {
      String str1 = paramParcel.readString();
      String str2 = paramParcel.readString();
      this.b.put(str1, str2);
    }
  }

  public bb(List<bc> paramList, Map<String, String> paramMap)
  {
    this.a = paramList;
    this.b = paramMap;
  }

  public final List<bc> a()
  {
    return this.a;
  }

  public final Map<String, String> b()
  {
    return this.b;
  }

  public int describeContents()
  {
    return 0;
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeList(this.a);
    paramParcel.writeInt(this.b.size());
    Iterator localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramParcel.writeString((String)localEntry.getKey());
      paramParcel.writeString((String)localEntry.getValue());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.bb
 * JD-Core Version:    0.6.2
 */