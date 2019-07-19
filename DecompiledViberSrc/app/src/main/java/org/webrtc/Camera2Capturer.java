package org.webrtc;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.CameraManager;
import javax.annotation.Nullable;

@TargetApi(21)
public class Camera2Capturer extends CameraCapturer
{

  @Nullable
  private final CameraManager cameraManager;
  private final Context context;

  public Camera2Capturer(Context paramContext, String paramString, CameraVideoCapturer.CameraEventsHandler paramCameraEventsHandler)
  {
    super(paramString, paramCameraEventsHandler, new Camera2Enumerator(paramContext));
    this.context = paramContext;
    this.cameraManager = ((CameraManager)paramContext.getSystemService("camera"));
  }

  protected void createCameraSession(CameraSession.CreateSessionCallback paramCreateSessionCallback, CameraSession.Events paramEvents, Context paramContext, SurfaceTextureHelper paramSurfaceTextureHelper, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Camera2Session.create(paramCreateSessionCallback, paramEvents, paramContext, this.cameraManager, paramSurfaceTextureHelper, paramString, paramInt1, paramInt2, paramInt3);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.Camera2Capturer
 * JD-Core Version:    0.6.2
 */