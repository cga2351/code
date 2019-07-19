package com.viber.voip.phone.vptt;

public abstract interface VideoPttRecord
{
  public abstract void dispose();

  public abstract byte[] getJpegPreview();

  public abstract boolean isRecording();

  public abstract void startVideoPttRecord(String paramString, Completion paramCompletion);

  public abstract void stopVideoPttRecord(StopCompletion paramStopCompletion);

  public static abstract interface Completion
  {
    public abstract void onCompletion(Error paramError);
  }

  public static abstract interface StopCompletion
  {
    public abstract void onCompletion(boolean paramBoolean, Error paramError, byte[] paramArrayOfByte);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.vptt.VideoPttRecord
 * JD-Core Version:    0.6.2
 */