package com.facebook.react.devsupport.interfaces;

import org.json.JSONObject;

public abstract interface StackFrame
{
  public abstract int getColumn();

  public abstract String getFile();

  public abstract String getFileName();

  public abstract int getLine();

  public abstract String getMethod();

  public abstract JSONObject toJSON();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.interfaces.StackFrame
 * JD-Core Version:    0.6.2
 */