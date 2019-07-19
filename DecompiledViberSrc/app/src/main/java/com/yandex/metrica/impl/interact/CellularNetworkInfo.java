package com.yandex.metrica.impl.interact;

import android.content.Context;
import android.text.TextUtils;
import com.yandex.metrica.impl.ob.ng;
import com.yandex.metrica.impl.ob.np;
import com.yandex.metrica.impl.ob.nr;
import com.yandex.metrica.impl.ob.ns;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class CellularNetworkInfo
{
  private String a = "";

  public CellularNetworkInfo(Context paramContext)
  {
    np.a(paramContext).a(new ns()
    {
      public void a(nr paramAnonymousnr)
      {
        ng localng = paramAnonymousnr.b();
        String str3;
        String str4;
        label112: String str5;
        label134: String str6;
        label156: StringBuilder localStringBuilder;
        Object localObject1;
        if (localng != null)
        {
          String str1 = localng.g();
          String str2 = localng.f();
          Integer localInteger1 = localng.c();
          Integer localInteger2 = localng.b();
          Integer localInteger3 = localng.e();
          Integer localInteger4 = localng.d();
          Integer localInteger5 = localng.a();
          HashMap localHashMap = new HashMap();
          localHashMap.put("network_type", str1);
          localHashMap.put("operator_name", str2);
          if (localInteger2 != null)
          {
            str3 = String.valueOf(localInteger2);
            localHashMap.put("country_code", str3);
            if (localInteger1 == null)
              break label315;
            str4 = String.valueOf(localInteger1);
            localHashMap.put("operator_id", str4);
            if (localInteger3 == null)
              break label321;
            str5 = String.valueOf(localInteger3);
            localHashMap.put("cell_id", str5);
            if (localInteger4 == null)
              break label327;
            str6 = String.valueOf(localInteger4);
            localHashMap.put("lac", str6);
            String str7 = null;
            if (localInteger5 != null)
              str7 = String.valueOf(localInteger5);
            localHashMap.put("signal_strength", str7);
            localStringBuilder = new StringBuilder();
            localObject1 = "";
            Iterator localIterator = localHashMap.entrySet().iterator();
            label216: if (!localIterator.hasNext())
              break label333;
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            String str8 = (String)localEntry.getValue();
            if (TextUtils.isEmpty(str8))
              break label347;
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append((String)localEntry.getKey());
            localStringBuilder.append("=");
            localStringBuilder.append(str8);
          }
        }
        label315: label321: label327: label333: label347: for (Object localObject2 = "&"; ; localObject2 = localObject1)
        {
          localObject1 = localObject2;
          break label216;
          str3 = null;
          break;
          str4 = null;
          break label112;
          str5 = null;
          break label134;
          str6 = null;
          break label156;
          CellularNetworkInfo.a(CellularNetworkInfo.this, localStringBuilder.toString());
          return;
        }
      }
    });
  }

  public String getCelluralInfo()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.interact.CellularNetworkInfo
 * JD-Core Version:    0.6.2
 */