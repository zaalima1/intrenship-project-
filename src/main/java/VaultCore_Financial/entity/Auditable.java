<<<<<<< HEAD:src/main/java/com/example/siya/entity/Auditable.java
package com.example.siya.entity;
=======
package VaultCore_Financial.entity;
>>>>>>> c9db6d00db9c98d9daee2928251090760a5a3095:src/main/java/VaultCore_Financial/entity/Auditable.java

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Auditable {
    String module();
    String action();
}