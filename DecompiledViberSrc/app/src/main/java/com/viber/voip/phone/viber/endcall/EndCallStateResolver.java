package com.viber.voip.phone.viber.endcall;

import android.view.View;
import com.viber.voip.R.id;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.InCallState;
import java.util.Arrays;

public enum EndCallStateResolver
{
  private static int[] statusAllowRedial = { 0, 1, 2, 3, 7 };
  private boolean suitableForAds;
  private int[][] viewsStates;

  static
  {
    int[][] arrayOfInt1 = new int[4][];
    int[] arrayOfInt2 = new int[2];
    arrayOfInt2[0] = R.id.phone_send_message;
    arrayOfInt2[1] = 0;
    arrayOfInt1[0] = arrayOfInt2;
    int[] arrayOfInt3 = new int[2];
    arrayOfInt3[0] = R.id.phone_redial;
    arrayOfInt3[1] = 8;
    arrayOfInt1[1] = arrayOfInt3;
    int[] arrayOfInt4 = new int[2];
    arrayOfInt4[0] = R.id.phone_viberout;
    arrayOfInt4[1] = 4;
    arrayOfInt1[2] = arrayOfInt4;
    int[] arrayOfInt5 = new int[2];
    arrayOfInt5[0] = R.id.phone_call_offline;
    arrayOfInt5[1] = 4;
    arrayOfInt1[3] = arrayOfInt5;
    DEFAULT = new EndCallStateResolver("DEFAULT", 0, arrayOfInt1, true);
    int[][] arrayOfInt6 = new int[4][];
    int[] arrayOfInt7 = new int[2];
    arrayOfInt7[0] = R.id.phone_send_message;
    arrayOfInt7[1] = 0;
    arrayOfInt6[0] = arrayOfInt7;
    int[] arrayOfInt8 = new int[2];
    arrayOfInt8[0] = R.id.phone_redial;
    arrayOfInt8[1] = 0;
    arrayOfInt6[1] = arrayOfInt8;
    int[] arrayOfInt9 = new int[2];
    arrayOfInt9[0] = R.id.phone_viberout;
    arrayOfInt9[1] = 8;
    arrayOfInt6[2] = arrayOfInt9;
    int[] arrayOfInt10 = new int[2];
    arrayOfInt10[0] = R.id.phone_call_offline;
    arrayOfInt10[1] = 4;
    arrayOfInt6[3] = arrayOfInt10;
    BUSY = new EndCallStateResolver("BUSY", 1, arrayOfInt6, false);
    int[][] arrayOfInt11 = new int[3][];
    int[] arrayOfInt12 = new int[2];
    arrayOfInt12[0] = R.id.phone_send_message;
    arrayOfInt12[1] = 0;
    arrayOfInt11[0] = arrayOfInt12;
    int[] arrayOfInt13 = new int[2];
    arrayOfInt13[0] = R.id.phone_redial;
    arrayOfInt13[1] = 0;
    arrayOfInt11[1] = arrayOfInt13;
    int[] arrayOfInt14 = new int[2];
    arrayOfInt14[0] = R.id.phone_viberout;
    arrayOfInt14[1] = 0;
    arrayOfInt11[2] = arrayOfInt14;
    TIMEOUT = new EndCallStateResolver("TIMEOUT", 2, arrayOfInt11, true);
    int[][] arrayOfInt15 = new int[4][];
    int[] arrayOfInt16 = new int[2];
    arrayOfInt16[0] = R.id.phone_send_message;
    arrayOfInt16[1] = 0;
    arrayOfInt15[0] = arrayOfInt16;
    int[] arrayOfInt17 = new int[2];
    arrayOfInt17[0] = R.id.phone_redial;
    arrayOfInt17[1] = 0;
    arrayOfInt15[1] = arrayOfInt17;
    int[] arrayOfInt18 = new int[2];
    arrayOfInt18[0] = R.id.phone_viberout;
    arrayOfInt18[1] = 0;
    arrayOfInt15[2] = arrayOfInt18;
    int[] arrayOfInt19 = new int[2];
    arrayOfInt19[0] = R.id.phone_call_offline;
    arrayOfInt19[1] = 0;
    arrayOfInt15[3] = arrayOfInt19;
    VIDEO_TIMEOUT = new EndCallStateResolver("VIDEO_TIMEOUT", 3, arrayOfInt15, true);
    int[][] arrayOfInt20 = new int[4][];
    int[] arrayOfInt21 = new int[2];
    arrayOfInt21[0] = R.id.phone_send_message;
    arrayOfInt21[1] = 8;
    arrayOfInt20[0] = arrayOfInt21;
    int[] arrayOfInt22 = new int[2];
    arrayOfInt22[0] = R.id.phone_redial;
    arrayOfInt22[1] = 0;
    arrayOfInt20[1] = arrayOfInt22;
    int[] arrayOfInt23 = new int[2];
    arrayOfInt23[0] = R.id.phone_viberout;
    arrayOfInt23[1] = 8;
    arrayOfInt20[2] = arrayOfInt23;
    int[] arrayOfInt24 = new int[2];
    arrayOfInt24[0] = R.id.phone_call_offline;
    arrayOfInt24[1] = 4;
    arrayOfInt20[3] = arrayOfInt24;
    VO_DEFAULT = new EndCallStateResolver("VO_DEFAULT", 4, arrayOfInt20, false);
    int[][] arrayOfInt25 = new int[4][];
    int[] arrayOfInt26 = new int[2];
    arrayOfInt26[0] = R.id.phone_send_message;
    arrayOfInt26[1] = 8;
    arrayOfInt25[0] = arrayOfInt26;
    int[] arrayOfInt27 = new int[2];
    arrayOfInt27[0] = R.id.phone_redial;
    arrayOfInt27[1] = 0;
    arrayOfInt25[1] = arrayOfInt27;
    int[] arrayOfInt28 = new int[2];
    arrayOfInt28[0] = R.id.phone_viberout;
    arrayOfInt28[1] = 8;
    arrayOfInt25[2] = arrayOfInt28;
    int[] arrayOfInt29 = new int[2];
    arrayOfInt29[0] = R.id.phone_call_offline;
    arrayOfInt29[1] = 4;
    arrayOfInt25[3] = arrayOfInt29;
    VO_DEFAULT_FAILED = new EndCallStateResolver("VO_DEFAULT_FAILED", 5, arrayOfInt25, false);
    int[][] arrayOfInt30 = new int[4][];
    int[] arrayOfInt31 = new int[2];
    arrayOfInt31[0] = R.id.phone_send_message;
    arrayOfInt31[1] = 8;
    arrayOfInt30[0] = arrayOfInt31;
    int[] arrayOfInt32 = new int[2];
    arrayOfInt32[0] = R.id.phone_redial;
    arrayOfInt32[1] = 8;
    arrayOfInt30[1] = arrayOfInt32;
    int[] arrayOfInt33 = new int[2];
    arrayOfInt33[0] = R.id.phone_viberout;
    arrayOfInt33[1] = 4;
    arrayOfInt30[2] = arrayOfInt33;
    int[] arrayOfInt34 = new int[2];
    arrayOfInt34[0] = R.id.phone_call_offline;
    arrayOfInt34[1] = 4;
    arrayOfInt30[3] = arrayOfInt34;
    VO_NO_CREDIT_FAILED = new EndCallStateResolver("VO_NO_CREDIT_FAILED", 6, arrayOfInt30, false);
    EndCallStateResolver[] arrayOfEndCallStateResolver = new EndCallStateResolver[7];
    arrayOfEndCallStateResolver[0] = DEFAULT;
    arrayOfEndCallStateResolver[1] = BUSY;
    arrayOfEndCallStateResolver[2] = TIMEOUT;
    arrayOfEndCallStateResolver[3] = VIDEO_TIMEOUT;
    arrayOfEndCallStateResolver[4] = VO_DEFAULT;
    arrayOfEndCallStateResolver[5] = VO_DEFAULT_FAILED;
    arrayOfEndCallStateResolver[6] = VO_NO_CREDIT_FAILED;
  }

