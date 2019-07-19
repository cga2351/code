package com.viber.voip.phone.call.filters;

import com.viber.voip.ViberApplication;
import com.viber.voip.contacts.ui.ParticipantSelector.Participant;
import com.viber.voip.model.entity.g;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.util.dr;
import com.viber.voip.util.dr.a;
import java.util.HashSet;
import java.util.Set;

public class ViberOutCallFilter
{
  private static final Set<Integer> FREE_VO_COUNTRIES = new HashSet();
  private static final int GREECE_COUNTRY_CODE = 30;
  private CallHandler mTarget;

  public ViberOutCallFilter(CallHandler paramCallHandler)
  {
    this.mTarget = paramCallHandler;
  }

  public static boolean isFreeVOCountryCode(String paramString)
  {
    if (FREE_VO_COUNTRIES.isEmpty())
      return false;
    ViberApplication localViberApplication = ViberApplication.getInstance();
    int i = dr.b(localViberApplication, dr.a(localViberApplication, paramString, paramString));
    return FREE_VO_COUNTRIES.contains(Integer.valueOf(i));
  }

  public boolean handleDialViberOut(final String paramString)
  {
    if (!isFreeVOCountryCode(paramString))
      return false;
    dr.a(paramString, new dr.a()
    {
      public void onCheckStatus(boolean paramAnonymousBoolean, int paramAnonymousInt, ParticipantSelector.Participant paramAnonymousParticipant, g paramAnonymousg)
      {
        switch (paramAnonymousInt)
        {
        default:
          ViberOutCallFilter.this.mTarget.handleDialViberOut(paramString);
          return;
        case 0:
        }
        ViberOutCallFilter.this.mTarget.handleDial(paramString, false);
      }
    });
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.call.filters.ViberOutCallFilter
 * JD-Core Version:    0.6.2
 */