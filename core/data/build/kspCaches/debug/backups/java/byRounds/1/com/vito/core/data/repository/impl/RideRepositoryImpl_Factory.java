package com.vito.core.data.repository.impl;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class RideRepositoryImpl_Factory implements Factory<RideRepositoryImpl> {
  @Override
  public RideRepositoryImpl get() {
    return newInstance();
  }

  public static RideRepositoryImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static RideRepositoryImpl newInstance() {
    return new RideRepositoryImpl();
  }

  private static final class InstanceHolder {
    private static final RideRepositoryImpl_Factory INSTANCE = new RideRepositoryImpl_Factory();
  }
}
