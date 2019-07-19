package com.viber.voip.s.a;

public class z extends y
{
  protected void a(StringBuilder paramStringBuilder)
  {
    super.a(paramStringBuilder);
    paramStringBuilder.append(" LEFT OUTER JOIN conversation_auxiliary ON (conversations._id = conversation_auxiliary._id)");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.s.a.z
 * JD-Core Version:    0.6.2
 */