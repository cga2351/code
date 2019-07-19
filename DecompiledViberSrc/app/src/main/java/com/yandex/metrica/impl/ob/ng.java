package com.yandex.metrica.impl.ob;

import android.annotation.TargetApi;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellSignalStrength;

public final class ng
{
  private Integer a;
  private final Integer b;
  private final Integer c;
  private final Integer d;
  private final Integer e;
  private final String f;
  private final String g;
  private final boolean h;
  private final int i;
  private final Integer j;

  public ng(Integer paramInteger1, Integer paramInteger2, Integer paramInteger3, Integer paramInteger4, String paramString1, String paramString2, Integer paramInteger5, boolean paramBoolean, int paramInt, Integer paramInteger6)
  {
    this.b = paramInteger1;
    this.c = paramInteger2;
    this.d = paramInteger3;
    this.e = paramInteger4;
    this.f = paramString1;
    this.g = paramString2;
    this.a = paramInteger5;
    this.h = paramBoolean;
    this.i = paramInt;
    this.j = paramInteger6;
  }

  public Integer a()
  {
    return this.a;
  }

  public void a(Integer paramInteger)
  {
    this.a = paramInteger;
  }

  public Integer b()
  {
    return this.b;
  }

  public Integer c()
  {
    return this.c;
  }

  public Integer d()
  {
    return this.d;
  }

  public Integer e()
  {
    return this.e;
  }

  public String f()
  {
    return this.f;
  }

  public String g()
  {
    return this.g;
  }

  public boolean h()
  {
    return this.h;
  }

  public int i()
  {
    return this.i;
  }

  public Integer j()
  {
    return this.j;
  }

  public String toString()
  {
    return "CellDescription{mSignalStrength=" + this.a + ", mMobileCountryCode=" + this.b + ", mMobileNetworkCode=" + this.c + ", mLocationAreaCode=" + this.d + ", mCellId=" + this.e + ", mOperatorName='" + this.f + '\'' + ", mNetworkType='" + this.g + '\'' + ", mConnected=" + this.h + ", mCellType=" + this.i + ", mPci=" + this.j + '}';
  }

  @TargetApi(17)
  static class a extends ng.b
  {
    ng a(CellInfo paramCellInfo)
    {
      CellInfoCdma localCellInfoCdma = (CellInfoCdma)paramCellInfo;
      return a(null, null, localCellInfoCdma.getCellSignalStrength(), null, null, localCellInfoCdma.isRegistered(), 2, null);
    }
  }

  @TargetApi(17)
  static abstract class b
  {
    static final Integer a = Integer.valueOf(2147483647);
    static final Integer b = Integer.valueOf(2147483647);
    static final Integer c = Integer.valueOf(2147483647);
    static final Integer d = Integer.valueOf(2147483647);
    static final Integer e = Integer.valueOf(2147483647);

    abstract ng a(CellInfo paramCellInfo);

    @TargetApi(17)
    protected ng a(Integer paramInteger1, Integer paramInteger2, CellSignalStrength paramCellSignalStrength, Integer paramInteger3, Integer paramInteger4, boolean paramBoolean, int paramInt, Integer paramInteger5)
    {
      Integer localInteger1 = null;
      Integer localInteger2;
      label31: Integer localInteger3;
      label47: Integer localInteger4;
      label67: Integer localInteger5;
      if (paramInteger1 != null)
      {
        if (paramInteger1 != a)
          localInteger1 = paramInteger1;
      }
      else
      {
        localInteger2 = null;
        if (paramInteger2 != null)
        {
          if (paramInteger2 == b)
            break label143;
          localInteger2 = paramInteger2;
        }
        if (paramCellSignalStrength == null)
          break label148;
        localInteger3 = Integer.valueOf(paramCellSignalStrength.getDbm());
        localInteger4 = null;
        if (paramInteger4 != null)
        {
          Integer localInteger8 = c;
          if (paramInteger4 == localInteger8)
            break label154;
          localInteger4 = paramInteger4;
        }
        localInteger5 = null;
        if (paramInteger3 != null)
        {
          Integer localInteger7 = d;
          if (paramInteger3 == localInteger7)
            break label160;
          label91: localInteger5 = paramInteger3;
        }
        if ((paramInteger5 == null) || (paramInteger5 == e))
          break label166;
      }
      label143: label148: label154: label160: label166: for (Integer localInteger6 = paramInteger5; ; localInteger6 = null)
      {
        return new ng(localInteger4, localInteger5, localInteger2, localInteger1, null, null, localInteger3, paramBoolean, paramInt, localInteger6);
        paramInteger1 = null;
        break;
        paramInteger2 = null;
        break label31;
        localInteger3 = null;
        break label47;
        paramInteger4 = null;
        break label67;
        paramInteger3 = null;
        break label91;
      }
    }
  }

  @TargetApi(17)
  static class c extends ng.b
  {
    ng a(CellInfo paramCellInfo)
    {
      CellInfoGsm localCellInfoGsm = (CellInfoGsm)paramCellInfo;
      CellIdentityGsm localCellIdentityGsm = localCellInfoGsm.getCellIdentity();
      return a(Integer.valueOf(localCellIdentityGsm.getCid()), Integer.valueOf(localCellIdentityGsm.getLac()), localCellInfoGsm.getCellSignalStrength(), Integer.valueOf(localCellIdentityGsm.getMnc()), Integer.valueOf(localCellIdentityGsm.getMcc()), localCellInfoGsm.isRegistered(), 1, null);
    }
  }

  @TargetApi(17)
  static class d extends ng.b
  {
    ng a(CellInfo paramCellInfo)
    {
      CellInfoLte localCellInfoLte = (CellInfoLte)paramCellInfo;
      CellIdentityLte localCellIdentityLte = localCellInfoLte.getCellIdentity();
      return a(Integer.valueOf(localCellIdentityLte.getCi()), Integer.valueOf(localCellIdentityLte.getTac()), localCellInfoLte.getCellSignalStrength(), Integer.valueOf(localCellIdentityLte.getMnc()), Integer.valueOf(localCellIdentityLte.getMcc()), localCellInfoLte.isRegistered(), 4, Integer.valueOf(localCellIdentityLte.getPci()));
    }
  }

  @TargetApi(18)
  static class e extends ng.b
  {
    ng a(CellInfo paramCellInfo)
    {
      CellInfoWcdma localCellInfoWcdma = (CellInfoWcdma)paramCellInfo;
      CellIdentityWcdma localCellIdentityWcdma = localCellInfoWcdma.getCellIdentity();
      return a(Integer.valueOf(localCellIdentityWcdma.getCid()), Integer.valueOf(localCellIdentityWcdma.getLac()), localCellInfoWcdma.getCellSignalStrength(), Integer.valueOf(localCellIdentityWcdma.getMnc()), Integer.valueOf(localCellIdentityWcdma.getMcc()), localCellInfoWcdma.isRegistered(), 3, Integer.valueOf(localCellIdentityWcdma.getPsc()));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ng
 * JD-Core Version:    0.6.2
 */