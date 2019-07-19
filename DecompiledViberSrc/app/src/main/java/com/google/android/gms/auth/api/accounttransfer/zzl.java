package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Indicator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.internal.auth.zzaz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@SafeParcelable.Class(creator="AccountTransferMsgCreator")
public final class zzl extends zzaz
{
  public static final Parcelable.Creator<zzl> CREATOR = new zzm();
  private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaz;

  @SafeParcelable.Indicator
  private final Set<Integer> zzba;

  @SafeParcelable.Field(getter="getAuthenticatorDatas", id=2)
  private ArrayList<zzr> zzbb;

  @SafeParcelable.Field(getter="getRequestType", id=3)
  private int zzbc;

  @SafeParcelable.Field(getter="getProgress", id=4)
  private zzo zzbd;

  @SafeParcelable.VersionField(id=1)
  private final int zzv;

  static
  {
    HashMap localHashMap = new HashMap();
    zzaz = localHashMap;
    localHashMap.put("authenticatorData", FastJsonResponse.Field.forConcreteTypeArray("authenticatorData", 2, zzr.class));
    zzaz.put("progress", FastJsonResponse.Field.forConcreteType("progress", 4, zzo.class));
  }

  public zzl()
  {
    this.zzba = new HashSet(1);
    this.zzv = 1;
  }

  @SafeParcelable.Constructor
  zzl(@SafeParcelable.Indicator Set<Integer> paramSet, @SafeParcelable.Param(id=1) int paramInt1, @SafeParcelable.Param(id=2) ArrayList<zzr> paramArrayList, @SafeParcelable.Param(id=3) int paramInt2, @SafeParcelable.Param(id=4) zzo paramzzo)
  {
    this.zzba = paramSet;
    this.zzv = paramInt1;
    this.zzbb = paramArrayList;
    this.zzbc = paramInt2;
    this.zzbd = paramzzo;
  }

  public final <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<T> paramArrayList)
  {
    int i = paramField.getSafeParcelableFieldId();
    switch (i)
    {
    default:
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(i);
      arrayOfObject[1] = paramArrayList.getClass().getCanonicalName();
      throw new IllegalArgumentException(String.format("Field with id=%d is not a known ConcreteTypeArray type. Found %s", arrayOfObject));
    case 2:
    }
    this.zzbb = paramArrayList;
    this.zzba.add(Integer.valueOf(i));
  }

  public final <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, T paramT)
  {
    int i = paramField.getSafeParcelableFieldId();
    switch (i)
    {
    default:
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = Integer.valueOf(i);
      arrayOfObject[1] = paramT.getClass().getCanonicalName();
      throw new IllegalArgumentException(String.format("Field with id=%d is not a known custom type. Found %s", arrayOfObject));
    case 4:
    }
    this.zzbd = ((zzo)paramT);
    this.zzba.add(Integer.valueOf(i));
  }

  protected final Object getFieldValue(FastJsonResponse.Field paramField)
  {
    switch (paramField.getSafeParcelableFieldId())
    {
    case 3:
    default:
      int i = paramField.getSafeParcelableFieldId();
      throw new IllegalStateException(37 + "Unknown SafeParcelable id=" + i);
    case 1:
      return Integer.valueOf(this.zzv);
    case 2:
      return this.zzbb;
    case 4:
    }
    return this.zzbd;
  }

  protected final boolean isFieldSet(FastJsonResponse.Field paramField)
  {
    return this.zzba.contains(Integer.valueOf(paramField.getSafeParcelableFieldId()));
  }

  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    Set localSet = this.zzba;
    if (localSet.contains(Integer.valueOf(1)))
      SafeParcelWriter.writeInt(paramParcel, 1, this.zzv);
    if (localSet.contains(Integer.valueOf(2)))
      SafeParcelWriter.writeTypedList(paramParcel, 2, this.zzbb, true);
    if (localSet.contains(Integer.valueOf(3)))
      SafeParcelWriter.writeInt(paramParcel, 3, this.zzbc);
    if (localSet.contains(Integer.valueOf(4)))
      SafeParcelWriter.writeParcelable(paramParcel, 4, this.zzbd, paramInt, true);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.auth.api.accounttransfer.zzl
 * JD-Core Version:    0.6.2
 */