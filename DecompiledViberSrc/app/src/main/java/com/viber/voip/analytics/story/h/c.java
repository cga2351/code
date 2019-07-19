package com.viber.voip.analytics.story.h;

import com.viber.voip.analytics.g;
import com.viber.voip.registration.ActivationController;
import java.util.Arrays;
import java.util.List;

public class c extends com.viber.common.permission.b
{
  private final g a;

  public c(g paramg)
  {
    this.a = paramg;
  }

  private void a(boolean paramBoolean)
  {
    this.a.a(b.a("Enable Manage Phone Calls", paramBoolean));
    this.a.a(d.a("Enabled Manage Phone Calls?", paramBoolean, "Manage Phone Calls"));
  }

  private boolean a(String[] paramArrayOfString, String paramString)
  {
    return Arrays.asList(paramArrayOfString).contains(paramString);
  }

  private boolean a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    return Arrays.asList(paramArrayOfString1).containsAll(Arrays.asList(paramArrayOfString2));
  }

  private void b(boolean paramBoolean)
  {
    this.a.a(b.a("Enable Photos", paramBoolean));
    this.a.a(d.a("Enable Photos?", paramBoolean, "Photos"));
  }

  private void c(boolean paramBoolean)
  {
    this.a.a(b.a("Enable Contact Access", paramBoolean));
    this.a.a(d.a("Enabled Contacts?", paramBoolean, "Contacts"));
  }

  private void d(boolean paramBoolean)
  {
    this.a.a(b.a("Enable Location", paramBoolean));
    this.a.a(d.a("Enabled Location?", paramBoolean, "Location"));
  }

  private void e(boolean paramBoolean)
  {
    this.a.a(b.a("Enable Camera", paramBoolean));
    this.a.a(d.a("Enabled Camera?", paramBoolean, "Camera"));
  }

  private void f(boolean paramBoolean)
  {
    this.a.a(b.a("Enable Microphone", paramBoolean));
    this.a.a(d.a("Enabled Microphone?", paramBoolean, "Microphone"));
  }

  public int[] acceptOnly()
  {
    return super.acceptOnly();
  }

  public void onCustomDialogAction(int paramInt1, String paramString, int paramInt2)
  {
    super.onCustomDialogAction(paramInt1, paramString, paramInt2);
  }

  public void onExplainPermissions(int paramInt, String[] paramArrayOfString, Object paramObject)
  {
    super.onExplainPermissions(paramInt, paramArrayOfString, paramObject);
  }

  public void onPermissionsDenied(int paramInt, boolean paramBoolean, String[] paramArrayOfString1, String[] paramArrayOfString2, Object paramObject)
  {
    if (!com.viber.voip.util.n.a(paramArrayOfString2))
      onPermissionsGranted(paramInt, paramArrayOfString2, paramObject);
    if (a(paramArrayOfString1, com.viber.voip.permissions.n.j))
      c(false);
    if (a(paramArrayOfString1, com.viber.voip.permissions.n.l))
      d(false);
    if (a(paramArrayOfString1, "android.permission.CAMERA"))
      e(false);
    if (a(paramArrayOfString1, "android.permission.RECORD_AUDIO"))
      f(false);
    if (a(paramArrayOfString1, com.viber.voip.permissions.n.m))
      b(false);
    if ((ActivationController.IS_ACTIVATION_BY_PHONE_CALL_AVAILABLE) && (a(paramArrayOfString1, com.viber.voip.permissions.n.o)))
      a(false);
  }

  public void onPermissionsGranted(int paramInt, String[] paramArrayOfString, Object paramObject)
  {
    if (a(paramArrayOfString, com.viber.voip.permissions.n.j))
      c(true);
    if (a(paramArrayOfString, com.viber.voip.permissions.n.l))
      d(true);
    if (a(paramArrayOfString, "android.permission.CAMERA"))
      e(true);
    if (a(paramArrayOfString, "android.permission.RECORD_AUDIO"))
      f(true);
    if (a(paramArrayOfString, com.viber.voip.permissions.n.m))
      b(true);
    if ((ActivationController.IS_ACTIVATION_BY_PHONE_CALL_AVAILABLE) && (a(paramArrayOfString, com.viber.voip.permissions.n.o)))
      a(true);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.analytics.story.h.c
 * JD-Core Version:    0.6.2
 */