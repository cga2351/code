package javax.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.meta.TypeQualifier;
import javax.annotation.meta.TypeQualifierValidator;
import javax.annotation.meta.When;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@TypeQualifier(applicableTo="Ljava/lang/Number;")
public @interface Nonnegative
{
  public abstract When when();

  public static class Checker
    implements TypeQualifierValidator<Nonnegative>
  {
    public When forConstantValue(Nonnegative paramNonnegative, Object paramObject)
    {
      int i = 1;
      if (!(paramObject instanceof Number))
        return When.NEVER;
      Number localNumber = (Number)paramObject;
      if ((localNumber instanceof Long))
        if (localNumber.longValue() >= 0L);
      while (i != 0)
      {
        return When.NEVER;
        i = 0;
        continue;
        if ((localNumber instanceof Double))
        {
          if (localNumber.doubleValue() >= 0.0D)
            i = 0;
        }
        else if ((localNumber instanceof Float))
        {
          if (localNumber.floatValue() >= 0.0F)
            i = 0;
        }
        else if (localNumber.intValue() >= 0)
          i = 0;
      }
      return When.ALWAYS;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     javax.annotation.Nonnegative
 * JD-Core Version:    0.6.2
 */