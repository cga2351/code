package com.viber.voip.user.viberid;

import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.EventBus;

public abstract interface ViberIdController
{
  public static final long LOGIN_BLOCKED_PERIOD = TimeUnit.HOURS.toSeconds(24L);

  public abstract void cancelEmailStatusCheck();

  public abstract void changeEmail(String paramString1, String paramString2);

  public abstract void changePassword(String paramString1, String paramString2);

  public abstract void checkEmailStatus(String paramString);

  public abstract EventBus getEventBus();

  public abstract PendingRegistrationRequest getPendingRegistrationRequest();

  public abstract ViberIdInfo getViberIdInfo();

  public abstract void performForgotPasswordAction(String paramString);

  public abstract void registerViberId(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2);

  public abstract void retypePassword(String paramString);

  public abstract void sendFreeStickerPackMessage();

  public abstract void unlinkViberId();

  public static class PendingEmailChangingRequest extends ViberIdController.PendingEmailRequest
  {
    private final String mPassword;

    PendingEmailChangingRequest(int paramInt, String paramString1, String paramString2)
    {
      super(paramString1);
      this.mPassword = paramString2;
    }

    public String toString()
    {
      return "PenndingEmailChangingRequest{mPassword='" + this.mPassword + '\'' + '}';
    }
  }

  public static class PendingEmailRequest
  {
    public final String email;
    final int seq;

    PendingEmailRequest(int paramInt, String paramString)
    {
      this.seq = paramInt;
      this.email = paramString;
    }

    public String toString()
    {
      return "PendingEmailRequest{seq=" + this.seq + ", email='" + this.email + '\'' + '}';
    }
  }

  public static class PendingPasswordActionRequest extends ViberIdController.PendingEmailRequest
  {
    public final int action;
    public final String newPassword;
    public final String oldPassword;

    PendingPasswordActionRequest(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2)
    {
      super(paramString1);
      this.oldPassword = paramString2;
      this.newPassword = paramString3;
      this.action = paramInt2;
    }

    public String toString()
    {
      return super.toString() + ",PendingPasswordActionRequest{action=" + this.action + '}';
    }
  }

  public static class PendingRegistrationRequest extends ViberIdController.PendingEmailRequest
  {
    public final boolean existingEmail;
    public final String password;
    public final boolean promotionsAgreed;

    public PendingRegistrationRequest(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
    {
      super(paramString1);
      this.password = paramString2;
      this.existingEmail = paramBoolean1;
      this.promotionsAgreed = paramBoolean2;
    }

    public String toString()
    {
      return super.toString() + ", PendingRegistrationRequest{existingEmail=" + this.existingEmail + '\'' + ", promotionsAgreed=" + this.promotionsAgreed + '}';
    }
  }

  public static class PendingUnlinkViberIdRequest
  {
    final int seq;

    PendingUnlinkViberIdRequest(int paramInt)
    {
      this.seq = paramInt;
    }

    public String toString()
    {
      return "PendingUnlinkViberIdRequest{seq=" + this.seq + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.ViberIdController
 * JD-Core Version:    0.6.2
 */