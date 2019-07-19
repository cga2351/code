package com.facebook.react.devsupport.interfaces;

import android.util.Pair;

public abstract interface ErrorCustomizer
{
  public abstract Pair<String, StackFrame[]> customizeErrorInfo(Pair<String, StackFrame[]> paramPair);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.interfaces.ErrorCustomizer
 * JD-Core Version:    0.6.2
 */