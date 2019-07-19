package com.viber.voip.sound.tones;

import com.viber.voip.R.raw;

public enum CallTone
{
  private static final float VOLUME = 0.66F;
  private final PooledToneInfo mToneInfo;

  static
  {
    HANGUP = new CallTone("HANGUP", 2, R.raw.ct_call_ended);
    HOLD = new CallTone("HOLD", 3, R.raw.ct_hold);
    DATA_INTERRUPTION_TONE = new CallTone("DATA_INTERRUPTION_TONE", 4, R.raw.ct_hold);
    CallTone[] arrayOfCallTone = new CallTone[5];
    arrayOfCallTone[0] = BUSY;
    arrayOfCallTone[1] = RINGBACK;
    arrayOfCallTone[2] = HANGUP;
    arrayOfCallTone[3] = HOLD;
    arrayOfCallTone[4] = DATA_INTERRUPTION_TONE;
  }

  private CallTone(int paramInt)
  {
    this.mToneInfo = new PooledToneInfo(paramInt, this, 0.66F);
  }

  public PooledToneInfo getToneInfo()
  {
    return this.mToneInfo;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.tones.CallTone
 * JD-Core Version:    0.6.2
 */