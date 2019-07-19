package com.viber.voip.messages.extensions;

import android.util.Base64;
import com.viber.voip.ViberApplication;
import com.viber.voip.p;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.registration.af;
import com.viber.voip.user.UserManager;
import java.util.Map;

final class j
{
  private final HardwareParameters a = ViberApplication.getInstance().getHardwareParameters();
  private final af b = UserManager.from(ViberApplication.getApplication()).getRegistrationValues();

  public void a(Map<String, String> paramMap)
  {
    paramMap.put("mcc", this.a.getSimMCC());
    paramMap.put("mnc", this.a.getSimMNC());
    paramMap.put("udid", this.a.getUdid());
    paramMap.put("member_id", this.b.l());
    paramMap.put("phone", this.b.g());
    paramMap.put("system", String.valueOf(p.j()));
  }

  public void a(Map<String, String> paramMap, long paramLong, byte[] paramArrayOfByte)
  {
    paramMap.put("authToken", Base64.encodeToString(paramArrayOfByte, 2));
    paramMap.put("timestamp", String.valueOf(paramLong));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.j
 * JD-Core Version:    0.6.2
 */