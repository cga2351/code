package com.viber.jni;

import android.os.Bundle;

public class JokerButton
{
  public String action;
  public String buttonTxt;
  public String iconUrl;

  public JokerButton()
  {
  }

  JokerButton(Bundle paramBundle)
  {
    this.iconUrl = paramBundle.getString("iconUrl");
    this.action = paramBundle.getString("action");
    this.buttonTxt = paramBundle.getString("buttonTxt");
  }

  public String getAction()
  {
    return this.action;
  }

  public String getButtonTxt()
  {
    return this.buttonTxt;
  }

  public String getIconUrl()
  {
    return this.iconUrl;
  }

  public String toString()
  {
    return "JokerButton{iconUrl='" + this.iconUrl + '\'' + ", action='" + this.action + '\'' + ", buttonTxt='" + this.buttonTxt + '\'' + '}';
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.jni.JokerButton
 * JD-Core Version:    0.6.2
 */