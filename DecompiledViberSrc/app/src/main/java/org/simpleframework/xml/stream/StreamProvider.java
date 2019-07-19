package org.simpleframework.xml.stream;

import java.io.InputStream;
import java.io.Reader;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;

class StreamProvider
  implements Provider
{
  private final XMLInputFactory factory = XMLInputFactory.newInstance();

  private EventReader provide(XMLEventReader paramXMLEventReader)
    throws Exception
  {
    return new StreamReader(paramXMLEventReader);
  }

  public EventReader provide(InputStream paramInputStream)
    throws Exception
  {
    return provide(this.factory.createXMLEventReader(paramInputStream));
  }

  public EventReader provide(Reader paramReader)
    throws Exception
  {
    return provide(this.factory.createXMLEventReader(paramReader));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.stream.StreamProvider
 * JD-Core Version:    0.6.2
 */