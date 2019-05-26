package br.com.livraria.tx;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.interceptor.InterceptorBinding;

@InterceptorBinding  // 1. define um interceptador fazendo o CDI reconhecer a anotação
@Target({ElementType.METHOD,ElementType.TYPE}) // 2. define que o alvo são metodos = method e classes = type
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Transacional {

}
