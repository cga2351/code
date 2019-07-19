package org.webrtc;

public enum VideoCodecStatus
{
  private final int number;

  static
  {
    NO_OUTPUT = new VideoCodecStatus("NO_OUTPUT", 1, 1);
    OK = new VideoCodecStatus("OK", 2, 0);
    ERROR = new VideoCodecStatus("ERROR", 3, -1);
    LEVEL_EXCEEDED = new VideoCodecStatus("LEVEL_EXCEEDED", 4, -2);
    MEMORY = new VideoCodecStatus("MEMORY", 5, -3);
    ERR_PARAMETER = new VideoCodecStatus("ERR_PARAMETER", 6, -4);
    ERR_SIZE = new VideoCodecStatus("ERR_SIZE", 7, -5);
    TIMEOUT = new VideoCodecStatus("TIMEOUT", 8, -6);
    UNINITIALIZED = new VideoCodecStatus("UNINITIALIZED", 9, -7);
    ERR_REQUEST_SLI = new VideoCodecStatus("ERR_REQUEST_SLI", 10, -12);
    FALLBACK_SOFTWARE = new VideoCodecStatus("FALLBACK_SOFTWARE", 11, -13);
    TARGET_BITRATE_OVERSHOOT = new VideoCodecStatus("TARGET_BITRATE_OVERSHOOT", 12, -14);
    VideoCodecStatus[] arrayOfVideoCodecStatus = new VideoCodecStatus[13];
    arrayOfVideoCodecStatus[0] = REQUEST_SLI;
    arrayOfVideoCodecStatus[1] = NO_OUTPUT;
    arrayOfVideoCodecStatus[2] = OK;
    arrayOfVideoCodecStatus[3] = ERROR;
    arrayOfVideoCodecStatus[4] = LEVEL_EXCEEDED;
    arrayOfVideoCodecStatus[5] = MEMORY;
    arrayOfVideoCodecStatus[6] = ERR_PARAMETER;
    arrayOfVideoCodecStatus[7] = ERR_SIZE;
    arrayOfVideoCodecStatus[8] = TIMEOUT;
    arrayOfVideoCodecStatus[9] = UNINITIALIZED;
    arrayOfVideoCodecStatus[10] = ERR_REQUEST_SLI;
    arrayOfVideoCodecStatus[11] = FALLBACK_SOFTWARE;
    arrayOfVideoCodecStatus[12] = TARGET_BITRATE_OVERSHOOT;
  }

  private VideoCodecStatus(int paramInt)
  {
    this.number = paramInt;
  }

  @CalledByNative
  public int getNumber()
  {
    return this.number;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.VideoCodecStatus
 * JD-Core Version:    0.6.2
 */