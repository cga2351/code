package com.viber.voip.stickers;

import android.content.Context;
import android.text.TextUtils;
import com.viber.voip.ViberApplication;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.registration.af;
import com.viber.voip.user.UserManager;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class r<T>
{
  public T a(Context paramContext, JSONObject paramJSONObject)
    throws JSONException
  {
    if (paramJSONObject == null)
      return null;
    af localaf = UserManager.from(paramContext).getRegistrationValues();
    String str1 = "+" + localaf.b();
    String str2 = localaf.g();
    ViberApplication localViberApplication = ViberApplication.getInstance();
    String str3 = localViberApplication.getHardwareParameters().getMCC();
    String str4 = localViberApplication.getHardwareParameters().getMNC();
    if ((!TextUtils.isEmpty(str3)) && (!TextUtils.isEmpty(str4)));
    for (String str5 = String.format("%s/%s", new Object[] { str3, str4 }); ; str5 = null)
    {
      Iterator localIterator = paramJSONObject.keys();
      Object localObject1 = null;
      Object localObject2 = null;
      Object localObject3 = null;
      Object localObject4 = null;
      label128: String str6;
      Object localObject5;
      Object localObject6;
      Object localObject7;
      Object localObject8;
      if (localIterator.hasNext())
      {
        str6 = (String)localIterator.next();
        if (str6.equals(""))
        {
          localObject5 = b(paramJSONObject, str6);
          localObject6 = localObject2;
          localObject7 = localObject3;
          localObject8 = localObject4;
        }
      }
      while (true)
      {
        localObject4 = localObject8;
        localObject3 = localObject7;
        localObject2 = localObject6;
        localObject1 = localObject5;
        break label128;
        if (str6.equals(str5))
        {
          Object localObject13 = b(paramJSONObject, str6);
          Object localObject14 = localObject1;
          localObject6 = localObject2;
          localObject7 = localObject3;
          localObject8 = localObject13;
          localObject5 = localObject14;
        }
        else if (str6.equals(str1))
        {
          Object localObject11 = b(paramJSONObject, str6);
          localObject7 = localObject3;
          localObject8 = localObject4;
          Object localObject12 = localObject1;
          localObject6 = localObject11;
          localObject5 = localObject12;
        }
        else
        {
          if ((str2 != null) && (str2.startsWith(str6)))
          {
            Object localObject9 = b(paramJSONObject, str6);
            localObject8 = localObject4;
            Object localObject10 = localObject2;
            localObject7 = localObject9;
            localObject5 = localObject1;
            localObject6 = localObject10;
            continue;
            if (localObject4 != null)
              return localObject4;
            if (localObject3 != null)
              return localObject3;
            if (localObject2 != null)
              return localObject2;
            if (localObject1 == null)
              break;
            return localObject1;
          }
          localObject5 = localObject1;
          localObject6 = localObject2;
          localObject7 = localObject3;
          localObject8 = localObject4;
        }
      }
    }
  }

  public abstract T b(JSONObject paramJSONObject, String paramString)
    throws JSONException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.r
 * JD-Core Version:    0.6.2
 */