package org.intellij.lang.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.jetbrains.annotations.NonNls;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.METHOD})
public @interface Flow
{

  @NonNls
  public static final String DEFAULT_SOURCE = "The method argument (if parameter was annotated) or this container (if instance method was annotated)";

  @NonNls
  public static final String DEFAULT_TARGET = "This container (if the parameter was annotated) or the return value (if instance method was annotated)";

  @NonNls
  public static final String RETURN_METHOD_TARGET = "The return value of this method";

  @NonNls
  public static final String THIS_SOURCE = "this";

  @NonNls
  public static final String THIS_TARGET = "this";

  public abstract String source();

  public abstract boolean sourceIsContainer();

  public abstract String target();

  public abstract boolean targetIsContainer();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.intellij.lang.annotations.Flow
 * JD-Core Version:    0.6.2
 */