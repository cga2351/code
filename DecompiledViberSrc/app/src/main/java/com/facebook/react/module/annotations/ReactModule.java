package com.facebook.react.module.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.TYPE})
public @interface ReactModule
{
  public abstract boolean canOverrideExistingModule();

  public abstract boolean hasConstants();

  public abstract boolean isCxxModule();

  public abstract String name();

  public abstract boolean needsEagerInit();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.module.annotations.ReactModule
 * JD-Core Version:    0.6.2
 */