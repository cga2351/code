package com.viber.voip.analytics.story.b.a;

import android.net.Uri;
import com.viber.jni.controller.PhoneController;
import com.viber.voip.analytics.a.i;
import com.viber.voip.analytics.g;
import com.viber.voip.analytics.story.b.c;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallerInfo;
import com.viber.voip.registration.af;
import com.viber.voip.util.ae;
import com.viber.voip.util.cg;
import com.viber.voip.util.da;
import javax.inject.Inject;

public class a
{
  private final c a;
  private final PhoneController b;
  private final af c;

  @Inject
  a(c paramc, PhoneController paramPhoneController, af paramaf)
  {
    this.a = paramc;
    this.b = paramPhoneController;
    this.c = paramaf;
  }

  public void a(CallInfo paramCallInfo, String paramString, long paramLong)
  {
    CallerInfo localCallerInfo = paramCallInfo.getCallerInfo();
    String str1 = cg.a(this.b, localCallerInfo.getPhoneNumber(), false);
    String str2 = cg.a(this.b, this.c.g(), true);
    Uri localUri = localCallerInfo.getCallerPhoto();
    boolean bool1;
    if ((localUri != null) && (!da.a(localUri.getPath())))
    {
      bool1 = true;
      if ((localCallerInfo.getContact() == null) || (!localCallerInfo.getContact().i()))
        break label165;
    }
    label165: for (boolean bool2 = true; ; bool2 = false)
    {
      long l = paramLong / 1000L;
      this.a.a(paramCallInfo, paramString, str1, str2, bool1, bool2, paramCallInfo.isPureViberCall(), paramCallInfo.isVln(), paramCallInfo.isPureViberIn(), l, ae.b());
      if (("Answer".equals(paramString)) || ("Answer with Video".equals(paramString)))
        g.a().a(i.b());
      return;
      bool1 = false;
      break;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.b.a.a
 * JD-Core Version:    0.6.2
 */