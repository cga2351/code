package com.google.android.exoplayer2.drm;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.exoplayer2.c;
import com.google.android.exoplayer2.g.a;
import com.google.android.exoplayer2.g.ag;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

public final class DrmInitData
  implements Parcelable, Comparator<SchemeData>
{
  public static final Parcelable.Creator<DrmInitData> CREATOR = new Parcelable.Creator()
  {
    public DrmInitData a(Parcel paramAnonymousParcel)
    {
      return new DrmInitData(paramAnonymousParcel);
    }

    public DrmInitData[] a(int paramAnonymousInt)
    {
      return new DrmInitData[paramAnonymousInt];
    }
  };
  private int hashCode;
  public final int schemeDataCount;
  private final SchemeData[] schemeDatas;
  public final String schemeType;

  DrmInitData(Parcel paramParcel)
  {
    this.schemeType = paramParcel.readString();
    this.schemeDatas = ((SchemeData[])paramParcel.createTypedArray(SchemeData.CREATOR));
    this.schemeDataCount = this.schemeDatas.length;
  }

  public DrmInitData(String paramString, List<SchemeData> paramList)
  {
    this(paramString, false, (SchemeData[])paramList.toArray(new SchemeData[paramList.size()]));
  }

  private DrmInitData(String paramString, boolean paramBoolean, SchemeData[] paramArrayOfSchemeData)
  {
    this.schemeType = paramString;
    if (paramBoolean);
    for (SchemeData[] arrayOfSchemeData = (SchemeData[])paramArrayOfSchemeData.clone(); ; arrayOfSchemeData = paramArrayOfSchemeData)
    {
      Arrays.sort(arrayOfSchemeData, this);
      this.schemeDatas = arrayOfSchemeData;
      this.schemeDataCount = arrayOfSchemeData.length;
      return;
    }
  }

  public DrmInitData(String paramString, SchemeData[] paramArrayOfSchemeData)
  {
    this(paramString, true, paramArrayOfSchemeData);
  }

  public DrmInitData(List<SchemeData> paramList)
  {
    this(null, false, (SchemeData[])paramList.toArray(new SchemeData[paramList.size()]));
  }

  public DrmInitData(SchemeData[] paramArrayOfSchemeData)
  {
    this(null, paramArrayOfSchemeData);
  }

  private static boolean containsSchemeDataWithUuid(ArrayList<SchemeData> paramArrayList, int paramInt, UUID paramUUID)
  {
    for (int i = 0; i < paramInt; i++)
      if (((SchemeData)paramArrayList.get(i)).uuid.equals(paramUUID))
        return true;
    return false;
  }

  public static DrmInitData createSessionCreationData(DrmInitData paramDrmInitData1, DrmInitData paramDrmInitData2)
  {
    int i = 0;
    ArrayList localArrayList = new ArrayList();
    if (paramDrmInitData1 != null)
    {
      str = paramDrmInitData1.schemeType;
      for (SchemeData localSchemeData2 : paramDrmInitData1.schemeDatas)
        if (localSchemeData2.hasData())
          localArrayList.add(localSchemeData2);
    }
    String str = null;
    if (paramDrmInitData2 != null)
    {
      if (str == null)
        str = paramDrmInitData2.schemeType;
      int j = localArrayList.size();
      SchemeData[] arrayOfSchemeData1 = paramDrmInitData2.schemeDatas;
      int k = arrayOfSchemeData1.length;
      while (i < k)
      {
        SchemeData localSchemeData1 = arrayOfSchemeData1[i];
        if ((localSchemeData1.hasData()) && (!containsSchemeDataWithUuid(localArrayList, j, localSchemeData1.uuid)))
          localArrayList.add(localSchemeData1);
        i++;
      }
    }
    if (localArrayList.isEmpty())
      return null;
    return new DrmInitData(str, localArrayList);
  }

  public int compare(SchemeData paramSchemeData1, SchemeData paramSchemeData2)
  {
    if (c.a.equals(paramSchemeData1.uuid))
    {
      if (c.a.equals(paramSchemeData2.uuid))
        return 0;
      return 1;
    }
    return paramSchemeData1.uuid.compareTo(paramSchemeData2.uuid);
  }

  public DrmInitData copyWithSchemeType(String paramString)
  {
    if (ag.a(this.schemeType, paramString))
      return this;
    return new DrmInitData(paramString, false, this.schemeDatas);
  }

  public int describeContents()
  {
    return 0;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject);
    DrmInitData localDrmInitData;
    do
    {
      return true;
      if ((paramObject == null) || (getClass() != paramObject.getClass()))
        return false;
      localDrmInitData = (DrmInitData)paramObject;
    }
    while ((ag.a(this.schemeType, localDrmInitData.schemeType)) && (Arrays.equals(this.schemeDatas, localDrmInitData.schemeDatas)));
    return false;
  }

  public SchemeData get(int paramInt)
  {
    return this.schemeDatas[paramInt];
  }

  @Deprecated
  public SchemeData get(UUID paramUUID)
  {
    for (SchemeData localSchemeData : this.schemeDatas)
      if (localSchemeData.matches(paramUUID))
        return localSchemeData;
    return null;
  }

  public int hashCode()
  {
    if (this.hashCode == 0)
      if (this.schemeType != null)
        break label37;
    label37: for (int i = 0; ; i = this.schemeType.hashCode())
    {
      this.hashCode = (i * 31 + Arrays.hashCode(this.schemeDatas));
      return this.hashCode;
    }
  }

  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.schemeType);
    paramParcel.writeTypedArray(this.schemeDatas, 0);
  }

  public static final class SchemeData
    implements Parcelable
  {
    public static final Parcelable.Creator<SchemeData> CREATOR = new Parcelable.Creator()
    {
      public DrmInitData.SchemeData a(Parcel paramAnonymousParcel)
      {
        return new DrmInitData.SchemeData(paramAnonymousParcel);
      }

      public DrmInitData.SchemeData[] a(int paramAnonymousInt)
      {
        return new DrmInitData.SchemeData[paramAnonymousInt];
      }
    };
    public final byte[] data;
    private int hashCode;
    public final String licenseServerUrl;
    public final String mimeType;
    public final boolean requiresSecureDecryption;
    private final UUID uuid;

    SchemeData(Parcel paramParcel)
    {
      this.uuid = new UUID(paramParcel.readLong(), paramParcel.readLong());
      this.licenseServerUrl = paramParcel.readString();
      this.mimeType = paramParcel.readString();
      this.data = paramParcel.createByteArray();
      if (paramParcel.readByte() != 0);
      for (boolean bool = true; ; bool = false)
      {
        this.requiresSecureDecryption = bool;
        return;
      }
    }

    public SchemeData(UUID paramUUID, String paramString1, String paramString2, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      this.uuid = ((UUID)a.a(paramUUID));
      this.licenseServerUrl = paramString1;
      this.mimeType = ((String)a.a(paramString2));
      this.data = paramArrayOfByte;
      this.requiresSecureDecryption = paramBoolean;
    }

    public SchemeData(UUID paramUUID, String paramString, byte[] paramArrayOfByte)
    {
      this(paramUUID, paramString, paramArrayOfByte, false);
    }

    public SchemeData(UUID paramUUID, String paramString, byte[] paramArrayOfByte, boolean paramBoolean)
    {
      this(paramUUID, null, paramString, paramArrayOfByte, paramBoolean);
    }

    public boolean canReplace(SchemeData paramSchemeData)
    {
      return (hasData()) && (!paramSchemeData.hasData()) && (matches(paramSchemeData.uuid));
    }

    public SchemeData copyWithData(byte[] paramArrayOfByte)
    {
      return new SchemeData(this.uuid, this.licenseServerUrl, this.mimeType, paramArrayOfByte, this.requiresSecureDecryption);
    }

    public int describeContents()
    {
      return 0;
    }

    public boolean equals(Object paramObject)
    {
      boolean bool = true;
      if (!(paramObject instanceof SchemeData))
        bool = false;
      SchemeData localSchemeData;
      do
      {
        do
          return bool;
        while (paramObject == this);
        localSchemeData = (SchemeData)paramObject;
      }
      while ((ag.a(this.licenseServerUrl, localSchemeData.licenseServerUrl)) && (ag.a(this.mimeType, localSchemeData.mimeType)) && (ag.a(this.uuid, localSchemeData.uuid)) && (Arrays.equals(this.data, localSchemeData.data)));
      return false;
    }

    public boolean hasData()
    {
      return this.data != null;
    }

    public int hashCode()
    {
      int i;
      if (this.hashCode == 0)
      {
        i = 31 * this.uuid.hashCode();
        if (this.licenseServerUrl != null)
          break label61;
      }
      label61: for (int j = 0; ; j = this.licenseServerUrl.hashCode())
      {
        this.hashCode = (31 * (31 * (j + i) + this.mimeType.hashCode()) + Arrays.hashCode(this.data));
        return this.hashCode;
      }
    }

    public boolean matches(UUID paramUUID)
    {
      return (c.a.equals(this.uuid)) || (paramUUID.equals(this.uuid));
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeLong(this.uuid.getMostSignificantBits());
      paramParcel.writeLong(this.uuid.getLeastSignificantBits());
      paramParcel.writeString(this.licenseServerUrl);
      paramParcel.writeString(this.mimeType);
      paramParcel.writeByteArray(this.data);
      if (this.requiresSecureDecryption);
      for (int i = 1; ; i = 0)
      {
        paramParcel.writeByte((byte)i);
        return;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DrmInitData
 * JD-Core Version:    0.6.2
 */