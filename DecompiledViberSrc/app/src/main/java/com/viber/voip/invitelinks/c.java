package com.viber.voip.invitelinks;

import android.net.Uri;
import com.viber.voip.flatbuffers.model.msginfo.GroupReferralInfo;
import com.viber.voip.util.da;
import com.viber.voip.util.dx;

public class c
{
  public CommunityFollowerData a(d.b paramb, String paramString, GroupReferralInfo paramGroupReferralInfo)
  {
    if (da.a(paramb.c));
    for (Uri localUri = null; ; localUri = dx.g(paramb.c))
      return new CommunityFollowerData(paramb.a, paramb.b, localUri, paramb.d, paramb.e, paramString, paramb.g, paramGroupReferralInfo, 1, 2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.invitelinks.c
 * JD-Core Version:    0.6.2
 */