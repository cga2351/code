package com.viber.voip.sound.tones;

import com.viber.voip.R.raw;

public enum SampleTone
{
  private final int mLoop;
  private final boolean mOutgoing;
  private final PooledToneInfo mToneInfo;

  static
  {
    ACTIVATE_SECONDARY = new SampleTone("ACTIVATE_SECONDARY", 3, false, R.raw.activate_secondary, 3);
    VM_SEND = new SampleTone("VM_SEND", 4, true, R.raw.vm_send, 0);
    VM_MAXIMUM_DURATION_REACHED = new SampleTone("VM_MAXIMUM_DURATION_REACHED", 5, true, R.raw.vm_maximum_duration_reached, 0);
    VM_START_RECORDING = new SampleTone("VM_START_RECORDING", 6, true, R.raw.vm_start_recording, 0);
    VM_TRASH = new SampleTone("VM_TRASH", 7, true, R.raw.vm_trash, 0);
    LIKE = new SampleTone("LIKE", 8, false, R.raw.like, 0);
    SampleTone[] arrayOfSampleTone = new SampleTone[9];
    arrayOfSampleTone[0] = INCOMING_FG;
    arrayOfSampleTone[1] = OUTGOING_FG;
    arrayOfSampleTone[2] = OUTGOING_STICKER;
    arrayOfSampleTone[3] = ACTIVATE_SECONDARY;
    arrayOfSampleTone[4] = VM_SEND;
    arrayOfSampleTone[5] = VM_MAXIMUM_DURATION_REACHED;
    arrayOfSampleTone[6] = VM_START_RECORDING;
    arrayOfSampleTone[7] = VM_TRASH;
    arrayOfSampleTone[8] = LIKE;
  }

  private SampleTone(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    this.mToneInfo = new PooledToneInfo(paramInt1, this);
    this.mOutgoing = paramBoolean;
    this.mLoop = paramInt2;
  }

  public int getLoop()
  {
    return this.mLoop;
  }

  public PooledToneInfo getToneInfo()
  {
    return this.mToneInfo;
  }

  public boolean isOutgoing()
  {
    return this.mOutgoing;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.sound.tones.SampleTone
 * JD-Core Version:    0.6.2
 */