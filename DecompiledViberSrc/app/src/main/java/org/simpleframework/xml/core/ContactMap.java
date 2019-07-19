package org.simpleframework.xml.core;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;

class ContactMap extends LinkedHashMap<Object, Contact>
  implements Iterable<Contact>
{
  public Iterator<Contact> iterator()
  {
    return values().iterator();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.simpleframework.xml.core.ContactMap
 * JD-Core Version:    0.6.2
 */