package com.viber.jni;

public class ConversationSettings
{
  private static final int HIDDEN_FLAG = 3;
  private static final int MUTE_FLAG = 2;
  private static final int SMART_FLAG = 1;
  public boolean hidden;
  public boolean mute;
  public boolean smartNotifications;

  public ConversationSettings(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.smartNotifications = paramBoolean1;
    this.mute = paramBoolean2;
    this.hidden = paramBoolean3;
  }

  public static ConversationSettings from(int paramInt)
  {
    boolean bool1 = true;
    boolean bool2;
    boolean bool3;
    if ((paramInt & 0x2) != 0)
    {
      bool2 = bool1;
      if ((paramInt & 0x4) == 0)
        break label41;
      bool3 = bool1;
      label18: if ((paramInt & 0x8) == 0)
        break label46;
    }
    while (true)
    {
      return new ConversationSettings(bool2, bool3, bool1);
      bool2 = false;
      break;
      label41: bool3 = false;
      break label18;
      label46: bool1 = false;
    }
  }

  public int convertToFlags()
  {
    boolean bool = this.smartNotifications;
    int i = 0;
    if (bool)
      i = 2;
    if (this.mute)
      i |= 4;
    if (this.hidden)
      i |= 8;
    return i;
  }

  public String toString()
  {
    return "ConversationSettings{smartNotifications=" + this.smartNotifications + ", mute=" + this.mute + ", hidden=" + this.hidden + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.ConversationSettings
 * JD-Core Version:    0.6.2
 */