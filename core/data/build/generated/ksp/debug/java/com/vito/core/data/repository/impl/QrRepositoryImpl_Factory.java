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
public final class QrRepositoryImpl_Factory implements Factory<QrRepositoryImpl> {
  @Override
  public QrRepositoryImpl get() {
    return newInstance();
  }

  public static QrRepositoryImpl_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static QrRepositoryImpl newInstance() {
    return new QrRepositoryImpl();
  }

  private static final class InstanceHolder {
    private static final QrRepositoryImpl_Factory INSTANCE = new QrRepositoryImpl_Factory();
  }
}
