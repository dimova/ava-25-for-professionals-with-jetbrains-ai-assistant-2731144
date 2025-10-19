package com.linkedin.importingmodules;

import module java.base;
import module java.sql;

class Ambiguous {
    // Date d; // error: java.util.Date or java.sql.Date?
}

