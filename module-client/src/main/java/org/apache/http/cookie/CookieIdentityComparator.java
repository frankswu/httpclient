/*
 * $HeadURL$
 * $Revision$
 * $Date$
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 *
 */

package org.apache.http.cookie;

import java.util.Comparator;

/**
 * This cookie comparator can be used to compare identity of cookies.
 *  
 * <p>
 *  Cookies are considered identical if their names are equal and 
 *  their domain attributes match ignoring case.
 * </p>
 * 
 * @author <a href="mailto:oleg at ural.ru">Oleg Kalnichevski</a>
 */
public class CookieIdentityComparator implements Comparator {

    public int compare(final Object o1, final Object o2) {
        Cookie c1 = (Cookie) o1;
        Cookie c2 = (Cookie) o2;
        int res = c1.getName().compareTo(c2.getName());
        if (res == 0) {
            // do not differentiate empty and null domains 
            String d1 = c1.getDomain();
            if (d1 == null) {
                d1 = "";
            }
            String d2 = c2.getDomain();
            if (d2 == null) {
                d2 = "";
            }
            res = d1.compareToIgnoreCase(d2);
        }
        return res;
    }

}