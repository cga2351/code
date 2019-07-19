package com.yandex.metrica.impl.ob;

import android.annotation.SuppressLint;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import android.text.TextUtils;
import android.util.SparseArray;
import com.yandex.metrica.impl.bw;

@SuppressLint({"NewApi"})
public class ni
  implements nq<ng>
{

  @SuppressLint({"InlineApi"})
  private static final SparseArray<String> a = new SparseArray()
  {
  };
  private final nj b;
  private iv c;

  public ni(nj paramnj, iv paramiv)
  {
    this.b = paramnj;
    this.c = paramiv;
  }

  private Integer e()
  {
    try
    {
      String str = this.b.c().getNetworkOperator().substring(0, 3);
      boolean bool = TextUtils.isEmpty(str);
      Object localObject = null;
      if (!bool)
      {
        Integer localInteger = Integer.valueOf(Integer.parseInt(str));
        localObject = localInteger;
      }
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private Integer f()
  {
    try
    {
      String str = this.b.c().getNetworkOperator().substring(3);
      boolean bool = TextUtils.isEmpty(str);
      Object localObject = null;
      if (!bool)
      {
        Integer localInteger = Integer.valueOf(Integer.parseInt(str));
        localObject = localInteger;
      }
      return localObject;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private String g()
  {
    try
    {
      int i = this.b.c().getNetworkType();
      String str = (String)a.get(i, "unknown");
      return str;
    }
    catch (Exception localException)
    {
    }
    return "unknown";
  }

  private String h()
  {
    try
    {
      String str = this.b.c().getNetworkOperatorName();
      return str;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public ng a()
  {
    if (this.b.i())
      return new ng(e(), f(), c(), b(), h(), g(), null, true, 0, null);
    return null;
  }

  @SuppressLint({"MissingPermission"})
  Integer b()
  {
    while (true)
    {
      try
      {
        if (this.c.c(this.b.d()))
        {
          GsmCellLocation localGsmCellLocation = (GsmCellLocation)this.b.c().getCellLocation();
          if (localGsmCellLocation == null)
            break label59;
          i = localGsmCellLocation.getCid();
          if (1 != i)
          {
            Integer localInteger = Integer.valueOf(i);
            return localInteger;
          }
          return null;
        }
      }
      catch (Exception localException)
      {
      }
      return null;
      label59: int i = 1;
    }
  }

  @SuppressLint({"MissingPermission"})
  Integer c()
  {
    try
    {
      if (this.c.c(this.b.d()))
      {
        int i = ((GsmCellLocation)this.b.c().getCellLocation()).getLac();
        if (1 != i)
        {
          Integer localInteger = Integer.valueOf(i);
          return localInteger;
        }
        return null;
      }
    }
    catch (Exception localException)
    {
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ni
 * JD-Core Version:    0.6.2
 */