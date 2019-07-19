package com.viber.voip.phone.call;

import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.banner.a.a.d;
import com.viber.voip.banner.a.a.f;

class SingleAdForCallFetcher
{
  private static final Logger L = ViberEnv.getLogger();
  public static final int SUCCESSFUL_CALL_MIN_DURATION_FOR_AD = 3000;
  private final f mAdsCallControllerFactory;
  private CallState mCallState = CallState.IDLE;

  public SingleAdForCallFetcher(f paramf)
  {
    this.mAdsCallControllerFactory = paramf;
  }

  public CallState getCallState()
  {
    return this.mCallState;
  }

  public void onCallStateChanged(int paramInt, CallInfo paramCallInfo)
  {
    CallState localCallState = this.mCallState.nextSate(paramInt, paramCallInfo, this.mAdsCallControllerFactory);
    if (localCallState != this.mCallState)
    {
      localCallState.process(paramInt, paramCallInfo, this.mAdsCallControllerFactory);
      this.mCallState = localCallState;
    }
  }

  public static abstract enum CallState
  {
    static
    {
      // Byte code:
      //   0: new 17	com/viber/voip/phone/call/SingleAdForCallFetcher$CallState$1
      //   3: dup
      //   4: ldc 18
      //   6: iconst_0
      //   7: invokespecial 22	com/viber/voip/phone/call/SingleAdForCallFetcher$CallState$1:<init>	(Ljava/lang/String;I)V
      //   10: putstatic 24	com/viber/voip/phone/call/SingleAdForCallFetcher$CallState:IDLE	Lcom/viber/voip/phone/call/SingleAdForCallFetcher$CallState;
      //   13: new 26	com/viber/voip/phone/call/SingleAdForCallFetcher$CallState$2
      //   16: dup
      //   17: ldc 27
      //   19: iconst_1
      //   20: invokespecial 28	com/viber/voip/phone/call/SingleAdForCallFetcher$CallState$2:<init>	(Ljava/lang/String;I)V
      //   23: putstatic 30	com/viber/voip/phone/call/SingleAdForCallFetcher$CallState:DIALED	Lcom/viber/voip/phone/call/SingleAdForCallFetcher$CallState;
      //   26: new 32	com/viber/voip/phone/call/SingleAdForCallFetcher$CallState$3
      //   29: dup
      //   30: ldc 33
      //   32: iconst_2
      //   33: invokespecial 34	com/viber/voip/phone/call/SingleAdForCallFetcher$CallState$3:<init>	(Ljava/lang/String;I)V
      //   36: putstatic 36	com/viber/voip/phone/call/SingleAdForCallFetcher$CallState:IN_CALL	Lcom/viber/voip/phone/call/SingleAdForCallFetcher$CallState;
      //   39: new 38	com/viber/voip/phone/call/SingleAdForCallFetcher$CallState$4
      //   42: dup
      //   43: ldc 39
      //   45: iconst_3
      //   46: invokespecial 40	com/viber/voip/phone/call/SingleAdForCallFetcher$CallState$4:<init>	(Ljava/lang/String;I)V
      //   49: putstatic 42	com/viber/voip/phone/call/SingleAdForCallFetcher$CallState:ENDED	Lcom/viber/voip/phone/call/SingleAdForCallFetcher$CallState;
      //   52: new 44	com/viber/voip/phone/call/SingleAdForCallFetcher$CallState$5
      //   55: dup
      //   56: ldc 45
      //   58: iconst_4
      //   59: invokespecial 46	com/viber/voip/phone/call/SingleAdForCallFetcher$CallState$5:<init>	(Ljava/lang/String;I)V
      //   62: putstatic 48	com/viber/voip/phone/call/SingleAdForCallFetcher$CallState:CALL_FAILED	Lcom/viber/voip/phone/call/SingleAdForCallFetcher$CallState;
      //   65: iconst_5
      //   66: anewarray 2	com/viber/voip/phone/call/SingleAdForCallFetcher$CallState
      //   69: astore_0
      //   70: aload_0
      //   71: iconst_0
      //   72: getstatic 24	com/viber/voip/phone/call/SingleAdForCallFetcher$CallState:IDLE	Lcom/viber/voip/phone/call/SingleAdForCallFetcher$CallState;
      //   75: aastore
      //   76: aload_0
      //   77: iconst_1
      //   78: getstatic 30	com/viber/voip/phone/call/SingleAdForCallFetcher$CallState:DIALED	Lcom/viber/voip/phone/call/SingleAdForCallFetcher$CallState;
      //   81: aastore
      //   82: aload_0
      //   83: iconst_2
      //   84: getstatic 36	com/viber/voip/phone/call/SingleAdForCallFetcher$CallState:IN_CALL	Lcom/viber/voip/phone/call/SingleAdForCallFetcher$CallState;
      //   87: aastore
      //   88: aload_0
      //   89: iconst_3
      //   90: getstatic 42	com/viber/voip/phone/call/SingleAdForCallFetcher$CallState:ENDED	Lcom/viber/voip/phone/call/SingleAdForCallFetcher$CallState;
      //   93: aastore
      //   94: aload_0
      //   95: iconst_4
      //   96: getstatic 48	com/viber/voip/phone/call/SingleAdForCallFetcher$CallState:CALL_FAILED	Lcom/viber/voip/phone/call/SingleAdForCallFetcher$CallState;
      //   99: aastore
      //   100: aload_0
      //   101: putstatic 50	com/viber/voip/phone/call/SingleAdForCallFetcher$CallState:$VALUES	[Lcom/viber/voip/phone/call/SingleAdForCallFetcher$CallState;
      //   104: return
    }

    void cancelFetchAd(CallInfo paramCallInfo, f paramf, int paramInt)
    {
      paramf.a(paramInt).d();
      if (paramCallInfo != null)
      {
        paramCallInfo.setAdType(0);
        paramCallInfo.setAdProviderType(0);
      }
    }

    abstract CallState nextSate(int paramInt, CallInfo paramCallInfo, f paramf);

    void process(int paramInt, CallInfo paramCallInfo, f paramf)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.call.SingleAdForCallFetcher
 * JD-Core Version:    0.6.2
 */