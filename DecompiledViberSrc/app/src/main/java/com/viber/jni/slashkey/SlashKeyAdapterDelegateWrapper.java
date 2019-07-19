package com.viber.jni.slashkey;

import com.google.d.f;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.da;

class SlashKeyAdapterDelegateWrapper
{
  private static final Logger L = ViberEnv.getLogger();
  private SlashKeyAdapterDelegate mDelegate;

  SlashKeyAdapterDelegateWrapper(SlashKeyAdapterDelegate paramSlashKeyAdapterDelegate)
  {
    this.mDelegate = paramSlashKeyAdapterDelegate;
  }

  @SlashKeyAdapterErrorCode
  private String clarifyError(String paramString)
  {
    if ("ERROR_TOKEN_EXPIRED".equals(paramString))
      return "ERROR_TOKEN_EXPIRED";
    return "OTHER";
  }

  void onInitialServiceSettingsReceived(int paramInt, String paramString1, String paramString2)
  {
    ServiceSettings localServiceSettings = (ServiceSettings)new f().a(paramString1, ServiceSettings.class);
    if (da.a(paramString2))
    {
      this.mDelegate.onInitialServiceSettingsReceived(paramInt, localServiceSettings);
      return;
    }
    this.mDelegate.onInitialServiceSettingsError(paramInt);
  }

  void onLoginServiceSettingsReceived(int paramInt, String paramString1, String paramString2)
  {
    ServiceSettings localServiceSettings = (ServiceSettings)new f().a(paramString1, ServiceSettings.class);
    if (da.a(paramString2))
    {
      this.mDelegate.onLoginServiceSettingsReceived(paramInt, localServiceSettings);
      return;
    }
    this.mDelegate.onLoginServiceSettingsError(paramInt);
  }

  void onSlashItemsReceived(int paramInt, String paramString1, String paramString2)
  {
    SlashItem[] arrayOfSlashItem = (SlashItem[])new f().a(paramString1, [Lcom.viber.jni.slashkey.SlashItem.class);
    if (da.a(paramString2))
    {
      this.mDelegate.onSlashItemsReceived(paramInt, arrayOfSlashItem);
      return;
    }
    this.mDelegate.onSlashItemsError(paramInt, clarifyError(paramString2));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.slashkey.SlashKeyAdapterDelegateWrapper
 * JD-Core Version:    0.6.2
 */