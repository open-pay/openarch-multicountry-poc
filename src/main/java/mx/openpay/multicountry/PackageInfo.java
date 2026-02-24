/*
 * COPYRIGHT © 2024. OPENPAY.
 * PATENT PENDING. ALL RIGHTS RESERVED.
 *
 * This software is confidential and proprietary information of OPENPAY.
 * You shall not disclose such Confidential Information and shall use it only
 * in accordance with the company policy.
 *
 */
package mx.openpay.multicountry;

import static java.lang.annotation.ElementType.PACKAGE;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The Interface PackageInfo.
 *
 * @author Hugo Hernández - hugo.hernandez@openpay.mx | Apr 4, 2024
 */
@Target(PACKAGE)
@Retention(RetentionPolicy.RUNTIME)
public @interface PackageInfo {

}
