package org.simpleframework.xml.stream;

public class Format
{
  private final int indent;
  private final String prolog;
  private final Style style;
  private final Verbosity verbosity;

  public Format()
  {
    this(3);
  }

  public Format(int paramInt)
  {
    this(paramInt, null, new IdentityStyle());
  }

  public Format(int paramInt, String paramString)
  {
    this(paramInt, paramString, new IdentityStyle());
  }

  public Format(int paramInt, String paramString, Style paramStyle)
  {
    this(paramInt, paramString, paramStyle, Verbosity.HIGH);
  }

  public Format(int paramInt, String paramString, Style paramStyle, Verbosity paramVerbosity)
  {
    this.verbosity = paramVerbosity;
    this.prolog = paramString;
    this.indent = paramInt;
    this.style = paramStyle;
  }

  public Format(int paramInt, Style paramStyle)
  {
    this(paramInt, null, paramStyle);
  }

  public Format(int paramInt, Style paramStyle, Verbosity paramVerbosity)
  {
    this(paramInt, null, paramStyle, paramVerbosity);
  }

  public Format(int paramInt, Verbosity paramVerbosity)
  {
    this(paramInt, new IdentityStyle(), paramVerbosity);
  }

  public Format(String paramString)
  {
    this(3, paramString);
  }

  public Format(Style paramStyle)
  {
    this(3, paramStyle);
  }

  public Format(Style paramStyle, Verbosity paramVerbosity)
  {
    this(3, paramStyle, paramVerbosity);
  }

  public Format(Verbosity paramVerbosity)
  {
    this(3, paramVerbosity);
  }

  public int getIndent()
  {
    return this.indent;
  }

  public String getProlog()
  {
    return this.prolog;
  }

  public Style getStyle()
  {
    return this.style;
  }

  public Verbosity getVerbosity()
  {
    return this.verbosity;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.Format
 * JD-Core Version:    0.6.2
 */