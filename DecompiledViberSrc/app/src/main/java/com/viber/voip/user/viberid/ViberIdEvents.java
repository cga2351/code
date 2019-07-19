package com.viber.voip.user.viberid;

public abstract interface ViberIdEvents
{
  public static class UnlinkViberIdEvent
  {
    public final int status;

    public UnlinkViberIdEvent(int paramInt)
    {
      this.status = paramInt;
    }

    public String toString()
    {
      return "UnlinkViberIdEvent{status=" + this.status + '}';
    }
  }

  public static class ViberIdChangePasswordActionEvent extends ViberIdEvents.ViberIdPasswordActionEvent
  {
    public ViberIdChangePasswordActionEvent(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }

    public int getAction()
    {
      return 1;
    }
  }

  public static class ViberIdEmailChangingEvent
  {
    public final int status;

    public ViberIdEmailChangingEvent(int paramInt)
    {
      this.status = paramInt;
    }

    public String toString()
    {
      return "ViberIdEmailChangingEvent{status=" + this.status + '}';
    }
  }

  public static class ViberIdEmailStatusEvent
  {
    public final String email;
    public final boolean promotionsAgreed;
    public final int status;

    public ViberIdEmailStatusEvent(String paramString, int paramInt, boolean paramBoolean)
    {
      this.email = paramString;
      this.status = paramInt;
      this.promotionsAgreed = paramBoolean;
    }

    public String toString()
    {
      return "ViberIdEmailStatusEvent{email='" + this.email + '\'' + ", status=" + this.status + ", promotionsAgreed=" + this.promotionsAgreed + '}';
    }
  }

  public static class ViberIdForgotPasswordActionEvent extends ViberIdEvents.ViberIdPasswordActionEvent
  {
    public ViberIdForgotPasswordActionEvent(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }

    public int getAction()
    {
      return 0;
    }
  }

  public static class ViberIdInfoChangedEvent
  {
    public final ViberIdInfo viberIdInfo;

    public ViberIdInfoChangedEvent(ViberIdInfo paramViberIdInfo)
    {
      this.viberIdInfo = paramViberIdInfo;
    }

    public String toString()
    {
      return "ViberIdInfoChangedEvent{viberIdInfo=" + this.viberIdInfo + '}';
    }
  }

  public static abstract class ViberIdPasswordActionEvent
  {
    public final int status;
    public final int version;

    public ViberIdPasswordActionEvent(int paramInt1, int paramInt2)
    {
      this.status = paramInt1;
      this.version = paramInt2;
    }

    public abstract int getAction();

    public String toString()
    {
      return "ViberIdPasswordActionEvent{status=" + this.status + ", action =" + getAction() + ", version=" + this.version + '}';
    }
  }

  public static class ViberIdRegistrationEvent
  {
    public final String email;
    public final int status;
    public final int version;

    public ViberIdRegistrationEvent(String paramString, int paramInt1, int paramInt2)
    {
      this.email = paramString;
      this.version = paramInt1;
      this.status = paramInt2;
    }

    public String toString()
    {
      return "ViberIdRegistrationEvent{email='" + this.email + '\'' + ", version=" + this.version + ", status=" + this.status + '}';
    }
  }

  public static class ViberIdRetypePasswordActionEvent extends ViberIdEvents.ViberIdPasswordActionEvent
  {
    public ViberIdRetypePasswordActionEvent(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }

    public int getAction()
    {
      return 2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.viberid.ViberIdEvents
 * JD-Core Version:    0.6.2
 */