  private EndCallStateResolver(int[][] paramArrayOfInt, boolean paramBoolean)
  {
    this.viewsStates = paramArrayOfInt;
    this.suitableForAds = paramBoolean;
  }

  public static EndCallStateResolver resolveCallState(CallInfo paramCallInfo)
  {
    if (paramCallInfo != null)
    {
      int i = paramCallInfo.getInCallState().getDisconnectStatus();
      int j = paramCallInfo.getInCallState().getEndReason();
      if (paramCallInfo.isViberOut())
      {
        if ((j == 12) || (j == 15))
          return VO_NO_CREDIT_FAILED;
        if (Arrays.binarySearch(statusAllowRedial, i) >= 0);
        for (int k = 1; (k == 0) || (j == 11) || (j == 3); k = 0)
          return DEFAULT;
        if ((paramCallInfo.getInCallState().isEndCallReasonFailed()) || (j == 1))
          return VO_DEFAULT_FAILED;
        return VO_DEFAULT;
      }
      if ((paramCallInfo.getInCallState().isEndCallReasonFailed()) && ((j == 6) || (j == 4) || (i == 8) || (i == 7) || (j == 2)))
      {
        if ((paramCallInfo.isOutgoingVideoCall()) || (paramCallInfo.isIncomingVideoCall()))
          return VIDEO_TIMEOUT;
        return TIMEOUT;
      }
      if ((i == 0) && (j == 4))
      {
        if ((paramCallInfo.isOutgoingVideoCall()) || (paramCallInfo.isIncomingVideoCall()))
          return VIDEO_TIMEOUT;
        return TIMEOUT;
      }
      if ((paramCallInfo.getInCallState().isEndCallReasonFailed()) || (j == 1))
        return BUSY;
      return DEFAULT;
    }
    return DEFAULT;
  }

  public boolean isSuitableForAds()
  {
    return this.suitableForAds;
  }

  public void resolveViewsState(View paramView)
  {
    for (int i = 0; i < this.viewsStates.length; i++)
    {
      View localView = paramView.findViewById(this.viewsStates[i][0]);
      if (localView != null)
        localView.setVisibility(this.viewsStates[i][1]);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.endcall.EndCallStateResolver
 * JD-Core Version:    0.6.2
 */