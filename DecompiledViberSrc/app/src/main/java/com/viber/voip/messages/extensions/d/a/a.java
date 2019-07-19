package com.viber.voip.messages.extensions.d.a;

import com.viber.voip.messages.extensions.model.ChatExtensionLoaderEntity;

public class a
{
  public final String a;
  public final ChatExtensionLoaderEntity b;

  public a(String paramString, ChatExtensionLoaderEntity paramChatExtensionLoaderEntity)
  {
    this.a = paramString;
    this.b = paramChatExtensionLoaderEntity;
  }

  public boolean equals(Object paramObject)
  {
    boolean bool1;
    if (this == paramObject)
      bool1 = true;
    a locala;
    boolean bool2;
    do
    {
      Class localClass1;
      Class localClass2;
      do
      {
        do
        {
          return bool1;
          bool1 = false;
        }
        while (paramObject == null);
        localClass1 = getClass();
        localClass2 = paramObject.getClass();
        bool1 = false;
      }
      while (localClass1 != localClass2);
      locala = (a)paramObject;
      bool2 = this.a.equals(locala.a);
      bool1 = false;
    }
    while (!bool2);
    return this.b.equals(locala.b);
  }

  public int hashCode()
  {
    return 31 * this.a.hashCode() + this.b.hashCode();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.d.a.a
 * JD-Core Version:    0.6.2
 */