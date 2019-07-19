package com.google.android.gms.location;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ClientIdentity;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

@SafeParcelable.Class(creator="ActivityTransitionRequestCreator")
@SafeParcelable.Reserved({1000})
public class ActivityTransitionRequest extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<ActivityTransitionRequest> CREATOR = new zzf();
  public static final Comparator<ActivityTransition> IS_SAME_TRANSITION = new zze();

  @SafeParcelable.Field(getter="getTag", id=2)
  private final String tag;

  @SafeParcelable.Field(getter="getActivityTransitions", id=1)
  private final List<ActivityTransition> zzl;

  @SafeParcelable.Field(getter="getClients", id=3)
  private final List<ClientIdentity> zzm;

  public ActivityTransitionRequest(List<ActivityTransition> paramList)
  {
    this(paramList, null, null);
  }

  @SafeParcelable.Constructor
  public ActivityTransitionRequest(@SafeParcelable.Param(id=1) List<ActivityTransition> paramList, @SafeParcelable.Param(id=2) String paramString, @SafeParcelable.Param(id=3) List<ClientIdentity> paramList1)
  {
    Preconditions.checkNotNull(paramList, "transitions can't be null");
    if (paramList.size() > 0);
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool, "transitions can't be empty.");
      TreeSet localTreeSet = new TreeSet(IS_SAME_TRANSITION);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        ActivityTransition localActivityTransition = (ActivityTransition)localIterator.next();
        Preconditions.checkArgument(localTreeSet.add(localActivityTransition), String.format("Found duplicated transition: %s.", new Object[] { localActivityTransition }));
      }
    }
    this.zzl = Collections.unmodifiableList(paramList);
    this.tag = paramString;
    if (paramList1 == null);
    for (List localList = Collections.emptyList(); ; localList = Collections.unmodifiableList(paramList1))
    {
      this.zzm = localList;
      return;
    }
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    ActivityTransitionRequest localActivityTransitionRequest;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localActivityTransitionRequest = (ActivityTransitionRequest)paramObject;
    }
    while ((Objects.equal(this.zzl, localActivityTransitionRequest.zzl)) && (Objects.equal(this.tag, localActivityTransitionRequest.tag)) && (Objects.equal(this.zzm, localActivityTransitionRequest.zzm)));
    return false;
  }

  public int hashCode()
  {
    int i = 31 * this.zzl.hashCode();
    if (this.tag != null);
    for (int j = this.tag.hashCode(); ; j = 0)
    {
      int k = 31 * (j + i);
      List localList = this.zzm;
      int m = 0;
      if (localList != null)
        m = this.zzm.hashCode();
      return k + m;
    }
  }

  public void serializeToIntentExtra(Intent paramIntent)
  {
    SafeParcelableSerializer.serializeToIntentExtra(this, paramIntent, "com.google.android.location.internal.EXTRA_ACTIVITY_TRANSITION_REQUEST");
  }

  public String toString()
  {
    String str1 = String.valueOf(this.zzl);
    String str2 = this.tag;
    String str3 = String.valueOf(this.zzm);
    return 61 + String.valueOf(str1).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + "ActivityTransitionRequest [mTransitions=" + str1 + ", mTag='" + str2 + '\'' + ", mClients=" + str3 + ']';
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeTypedList(paramParcel, 1, this.zzl, false);
    SafeParcelWriter.writeString(paramParcel, 2, this.tag, false);
    SafeParcelWriter.writeTypedList(paramParcel, 3, this.zzm, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.location.ActivityTransitionRequest
 * JD-Core Version:    0.6.2
 */