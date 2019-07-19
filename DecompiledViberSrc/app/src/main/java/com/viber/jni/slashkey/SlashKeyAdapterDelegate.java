package com.viber.jni.slashkey;

public abstract interface SlashKeyAdapterDelegate
{
  public abstract void onInitialServiceSettingsError(int paramInt);

  public abstract void onInitialServiceSettingsReceived(int paramInt, ServiceSettings paramServiceSettings);

  public abstract void onLoginServiceSettingsError(int paramInt);

  public abstract void onLoginServiceSettingsReceived(int paramInt, ServiceSettings paramServiceSettings);

  public abstract void onSlashItemsError(int paramInt, @SlashKeyAdapterErrorCode String paramString);

  public abstract void onSlashItemsReceived(int paramInt, SlashItem[] paramArrayOfSlashItem);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.slashkey.SlashKeyAdapterDelegate
 * JD-Core Version:    0.6.2
 */