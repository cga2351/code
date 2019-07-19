package com.viber.voip.sound.tones;

import com.viber.voip.R.raw;

public enum DtmfTone
{
  private static final float DTMF_VOLUME = 0.16F;
  private final PooledToneInfo mToneInfo;

  static
  {
    ONE = new DtmfTone("ONE", 1, R.raw.dtmf1);
    TWO = new DtmfTone("TWO", 2, R.raw.dtmf2);
    THREE = new DtmfTone("THREE", 3, R.raw.dtmf3);
    FOUR = new DtmfTone("FOUR", 4, R.raw.dtmf4);
    FIVE = new DtmfTone("FIVE", 5, R.raw.dtmf5);
    SIX = new DtmfTone("SIX", 6, R.raw.dtmf6);
    SEVEN = new DtmfTone("SEVEN", 7, R.raw.dtmf7);
    EIGHT = new DtmfTone("EIGHT", 8, R.raw.dtmf8);
    NINE = new DtmfTone("NINE", 9, R.raw.dtmf9);
    ASTERIX = new DtmfTone("ASTERIX", 10, R.raw.asterix);
    POUND = new DtmfTone("POUND", 11, R.raw.number);
    DtmfTone[] arrayOfDtmfTone = new DtmfTone[12];
    arrayOfDtmfTone[0] = ZERO;
    arrayOfDtmfTone[1] = ONE;
    arrayOfDtmfTone[2] = TWO;
    arrayOfDtmfTone[3] = THREE;
    arrayOfDtmfTone[4] = FOUR;
    arrayOfDtmfTone[5] = FIVE;
    arrayOfDtmfTone[6] = SIX;
    arrayOfDtmfTone[7] = SEVEN;
    arrayOfDtmfTone[8] = EIGHT;
    arrayOfDtmfTone[9] = NINE;
    arrayOfDtmfTone[10] = ASTERIX;
    arrayOfDtmfTone[11] = POUND;
  }

  private DtmfTone(int paramInt)
  {
    this.mToneInfo = new PooledToneInfo(paramInt, this, 0.16F);
  }

  public PooledToneInfo getToneInfo()
  {
    return this.mToneInfo;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.tones.DtmfTone
 * JD-Core Version:    0.6.2
 */