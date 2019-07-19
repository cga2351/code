package a.a;

import com.appboy.e.e;
import java.util.UUID;

public final class bi
  implements e<String>
{
  private final UUID a;
  private final String b;

  public bi(UUID paramUUID)
  {
    this.a = paramUUID;
    this.b = paramUUID.toString();
  }

  public static bi a()
  {
    return new bi(UUID.randomUUID());
  }

  public static bi a(String paramString)
  {
    return new bi(UUID.fromString(paramString));
  }

  public String b()
  {
    return this.b;
  }

  public boolean equals(Object paramObject)
  {
    if (this == paramObject)
      return true;
    if ((paramObject == null) || (getClass() != paramObject.getClass()))
      return false;
    bi localbi = (bi)paramObject;
    return this.a.equals(localbi.a);
  }

  public int hashCode()
  {
    return this.a.hashCode();
  }

  public String toString()
  {
    return this.b;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.bi
 * JD-Core Version:    0.6.2
 */