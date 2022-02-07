/*
 * Copyright (C) 2022 Everwin (www.everwin.fr)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr.everwin.open.api.core.config;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;

/**
 * @author d.storti
 */
public class ConfigHelper {

    private static final org.apache.logging.log4j.Logger LOG4J = org.apache.logging.log4j.LogManager.getLogger();

    public static final String URI_WS = "http://localhost:8080/sx/rest"; //"https://mars2:12443/sx/rest"
    public static final String VERSION = "v2";
    public static final String DATETIMEFORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String TIMEFORMAT = "HH:mm";

    protected static ConfigHelper instance;

    private ConfigHelper() {
        // empty
    }


    public static Calendar newCalendar(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        return c;
    }

    public static Calendar getFirstPeriodDate(Calendar period) {

        Calendar newPeriod = Calendar.getInstance();
        newPeriod.setTime(period.getTime());
        newPeriod.set(Calendar.MONTH, 0);
        newPeriod.set(Calendar.DAY_OF_MONTH, 1);
        newPeriod.set(Calendar.HOUR_OF_DAY, 0);
        newPeriod.set(Calendar.MINUTE, 0);
        newPeriod.set(Calendar.SECOND, 0);
        newPeriod.set(Calendar.MILLISECOND, 0);
        return newPeriod;
    }

    /**
     * Round a number, using the Math.round function<br>
     * @param val The value to be rounded
     * @param nbdec The number of decimals (must be >= 1)
     */
    public static double round(double val, int nbdec) {
        try {
            BigDecimal bd = new BigDecimal(String.valueOf(val));
            bd = bd.setScale(nbdec, RoundingMode.HALF_UP);
            return bd.doubleValue();
        } catch (NumberFormatException e) {
            LOG4J.error(e.getMessage(), e);
            val = 0;
        }
        return val;
    }

}
