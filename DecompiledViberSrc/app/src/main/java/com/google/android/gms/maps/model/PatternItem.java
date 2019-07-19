package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SafeParcelable.Class(creator="PatternItemCreator")
@SafeParcelable.Reserved({1})
public class PatternItem extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<PatternItem> CREATOR = new zzi();
  private static final String TAG = PatternItem.class.getSimpleName();

  @SafeParcelable.Field(getter="getType", id=2)
  private final int type;

  @SafeParcelable.Field(getter="getLength", id=3)
  private final Float zzdv;

  @SafeParcelable.Constructor
  public PatternItem(@SafeParcelable.Param(id=2) int paramInt, @SafeParcelable.Param(id=3) Float paramFloat)
  {
    if ((paramInt == i) || ((paramFloat != null) && (paramFloat.floatValue() >= 0.0F)));
    while (true)
    {
      String str = String.valueOf(paramFloat);
      Preconditions.checkArgument(i, 45 + String.valueOf(str).length() + "Invalid PatternItem: type=" + paramInt + " length=" + str);
      this.type = paramInt;
      this.zzdv = paramFloat;
      return;
      i = 0;
    }
  }

  static List<PatternItem> zza(List<PatternItem> paramList)
  {
    if (paramList == null)
      return null;
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
    {
      Object localObject = (PatternItem)localIterator.next();
      if (localObject == null)
        localObject = null;
      while (true)
      {
        localArrayList.add(localObject);
        break;
        switch (((PatternItem)localObject).type)
        {
        default:
          String str = TAG;
          int i = ((PatternItem)localObject).type;
          Log.w(str, 37 + "Unknown PatternItem type: " + i);
          break;
        case 0:
          localObject = new Dash(((PatternItem)localObject).zzdv.floatValue());
          break;
        case 1:
          localObject = new Dot();
          break;
        case 2:
          localObject = new Gap(((PatternItem)localObject).zzdv.floatValue());
        }
      }
    }
    return localArrayList;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    PatternItem localPatternItem;
    do
    {
      return true;
      if (!(paramObject instanceof PatternItem))
        return false;
      localPatternItem = (PatternItem)paramObject;
    }
    while ((this.type == localPatternItem.type) && (Objects.equal(this.zzdv, localPatternItem.zzdv)));
    return false;
  }

  public int hashCode()
  {
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = Integer.valueOf(this.type);
    arrayOfObject[1] = this.zzdv;
    return Objects.hashCode(arrayOfObject);
  }

  public String toString()
  {
    int i = this.type;
    String str = String.valueOf(this.zzdv);
    return 39 + String.valueOf(str).length() + "[PatternItem: type=" + i + " length=" + str + "]";
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 2, this.type);
    SafeParcelWriter.writeFloatObject(paramParcel, 3, this.zzdv, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.maps.model.PatternItem
 * JD-Core Version:    0.6.2
 */