package javax.annotation.meta;

public enum When
{
  static
  {
    MAYBE = new When("MAYBE", 2);
    NEVER = new When("NEVER", 3);
    When[] arrayOfWhen = new When[4];
    arrayOfWhen[0] = ALWAYS;
    arrayOfWhen[1] = UNKNOWN;
    arrayOfWhen[2] = MAYBE;
    arrayOfWhen[3] = NEVER;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     javax.annotation.meta.When
 * JD-Core Version:    0.6.2
 */