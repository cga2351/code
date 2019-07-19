package org.webrtc;

abstract interface CameraSession
{
  public abstract void stop();

  public static abstract interface CreateSessionCallback
  {
    public abstract void onDone(CameraSession paramCameraSession);

    public abstract void onFailure(CameraSession.FailureType paramFailureType, String paramString);
  }

  public static abstract interface Events
  {
    public abstract void onCameraClosed(CameraSession paramCameraSession);

    public abstract void onCameraDisconnected(CameraSession paramCameraSession);

    public abstract void onCameraError(CameraSession paramCameraSession, String paramString);

    public abstract void onCameraOpening();

    public abstract void onFrameCaptured(CameraSession paramCameraSession, VideoFrame paramVideoFrame);
  }

  public static enum FailureType
  {
    static
    {
      DISCONNECTED = new FailureType("DISCONNECTED", 1);
      FailureType[] arrayOfFailureType = new FailureType[2];
      arrayOfFailureType[0] = ERROR;
      arrayOfFailureType[1] = DISCONNECTED;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.CameraSession
 * JD-Core Version:    0.6.2
 */