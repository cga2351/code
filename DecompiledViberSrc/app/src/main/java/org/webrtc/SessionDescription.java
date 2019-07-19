package org.webrtc;

import java.util.Locale;

public class SessionDescription
{
  public final String description;
  public final Type type;

  @CalledByNative
  public SessionDescription(Type paramType, String paramString)
  {
    this.type = paramType;
    this.description = paramString;
  }

  @CalledByNative
  String getDescription()
  {
    return this.description;
  }

  @CalledByNative
  String getTypeInCanonicalForm()
  {
    return this.type.canonicalForm();
  }

  public static enum Type
  {
    static
    {
      ANSWER = new Type("ANSWER", 2);
      Type[] arrayOfType = new Type[3];
      arrayOfType[0] = OFFER;
      arrayOfType[1] = PRANSWER;
      arrayOfType[2] = ANSWER;
    }

    @CalledByNative("Type")
    public static Type fromCanonicalForm(String paramString)
    {
      return (Type)valueOf(Type.class, paramString.toUpperCase(Locale.US));
    }

    public String canonicalForm()
    {
      return name().toLowerCase(Locale.US);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.SessionDescription
 * JD-Core Version:    0.6.2
 */