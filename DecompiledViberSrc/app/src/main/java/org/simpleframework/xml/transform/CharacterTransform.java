package org.simpleframework.xml.transform;

class CharacterTransform
  implements Transform<Character>
{
  public Character read(String paramString)
    throws Exception
  {
    if (paramString.length() != 1)
      throw new InvalidFormatException("Cannot convert '%s' to a character", new Object[] { paramString });
    return Character.valueOf(paramString.charAt(0));
  }

  public String write(Character paramCharacter)
    throws Exception
  {
    return paramCharacter.toString();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.transform.CharacterTransform
 * JD-Core Version:    0.6.2
 */