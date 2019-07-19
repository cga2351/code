package org.simpleframework.xml.core;

import org.simpleframework.xml.Version;

class ClassSchema
  implements Schema
{
  private final Caller caller;
  private final Decorator decorator;
  private final Instantiator factory;
  private final boolean primitive;
  private final Version revision;
  private final Section section;
  private final Label text;
  private final Class type;
  private final Label version;

  public ClassSchema(Scanner paramScanner, Context paramContext)
    throws Exception
  {
    this.caller = paramScanner.getCaller(paramContext);
    this.factory = paramScanner.getInstantiator();
    this.revision = paramScanner.getRevision();
    this.decorator = paramScanner.getDecorator();
    this.primitive = paramScanner.isPrimitive();
    this.version = paramScanner.getVersion();
    this.section = paramScanner.getSection();
    this.text = paramScanner.getText();
    this.type = paramScanner.getType();
  }

  public Caller getCaller()
  {
    return this.caller;
  }

  public Decorator getDecorator()
  {
    return this.decorator;
  }

  public Instantiator getInstantiator()
  {
    return this.factory;
  }

  public Version getRevision()
  {
    return this.revision;
  }

  public Section getSection()
  {
    return this.section;
  }

  public Label getText()
  {
    return this.text;
  }

  public Label getVersion()
  {
    return this.version;
  }

  public boolean isPrimitive()
  {
    return this.primitive;
  }

  public String toString()
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = this.type;
    return String.format("schema for %s", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ClassSchema
 * JD-Core Version:    0.6.2
 */